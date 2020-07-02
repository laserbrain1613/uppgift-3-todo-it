package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.*;
import static se.lexicon.lasse78.data.PersonSequencer.*;

public class TestPersonSequencer {

    @Test
    public void testNextPersonId() {
        //Arrange

        //Act
        int returnValue = nextPersonId(5);

        //Assert
        assertEquals(6, returnValue);
    }


}
