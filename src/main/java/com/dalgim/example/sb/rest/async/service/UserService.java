package com.dalgim.example.sb.rest.async.service;

import com.dalgim.example.sb.rest.async.domain.User;
import com.dalgim.example.sb.rest.async.dto.UserDto;
import com.dalgim.example.sb.rest.async.mapper.UserMapper;
import com.dalgim.example.sb.rest.async.mapper.UserMapperImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Mateusz Dalgiewicz on 06.06.2017.
 */
@Service
public class UserService {

    private static final UserMapper USER_MAPPER = new UserMapperImpl();
    private static final List<User> users = new ArrayList<>();

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
        return users.stream()
                .map(USER_MAPPER::map)
                .collect(Collectors.toList());
    }
}
