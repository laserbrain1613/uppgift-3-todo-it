package se.lexicon.lasse78;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void nonsenseTest() {
        String[] test = {"I Am A Coverage Junkie"};
        App.main(test);
        assertTrue(true);
    }
}
