package by.ibank.service;

public class HistoryService {
    private static HistoryService INSTANCE = null;

    private HistoryService(){}

    public static HistoryService getInstance(){
        if(INSTANCE==null){
            synchronized (AccountService.class){
                if(INSTANCE==null){
                    INSTANCE = new HistoryService();
                }
            }
        }
        return INSTANCE;
    }
}
