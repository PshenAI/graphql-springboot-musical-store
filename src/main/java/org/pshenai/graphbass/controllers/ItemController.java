package org.pshenai.graphbass.controllers;

import org.pshenai.graphbass.entities.item.ItemEntity;
import org.pshenai.graphbass.entities.item.ItemService;
import org.pshenai.graphbass.entities.item.ItemType;
import org.pshenai.graphbass.entities.manufacturer.ManufacturerEntity;
import org.pshenai.graphbass.entities.manufacturer.ManufacturerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ItemController {

    private final ItemService service;
    private final ManufacturerService manufacturerService;

    public ItemController(ItemService service, ManufacturerService manufacturerService) {
        this.service = service;
        this.manufacturerService = manufacturerService;
    }

    @MutationMapping
    ItemEntity addItem(@Argument ItemInput item){
        ManufacturerEntity manufacturer = manufacturerService.getManufacturer(item.manufacturerId());

        return service.saveItem(new ItemEntity(item.itemName(), ItemType.valueOf(item.itemType()), item.price(), item.quantity(), manufacturer));
    }

    record ItemInput(String itemName, String itemType, String price, int quantity, UUID manufacturerId) {}
}
