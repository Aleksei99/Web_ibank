package by.ibank.service;

import by.ibank.dao.impl.CreditCardDAOImpl;
import by.ibank.entity.Account;
import by.ibank.entity.CreditCard;
import by.ibank.entity.User;

import java.util.LinkedList;
import java.util.List;

public class CreditCardService {
    private static CreditCardService INSTANCE = null;

    private CreditCardService(){}

    public static CreditCardService getInstance(){
        if(INSTANCE==null){
            synchronized (CreditCardService.class){
                if(INSTANCE==null){
                    INSTANCE = new CreditCardService();
                }
            }
        }
        return INSTANCE;
    }
    public void addCard(Account account, CreditCard creditCard){
        CreditCardDAOImpl.getInstance().add(account,creditCard);
    }
    public void transferMoney(User user,int fromCreditCard, int money, int toCreditCard){
        CreditCardDAOImpl.getInstance().transferMoney(user,fromCreditCard,money,toCreditCard);
    }
    public LinkedList<CreditCard> findAllUserCards(User user){
       return CreditCardDAOImpl.getInstance().findAll(user);
    }
}
