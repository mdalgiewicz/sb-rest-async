package com.dalgim.example.sb.rest.async.controller;

import com.dalgim.example.sb.rest.async.dto.UserDto;
import com.dalgim.example.sb.rest.async.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Mateusz Dalgiewicz on 07.06.2017.
 */
@RestController
@RequestMapping("/deferred/users")
public class DeferredResultUserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public DeferredResultUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DeferredResult<List<UserDto>> getAllUsers() {
        final DeferredResult<List<UserDto>> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(userService::getAll)
                .whenCompleteAsync((userDtos, throwable) -> deferredResult.setResult(userDtos));
        LOGGER.info("Returns deferred result");
        return deferredResult;
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public DeferredResult<List<UserDto>> getAllUsersException() {
        final DeferredResult<List<UserDto>> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(userService::getAllException)
                .whenCompleteAsync((userDtos, throwable) -> deferredResult.setResult(userDtos))
                .exceptionally(throwable -> {
                    System.out.println("Test exception occurred");
                    return Collections.emptyList();
                });
        LOGGER.info("Returns deferred result");
        return deferredResult;
    }
}
