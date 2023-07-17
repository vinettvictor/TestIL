package cl.bci.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "phone")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pho_id")
    private Long id;

    @Column(name = "pho_number")
    private String number;

    @Column(name = "pho_citycode")
    private String citycode;

    @Column(name = "pho_contrycode")
    private String contrycode;

    @ManyToOne
    private User user;


    @Override
    public String toString() {
        return "Phones{" +
                "number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", contrycode='" + contrycode + '\'' +
                '}';
    }
}
