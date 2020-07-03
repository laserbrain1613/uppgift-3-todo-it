package se.lexicon.lasse78;

import java.util.Arrays;
import se.lexicon.lasse78.data.People;
import se.lexicon.lasse78.data.TodoItems;
import se.lexicon.lasse78.model.Person;
import se.lexicon.lasse78.model.Todo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestTodoItems {

    Person[] DEFAULT_PERSONARRAY = People.createPerson("James", "Hetfield");

    @Before
    public void resetBefore() {
        TodoItems.clear();
    }

    @Test
    public void testCreateNewTodo() {
        //Arrange
        Todo[] todoArray;

        //Act
        todoArray = TodoItems.createTodo("Fancy Description", true, DEFAULT_PERSONARRAY[0]);

        //Assert
        assertEquals(1, todoArray[0].getTodoId());
        assertEquals("Fancy Description", todoArray[0].getDescription());
        assertTrue(todoArray[0].isDone());
    }


    @Test
    public void testCreateTwoNewTodo() {
        //Arrange
        DEFAULT_PERSONARRAY = People.createPerson("Lars", "Ulrich");
        Todo[] todoArray;

        //Act
        TodoItems.createTodo("First description", true, DEFAULT_PERSONARRAY[0]);
        todoArray = TodoItems.createTodo("Second description", false, DEFAULT_PERSONARRAY[1]);

        //Assert
        assertEquals(1, todoArray[0].getTodoId());
        assertEquals("First description", todoArray[0].getDescription());
        assertTrue(todoArray[0].isDone());
        assertEquals(2, todoArray[1].getTodoId());
        assertEquals("Second description", todoArray[1].getDescription());
        assertFalse(todoArray[1].isDone());
    }

    @Test
    public void hasArrayExpanded() {
        //Arrange
        int oldSize = TodoItems.size();
        DEFAULT_PERSONARRAY = People.createPerson("Lars", "Ulrich");
        TodoItems.createTodo("Whatever", true, DEFAULT_PERSONARRAY[1]); //Could've pointed to [0] during the test. Makes less sense in runtime enviroment

        //Act
        int newSize = TodoItems.size();

        //Assert
        assertEquals(oldSize + 1, newSize);
    }

    @Test
    public void hasArrayExpandedTwice() {
        //Arrange
        int oldSize = TodoItems.size();
        DEFAULT_PERSONARRAY = People.createPerson("Lars", "Ulrich");
        TodoItems.createTodo("Whatever", true, DEFAULT_PERSONARRAY[0]);
        TodoItems.createTodo("However", true, DEFAULT_PERSONARRAY[1]);

        //Act
        int newSize = People.size();

        //Assert
        assertEquals(oldSize + 2, newSize);
    }

    @Test
    public void testFindByIdTrue() {
        //Arrange
        DEFAULT_PERSONARRAY = People.createPerson("Lars", "Ulrich");
        Todo foundId;
        TodoItems.createTodo("Whatever", true, DEFAULT_PERSONARRAY[0]); // ID 1
        TodoItems.createTodo("However", false, DEFAULT_PERSONARRAY[1]); // ID 2

        //Act
        foundId = TodoItems.findById(2); // Looking for ID 2

        //Assert
        assertNotNull(foundId);
        assertSame(2, foundId.getTodoId());
    }

    @Test
    public void testFindByIdFalse() {
        //Arrange
        Todo foundId;
        TodoItems.createTodo("Whatever", true, DEFAULT_PERSONARRAY[0]); // ID 1

        //Act
        foundId = TodoItems.findById(2); // Looking for ID 2

        //Assert
        assertNull(foundId);
    }

    @Test
    public void testClear() { // Note: Tested this PRIOR to putting it in @Before
        //Arrange
        DEFAULT_PERSONARRAY = People.createPerson("Lars", "Ulrich");
        TodoItems.createTodo("Whatever", true, DEFAULT_PERSONARRAY[0]); // ID 1
        TodoItems.createTodo("However", false, DEFAULT_PERSONARRAY[1]); // ID 2
        int oldSize = TodoItems.size();

        //Act
        People.clear();

        //Assert
        assertEquals(oldSize , 2);
        assertEquals(0, People.size());
    }

    @Test
    public void testFindAll() {
        //Arrange
        DEFAULT_PERSONARRAY = People.createPerson("Lars", "Ulrich");
        TodoItems.createTodo("Whatever", true, DEFAULT_PERSONARRAY[0]); // ID 1
        TodoItems.createTodo("However", false, DEFAULT_PERSONARRAY[1]); // ID 2

        //Act
        Todo[] testCopyOfArray = Arrays.copyOf(TodoItems.findAll(), TodoItems.findAll().length);

        //Assert - can't use reference for a return comparison
        assertTrue(Arrays.deepEquals(testCopyOfArray, TodoItems.findAll()));
    }

    @Test
    public void testFindAllEmptyArray() {
        //Arrange

        //Act
        Todo[] testCopyOfArray = Arrays.copyOf(TodoItems.findAll(), TodoItems.findAll().length);

        //Assert - can't use reference for a return comparison
        assertTrue(Arrays.deepEquals(testCopyOfArray, TodoItems.findAll()));
    }

}
