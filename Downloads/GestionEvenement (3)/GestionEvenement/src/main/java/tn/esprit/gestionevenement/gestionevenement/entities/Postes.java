package tn.esprit.gestionevenement.gestionevenement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Postes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String contenu ;
    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy ="post")
    private Set<Commentaires> commentaires;
}
