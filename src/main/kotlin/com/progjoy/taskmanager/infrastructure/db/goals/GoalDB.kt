package com.progjoy.taskmanager.infrastructure.db.goals

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.util.Date

@Table("goals")
class GoalDB(
    @Id
    val id: String,
    val description: String,
    @MappedCollection(idColumn = "goal_id", keyColumn = "goal_id")
    val bricks: List<BrickDB>,
)

@Table("bricks")
class BrickDB(
    @Id
    val id: String,
    val description: String,
    val startDate: Date,
    val endDate: Date,
    @MappedCollection(idColumn = "brick_id", keyColumn = "brick_id")
    val tasks: List<TaskDB>,
)

@Table("tasks")
class TaskDB(
    @Id
    val id: String,
    val description: String,
    val status: TaskStatusDB,
    val expectedDate: Date,
)

enum class TaskStatusDB {
    OPEN,
    IN_PROGRESS,
    PAUSED,
    DONE,
}
