package my.ohrem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@ToString(exclude = "orderEntity")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "car")
public class CarEntity implements BaseEntity<Long> {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;
    private String brand;
    private String model;
    private String color;
    private Double price;
    private Boolean isAvailable;

    @OneToOne(mappedBy = "carEntity", fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private CarPhoto carPhoto;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private CarDescription carDescription;
}