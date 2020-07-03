package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.*;
import static se.lexicon.lasse78.data.TodoSequencer.*;

public class TestTodoSequencer {

    @Test
    public void testTodoNextPersonId() {
        //Arrange

        //Act
        int oldCounter = todoNextPersonId();
        int newCounter = todoNextPersonId();


        //Assert
        assertEquals(oldCounter + 1, newCounter);
    }


}