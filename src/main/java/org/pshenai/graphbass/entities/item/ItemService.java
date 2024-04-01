package org.pshenai.graphbass.entities.item;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void saveItem(ItemEntity item) {
        repository.save(item);
    }

    public ItemEntity getItem(UUID itemId) {
        return repository.getReferenceById(itemId);
    }
}
