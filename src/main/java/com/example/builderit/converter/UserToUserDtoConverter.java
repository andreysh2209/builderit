package com.example.builderit.converter;

import com.example.builderit.dto.UserDto;
import com.example.builderit.enums.UserRole;
import com.example.builderit.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter extends Converter <User, UserDto>{
    @Override
    public  UserDto convert(User user) {
      UserDto userDto = new UserDto();
      userDto.setId(user.getId());
      userDto.setLogin(user.getLogin());
      userDto.setUserRole(user.getUserRoles().stream().toList().get(0).name());

        return userDto;
    }
}


