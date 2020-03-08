package by.ibank.dao;

import java.time.LocalDate;

public interface HistoryDAO {
    void addToHistory(int cardNumber, LocalDate date,int amount);
}
