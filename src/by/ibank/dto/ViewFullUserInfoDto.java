package by.ibank.dto;

import java.util.Date;

public class ViewFullUserInfoDto {
    private String name;
    private String secondName;
    private String surname;
    private String birthday;
    private String address;
    private String telephone;
    private String sex;
    private String passportNumber;
    private String email;

    public ViewFullUserInfoDto(String name, String secondName, String surname,
                               String birthday, String address, String telephone,
                               String sex, String passportNumber, String email) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.telephone = telephone;
        this.sex = sex;
        this.passportNumber = passportNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
