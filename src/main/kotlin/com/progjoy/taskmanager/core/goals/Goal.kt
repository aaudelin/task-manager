package com.progjoy.taskmanager.core.goals

import java.util.Date

class Goal(
    val id: GoalId,
    val description: GoalDescription,
    val status: GoalStatus,
    val tasks: List<Task>,
)

data class GoalId(
    val value: String,
)

data class GoalDescription(
    val value: String,
)

enum class GoalStatus {
    OPEN,
    IN_PROGRESS,
    PAUSED,
    DONE,
}

data class Task(
    val id: TaskId,
    val description: TaskDescription,
    val status: TaskStatus,
    val startDate: TaskStartDate,
    val endDate: TaskEndDate,
)

data class TaskId(
    val value: String,
)

data class TaskDescription(
    val value: String,
)

enum class TaskStatus {
    OPEN,
    IN_PROGRESS,
    PAUSED,
    DONE,
}

data class TaskStartDate(
    val value: Date,
)

data class TaskEndDate(
    val value: Date,
)
