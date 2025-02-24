package com.projectspring.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectspring.api.Dto.UserDto;
import com.projectspring.api.Generic.GenericController;
import com.projectspring.api.Repositories.RoleRepositories;
import com.projectspring.api.Repositories.UserRepositories;
import com.projectspring.api.Services.UserService;


@RestController
@RequestMapping("/users")
public class UserController extends GenericController<UserDto, Integer, UserService> {
    public UserController(UserService service) {
        super(service);
    }
    
    @Autowired
    private RoleRepositories roleRepositories;

    @Autowired
    private UserRepositories userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 


    @PostMapping(value = "/test")
    public UserDto saveOrUpdateUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return service.saveOrUpdate(userDto);
    }


}
