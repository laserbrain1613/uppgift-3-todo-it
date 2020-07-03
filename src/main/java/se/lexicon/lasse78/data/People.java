package se.lexicon.lasse78.data;
import se.lexicon.lasse78.model.Person;
import java.util.Arrays;

public class People {

        private static Person[] array = new Person[0];

        public static int size() { return array.length; }
        public static Person[] findAll() { return array; }

        public static Person findById(int personId) {
            for (int i = 0; i < size(); i++) {
                if (array[i].getPersonId() == personId) {
                    return array[i];
                }
            }
            return null;
        }

        public static Person[] createPerson(String firstName, String lastName) {
            Person[] expandedArray = Arrays.copyOf(array, array.length+1);
            expandedArray[expandedArray.length-1] = new Person(PersonSequencer.nextPersonId(), firstName, lastName);
            array = expandedArray;
            return array;
        }

        public static void clear() { //Starts over both array and ID counter
            array = new Person[0];
            PersonSequencer.reset();
        }



    }