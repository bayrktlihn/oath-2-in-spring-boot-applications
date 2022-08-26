package io.bayrktlihn.legacy_users_service.dbentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class UserDbEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(nullable = false, name = "user_id")
    private String userId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "encrypted_password")
    private String encryptedPassword;

    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "email_verification_status")
    private Boolean emailVerificationStatus = false;

    public UserDbEntity(String userId, String firstName, String lastName, String email, String encryptedPassword, String emailVerificationToken, Boolean emailVerificationStatus) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.emailVerificationToken = emailVerificationToken;
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
