package se.lexicon.lasse78;

import se.lexicon.lasse78.data.People;
import se.lexicon.lasse78.model.Person;
import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestPeople {

    @Before
    public void resetBefore() {
        People.clear();
    }

    @Test
    public void testCreateNewPerson() {
        //Arrange
        Person[] testArray;

        //Act
        testArray = People.createPerson("James", "Hetfield");

        //Assert
        assertEquals(1, testArray[0].getPersonId());
        assertEquals("James", testArray[0].getFirstName());
        assertEquals("Hetfield", testArray[0].getLastName());
    }

    @Test
    public void testCreateTwoNewPersons() {
        //Arrange
        Person[] testArray;
        People.createPerson("James", "Hetfield");

        //Act
        testArray = People.createPerson("Lars", "Ulrich"); //testArray will contain first created object as well

        //Assert
        assertEquals(1, testArray[0].getPersonId());
        assertEquals("James", testArray[0].getFirstName());
        assertEquals("Hetfield", testArray[0].getLastName());
        assertEquals(2, testArray[1].getPersonId());
        assertEquals("Lars", testArray[1].getFirstName());
        assertEquals("Ulrich", testArray[1].getLastName());
    }

    @Test
    public void hasArrayExpanded() {
        //Arrange
        int oldSize = People.size();
        People.createPerson("James", "Hetfield");

        //Act
        int newSize = People.size();

        //Assert
        assertEquals(oldSize + 1, newSize);
    }

    @Test
    public void hasArrayExpandedTwice() {
        //Arrange
        int oldSize = People.size();
        People.createPerson("James", "Hetfield");
        People.createPerson("Lars", "Ulrich");

        //Act
        int newSize = People.size();

        //Assert
        assertEquals(oldSize + 2, newSize);
    }

    @Test
    public void testFindByIdTrue() {
        //Arrange
        Person foundId;
        People.createPerson("James", "Hetfield"); //ID 1
        People.createPerson("Lars", "Ulrich"); // ID 2

        //Act
        foundId = People.findById(2); // Looking for Lars Ulrich's ID

        //Assert
        assertSame(foundId, People.findById(2));
    }

    @Test
    public void testFindByIdFalse() {
        //Arrange
        Person foundTestPerson;
        People.createPerson("James", "Hetfield"); // ID 1

        //Act
        foundTestPerson = People.findById(2); // Should return a null

        //Assert
        assertNull(foundTestPerson);
    }

    @Test
    public void testClear() { // Note: Tested this PRIOR to putting it in @Before
        //Arrange
        People.createPerson("James", "Hetfield"); //ID 1
        People.createPerson("Lars", "Ulrich"); // ID 2
        int oldSize = People.size();

        //Act
        People.clear();

        //Assert
        assertEquals(oldSize , 2);
        assertEquals(0, People.size());
    }

    @Test
    public void testFindAll() {
        //Arrange
        People.createPerson("James", "Hetfield"); //ID 1

        //Act
        Person[] testArray = Arrays.copyOf(People.findAll(), People.findAll().length);

        //Assert - can't use reference for a return comparison
        assertTrue(Arrays.deepEquals(testArray, People.findAll()));
    }

    @Test
    public void testFindAllEmptyArray() {
        //Arrange

        //Act
        Person[] testArray = Arrays.copyOf(People.findAll(), People.findAll().length);

        //Assert - can't use reference for a return comparison
        assertTrue(Arrays.deepEquals(testArray, People.findAll()));
    }


}
