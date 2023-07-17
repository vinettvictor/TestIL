package cl.bci.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.*;

@Builder
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
    private Date createAt;

    @CreationTimestamp
    private Date modifiedAt;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Phones> phone = new ArrayList<>();



    public void addPhone(Phones phones){
        phone.add(phones);
        phones.setUser(this);
    }

}
