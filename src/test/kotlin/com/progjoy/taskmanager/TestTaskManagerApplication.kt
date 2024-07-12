package com.progjoy.taskmanager

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<TaskManagerApplication>().with(TestcontainersConfiguration::class).run(*args)
}
