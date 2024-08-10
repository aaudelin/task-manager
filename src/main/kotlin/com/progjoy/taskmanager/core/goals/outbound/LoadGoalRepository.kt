package com.progjoy.taskmanager.core.goals.outbound

import com.progjoy.taskmanager.core.annotation.DDDRepository
import com.progjoy.taskmanager.core.goals.Goal

@DDDRepository
interface LoadGoalRepository {
    fun find(): List<Goal>

    fun find(id: String): Goal?
}
