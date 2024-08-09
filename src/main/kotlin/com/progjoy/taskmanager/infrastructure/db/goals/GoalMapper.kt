package com.progjoy.taskmanager.infrastructure.db.goals

import com.progjoy.taskmanager.core.goals.Brick
import com.progjoy.taskmanager.core.goals.Description
import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.Id
import com.progjoy.taskmanager.core.goals.Task
import com.progjoy.taskmanager.core.goals.TaskStatus
import com.progjoy.taskmanager.core.goals.TimePeriod
import org.springframework.stereotype.Component

@Component
class GoalMapper {
    fun toGoal(goalDB: GoalDB): Goal =
        Goal(
            id = Id(goalDB.id),
            description = Description(goalDB.description),
            bricks = goalDB.bricks.map { toBrick(it) },
        )

    fun toBrick(brickDB: BrickDB): Brick =
        Brick(
            id = Id(brickDB.id),
            description = Description(brickDB.description),
            period = TimePeriod(brickDB.startDate, brickDB.endDate),
            tasks = brickDB.tasks.map { toTask(it) },
        )

    fun toTask(taskDB: TaskDB): Task =
        Task(
            id = Id(taskDB.id),
            description = Description(taskDB.description),
            status =
                when (taskDB.status) {
                    TaskStatusDB.OPEN -> TaskStatus.OPEN
                    TaskStatusDB.IN_PROGRESS -> TaskStatus.IN_PROGRESS
                    TaskStatusDB.PAUSED -> TaskStatus.PAUSED
                    TaskStatusDB.DONE -> TaskStatus.DONE
                },
            period = taskDB.expectedDate,
        )
}
