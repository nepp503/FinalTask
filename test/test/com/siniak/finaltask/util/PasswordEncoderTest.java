package test.com.siniak.finaltask.util;

import com.siniak.finaltask.util.PasswordEncoder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordEncoderTest {
    String login;
    String password;

    @BeforeClass
    public void setUp() {
        login = "login";
        password = "password";
    }

    @Test
    public void encodePasswordTestTrue() {
        String actual = PasswordEncoder.encodePassword(password, login);
        String expected = "7e06ee529e096fda486a07c128586b3de750cde57e96c0175969bb13e95c6204";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void encodePasswordTestFalse() {
        String actual = PasswordEncoder.encodePassword(password, login);
        String expected = "7e06ee529e096fda486a07c128586b3de750cde57e96c0175969bb13e";
        Assert.assertNotEquals(actual, expected);
    }
}
