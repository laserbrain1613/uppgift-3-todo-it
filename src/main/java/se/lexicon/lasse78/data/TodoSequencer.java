package se.lexicon.lasse78.data;

public class TodoSequencer {
    private static int todoPersonId;

    public static int nextTodoPersonId() {
        todoPersonId++;
        return todoPersonId;
    }

    public static void reset() {
        todoPersonId = 0;
    }

}