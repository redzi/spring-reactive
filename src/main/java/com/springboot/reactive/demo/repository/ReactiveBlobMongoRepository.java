/* Copyright 2013 SabYre Holdings */
package com.springboot.reactive.demo.repository;

import com.springboot.reactive.demo.model.Blob;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveBlobMongoRepository extends ReactiveMongoRepository<Blob, String>
{
}
