package io.bayrktlihn.resource_server.controller;

import io.bayrktlihn.resource_server.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    Environment env;

    @GetMapping("status/check")
    public String status() {
        return "Working on port: " + env.getProperty("local.server.port");
    }

    //    @Secured("ROLE_developer")
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('developer')")
    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping("/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("Alihan", "Bayraktar", "e861bd9f-0e72-4647-b7f9-73a5238e88eb");
    }


}
