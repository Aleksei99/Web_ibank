package by.ibank.dao.impl;

import by.ibank.dao.ConnectionManager;
import by.ibank.dao.UserDAO;
import by.ibank.entity.User;
import by.ibank.entity.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String FIND_ALL = "select * from users";
    private static final String FIND_BY_ID = "select * from users where id = ?";
    private static final String FIND_BY_LOGIN = "select * from users where login = ?";
    private static final String SAVE = "INSERT into users (name,second_name, surname, birthday, address," +
            " phone_number, sex,  passport_number," +
            " email, password, login,role) values (?,?,?,?,?,?,?,?,?,?,?,'USER')";
    private static final String DELETE_BY_ID = "delete from users where id = ?";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    User user = new User();
                    UserInfo(resultSet, user, UserRole.valueOf(resultSet.getString("role")));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private void UserInfo(ResultSet resultSet, User user, UserRole userRole) throws SQLException {
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setBirthday(resultSet.getDate("birthday"));
        user.setAddress(resultSet.getString("address"));
        user.setTelephone(resultSet.getString("phone_number"));
        user.setSex(resultSet.getString("sex"));
        user.setSecondName(resultSet.getString("second_name"));
        user.setPassportNumber(resultSet.getString("passport_number"));
        user.setUserRole(userRole);
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
    }

    @Override
    public User find(int id) {
        User user = new User();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    UserInfo(resultSet, user, UserRole.valueOf(resultSet.getString("role")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {
        User user = new User();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    UserInfo(resultSet, user, UserRole.valueOf(resultSet.getString("role")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public boolean save(User user) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getTelephone());
            preparedStatement.setString(7, user.getSex());
            preparedStatement.setString(8, user.getPassportNumber());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setString(10, user.getPassword());
            preparedStatement.setString(11, user.getLogin());
            // preparedStatement.setString(12, user.getUserRole().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {

    }
}
