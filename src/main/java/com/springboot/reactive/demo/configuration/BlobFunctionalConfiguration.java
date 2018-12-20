//package com.springboot.reactive.demo.configuration;
//
//import com.springboot.reactive.demo.model.Blob;
//import com.springboot.reactive.demo.repository.ReactiveBlobMongoRepository;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import java.util.Date;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
//import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
//import static org.springframework.web.reactive.function.server.RequestPredicates.path;
//import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//
//@Configuration
//public class BlobFunctionalConfiguration
//{
//    @Bean
//    RouterFunction<?> handleBlobs(ReactiveBlobMongoRepository reactiveBlobMongoRepository)
//    {
//        return nest(path("/blob/reactive"),
//
//                route(GET("/all"),
//                        serverRequest -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                                .body(reactiveBlobMongoRepository.findAll(), Blob.class))
//                .andRoute(POST("/insert"),
//                        serverRequest -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                                .body(reactiveBlobMongoRepository.insert(serverRequest.bodyToMono(Blob.class)), Blob.class))
//                .andRoute(POST("/insertTest"),
//                        serverRequest -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                                .body(reactiveBlobMongoRepository.saveAll(RandomBlobGenerator.generate(Optional.of(serverRequest.pathVariable("quantity"))
//                                    .map(Integer::valueOf)
//                                    .orElse(0))), Blob.class))
//                .andRoute(DELETE("/deleteAll"),
//                        serverRequest -> {
//                            reactiveBlobMongoRepository.deleteAll();
//                            return ServerResponse.ok().build();
//                        }));
//    }
//
//        private static class RandomBlobGenerator
//    {
//        private static Set<Blob> generate(Integer quantity)
//        {
//            return IntStream.range(0, quantity)
//                    .mapToObj(i -> new Blob(new Date(),
//                            RandomStringUtils.random(quantity, true, true)))
//                    .collect(Collectors.toSet());
//        }
//    }
//}
