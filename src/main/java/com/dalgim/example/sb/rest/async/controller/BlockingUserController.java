package com.dalgim.example.sb.rest.async.controller;

import com.dalgim.example.sb.rest.async.dto.UserDto;
import com.dalgim.example.sb.rest.async.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Mateusz Dalgiewicz on 07.06.2017.
 */
@RestController
@RequestMapping(value = "/blocking/users")
public class BlockingUserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public BlockingUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getAllUsers() {
        final List<UserDto> userDtos = userService.getAll();
        LOGGER.info("Returns blocking result");
        return userDtos;
    }
}
