package com.uniyaz.cinema.service.dto;

import com.uniyaz.cinema.domain.EnumUserRole;

public class UserDto {

    private EnumUserRole userRole;
    private String name;
    private String surname;

    public EnumUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(EnumUserRole userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
