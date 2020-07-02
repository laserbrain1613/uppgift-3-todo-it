package se.lexicon.lasse78.data;

public class PersonSequencer {
    private static int personId;

    public static int nextPersonId(int personId) {
        personId++;
        return personId;
    }

    public static void reset() {
        personId = 0;
    }


}
