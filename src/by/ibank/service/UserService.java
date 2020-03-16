package by.ibank.service;

import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.dto.ViewBasicUserInfoDto;
import by.ibank.dto.ViewFullUserInfoDto;
import by.ibank.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ViewBasicUserInfoDto> getAllUsers(){
        return UserDAOImpl.getInstance().findAll().stream()
                .map(userEntity -> new ViewBasicUserInfoDto(userEntity.getId(), userEntity.getName()))
                .collect(Collectors.toList());
    }
    public User getUserByLogin(String login){
        return UserDAOImpl.getInstance().findByLogin(login);
    }
}
