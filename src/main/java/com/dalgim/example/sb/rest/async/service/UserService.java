package com.dalgim.example.sb.rest.async.service;

import com.dalgim.example.sb.rest.async.domain.User;
import com.dalgim.example.sb.rest.async.dto.UserDto;
import com.dalgim.example.sb.rest.async.mapper.UserMapper;
import com.dalgim.example.sb.rest.async.mapper.UserMapperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Mateusz Dalgiewicz on 06.06.2017.
 */
@Service
public class UserService {

    private static final UserMapper USER_MAPPER = new UserMapperImpl();
    private static final List<User> users = new ArrayList<>();
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private AtomicLong atomicLong = new AtomicLong();


    @PostConstruct
    private void init() {
        users.add(new User(atomicLong.getAndIncrement(), "John0", "Smith0"));
        users.add(new User(atomicLong.getAndIncrement(), "John1", "Smith1"));
        users.add(new User(atomicLong.getAndIncrement(), "John2", "Smith2"));
        users.add(new User(atomicLong.getAndIncrement(), "John3", "Smith3"));
        users.add(new User(atomicLong.getAndIncrement(), "John4", "Smith4"));
        users.add(new User(atomicLong.getAndIncrement(), "John5", "Smith5"));
        users.add(new User(atomicLong.getAndIncrement(), "John6", "Smith6"));
        users.add(new User(atomicLong.getAndIncrement(), "John7", "Smith7"));
        users.add(new User(atomicLong.getAndIncrement(), "John8", "Smith8"));
        users.add(new User(atomicLong.getAndIncrement(), "John9", "Smith9"));
    }

    public void add(UserDto userDto) {
        users.add(USER_MAPPER.map(userDto));
    }

    public void remove(UserDto userDto) {
        users.remove(USER_MAPPER.map(userDto));
    }

    public Optional<UserDto> findById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .map(USER_MAPPER::map);
    }

    public List<UserDto> getAll() {
        try {
            LOGGER.info("Slowing task START...");
            TimeUnit.SECONDS.sleep(3);
            final List<UserDto> userDtos = users.stream()
                    .map(USER_MAPPER::map)
                    .collect(Collectors.toList());
            LOGGER.info("Slowing task STOP...");
            return userDtos;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
