package com.progjoy.taskmanager.core.goals.inbound

import com.progjoy.taskmanager.core.annotation.DDDUseCase
import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.outbound.LoadGoalRepository

@FunctionalInterface
interface FindGoalUseCase {
    fun execute(): List<Goal>
}

@DDDUseCase
class FindGoalUseCaseImpl(
    val goalRepository: LoadGoalRepository,
) : FindGoalUseCase {
    override fun execute(): List<Goal> = goalRepository.find()
}
