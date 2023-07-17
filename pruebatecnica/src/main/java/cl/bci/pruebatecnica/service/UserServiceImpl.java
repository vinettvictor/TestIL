package cl.bci.pruebatecnica.service;

import cl.bci.pruebatecnica.constantes.Messages;
import cl.bci.pruebatecnica.exception.ErrorException;
import cl.bci.pruebatecnica.model.User;
import cl.bci.pruebatecnica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Messages messages;

    @Override
    public User createUser(User userRequest) throws ErrorException {

        User newUser = null;
        Optional<User> userEmail = Optional.ofNullable(userRepository.findByEmail(userRequest.getEmail()));

        Boolean emailValido = validateEmail(userRequest.getEmail());
        Boolean validPassword = validatePassword(userRequest.getPassword());

        //Validamos que la contraseña ingresada cumpla las condiciones
        if (validPassword == false){
            throw new ErrorException(messages.ERROR_PARAMETRO_ENTRADA,messages.ERROR_PASSWORD);
        }

        //Validamos que el email ingresado sea válida: aaaaa@gmail.com
        if (emailValido == false){
            throw new ErrorException(messages.ERROR_PARAMETRO_ENTRADA,messages.ERROR_CORREO_INVALIDO);
        }

        try{
            if (!userEmail.isEmpty()) {
                if (!userEmail.get().getEmail().equals(userRequest.getEmail())) {
                    userRequest.setIsActive(true);
                    newUser = userRepository.save(userRequest);
                } else {
                    throw new ErrorException(messages.ERROR_PARAMETRO_ENTRADA, messages.ERROR_CORREO_EXISTE );
                }
            } else {
                userRequest.setIsActive(true);
                newUser = userRepository.save(userRequest);
            }
        }catch (ErrorException re) {
            throw new ErrorException(re.getMessage(),re.getDescription());
    }
        return newUser;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getId());

        if(userObj.isPresent()){
            User userUpdate = userObj.get();
            userUpdate.setId(user.getId());
            userUpdate.setName(user.getName());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPhone(user.getPhone());
            userUpdate.setModifiedAt(user.getModifiedAt());

            userRepository.save(userUpdate);
            return userUpdate;
        } else {
            throw new ErrorException(messages.ERROR_PARAMETRO_ENTRADA, "No se encontró la id: "+ user.getId());
        }
    }

    //Metodo para validar el email con formato: minusculas,numero y puntos.
    public Boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher matcher = pattern.matcher(email);

        if(matcher.find() == true){
            return true;
        }
        return false;
    }

    /**
     * Permite validar la Contraseña ingresada mediante una expreción regular de la OWASP y que cumpla las siguientes caracteristicas
     * Que tenga entre 4 y 8 carácteres, que contenga números, letras minúsuclas y mayúsculas.
     * @param password Paswword ingresado para la creación del usuario
     * @return
     */
    public Boolean validatePassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$"); //Regex de validación OWASP
        Matcher matcher = pattern.matcher(password);

        if(matcher.find() == true){
            return true;
        }
        return false;
    }
}
