package se.lexicon.lasse78.data;

import se.lexicon.lasse78.model.Person;

import java.util.Arrays;

public class People {

    private static Person[] array = new Person[0];


    public static void clear() {
        array = new Person[0];
        PersonSequencer.reset();
    }

    public int size() { // Is there a difference between size() and findAll().length?
        return array.length;
    }

    public Person[] findAll() {
        return array;
    }

    public Person findById(int personId) {
        for (int i = 0; i < size(); i++) {
            if (array[i].getPersonId() == personId) {
                return array[i];
            }
        }
        return null;
    }

    public Person createPerson(String firstName, String lastName) {
        Person tempPerson = new Person(PersonSequencer.nextPersonId(), firstName, lastName);
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = tempPerson;
        return tempPerson; // Assignment instructed me to return this. Why?
    }

    public void deletePerson(int personId) {
        for (int i = 0; i < size(); i++) {
            if (array[i].getPersonId() == personId) {
                for (int j = i + 1; j < size(); j++) {
                    array[i] = array[j];
                }
                array = Arrays.copyOf(array, array.length - 1);
            }
        }
    }

}