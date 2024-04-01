package org.pshenai.graphbass.entities.manufacturer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerService {

    private ManufacturerRepository repository;

    public ManufacturerService(ManufacturerRepository repository) {
        this.repository = repository;
    }


    public void saveManufacturer(ManufacturerEntity manufacturer) {
        repository.save(manufacturer);
    }

    public ManufacturerEntity getManufacturer(UUID manufacturerId) {
        return repository.getReferenceById(manufacturerId);
    }

    public void saveAll(List<ManufacturerEntity> entities) {
        repository.saveAll(entities);
    }
}
