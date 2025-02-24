package com.projectspring.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectspring.api.Dto.UserDto;
import com.projectspring.api.Generic.GenericController;
import com.projectspring.api.Models.RoleEntities;
import com.projectspring.api.Models.UserEntities;
import com.projectspring.api.Repositories.RoleRepositories;
import com.projectspring.api.Repositories.UserRepositories;
import com.projectspring.api.Services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


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

    // @PostMapping(value = "/user", consumes = "application/json")
    // public UserEntities createAdmin(@RequestBody UserEntities users) {
    //     UserEntities existingUser = userRepository.findByUsername(users.getUsername());
    //     if (existingUser != null) {
    //         throw new RuntimeException("L'adresse e-mail est déjà utilisée.");
    //     }

    //     String passwordEncode = passwordEncoder.encode(users.getPassword());
    //     users.setPassword(passwordEncode);
    //     RoleEntities userRole = roleRepositories.findByName("ROLE_ADMIN");
    //     if (userRole == null) {
    //         throw new RuntimeException("Role introuvable");
    //     }
    //     users.getRoles().add(userRole);
    //     return service.saveOrUpdate(null)
    // }


    @PostMapping(value = "/test", consumes = "application/json")
    public UserDto saveOrUpdateUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return service.saveOrUpdate(userDto);
    }


}
