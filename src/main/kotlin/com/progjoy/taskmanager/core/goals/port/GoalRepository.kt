package com.progjoy.taskmanager.core.goals.port

import com.progjoy.taskmanager.core.goals.Goal

interface GoalRepository {
    fun find(): List<Goal>

    fun find(id: String): Goal?
}
