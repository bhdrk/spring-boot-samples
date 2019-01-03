package demo.controller;


import com.fasterxml.jackson.annotation.JsonView;
import demo.dto.UserDto;
import demo.entity.UserEntity;
import demo.entity.UserView;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public UserEntity create(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/{userId}")
    @JsonView(UserView.PublicWithIdentityNumber.class)
    public UserDto get(@PathVariable(name = "userId") Long id){
        return userService.findUserById(id);
    }

}
