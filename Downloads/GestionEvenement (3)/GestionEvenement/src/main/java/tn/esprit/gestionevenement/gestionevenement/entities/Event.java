package tn.esprit.gestionevenement.gestionevenement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String libelle;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String objectif;
    private String environnement;
    private Integer valeur ;
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy ="event")
    private Set<Projet> projets;

    @OneToMany(mappedBy = "event")
    private Set<Cible> cibles;
}
