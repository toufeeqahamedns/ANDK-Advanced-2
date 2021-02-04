package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsKtTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false),
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnZeros() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnZeros() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}