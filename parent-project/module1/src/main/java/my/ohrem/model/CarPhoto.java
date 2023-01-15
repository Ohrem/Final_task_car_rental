package my.ohrem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name = "car_photo")
@Getter
@Setter
@RequiredArgsConstructor
public class CarPhoto {
    @Id
    @Column(name = "PHOTO_ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @Lob
    @Column(name = "car_photo", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;
}
