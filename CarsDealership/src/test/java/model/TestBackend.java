package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;

import pl.polsl.carsdealership.Model.*;

/**
 * Class used for testing model methods
 *
 * @version 1.1
 * @author Piotr Januszkiewicz
 */
public class TestBackend {

    /**
     * private field that holds 'Backend' object
     */
    private Backend backend;

    /**
     * part of the 'given' section for all tests. creating new 'Backend' object
     * from model
     */
    @BeforeEach
    public void setup() {
        backend = new Backend();
    }

    /**
     * test for checking if car is in range of possible years for cars. Input
     * data is correct.
     * @param number element of list of years that can be given from user
     */
    @ParameterizedTest
    @ValueSource(ints = {1930, 1955, 2020, 2021})
    public void testTrueCheckIfCarInRangeOfYear(int number) {
        /*when:*/ Boolean result = backend.checkIfYearInRange(number);

        /*then:*/ assertEquals(true, result);
    }

    /**
     * test for checking if car is in range of possible years for cars. Input
     * data is incorrect.
     * @param number element of list of years that can be given from user
     */
    @ParameterizedTest
    @ValueSource(ints = {10, -100, 1000, 1929, 1910, 2022})
    public void testFalseCheckIfCarInRangeOfYear(int number) {
        /*when:*/ Boolean result = backend.checkIfYearInRange(number);

        /*then:*/ assertEquals(false, result);
    }

    /**
     * test for checking if car is in range of given amount of money. Input data
     * is correct.
     * @param number element of list of clients budget that can be given from user
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 1000, 5000, 2000})
    public void testTrueCheckIfCarInRangeOfMoney(int number) {
        /*when:*/ int result = backend.checkIfCarInRangeOfMoney(5000, number);

        /*then:*/ assertEquals(1, result);
    }

    /**
     * test for checking if car is in range of given amount of money. Input data
     * is incorrect.
     *
     * @param number element of list of clients budget that can be given from user
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, -50, -500, 1000000})
    public void testFalseCheckIfCarInRangeOfMoney(int number) {
        /*when:*/ int result = backend.checkIfCarInRangeOfMoney(50000, number);

        /*then:*/ assertEquals(0, result);
    }

    /**
     * test for checking if given amount of money is valid. Input data is
     * correct.
     *
     * @param number element of element of list of prices for cars.
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 100, 500, 10000000})
    public void testTrueCheckIfCarPriceInRange(int number) {
        /*when:*/ Boolean result = backend.checkIfPriceInRange(number);

        /*then:*/ assertEquals(true, result);
    }

    /**
     * test for checking if given amount of money is valid. Input data is
     * incorrect.
     *
     * @param number element of list of prices for cars.
     */
    @ParameterizedTest
    @ValueSource(ints = {-10, -50, 100000000, 999999999})
    public void testFalseCheckIfCarPriceInRange(int number) {
        /*when:*/ Boolean result = backend.checkIfPriceInRange(number);

        /*then:*/ assertEquals(false, result);
    }
}
