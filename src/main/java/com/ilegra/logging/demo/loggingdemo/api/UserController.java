package com.ilegra.logging.demo.loggingdemo.api;

import com.ilegra.logging.demo.loggingdemo.api.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/users")
    public List<UserDto> getAllUsers() {
        return Arrays.asList(new UserDto("Karane"));
    }
}
