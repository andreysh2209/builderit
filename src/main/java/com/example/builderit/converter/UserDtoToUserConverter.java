package com.example.builderit.converter;

import com.example.builderit.dto.UserDto;
import com.example.builderit.enums.UserRole;
import com.example.builderit.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter extends Converter <UserDto, User>{

    @Override
    public User convert(UserDto userDto) {
        User user =new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.getUserRoles().add(UserRole.ROLE_USER);
        return user;
    }
}
