package my.ohrem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_client")
@Getter
@Setter
public class Client {
    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "t_client_seq")
    private long id;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private ClientDetail clientDetail;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private ClientPhoto clientPhoto;
}
