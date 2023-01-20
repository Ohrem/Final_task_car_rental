package my.ohrem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@ToString(exclude = {"userEntity", "carEntity", "paymentEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class OrderEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String message;

    @OneToOne
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity paymentEntity;

}
