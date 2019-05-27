package test.com.siniak.finaltask.util;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.util.UserValidation;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserValidationTest {
    UserValidation validation;
    User correctUser;
    User incorrectUser;

    @BeforeClass
    public void setUp() {
        validation = new UserValidation();
        correctUser = new User();
        incorrectUser = new User();
        correctUser.setLogin("Login");
        correctUser.setPassword("539419Pass");
        correctUser.setEmail("email@gmail.com");
        incorrectUser.setLogin("Login;");
        incorrectUser.setPassword("539419P");
    }

    @Test
    public void isValidTestTrue() {
        boolean actual = validation.isValid(correctUser);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidTestFalse() {
        boolean actual = validation.isValid(incorrectUser);
        Assert.assertFalse(actual);
    }
    @Test
    public void isValidUpdateTestTrue() {
        boolean actual = validation.isUpdateValid(correctUser);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidUpdateTestFalse() {
        boolean actual = validation.isUpdateValid(incorrectUser);
        Assert.assertFalse(actual);
    }

    @AfterClass
    public void clean() {
        validation = null;
        correctUser = null;
        incorrectUser = null;
    }
}
