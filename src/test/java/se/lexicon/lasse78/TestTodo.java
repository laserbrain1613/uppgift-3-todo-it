package se.lexicon.lasse78;

import se.lexicon.lasse78.model.Todo;
import se.lexicon.lasse78.model.Person;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTodo {

    Todo testTodo = new Todo(1, "Hello");

    @Test
    public void testConstructor() {
        //Assert
        assertEquals(1, testTodo.getTodoId());
        assertEquals("Hello", testTodo.getDescription());
    }

    @Test
    public void changeDescription() {
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
    public void changeAssignee() {
        //Arrange
        Person firstTestPerson = new Person(1, "Jack", "Pott");
        Person secondTestPerson = new Person(2, "Joe", "King");
        testTodo.setAssignee(firstTestPerson);

        //Act
        testTodo.setAssignee(secondTestPerson);

        //Assert
        assertSame(secondTestPerson, testTodo.getAssignee());
    }

}
