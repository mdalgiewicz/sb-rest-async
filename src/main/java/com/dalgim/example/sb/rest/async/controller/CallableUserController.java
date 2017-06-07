package com.dalgim.example.sb.rest.async.controller;

import com.dalgim.example.sb.rest.async.dto.UserDto;
import com.dalgim.example.sb.rest.async.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Mateusz Dalgiewicz on 07.06.2017.
 */
@RestController
@RequestMapping("/callable/users")
public class CallableUserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public CallableUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Callable<List<UserDto>> getAllUsers() {
        final Callable<List<UserDto>> callable = userService::getAll;
        LOGGER.info("Returns callable result");
        return callable;
    }
}
