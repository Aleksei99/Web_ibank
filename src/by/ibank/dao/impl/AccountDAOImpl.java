package by.ibank.dao.impl;

import by.ibank.dao.AccountDAO;
import by.ibank.connection.ConnectionManager;
import by.ibank.entity.Account;
import by.ibank.entity.CreditCard;
import by.ibank.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountDAOImpl implements AccountDAO {
    private static final String NEW_ACCOUNT = "insert into accounts (account_number,amount,user_id) values (?,?,?)";
    private static final String DELETE_ACCOUNT = "DELETE FROM  accounts WHERE (account_number = ?)";
    private static final String ADD_MONEY = "UPDATE  accounts SET amount = ? WHERE account_number = ?";
    private static final String FIND_ALL_ACCOUNTS = "select * from accounts";
    private static final String FIND_ALL_USER_ACCOUNTS = "select * from accounts where user_id = ?";
    private static final String FIND_ACCOUNT = "select * from accounts where account_number = ?";
    private static final String TRANSFER_MONEY = "update accounts set amount = ? where account_number = ?";

    private static AccountDAOImpl INSTANCE = null;

private AccountDAOImpl(){}

public static AccountDAOImpl getInstance(){
    if(INSTANCE==null){
        synchronized (AccountDAOImpl.class){
            if(INSTANCE==null){
                INSTANCE = new AccountDAOImpl();
            }
        }
    }
    return INSTANCE;
}
    @Override
    public void save(User user, Account account) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(NEW_ACCOUNT)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setInt(2, account.getAmount());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String account_number) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setString(1, account_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMoney(Account account, int money) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_MONEY)) {
            preparedStatement.setInt(1, account.getAmount() + money);
            preparedStatement.setString(2, account.getAccountNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL_ACCOUNTS)) {
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountNumber(resultSet.getString("account_number"));
                    account.setAmount(resultSet.getInt("amount"));
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public HashSet<Account> findAllUserAccounts(User user) {
        HashSet<Account> accounts = new HashSet<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USER_ACCOUNTS)) {
            preparedStatement.setInt(1,user.getId());
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountNumber(resultSet.getString("account_number"));
                    account.setAmount(resultSet.getInt("amount"));
                    account.setId(resultSet.getInt("id"));
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account find(String account_number) {
        Account account = new Account();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ACCOUNT)) {
            preparedStatement.setString(1, account_number);
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    account.setId(resultSet.getInt("id"));
                    account.setAccountNumber(resultSet.getString("account_number"));
                    account.setAmount(resultSet.getInt("amount"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void transferMoney(Account fromAccount, int money, Account toAccount) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(TRANSFER_MONEY);
             PreparedStatement preparedStatement1 = connection.prepareStatement(TRANSFER_MONEY)) {

            preparedStatement.setInt(1, fromAccount.getAmount() - money);
            preparedStatement.setString(2, fromAccount.getAccountNumber());

            preparedStatement1.setInt(1, toAccount.getAmount() + money);
            preparedStatement1.setString(2, toAccount.getAccountNumber());

            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
