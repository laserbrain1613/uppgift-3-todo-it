package se.lexicon.lasse78;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.lasse78.data.TodoItems;
import se.lexicon.lasse78.model.Person;
import se.lexicon.lasse78.model.Todo;

import static org.junit.Assert.*;

public class TestTodoItems {

    private TodoItems testTodo;

    @Before
    public void doBefore() {
        testTodo = new TodoItems();
        TodoItems.clear();
        testTodo.createTodo("Fancy Description");
        testTodo.createTodo("Another Fancy Description");
    }

    @Test
    public void createTwoObjects() {
        //Assert
        assertEquals(1, testTodo.findAll()[0].getTodoId());
        assertEquals("Fancy Description", testTodo.findAll()[0].getDescription());
        assertEquals(2, testTodo.findAll()[1].getTodoId());
        assertEquals("Another Fancy Description", testTodo.findAll()[1].getDescription());
    }

    @Test
    public void hasArrayExpanded() {
        //Arrange
        int oldSize = testTodo.size();

        //Act
        testTodo.createTodo("Yet Another Fancy Description");

        //Assert
        assertEquals(oldSize + 1, testTodo.size());

    }

    @Test
    public void findByIdTrue() {
        //Act
        Todo foundId = testTodo.findById(2);

        //Assert
        assertSame(foundId, testTodo.findById(2));
    }

    @Test
    public void findByIdFalse() {
        //Act
        Todo foundId = testTodo.findById(3);

        //Assert
        assertNull(foundId);
    }

    @Test
    public void findByDoneStatusBothFalse() { //Default bool for both objects are false
        //Arrange
        Todo[] statusTodo;

        //Act
        statusTodo = testTodo.findByDoneStatus(false);

        //Assert
        assertEquals(2, statusTodo.length);
        assertEquals(1, statusTodo[0].getTodoId());
        assertEquals("Fancy Description", statusTodo[0].getDescription());
        assertEquals(2, statusTodo[1].getTodoId());
        assertEquals("Another Fancy Description", statusTodo[1].getDescription());
    }

    @Test
    public void findByDoneStatusOneTrue() { // First object is false by default
        //Arrange
        Todo[] statusTodo;
        testTodo.findAll()[1].setDone(true);

        //Act
        statusTodo = testTodo.findByDoneStatus(true);

        //Assert
        assertEquals(1, statusTodo.length);
        assertEquals(2, statusTodo[0].getTodoId());
        assertEquals("Another Fancy Description", statusTodo[0].getDescription());
    }

    @Test
    public void findByAssigneeIdNothingFound() {
        //Arrange
        Todo[] assigneeId;

        //Act
        assigneeId = testTodo.findByAssignee(1);

        //Assert
        assertEquals(0, assigneeId.length);

    }

    @Test
    public void findByAssigneeIdFoundTwoAssignees() {
        //Arrange
        Todo[] assigneeId;
        Person testPerson = new Person(5, "John", "Smith");
        testTodo.findAll()[0].setAssignee(testPerson);
        testTodo.findAll()[1].setAssignee(testPerson);

        //Act
        assigneeId = testTodo.findByAssignee(5);

        //Assert
        assertEquals(2, assigneeId.length);
    }

    @Test
    public void findByAssigneePersonNothingFound() {
        //Arrange
        Todo[] arrayPersonInObject;
        Person testPerson = new Person(5, "John", "Smith");

        //Act
        arrayPersonInObject = testTodo.findByAssignee(testPerson);

        //Assert
        assertEquals(0, arrayPersonInObject.length);
    }

    @Test
    public void findByAssigneePersonTwoFound() {
        //Arrange
        Todo[] arrayPersonInObject;
        Person testPerson = new Person(5, "John", "Smith");
        testTodo.findAll()[0].setAssignee(testPerson);
        testTodo.findAll()[1].setAssignee(testPerson);

        //Act
        arrayPersonInObject = testTodo.findByAssignee(testPerson);

        //Assert
        assertEquals(2, arrayPersonInObject.length);
    }

    @Test
    public void findUnassignedTodoItemsNothingFound() {
        //Arrange
        Todo[] arrayUnAssignedPerson;

        //Act
        arrayUnAssignedPerson = testTodo.findUnassignedTodoItems();

        //Assert
        assertEquals(2, arrayUnAssignedPerson.length);
    }

    @Test
    public void findUnassignedTodoItemsFoundAssignees() {
        //Arrange
        Todo[] arrayUnAssignedPerson;
        Person testPerson = new Person(5, "John", "Smith");
        testTodo.findAll()[0].setAssignee(testPerson);
        testTodo.findAll()[1].setAssignee(testPerson);

        //Act
        arrayUnAssignedPerson = testTodo.findUnassignedTodoItems();

        //Assert
        assertEquals(0, arrayUnAssignedPerson.length);
    }

    @Test
    public void deletePersonIdNotFound() {
        //Arrange

        //Act
        testTodo.deleteTodo(5); // testPeople has only two objects as default

        //Assert
        assertEquals(2, testTodo.size());

    }

    @Test
    public void deletePersonIdFound() {
        //Arrange
        testTodo.createTodo("Superior Fancy Description");

        //Act
        testTodo.deleteTodo(2);

        //Assert
        assertEquals(2, testTodo.size());
        assertEquals(1, testTodo.findAll()[0].getTodoId());
        assertEquals("Fancy Description", testTodo.findAll()[0].getDescription());
        assertEquals(3, testTodo.findAll()[1].getTodoId());
        assertEquals("Superior Fancy Description", testTodo.findAll()[1].getDescription());
    }

}
