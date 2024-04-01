package org.pshenai.graphbass.entities.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

}
