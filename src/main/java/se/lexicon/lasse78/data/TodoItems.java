package se.lexicon.lasse78.data;

import se.lexicon.lasse78.model.Person;
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

    public Todo[] findByDoneStatus(boolean doneStatus) {
        Todo[] statusArray = new Todo[0];
        for (int i = 0; i < size() ; i++) {
            if (array[i].isDone() == doneStatus) {
                statusArray = Arrays.copyOf(statusArray, statusArray.length + 1);
                statusArray[statusArray.length-1] = array[i];
            }
        }
        return statusArray;
    }

    public Todo[] findByAssignee(int personId) {
        Todo[] assigneeArray = new Todo[0];
        for (int i = 0; i < size() ; i++) {
            if (array[i].getAssignee() != null) { // Accounts for objects without assignee
                if (array[i].getAssignee().getPersonId() == personId) {
                    assigneeArray = Arrays.copyOf(assigneeArray, assigneeArray.length +1);
                    assigneeArray[assigneeArray.length-1] = array[i];
                }
            }
        }
        return assigneeArray;
    }

    public Todo[] findByAssignee(Person assignee) {
        Todo[] hasPersonInObject = new Todo[0];
        for (int i = 0; i < size() ; i++) {
            if (array[i].getAssignee() == assignee) {
                hasPersonInObject = Arrays.copyOf(hasPersonInObject, hasPersonInObject.length +1);
                hasPersonInObject[hasPersonInObject.length-1] = array[i];
            }
        }
        return hasPersonInObject;
    }

    public Todo[] findUnassignedTodoItems() {
        Todo[] noAssigneeInObject = new Todo[0];
        for (int i = 0; i < size() ; i++) {
            if (array[i].getAssignee() == null) {
                noAssigneeInObject = Arrays.copyOf(noAssigneeInObject, noAssigneeInObject.length +1);
                noAssigneeInObject[noAssigneeInObject.length-1] = array[i];
            }
        }
        return noAssigneeInObject;
    }


}