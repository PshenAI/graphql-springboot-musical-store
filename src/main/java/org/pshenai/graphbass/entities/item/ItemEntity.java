package org.pshenai.graphbass.entities.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "items")

public class ItemEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String itemName;
    @Enumerated(EnumType.ORDINAL)
    private ItemType itemType;
    private String price;
    private int quantity;
}
