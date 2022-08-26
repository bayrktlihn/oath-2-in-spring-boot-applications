package io.bayrktlihn.legacy_users_service;

import io.bayrktlihn.legacy_users_service.dbentity.UserDbEntity;
import io.bayrktlihn.legacy_users_service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserDbEntity user = new UserDbEntity("qswe3mg84mfjtu", "Alihan", "Bayraktar", "alihan.bayraktar@bayrktlihn.com", bCryptPasswordEncoder.encode("12345"), "", false);
        usersRepository.save(user);
    }
}
