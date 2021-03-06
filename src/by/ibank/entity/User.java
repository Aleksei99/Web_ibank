package by.ibank.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User extends Man {

    private List<CreditCard> cards = new ArrayList<>();
    private Account account;
    private List<History> spending = new ArrayList<>();
    private UserRole userRole;

    private int id;/////--------------??????????
    private String password;
    private String login;

    public User(int id, String name, String secondName, String surname,
                Date birthday, String address, String telephone, String sex,
                String nPassport, String email, String password, String login) {
        super(name, secondName, surname, birthday, address, telephone, sex, nPassport, email);
        this.id=id;
        this.password = password;
        this.login = login;
    }

    public User(String name, String secondName, String surname,
                Date birthday, String address, String telephone, String sex,
                String nPassport, String email,String password, String login,UserRole userRole) {
        super(name, secondName, surname, birthday, address, telephone, sex, nPassport, email);
        this.userRole=userRole;
        this.login=login;
        this.password=password;
    }

    public User(String name, String secondName, String surname,
                Date birthday, String address, String telephone, String sex,
                String nPassport, String email,String password, String login ) {
        super(name, secondName, surname, birthday, address, telephone, sex, nPassport, email);
        this.login=login;
        this.password=password;
    }

    public User() {

    }



    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCard(CreditCard card) {
        cards.add(card);
    }

    public void removeCard(CreditCard card){
        cards.remove(card);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<History> getHistory() {
        return spending;
    }

    public void setSpending(History spending) {
        this.spending.add(spending);
    }

    public void clearHistory(){
        spending.clear();
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(cards, user.cards) &&
                Objects.equals(account, user.account) &&
                Objects.equals(spending, user.spending) &&
                userRole == user.userRole &&
                Objects.equals(password, user.password) &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, account, spending, userRole, id, password, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "cards=" + cards +
                ", account=" + account +
                ", spending=" + spending +
                ", userRole=" + userRole +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
