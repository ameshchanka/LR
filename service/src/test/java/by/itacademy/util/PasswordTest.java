package by.itacademy.util;

import junit.framework.TestCase;

import static by.itacademy.util.Password.checkPassword;
import static by.itacademy.util.Password.hashPassword;
import static org.junit.Assert.*;

public class PasswordTest extends TestCase {

    /**
     * A simple test case for the main method, verify that a pre-generated test hash verifies successfully
     * for the password it represents, and also generate a new hash and ensure that the new hash verifies
     * just the same.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(PasswordTest.class);
    }

    public void testPassword() {

        String test_passwd = "abcdefghijklmnopqrstuvwxyz";
        String test_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";

        System.out.println("Testing BCrypt Password hashing and verification");
        System.out.println("Test password: " + test_passwd);
        System.out.println("Test stored hash: " + test_hash);
        System.out.println("Hashing test password...");
        System.out.println();

        String computed_hash = hashPassword(test_passwd);
        System.out.println("Test computed hash: " + computed_hash);
        System.out.println();
        System.out.println("Verifying that hash and stored hash both match for the test password...");
        System.out.println();

        String compare_test = checkPassword(test_passwd, test_hash)
                ? "Passwords Match" : "Passwords do not match";
        String compare_computed = checkPassword(test_passwd, computed_hash)
                ? "Passwords Match" : "Passwords do not match";

        System.out.println("Verify against stored hash:   " + compare_test);
        System.out.println("Verify against computed hash: " + compare_computed);
    }
}