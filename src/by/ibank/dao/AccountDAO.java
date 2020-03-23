package by.ibank.dao;

import by.ibank.entity.Account;
import by.ibank.entity.User;

import java.util.HashSet;
import java.util.List;

public interface AccountDAO {
    void save(User user, Account account);

    void delete(String account_number);

    void addMoney(Account account, int money);

    List<Account> findAll();

    HashSet<Account> findAllUserAccounts(User user);

    Account find(String account_number);

    void transferMoney(Account fromAccount, int money, Account toAccount);
}
