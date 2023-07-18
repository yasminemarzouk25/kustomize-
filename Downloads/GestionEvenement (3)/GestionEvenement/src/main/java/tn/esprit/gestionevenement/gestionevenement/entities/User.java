package tn.esprit.gestionevenement.gestionevenement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable , UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole ;
    private Boolean locked =false ;
    private  Boolean enabled = false;

    public User(String name, String email, String pwd, AppUserRole appUserRole) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.appUserRole = appUserRole;

    }

    @OneToMany(mappedBy ="user")
    private Set<Postes> postes;

    @OneToMany(mappedBy ="user")
    private Set<Logistique> logistiques;

    @JsonIgnore
    @OneToMany(mappedBy ="user")
    private Set<Event> events;

    @OneToMany(mappedBy ="user")
    private Set<Reclamation> reclamations;

    @OneToMany(mappedBy ="user")
    private Set<FeedBack> feedBacks;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }



    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
