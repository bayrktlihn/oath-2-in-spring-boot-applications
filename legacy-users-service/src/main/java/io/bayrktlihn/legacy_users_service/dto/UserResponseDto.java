package io.bayrktlihn.legacy_users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String userId;
}
