package com.progjoy.taskmanager.core.goals

import com.progjoy.taskmanager.core.annotation.DDDAggregate
import java.util.Date

@DDDAggregate
data class Goal(
    val id: Id,
    val description: Description,
    val bricks: List<Brick>,
) {
    fun status(): GoalStatus {
        val tasks = bricks.flatMap { it.tasks }
        return if (tasks.any { it.status == TaskStatus.OPEN }) {
            GoalStatus.OPEN
        } else if (tasks.any { it.status == TaskStatus.IN_PROGRESS }) {
            GoalStatus.IN_PROGRESS
        } else if (tasks.any { it.status == TaskStatus.PAUSED }) {
            GoalStatus.PAUSED
        } else {
            GoalStatus.DONE
        }
    }
}

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
