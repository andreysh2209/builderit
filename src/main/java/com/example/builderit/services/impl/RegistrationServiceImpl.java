package com.example.builderit.services.impl;

import com.example.builderit.converter.UserDtoToUserConverter;
import com.example.builderit.converter.UserToUserDtoConverter;
import com.example.builderit.dto.UserDto;
import com.example.builderit.models.User;
import com.example.builderit.repositories.UserRepository;
import com.example.builderit.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserDtoToUserConverter userDtoToUserConverter;
    private final UserRepository userRepository;
    private final UserToUserDtoConverter userToUserDtoConverter;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto registratoon(UserDto userDto) {
        User user = userDtoToUserConverter.convert(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return userToUserDtoConverter.convert(save);
    }
}
