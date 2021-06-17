package com.tkachuk.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ContactsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer contact_id;
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "This is required field min 2 symbols")
    private String name;
    @Column(name = "surname")
    @Size(min = 2, max = 30, message = "This is required field min 2 symbols")
    private String surname;
    @Column(name = "middlename")
    @Size(min = 2, max = 30, message = "This is required field min 2 symbols")
    private String middlename;
    @Column(name = "mobilephone")
    @Pattern(regexp = "[+]{1}380[0-9]{9}", message = "Invalid phone format, should be as +380xxxxxxxxx")
    private String mobilephone;
    @Column(name = "email")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email")
    private String email;
    @Column(name = "workphone")
    private String workphone;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserEntity userId;
}
