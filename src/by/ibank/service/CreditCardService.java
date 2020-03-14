package by.ibank.service;

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
}
