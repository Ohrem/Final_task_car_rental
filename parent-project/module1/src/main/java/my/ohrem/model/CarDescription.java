package my.ohrem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "car_description")
@Getter
@Setter
@RequiredArgsConstructor
public class CarDescription {
    @Id
    @Column(name = "DESCRIPTION_ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @Column
    private String description;


}
