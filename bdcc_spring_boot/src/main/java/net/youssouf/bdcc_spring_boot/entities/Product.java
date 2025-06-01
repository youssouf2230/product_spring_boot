package net.youssouf.bdcc_spring_boot.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode @Getter @Setter @Data @Builder
public class Product {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private  String name;
    private  String description;
    @Min(0)
    private  double price;
    @Min(1)
    private  double quantity;

}
