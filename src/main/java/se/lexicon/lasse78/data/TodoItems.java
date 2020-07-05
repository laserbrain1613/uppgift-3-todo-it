package se.lexicon.lasse78.data;

import se.lexicon.lasse78.model.Todo;

import java.util.Arrays;

public class TodoItems {

    private static Todo[] array = new Todo[0];


    public static void clear() {
        array = new Todo[0];
        TodoSequencer.reset();
    }

    public int size() { return array.length; }

    public Todo[] findAll() { return array; }

    public Todo findById(int personId) {
        for (int i = 0; i < size(); i++) {
            if (array[i].getTodoId() == personId) {
                return array[i];
            }
        }
        return null;
    }

    public Todo createTodo(String description) {
        Todo tempTodo = new Todo(TodoSequencer.nextTodoPersonId(), description);
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = tempTodo;
        return tempTodo;
    }


}