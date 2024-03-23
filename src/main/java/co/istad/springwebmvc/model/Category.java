package co.istad.springwebmvc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//annotation for orm
@Entity
//customize table or change name
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {

//    JPA specification
//    Primarykey : @Id
    @Id
//    change strategy from integer to serial (auto increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false,length = 40)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

}
