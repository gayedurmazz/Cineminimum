package com.uniyaz.cinema.service.converter;

import com.uniyaz.cinema.domain.User;
import com.uniyaz.cinema.service.dto.UserDto;

public class UserConverter {

    /// UserDto'yu User'a çevirme
    public User convertToUser(UserDto userDto){

        User user = new User();
        user.setUserRole(userDto.getUserRole());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        return user;
    }

    /// User'ı UserDto'ya çevirme
    public UserDto convertToUserDto(User user){

        UserDto userDto = new UserDto();
        userDto.setUserRole(user.getUserRole());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }
}
