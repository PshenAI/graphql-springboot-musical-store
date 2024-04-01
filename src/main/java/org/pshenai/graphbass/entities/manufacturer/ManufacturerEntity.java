package org.pshenai.graphbass.entities.manufacturer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pshenai.graphbass.entities.item.ItemEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "manufacturers")
public class ManufacturerEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String companyName;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<ItemEntity> items = new ArrayList<>();

    public ManufacturerEntity(String companyName, List<ItemEntity> items) {
        this.companyName = companyName;
        this.items = items;
    }
}
