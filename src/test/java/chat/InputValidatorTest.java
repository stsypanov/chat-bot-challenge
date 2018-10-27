package chat;

import chat.application.InputValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {
    private InputValidator validator;

    @Test(expected = NullPointerException.class)
    public void validate_inputIsNullable_expectInputIsInvalid() {
        validator = new InputValidator((String)null);
    }

    @Test
    public void validate_inputIsEmpty_expectInputIsInvalid() {
        validator = new InputValidator("");
        boolean inputValid = validator.inputValid();
        assertFalse(inputValid);
    }

    @Test
    public void validate_inputIncomplete1_expectInputIsInvalid() {
        validator = new InputValidator("-r rand");
        boolean inputValid = validator.inputValid();
        assertFalse(inputValid);
    }

    @Test
    public void validate_inputIncomplete2_expectInputIsInvalid() {
        validator = new InputValidator("-r upseq -f ");
        boolean inputValid = validator.inputValid();
        assertFalse(inputValid);
    }

    @Test
    public void validate_badStrategy_expectInputIsInvalid() {
        validator = new InputValidator("-r azaza -f ~/file.txt");
        boolean inputValid = validator.inputValid();
        assertFalse(inputValid);
    }

    @Test
    public void validate_expectInputIsValid() {
        validator = new InputValidator("-r downseq -f dictionary.txt");
        boolean inputValid = validator.inputValid();
        assertTrue(inputValid);
    }
}