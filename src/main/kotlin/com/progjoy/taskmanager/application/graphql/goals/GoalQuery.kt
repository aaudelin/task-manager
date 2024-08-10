package com.progjoy.taskmanager.application.graphql.goals

import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.inbound.FindGoalUseCase
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class GoalQuery(
    val findGoalUseCase: FindGoalUseCase,
) {
    @QueryMapping
    fun findGoals(): List<Goal> = findGoalUseCase.execute()
}
