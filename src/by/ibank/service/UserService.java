package by.ibank.service;

import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.dto.ViewFullUserInfoDto;
import by.ibank.entity.User;

import java.util.Optional;

public class UserService {
    private static UserService INSTANCE = null;

    private UserService(){}

    public static UserService getInstance(){
        if(INSTANCE==null){
            synchronized (UserService.class){
                if(INSTANCE==null){
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }
    public ViewFullUserInfoDto getFullUserInfo(int id){
        Optional<User> userOptional = Optional.ofNullable(UserDAOImpl.getInstance().find(id));
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("No user with provided id!");
        }
        User user = userOptional.get();
        return new ViewFullUserInfoDto(user.getName(), user.getSecondName(), user.getSurname(),
                user.getBirthday().toString(), user.getAddress(),user.getTelephone(),
                user.getSex(),user.getPassportNumber(),user.getEmail());
    }
}
