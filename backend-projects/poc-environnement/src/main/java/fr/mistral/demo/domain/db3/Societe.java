package fr.mistral.demo.domain.db3;

import fr.mistral.demo.domain.central.UserC;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Societe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable=false)
//    private UserC usr;
}
