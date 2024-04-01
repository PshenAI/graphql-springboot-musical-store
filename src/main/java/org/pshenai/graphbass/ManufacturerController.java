package org.pshenai.graphbass;

import org.pshenai.graphbass.entities.manufacturer.ManufacturerEntity;
import org.pshenai.graphbass.entities.manufacturer.ManufacturerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ManufacturerController {

    private final ManufacturerService service;

    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }


    @QueryMapping
    Iterable<ManufacturerEntity> manufacturers() {
        return service.getAll();
    }

    @QueryMapping
    ManufacturerEntity manufacturerById(@Argument UUID id) {
        return service.getManufacturer(id);
    }
}
