package org.pshenai.graphbass.entities.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, UUID> {
}
