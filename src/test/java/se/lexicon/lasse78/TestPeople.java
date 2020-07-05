package se.lexicon.lasse78;

import se.lexicon.lasse78.data.People;
import org.junit.Test;
import org.junit.Before;
import se.lexicon.lasse78.model.Person;
import static org.junit.Assert.*;

public class TestPeople {

    private People testPeople;

    @Before
    public void doBefore() {
        testPeople = new People();
        People.clear();
        testPeople.createPerson("James", "Hetfield");
        testPeople.createPerson("Lars", "Ulrich");
    }

    @Test
    public void testCreateTwoPersons() {
        //Assert
        assertEquals(1, testPeople.findAll()[0].getPersonId());
        assertEquals("James", testPeople.findAll()[0].getFirstName());
        assertEquals("Hetfield", testPeople.findAll()[0].getLastName());
        assertEquals(2, testPeople.findAll()[1].getPersonId());
        assertEquals("Lars", testPeople.findAll()[1].getFirstName());
        assertEquals("Ulrich", testPeople.findAll()[1].getLastName());
    }

    @Test
    public void hasArrayExpanded() {
        //Arrange
        int oldSize = testPeople.size();

        //Act
        testPeople.createPerson("Kirk", "Hammett");

        //Assert
        assertEquals(oldSize + 1, testPeople.size());
    }

    @Test
    public void testFindByIdTrue() {
        //Act
        Person foundId = testPeople.findById(2);

        //Assert
        assertSame(foundId, testPeople.findById(2));
    }

    @Test
    public void testFindByIdFalse() {
        //Act
        Person foundId = testPeople.findById(3); // Should return a null

        //Assert
        assertNull(foundId);
    }

}
