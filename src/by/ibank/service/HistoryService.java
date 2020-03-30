package by.ibank.service;

import by.ibank.dao.impl.HistoryDAOImpl;
import by.ibank.entity.History;
import by.ibank.entity.User;

import java.util.List;

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
    public List<History> getHistory(User user){
        return HistoryDAOImpl.getInstance().showHistory(user);
    }
}
