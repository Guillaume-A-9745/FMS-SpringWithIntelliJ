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
public class OrderItem implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idOrderItem;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Article> articles;

    private int quantity;
    private double unitaryPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Command command;
}
