package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Command implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCommand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "command")
    private Collection<OrderItem> orderItems;

    private double amount;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
