package by.ibank.dao;

import java.time.LocalDate;

public interface HistoryDAO {
    void addToHistory(int card_number, LocalDate date,int amount);
}
