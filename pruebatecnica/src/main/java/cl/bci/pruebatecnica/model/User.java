package cl.bci.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "usu_id")
    private UUID id;

    @Column(name = "usu_name")
    private String name;

    @Column(name = "usu_password")
    private String password;

    @Column(name = "usu_email")
    private String email;

    @Column(name = "usu_estate")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "usu_create")
    private Date createAt;

    @CreationTimestamp
    @Column(name = "usu_modified")
    private Date modifiedAt;

    @CreationTimestamp
    @Column(name = "usu_lastlogin")
    private Date lastLogin;

    private String token;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Phones> phone = new ArrayList<>();


    public void addPhone(Phones phones){
        phone.add(phones);
    }

}
