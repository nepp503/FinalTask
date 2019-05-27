package test.com.siniak.finaltask.util;

import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.util.HelpResponseValidation;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelpResponseValidationTest {
    HelpResponseValidation validation;
    HelpResponse correctResponse;
    HelpResponse incorrectResponse;

    @BeforeClass
    public void setUp() {
        validation = new HelpResponseValidation();
        correctResponse = new HelpResponse();
        incorrectResponse = new HelpResponse();
        correctResponse.setTitle("Title");
        correctResponse.setBody("Body");
        incorrectResponse.setTitle("");
        incorrectResponse.setBody("");
    }

    @Test
    public void isValidTestTrue() {
        boolean actual = validation.isValid(correctResponse);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidTestFalse() {
        boolean actual = validation.isValid(incorrectResponse);
        Assert.assertFalse(actual);
    }

    @AfterClass
    public void clean() {
        validation = null;
        correctResponse = null;
        incorrectResponse = null;
    }
}
