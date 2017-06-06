package com.dalgim.example.sb.rest.async.mapper;

import com.dalgim.example.sb.rest.async.domain.User;
import com.dalgim.example.sb.rest.async.dto.UserDto;
import org.mapstruct.Mapper;

/**
 * Created by Mateusz Dalgiewicz on 06.06.2017.
 */
@Mapper
public interface UserMapper {

    UserDto map(User user);
    User map(UserDto userDto);
}
