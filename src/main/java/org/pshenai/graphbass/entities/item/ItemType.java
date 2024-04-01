package org.pshenai.graphbass.entities.item;

import lombok.Getter;

@Getter
public enum ItemType {
    INSTRUMENT(1),
    MISCELLANEOUS(2);

    private final int itemType;

    ItemType(int itemType) {
        this.itemType = itemType;
    }
}
