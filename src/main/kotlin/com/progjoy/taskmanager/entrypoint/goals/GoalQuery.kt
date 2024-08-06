package com.progjoy.taskmanager.entrypoint.goals

import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.usecase.FindGoalUseCase
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class GoalQuery(
    val findGoalUseCase: FindGoalUseCase,
) {
    @QueryMapping
    fun findGoals(): List<Goal> = findGoalUseCase.execute()
}
