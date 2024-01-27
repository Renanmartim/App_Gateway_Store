package com.Store.Store.Repository;

import com.Store.Store.Entity.StoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends MongoRepository<StoreEntity, String> {

    Optional<StoreEntity> findBynameItem(String name);
}
