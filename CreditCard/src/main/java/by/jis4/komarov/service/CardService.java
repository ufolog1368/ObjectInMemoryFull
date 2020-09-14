package by.jis4.komarov.service;

import by.jis4.komarov.bean.CreditCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardService {


    private Logger logger = LoggerFactory.getLogger(CardService.class);

    public void withdraw(double moneyWant, CreditCard creditCard, int pin) {
        if (creditCard.getPin() == pin) {
            double actualBalance;
            actualBalance = creditCard.getBalance() - moneyWant;
            if (actualBalance < 0) {
                actualBalance = Math.abs(actualBalance);
                if ((float) actualBalance <= (float) (creditCard.getCrLimit() - creditCard.getIndebtedness())) {
                    creditCard.setIndebtedness(creditCard.getIndebtedness() + actualBalance);
                    creditCard.setBalance(0);
                } else {
                    logger.info("Credit limit has max.");
                }
            } else {
                creditCard.setBalance(actualBalance);
            }
        } else {
            logger.info("pincode is wrong. Retry effort.");
        }
    }


    public void deposit(CreditCard creditCard,double money, int pin) {
        if (creditCard.getPin() == pin) {
            if (creditCard.getIndebtedness() > 0) {
                creditCard.setIndebtedness(money - creditCard.getIndebtedness());
                if (creditCard.getIndebtedness() < 0) {
                    creditCard.setIndebtedness(Math.abs(creditCard.getIndebtedness()));
                } else {
                    creditCard.setBalance(creditCard.getIndebtedness());
                    creditCard.setIndebtedness(0);
                }
            } else {
                creditCard.setBalance(creditCard.getBalance() + money);
            }
        } else {
            logger.info("pincode is wrong. Retry effort.");
        }
    }
}





