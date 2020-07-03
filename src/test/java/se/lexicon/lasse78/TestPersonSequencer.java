package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.*;
import static se.lexicon.lasse78.data.PersonSequencer.*;

public class TestPersonSequencer {

    @Test
    public void testNextPersonId() {
        //Arrange

        //Act
        int oldCounter = nextPersonId();
        int newCounter = nextPersonId();

        //Assert
        assertEquals(oldCounter+1, newCounter);
    }

}
