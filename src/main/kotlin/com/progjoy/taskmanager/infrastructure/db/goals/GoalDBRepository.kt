package com.progjoy.taskmanager.infrastructure.db.goals

import com.progjoy.taskmanager.core.goals.Goal
import com.progjoy.taskmanager.core.goals.outbound.LoadGoalRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface GoalDBRepository : CrudRepository<GoalDB, String>

@Repository
class GoalDBRepositoryCustom(
    val goalDBRepository: GoalDBRepository,
    val goalMapper: GoalMapper,
) : LoadGoalRepository {
    override fun find(): List<Goal> = goalDBRepository.findAll().toList().map { goalMapper.toGoal(it) }

    override fun find(id: String): Goal? = goalMapper.toGoal(goalDBRepository.findById(id).orElse(null))
}
