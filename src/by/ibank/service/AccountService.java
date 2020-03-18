package by.ibank.service;

import by.ibank.dao.impl.AccountDAOImpl;
import by.ibank.entity.Account;
import by.ibank.entity.User;

import java.util.List;

public class AccountService {
    private static AccountService INSTANCE = null;

    private AccountService(){}

    public static AccountService getInstance(){
        if(INSTANCE==null){
            synchronized (AccountService.class){
                if(INSTANCE==null){
                    INSTANCE = new AccountService();
                }
            }
        }
        return INSTANCE;
    }
    public List<Account> allUserAccounts(User user){
        return AccountDAOImpl.getInstance().findAllUserAccounts(user);
    }
    public void addBill(User user, Account account){
        AccountDAOImpl.getInstance().save(user,account);
    }
    public Account find(String accountNumber){
        return AccountDAOImpl.getInstance().find(accountNumber);
    }
}
