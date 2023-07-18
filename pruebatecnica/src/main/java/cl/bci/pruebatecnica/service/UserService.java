package cl.bci.pruebatecnica.service;

import cl.bci.pruebatecnica.exception.ErrorException;
import cl.bci.pruebatecnica.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user) throws ErrorException;

    List<User> getUsers() throws ErrorException;
    User updateUser(User user);

}
