package by.ibank.dao;

import by.ibank.entity.Account;
import by.ibank.entity.CreditCard;

import java.util.List;

public interface CreditCardDAO {
    List<CreditCard> findAll(String user);

    void transferMoney(int fromCreditCard, int money, int toCreditCard);

    void add(Account account, CreditCard creditCard);

    void delete(int cardNumber);
}
