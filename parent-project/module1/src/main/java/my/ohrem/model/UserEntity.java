package my.ohrem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "app_user")
public class UserEntity implements BaseEntity<Long> {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    private Double balance;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserPhoto userPhoto;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private OrderEntity orderEntity;

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userEntities", fetch = FetchType.EAGER)
    private List<OrderEntity> orderList;*/


}