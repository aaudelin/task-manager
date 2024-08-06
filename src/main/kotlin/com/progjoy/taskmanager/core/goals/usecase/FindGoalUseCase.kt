package com.progjoy.taskmanager.core.goals.usecase

import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.GoalDescription
import com.progjoy.taskmanager.core.goals.GoalId
import com.progjoy.taskmanager.core.goals.GoalStatus
import com.progjoy.taskmanager.core.goals.Task
import com.progjoy.taskmanager.core.goals.TaskDescription
import com.progjoy.taskmanager.core.goals.TaskEndDate
import com.progjoy.taskmanager.core.goals.TaskId
import com.progjoy.taskmanager.core.goals.TaskStartDate
import com.progjoy.taskmanager.core.goals.TaskStatus
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Date

interface FindGoalUseCase {
    fun execute(): List<Goal>
}

@Service
class FindGoalUseCaseImpl : FindGoalUseCase {
    override fun execute(): List<Goal> =
        listOf(
            Goal(
                id = GoalId("1"),
                description = GoalDescription("Goal 1"),
                status = GoalStatus.OPEN,
                tasks =
                    listOf(
                        Task(
                            id = TaskId("1"),
                            description = TaskDescription("Task 1"),
                            status = TaskStatus.OPEN,
                            startDate = TaskStartDate(Date.from(Instant.now())),
                            endDate = TaskEndDate(Date.from(Instant.now().plus(15, ChronoUnit.DAYS))),
                        ),
                    ),
            ),
            Goal(
                id = GoalId("2"),
                description = GoalDescription("Goal 2"),
                status = GoalStatus.PAUSED,
                tasks =
                    listOf(
                        Task(
                            id = TaskId("2"),
                            description = TaskDescription("Task 2"),
                            status = TaskStatus.PAUSED,
                            startDate = TaskStartDate(Date.from(Instant.now())),
                            endDate = TaskEndDate(Date.from(Instant.now().plus(15, ChronoUnit.DAYS))),
                        ),
                        Task(
                            id = TaskId("3"),
                            description = TaskDescription("Task 3"),
                            status = TaskStatus.DONE,
                            startDate = TaskStartDate(Date.from(Instant.now())),
                            endDate = TaskEndDate(Date.from(Instant.now())),
                        ),
                    ),
            ),
            Goal(
                id = GoalId("3"),
                description = GoalDescription("Goal 3"),
                status = GoalStatus.IN_PROGRESS,
                tasks =
                    listOf(
                        Task(
                            id = TaskId("4"),
                            description = TaskDescription("Task 4"),
                            status = TaskStatus.OPEN,
                            startDate = TaskStartDate(Date.from(Instant.now())),
                            endDate = TaskEndDate(Date.from(Instant.now().plus(15, ChronoUnit.DAYS))),
                        ),
                        Task(
                            id = TaskId("5"),
                            description = TaskDescription("Task 5"),
                            status = TaskStatus.IN_PROGRESS,
                            startDate = TaskStartDate(Date.from(Instant.now())),
                            endDate = TaskEndDate(Date.from(Instant.now().plus(10, ChronoUnit.DAYS))),
                        ),
                        Task(
                            id = TaskId("6"),
                            description = TaskDescription("Task 6"),
                            status = TaskStatus.DONE,
                            startDate = TaskStartDate(Date.from(Instant.now())),
                            endDate = TaskEndDate(Date.from(Instant.now())),
                        ),
                    ),
            ),
        )
}
