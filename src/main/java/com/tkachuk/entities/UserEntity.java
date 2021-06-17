package com.tkachuk.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "This is a required field min 2 symbols")
    private String name;
    @Column(name = "surname")
    @Size(min = 2, max = 30, message = "This is required field min 2 symbols")
    private String surname;
    @Column(name = "middlename")
    @Size(min = 2, max = 30, message = "This is required field min 2 symbols")
    private String middlename;
    @Column(name = "login")
    @Size(min = 3, max = 30, message = "This is required field min 3 symbols")
    @Pattern(regexp = "[A-Za-z]+", message = "Only English characters")
    private String login;
    @Column(name = "password")
    @Size(min = 5, max = 50, message = "This is required field and min 5 symbols")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ContactsEntity> contactsCollection;
}
