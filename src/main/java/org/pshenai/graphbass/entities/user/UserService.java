package org.pshenai.graphbass.entities.user;

import jakarta.transaction.Transactional;
import org.pshenai.graphbass.entities.item.ItemEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(UserEntity user) {
        repository.save(user);
    }

    public UserEntity getUser(UUID userId) {
        return repository.getReferenceById(userId);
    }

    public void saveAll(List<UserEntity> entities) {
        repository.saveAll(entities);
    }

}
