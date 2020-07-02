package se.lexicon.lasse78;

import org.junit.Test;
import se.lexicon.lasse78.model.Todo;
import se.lexicon.lasse78.model.Person;
import static org.junit.Assert.*;

public class TestTodo {

    Person testPerson = new Person(4096, "Holly", "Wood");
    Todo testTodo = new Todo(42, "Hello", true, testPerson);

    @Test
    public void testConstructor() {
        //Arrange

        //Act

        //Assert
        assertEquals(42, testTodo.getTodoId());
        assertEquals("Hello", testTodo.getDescription());
        assertTrue(testTodo.isDone());
        assertEquals(testPerson, testTodo.getAssignee());
        assertNotNull(testTodo.getAssignee());
    }

    @Test
    public void changeDescription() {
        //Arrange

        //Act
        testTodo.setDescription("New description");

        //Assert
        assertEquals("New description", testTodo.getDescription());
    }

    @Test
    public void changeBoolean() {
        //Arrange
        boolean oldBoolean = testTodo.isDone();

        //Act
        testTodo.setDone(!oldBoolean);

        //Assert
        assertTrue(oldBoolean != testTodo.isDone());
    }

    @Test
    public void changeClass() {
        //Arrange
        Person anotherTestPerson = new Person(8192, "Jack", "Pott");

        //Act
        testTodo.setAssignee(anotherTestPerson);

        //Assert
        assertNotSame(testPerson, testTodo.getAssignee());
        assertNotNull(testTodo.getAssignee());
    }




}
