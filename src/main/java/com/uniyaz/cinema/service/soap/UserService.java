package com.uniyaz.cinema.service.soap;

import com.uniyaz.cinema.service.dto.UserDto;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserService {
    @WebMethod
    UserDto saveUser (UserDto userDto);

}
