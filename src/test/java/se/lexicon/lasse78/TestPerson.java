package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.*;
import se.lexicon.lasse78.model.Person;

public class TestPerson {

    @Test
    public void constructorTest() {
        //Arrange
        Person testPerson = new Person(31415, "John", "Smith");

        //Act

        //Assert
        assertEquals(31415, testPerson.getPersonId());
        assertEquals("John", testPerson.getFirstName());
        assertEquals("Smith", testPerson.getLastName());
    }

    @Test
    public void changeFirstName() {
        //Arrange
        Person testPerson = new Person(31415, "John", "Smith");

        //Act
        testPerson.setFirstName("Will");

        //Assert
        assertEquals("Will", testPerson.getFirstName());
    }

    @Test
    public void changeLastName() {
        //Arrange
        Person testPerson = new Person(31415, "John", "Smith");

        //Act
        testPerson.setLastName("Travolta");

        //Assert
        assertEquals("Travolta", testPerson.getLastName());
    }


}