package io.bayrktlihn.resource_server.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {
    private String userFirstName;
    private String userLastname;
    private String userId;
}
