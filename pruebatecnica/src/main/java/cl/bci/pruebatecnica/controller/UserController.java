package cl.bci.pruebatecnica.controller;

import cl.bci.pruebatecnica.exception.ErrorException;
import cl.bci.pruebatecnica.model.User;
import cl.bci.pruebatecnica.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser (@RequestBody User userData){
        Map<String, String> response = new HashMap<>();
        try{
            Optional<User> newUser = Optional.ofNullable(userService.createUser(userData));
            if(newUser.isPresent()){
                response.put("id",newUser.get().getId().toString());
                response.put("name", newUser.get().getName());
                response.put("email", newUser.get().getEmail());
                response.put("createAt",newUser.get().getCreateAt().toString());
                response.put("modifiedAt",newUser.get().getModifiedAt().toString());
                response.put("phones",newUser.get().getPhone().get(0).getNumber());
                response.put("cityCode",newUser.get().getPhone().get(0).getCitycode());
                response.put("contryCode",newUser.get().getPhone().get(0).getContrycode());
                response.put("isActive", newUser.get().getIsActive().toString());
                response.put("accesToken", newUser.get().getToken());
                response.put("last_login", newUser.get().getLastLogin().toString());
                return new ResponseEntity(response, HttpStatus.OK);
            }
        }catch (ErrorException eE){
            response.put("mensaje", eE.getDescription());
            return new  ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUser (){
        return ResponseEntity.ok(userService.getUsers());
    }
}
