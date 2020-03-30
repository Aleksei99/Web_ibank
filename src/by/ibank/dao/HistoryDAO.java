package by.ibank.dao;

import by.ibank.entity.History;
import by.ibank.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface HistoryDAO {
    void addToHistory(User user,int cardNumberFrom, int amount, int cardNumberTo);
    List<History> showHistory(User user);
}
