package com.progjoy.taskmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SubscriptionMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import java.time.Duration

@SpringBootApplication
class TaskManagerApplication

fun main(args: Array<String>) {
    runApplication<TaskManagerApplication>(*args)
}

@Controller
private class EventController {
    @QueryMapping
    fun findEvent(): String = "Hello, World!"

    @SubscriptionMapping
    fun newEvent(): Flux<String> =
        Flux
            .interval(Duration.ofMillis(50))
            .map { "Hello, World!" }
}
