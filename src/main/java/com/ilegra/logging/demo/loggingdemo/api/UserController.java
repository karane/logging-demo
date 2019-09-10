package com.ilegra.logging.demo.loggingdemo.api;

import com.ilegra.logging.demo.loggingdemo.api.dto.UserDto;
import com.ilegra.logging.demo.loggingdemo.instrumentation.LoggingInstrumentation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private LoggingInstrumentation instrumentation;

    @RequestMapping("/users")
    public List<UserDto> getAllUsers() {
        instrumentation.beforeListing();
        return Arrays.asList(new UserDto("Karane"));
    }
}
