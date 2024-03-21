package org.foo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "cart_item_rel",
    joinColumns = @JoinColumn(name = "cart_id"),
    inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

}
