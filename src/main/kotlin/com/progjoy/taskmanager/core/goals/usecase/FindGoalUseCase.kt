package com.progjoy.taskmanager.core.goals.usecase

import com.progjoy.taskmanager.core.annotations.UseCase
import com.progjoy.taskmanager.core.goals.Brick
import com.progjoy.taskmanager.core.goals.Description
import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.GoalStatus
import com.progjoy.taskmanager.core.goals.Id
import com.progjoy.taskmanager.core.goals.Task
import com.progjoy.taskmanager.core.goals.TaskStatus
import com.progjoy.taskmanager.core.goals.TimePeriod
import java.time.Duration
import java.time.Instant
import java.util.Date

interface FindGoalUseCase {
    fun execute(): List<Goal>
}

@UseCase
class FindGoalUseCaseImpl : FindGoalUseCase {
    override fun execute(): List<Goal> =
        listOf(
            Goal(
                id = Id("1"),
                description = Description("Goal 1"),
                status = GoalStatus.OPEN,
                bricks =
                    listOf(
                        Brick(
                            id = Id("1"),
                            description = Description("Brick 1"),
                            period = TimePeriod(Date(), Date.from(Instant.now().plus(Duration.ofDays(1)))),
                            tasks =
                                listOf(
                                    Task(
                                        id = Id("1"),
                                        description = Description("Task 1"),
                                        status = TaskStatus.OPEN,
                                        period = Date(),
                                    ),
                                ),
                        ),
                    ),
            ),
            Goal(
                id = Id("2"),
                description = Description("Goal 2"),
                status = GoalStatus.IN_PROGRESS,
                bricks =
                    listOf(
                        Brick(
                            id = Id("2"),
                            description = Description("Brick 2"),
                            period = TimePeriod(Date(), Date.from(Instant.now().plus(Duration.ofDays(2)))),
                            tasks =
                                listOf(
                                    Task(
                                        id = Id("2"),
                                        description = Description("Task 2"),
                                        status = TaskStatus.IN_PROGRESS,
                                        period = Date.from(Instant.now().minus(Duration.ofDays(1))),
                                    ),
                                    Task(
                                        id = Id("3"),
                                        description = Description("Task 3"),
                                        status = TaskStatus.OPEN,
                                        period = Date.from(Instant.now().minus(Duration.ofDays(5))),
                                    ),
                                ),
                        ),
                    ),
            ),
            Goal(
                id = Id("3"),
                description = Description("Goal 3"),
                status = GoalStatus.PAUSED,
                bricks =
                    listOf(
                        Brick(
                            id = Id("3"),
                            description = Description("Brick 3"),
                            period = TimePeriod(Date(), Date.from(Instant.now().plus(Duration.ofDays(3)))),
                            tasks =
                                listOf(
                                    Task(
                                        id = Id("4"),
                                        description = Description("Task 4"),
                                        status = TaskStatus.PAUSED,
                                        period = Date.from(Instant.now().minus(Duration.ofDays(6))),
                                    ),
                                    Task(
                                        id = Id("5"),
                                        description = Description("Task 5"),
                                        status = TaskStatus.IN_PROGRESS,
                                        period = Date(),
                                    ),
                                    Task(
                                        id = Id("6"),
                                        description = Description("Task 6"),
                                        status = TaskStatus.DONE,
                                        period = Date(),
                                    ),
                                ),
                        ),
                    ),
            ),
        )
}
