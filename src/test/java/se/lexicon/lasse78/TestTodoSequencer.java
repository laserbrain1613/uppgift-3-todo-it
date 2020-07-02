package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.*;
import static se.lexicon.lasse78.data.TodoSequencer.*;

public class TestTodoSequencer {

    @Test
    public void testTodoNextPersonId() {
        //Arrange

        //Act
        int returnValue = todoNextPersonId(5);

        //Assert
        assertEquals(6, returnValue);
    }


}
