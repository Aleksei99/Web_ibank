package by.ibank.entity;

import by.ibank.dao.*;
import by.ibank.dao.impl.AccountDAOImpl;
import by.ibank.dao.impl.CreditCardDAOImpl;
import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.service.AccountService;
import by.ibank.service.CreditCardService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void checkFunctional(String userRole) {
        if (userRole.equals(UserRole.ADMIN.name())) {
            System.out.println("welcome administrator");
        }else if(userRole.equals(UserRole.USER.name())) {
            System.out.println("welcome user");
        }else if(userRole.equals(UserRole.MODERATOR.name())) {
            System.out.println("welcome user");
        }
        else {
            System.out.println("register please");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        checkFunctional("ADMIN");
        checkFunctional("MODERATOR");
        System.out.println(UserRole.ADMIN);
        //UserDAO userDAO = new UserDAOImpl();
//        User user2 = new User("Aloxa","Alexandrovich","kekw",1992,11,2,"home","+375298582223","mail","mc2845492","al@gamil.com","dsgff584","alox",UserRole.USER);
//        userDAO.save(user2);
       // User user = userDAO.findUser(2);
       // AccountDAO accountDAO = new AccountDAOImpl();
      //  Account ac1 =new Account("3wjr4h87ff",200);//3wjr4h2j23428
       // accountDAO.save(user,ac1);
//        Account fromAccount = accountDAO.findAccount("3wjr4h2j23428");
//        Account toAccount = accountDAO.findAccount("3wjr4h87ff");
//        accountDAO.transferMoney(fromAccount,50,toAccount);

        //CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
        //System.out.println(creditCardDAO.findAllUserCards("Alex"));
        //CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
       // creditCardDAO.transferMoney(554,50,552);
//        LocalDate date = LocalDate.parse("11"+"/15/"+"2023", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        CreditCardDAOImpl creditCardDAO = CreditCardDAOImpl.getInstance();
//        CreditCardService.getInstance().addCard(AccountService.getInstance().find("651654fg"),new CreditCard(2339,date));
//        creditCardDAO.add(new Account(1,"651654fg",500),new CreditCard(123456,date));
    }


}
