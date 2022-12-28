package my.ohrem.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_client_photo")
@Getter
@Setter
public class ClientPhoto {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Lob
    @Column(name = "CLIENT_PHOTO", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;
}
