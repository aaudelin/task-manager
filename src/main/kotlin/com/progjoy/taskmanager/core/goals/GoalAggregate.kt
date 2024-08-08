package com.progjoy.taskmanager.core.goals

import java.util.Date

data class Goal(
    val id: Id,
    val description: Description,
    val status: GoalStatus,
    val bricks: List<Brick>,
)

enum class GoalStatus {
    OPEN,
    IN_PROGRESS,
    PAUSED,
    DONE,
}

data class Brick(
    val id: Id,
    val description: Description,
    val period: TimePeriod,
    val tasks: List<Task>,
)

data class Task(
    val id: Id,
    val description: Description,
    val status: TaskStatus,
    val period: Date,
)

enum class TaskStatus {
    OPEN,
    IN_PROGRESS,
    PAUSED,
    DONE,
}

data class Id(
    val value: String,
)

data class Description(
    val value: String,
)

data class TimePeriod(
    val startDate: Date,
    val endDate: Date,
)
