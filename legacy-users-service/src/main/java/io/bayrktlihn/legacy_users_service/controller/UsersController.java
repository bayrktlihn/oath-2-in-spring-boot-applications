package io.bayrktlihn.legacy_users_service.controller;

import io.bayrktlihn.legacy_users_service.dto.UserResponseDto;
import io.bayrktlihn.legacy_users_service.dto.VerifyPasswordResponseDto;
import io.bayrktlihn.legacy_users_service.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("{username}")
    public UserResponseDto getUser(@PathVariable("username") String username) {
        return usersService.getUserDetails(username);
    }

    @PostMapping("{username}/verify-password")
    public VerifyPasswordResponseDto verifyPasswordResponseDto(@PathVariable("username") String username, @RequestBody String password) {
        VerifyPasswordResponseDto verifyPasswordResponseDto = new VerifyPasswordResponseDto(false);

        UserResponseDto userResponseDto = usersService.getUserDetails(username, password);

        if (userResponseDto != null) {
            verifyPasswordResponseDto.setResult(true);
        }

        return verifyPasswordResponseDto;
    }
}
