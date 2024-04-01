package org.pshenai.graphbass.entities.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pshenai.graphbass.entities.manufacturer.ManufacturerEntity;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private ManufacturerEntity manufacturer;

    public ItemEntity(String itemName, ItemType itemType, String price, int quantity, ManufacturerEntity manufacturer) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }
}
