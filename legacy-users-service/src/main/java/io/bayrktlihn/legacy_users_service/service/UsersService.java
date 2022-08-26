package io.bayrktlihn.legacy_users_service.service;

import io.bayrktlihn.legacy_users_service.dto.UserResponseDto;
import io.bayrktlihn.legacy_users_service.dbentity.UserDbEntity;
import io.bayrktlihn.legacy_users_service.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersService {


    private final UsersRepository usersRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResponseDto getUserDetails(String username) {
        UserResponseDto userResponseDto = new UserResponseDto();

        UserDbEntity userDbEntity = usersRepository.findByEmail(username);

        if (userDbEntity == null) {
            return userResponseDto;
        }

        BeanUtils.copyProperties(userDbEntity, userResponseDto);

        return userResponseDto;
    }


    public UserResponseDto getUserDetails(String username, String password) {
        UserResponseDto userResponseDto = null;

        UserDbEntity userDbEntity = usersRepository.findByEmail(username);

        if (userDbEntity == null) {
            return userResponseDto;
        }

        if (bCryptPasswordEncoder.matches(password, userDbEntity.getEncryptedPassword())) {
            System.out.println("password matches!!!");

            userResponseDto = new UserResponseDto();
            BeanUtils.copyProperties(userDbEntity, userResponseDto);
        }

        return userResponseDto;
    }
}
