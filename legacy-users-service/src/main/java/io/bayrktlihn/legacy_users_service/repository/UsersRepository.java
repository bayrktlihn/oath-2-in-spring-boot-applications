package io.bayrktlihn.legacy_users_service.repository;

import io.bayrktlihn.legacy_users_service.dbentity.UserDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserDbEntity, Long> {
    UserDbEntity findByEmail(String username);

}
