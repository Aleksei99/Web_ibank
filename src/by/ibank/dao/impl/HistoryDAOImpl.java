package by.ibank.dao.impl;

import by.ibank.connection.ConnectionManager;
import by.ibank.dao.HistoryDAO;
import by.ibank.entity.CreditCard;
import by.ibank.entity.History;
import by.ibank.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAOImpl implements HistoryDAO {
    private static final String ADD_TO_HISTORY = "insert into history (card_number_from,date, amount,card_number_to, user_id) values (?,?,?,?,?)";
    private static final String SHOW_HISTORY = "select * from history where user_id = ?";

    private static HistoryDAOImpl INSTANCE = null;

    private HistoryDAOImpl(){}

    public static HistoryDAOImpl getInstance(){
        if(INSTANCE==null){
            synchronized (HistoryDAOImpl.class){
                if(INSTANCE==null){
                    INSTANCE = new HistoryDAOImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void addToHistory(User user,int cardNumberFrom, int amount, int cardNumberTo) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_TO_HISTORY)) {
            preparedStatement.setInt(1, cardNumberFrom);
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            preparedStatement.setTimestamp(2, date);
            preparedStatement.setInt(3, amount);
            preparedStatement.setInt(4, cardNumberTo);
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<History> showHistory(User user) {
        List<History> list = new ArrayList<>();
        try(Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SHOW_HISTORY)) {
            preparedStatement.setInt(1,user.getId());
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()){
                    History history = new History();
                    history.setCreditCardFrom(new CreditCard(resultSet.getInt("card_number_from")));
                    history.setDatePurchase(resultSet.getTimestamp("date"));
                    history.setSpentMoney(resultSet.getInt("amount"));
                    history.setCreditCardTo(new CreditCard(resultSet.getInt("card_number_to")));
                    list.add(history);
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
