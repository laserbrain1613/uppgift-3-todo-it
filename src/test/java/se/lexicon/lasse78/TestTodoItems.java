package se.lexicon.lasse78;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.lasse78.data.TodoItems;
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
    public void testCreateTwoPersons() {
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
    public void testFindByIdTrue() {
        //Act
        Todo foundId = testTodo.findById(2);

        //Assert
        assertSame(foundId, testTodo.findById(2));
    }

    @Test
    public void testFindByIdFalse() {
        //Act
        Todo foundId = testTodo.findById(3); // Should return a null

        //Assert
        assertNull(foundId);
    }


}
