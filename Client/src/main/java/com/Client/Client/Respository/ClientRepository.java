package com.Client.Client.Respository;

import com.Client.Client.Entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity, String> {
    Optional<ClientEntity> findAllById(String id);
}
