/* Copyright 2013 Sabre Holdings */
package com.springboot.reactive.demo.repository;

import com.springboot.reactive.demo.model.Blob;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlockingBlobMongoRepository extends MongoRepository<Blob, String>
{
}
