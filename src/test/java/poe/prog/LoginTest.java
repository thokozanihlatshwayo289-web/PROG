package poe.prog;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    private Login login;

    @Before
    public void setUp() {
        login = new Login("Kyle", "Smith");
    }

    // --- Unit Tests for Part 1 Requirements ---

    @Test
    public void testUsernameCorrectlyFormattedMessage() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String actual = login.returnLoginStatus(true);
        assertEquals("Welcome Kyle ,Smith it is great to see you.", actual);
    }

    @Test
    public void testUsernameIncorrectlyFormattedMessage() {
        String actual = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", actual);
    }

    @Test
    public void testPasswordMeetsComplexityMessage() {
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(actual.contains("Password successfully captured."));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityMessage() {
        String actual = login.registerUser("kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", actual);
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}