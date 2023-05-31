package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUser;

    private String login;
    private String pwd;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Customer customer;
}
