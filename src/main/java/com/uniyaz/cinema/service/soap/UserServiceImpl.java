package com.uniyaz.cinema.service.soap;

import com.uniyaz.cinema.dao.UserDao;
import com.uniyaz.cinema.domain.User;
import com.uniyaz.cinema.service.converter.UserConverter;
import com.uniyaz.cinema.service.dto.UserDto;

import javax.jws.WebService;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/services/*", name = "UserServiceServlet", loadOnStartup = 1)
@WebListener(value = "com.sun.xml.ws.transport.http.servlet.WSServletContextListener")
@WebService(endpointInterface = "com.uniyaz.cinema.service.soap.UserServiceImpl", name = "UserService")
public class UserServiceImpl implements UserService {
    @Override
    public UserDto saveUser(UserDto userDto) {

        UserConverter userConverter = new UserConverter();
        User user = userConverter.convertToUser(userDto);

        UserDao userDao = new UserDao();
        User savedUser = userDao.saveUser(user);

        UserDto userDtoSaved = userConverter.convertToUserDto(savedUser);

        return userDtoSaved;
    }
}
