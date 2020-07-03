package se.lexicon.lasse78;

import org.junit.Test;
import se.lexicon.lasse78.model.Todo;
import se.lexicon.lasse78.model.Person;
import static org.junit.Assert.*;

public class TestTodo {

    Person DEFAULT_TESTPERSON = new Person(4096, "Holly", "Wood");
    Todo DEFAULT_TESTTODO = new Todo(42, "Hello", true, DEFAULT_TESTPERSON);

    @Test
    public void testConstructor() {
        //Arrange

        //Act

        //Assert
        assertEquals(42, DEFAULT_TESTTODO.getTodoId());
        assertEquals("Hello", DEFAULT_TESTTODO.getDescription());
        assertTrue(DEFAULT_TESTTODO.isDone());
        assertEquals(DEFAULT_TESTPERSON, DEFAULT_TESTTODO.getAssignee());
        assertNotNull(DEFAULT_TESTTODO.getAssignee());
    }

    @Test
    public void changeDescription() {
        //Arrange

        //Act
        DEFAULT_TESTTODO.setDescription("New description");

        //Assert
        assertEquals("New description", DEFAULT_TESTTODO.getDescription());
    }

    @Test
    public void changeBoolean() {
        //Arrange
        boolean oldBoolean = DEFAULT_TESTTODO.isDone();

        //Act
        DEFAULT_TESTTODO.setDone(!oldBoolean);

        //Assert
        assertTrue(oldBoolean != DEFAULT_TESTTODO.isDone());
    }

    @Test
    public void changeClass() {
        //Arrange
        Person anotherTestPerson = new Person(8192, "Jack", "Pott");

        //Act
        DEFAULT_TESTTODO.setAssignee(anotherTestPerson);

        //Assert
        assertNotSame(DEFAULT_TESTPERSON, DEFAULT_TESTTODO.getAssignee());
        assertNotNull(DEFAULT_TESTTODO.getAssignee());
    }




}
