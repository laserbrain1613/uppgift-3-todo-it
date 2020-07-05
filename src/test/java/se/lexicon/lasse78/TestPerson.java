package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.*;
import se.lexicon.lasse78.model.Person;

public class TestPerson {

    Person testPerson = new Person(1, "John", "Smith");

    @Test
    public void constructorTest() {
        //Assert
        assertEquals(1, testPerson.getPersonId());
        assertEquals("John", testPerson.getFirstName());
        assertEquals("Smith", testPerson.getLastName());
    }

    @Test
    public void changeFirstName() {
        //Act
        testPerson.setFirstName("Will");

        //Assert
        assertEquals("Will", testPerson.getFirstName());
    }

    @Test
    public void changeLastName() {
        //Act
        testPerson.setLastName("Travolta");

        //Assert
        assertEquals("Travolta", testPerson.getLastName());
    }


}