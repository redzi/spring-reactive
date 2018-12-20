package com.springboot.reactive.demo.controller;

import com.springboot.reactive.demo.model.Blob;
import com.springboot.reactive.demo.repository.ReactiveBlobMongoRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/blob/reactive")
public class BlobReactiveController
{
    @Autowired
    private ReactiveBlobMongoRepository reactiveBlobMongoRepository;

    @GetMapping(value = "/all")
    public Flux<Blob> findAll() throws Exception
    {
        System.out.println("Request is hadled by: " + Thread.currentThread().getName());
        return reactiveBlobMongoRepository.findAll();
//        Thread.currentThread().sleep(150L);
//        return Flux.empty();
    }

    @PostMapping(value = "/insert")
    public Mono<Blob> insert(@RequestParam Blob blob)
    {
        return Mono.just(blob);
    }

    @PostMapping(value = "/insertTest")
    public Flux<Blob> insertTest(@RequestParam("quantity") @NonNull Integer quantity)
    {
        return reactiveBlobMongoRepository.saveAll(RandomBlobGenerator.generate(quantity));
    }

    @DeleteMapping(value = "/deleteAll")
    public Mono<Void> deleteAll()
    {
        return reactiveBlobMongoRepository.deleteAll();
    }

    private static class RandomBlobGenerator
    {
        private static Set<Blob> generate(Integer quantity)
        {
            return IntStream.range(0, quantity)
                    .mapToObj(i -> new Blob(new Date(),
                            RandomStringUtils.random(quantity, true, true)))
                    .collect(Collectors.toSet());
        }
    }
}
