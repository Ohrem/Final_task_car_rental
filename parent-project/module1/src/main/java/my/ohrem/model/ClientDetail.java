package my.ohrem.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name = "t_client_detail")
@Getter
@Setter
public class ClientDetail {
    @Id
    @Column(name = "F_CLIENTID")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "client")
    )
    private long id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STATE")
    private String state;

    @Column(name = "STREET")
    private String street;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Client client;

    @Override
    public String toString() {
        return "RentalUserDetail{" +
               "id=" + id +
               ", city='" + city + '\'' +
               ", country='" + country + '\'' +
               ", state='" + state + '\'' +
               ", street='" + street + '\'' +
               ", rentalUser=" + client +
               '}';
    }
}
