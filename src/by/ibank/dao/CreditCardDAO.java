package by.ibank.dao;

import by.ibank.entity.Account;
import by.ibank.entity.CreditCard;
import by.ibank.entity.User;

import java.util.LinkedList;
import java.util.List;

public interface CreditCardDAO {
    LinkedList<CreditCard> findAll(User user);

    void transferMoney(User user,int fromCreditCard, int money, int toCreditCard);

    void add(Account account, CreditCard creditCard);

    void delete(int cardNumber);
}
