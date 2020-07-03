package se.lexicon.lasse78.data;
import se.lexicon.lasse78.model.Person;
import se.lexicon.lasse78.model.Todo;
import java.util.Arrays;

public class TodoItems {

    private static Todo[] array = new Todo[0];

    public static int size() { return array.length; }
    public static Todo[] findAll() { return array; }

    public static Todo findById(int personId) {
        for (int i = 0; i < size(); i++) {
            if (array[i].getTodoId() == personId) {
                return array[i];
            }
        }
        return null;
    }

    public static Todo[] createTodo(String description, boolean isDone, Person assignee) {
        Todo[] expandedArray = Arrays.copyOf(array, array.length+1);
        expandedArray[expandedArray.length-1] = new Todo(TodoSequencer.todoNextPersonId(), description, isDone, assignee);
        array = expandedArray;
        return array;
    }

    public static void clear() { //Starts over both array and ID counter
        array = new Todo[0];
        TodoSequencer.reset();
    }
}