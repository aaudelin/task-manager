package com.progjoy.taskmanager.infrastructure.db.goals

class GoalDB(
    val id: String,
    val description: String,
    val bricks: List<BrickDB>,
)

class BrickDB(
    val id: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val tasks: List<TaskDB>,
)

class TaskDB(
    val id: String,
    val description: String,
    val status: TaskStatusDB,
    val date: String,
)

enum class TaskStatusDB {
    OPEN,
    IN_PROGRESS,
    PAUSED,
    DONE,
}
