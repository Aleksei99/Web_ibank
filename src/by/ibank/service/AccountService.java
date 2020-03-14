package by.ibank.service;

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
}
