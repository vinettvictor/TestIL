package cl.bci.pruebatecnica.service;

import cl.bci.pruebatecnica.exception.ErrorException;
import cl.bci.pruebatecnica.model.User;

public interface UserService {
    User createUser(User user) throws ErrorException;
    User updateUser(User user);

}
