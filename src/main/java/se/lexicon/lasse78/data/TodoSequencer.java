package se.lexicon.lasse78.data;

public class TodoSequencer {
    private static int todoPersonId;

    public static int todoNextPersonId(int todoPersonId) {
        todoPersonId++;
        return todoPersonId;
    }

    public static void todoReset() {
        todoPersonId = 0;
    }

}