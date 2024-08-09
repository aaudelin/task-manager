package com.progjoy.taskmanager.core.goals.usecase

import com.progjoy.taskmanager.core.annotation.UseCase
import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.port.GoalRepository

interface FindGoalUseCase {
    fun execute(): List<Goal>
}

@UseCase
class FindGoalUseCaseImpl(
    val goalRepository: GoalRepository,
) : FindGoalUseCase {
    override fun execute(): List<Goal> = goalRepository.find()
}
