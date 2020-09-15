package by.jis4.komarov.service;

import by.jis4.komarov.bean.CreditCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardServiceTest {

    CreditCard creditCard;
    CardService cardService;


    @Before
    public void setUp() {
        cardService = new CardService();
        creditCard = new CreditCard(5647_7689_6576_8675L, 1234);
    }

    @Test
    public void depositReturnFalsePincode() {
        cardService.deposit(creditCard, 3000, 1235);

        boolean expected = false;
        boolean actual = creditCard.getPin() == 1235;

        assertEquals(expected, actual);
    }

    @Test
    public void depositReturnTruePincode() {
        cardService.deposit(creditCard, 1000, 1234);

        boolean expected = true;
        boolean actual = creditCard.getPin() == 1234;

        assertEquals(expected, actual);
    }

    @Test
    public void depositReturnPositiveBalance() {
        cardService.deposit(creditCard, 2500.0, 1234);

        double expected = 2500.0;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void depositReturnNegativeDept() {
        creditCard.setIndebtedness(3000.0);
        cardService.deposit(creditCard, 1000.0, 1234);

        double expected = 2000.0;
        double actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void depositReturnPositiveBalanceAndZeroDept() {
        creditCard.setIndebtedness(3000.0);
        cardService.deposit(creditCard, 4000, 1234);

        double expected = 1000.0;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);

        expected = 0.0;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void depositReturnZeroBalanceAndPositiveDept() {
        creditCard.setIndebtedness(3000.0);
        cardService.deposit(creditCard, 2000, 1234);

        double expected = 0.0;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);

        expected = 1000.0;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void depositReturnBalanceAndDeptZero() {
        creditCard.setIndebtedness(2000.0);
        cardService.deposit(creditCard, 2000, 1234);

        double expected = 0.0;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);

        expected = 0.0;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void withdrawReturnPincodeTrue() {
        cardService.withdraw(0, creditCard, 1234);

        int expected = 1234;
        int actual = creditCard.getPin();

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawReturnPincodeFalse() {
        cardService.withdraw(0, creditCard, 1236);

        boolean expected = false;
        boolean actual = creditCard.getPin() == 1236;

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawReturnPositiveBalance() {
        cardService.deposit(creditCard, 4000, 1234);
        cardService.withdraw(3000, creditCard, 1234);

        double expected = 1000;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);

        expected = 0.0;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void withdrawReturnZeroBalance() {
        cardService.deposit(creditCard, 3000, 1234);
        cardService.withdraw(2000, creditCard, 1234);
        cardService.withdraw(1000, creditCard, 1234);

        double expected = 0;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void withdrawReturnPositiveDeptAndZeroBalance() {
        creditCard.setCrLimit(2000);
        cardService.deposit(creditCard, 1000, 1234);
        cardService.withdraw(3000, creditCard, 1234);

        double expected = 0;
        double actual = creditCard.getBalance();

        assertEquals(expected, actual, 0.009999999);

        expected = 2000;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void withdrawReturnDoubleValueDebt() {
        creditCard.setCrLimit(2000);
        cardService.withdraw(1000, creditCard, 1234);
        cardService.withdraw(500, creditCard, 1234);
        cardService.withdraw(501, creditCard, 1234);

        double expected = 1500;
        double actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void withdrawReturnSetNumberMoreThaneCreditLimit() {
        creditCard.setCrLimit(2000);
        cardService.withdraw(4000, creditCard, 1234);

        double expected = 0;
        double actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void withdrawReturnPositiveDepto() {
        creditCard.setCrLimit(2000);
        creditCard.setIndebtedness(1000);
        cardService.deposit(creditCard, 1000, 1234);
        cardService.withdraw(3000, creditCard, 1234);

        double expected = 0;
        double actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);

        cardService.withdraw(1999.99, creditCard, 1234);

        expected = 1999.99;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);

        cardService.withdraw(0.01, creditCard, 1234);
        expected = 2000.0;
        actual = creditCard.getIndebtedness();

        assertEquals(expected, actual, 0.009999999);
    }

}
