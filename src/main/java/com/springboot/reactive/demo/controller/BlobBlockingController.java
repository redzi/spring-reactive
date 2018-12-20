/* Copyright 2013 Sabre Holdings */
package com.springboot.reactive.demo.controller;

import com.springboot.reactive.demo.model.Blob;
import com.springboot.reactive.demo.repository.BlockingBlobMongoRepository;
import com.springboot.reactive.demo.repository.ReactiveBlobMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@RestController
@RequestMapping("/blob/blocking")
public class BlobBlockingController
{
    @Autowired
    private BlockingBlobMongoRepository blockingBlobMongoRepository;

    @GetMapping(value = "/all")
    public Iterable<Blob> findAll() throws Exception
    {
        System.out.println("Request is hadled by: " + Thread.currentThread().getName());
        return blockingBlobMongoRepository.findAll();

//        Thread.currentThread().sleep(150L);

//        return new HashSet<>();

    }

    @PostMapping(value = "/insert")
    public Blob insert(@RequestParam Blob blob)
    {
        return blockingBlobMongoRepository.save(blob);
    }

}
