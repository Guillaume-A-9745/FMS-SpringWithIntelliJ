package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCustomer;
    private String name;
    private String firstname;
    private String email;
    private String phone;
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Collection<Command> commands;
}
