package com.example.todoappch7.todoapp

import com.example.todoappch7.TodoViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {
    // The system under test recreated before each test
    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp(){
        viewModel = TodoViewModel()
    }

    @Test
    fun add_Task_withValidTitle_appearsInList(){
        // Arrange - the setUp() already created an empty viewModel

        // Action -- Call the function we want to test
        viewModel.addTask("Buy Groceries")

        // Assert -- Verify the result
        assertEquals(1,viewModel.getTaskCount())
        assertTrue(viewModel.containsTask("Buy Groceries"))
    }

    @Test
    fun add_Task_withBlankTitle_isIgnored(){
        // Action
        viewModel.addTask("              ")

        // Assert
        assertEquals(0,viewModel.getTaskCount())
        assertFalse(viewModel.containsTask("              "))
    }

    @Test
    fun add_Task_withEmptyString_isIgnored(){
        // Action
        viewModel.addTask("")

        // Assert
        assertEquals(0,viewModel.getTaskCount())
        assertFalse(viewModel.containsTask(""))
    }

    @Test
    fun add_Task_tittleIsTrimmed(){
        // Action
        viewModel.addTask("     Do exercise      ")

        // Assert
        assertEquals(1,viewModel.getTaskCount())
        assertTrue(viewModel.containsTask("Do exercise"))
    }

    @Test
    fun removeTask_withValidId_removesTask(){
        // Arrange - add a task first so we have something to remove
        viewModel.addTask("Do exercise")
        val taskId = viewModel.task[0].id

        // Action
        viewModel.removeTask(taskId)

        // Assert
        assertEquals(0,viewModel.getTaskCount())
        assertFalse(viewModel.containsTask("Do exercise"))
    }

    // Challenge
    @Test
    fun removeTask_withInvalidId_doesNothing(){
        // Arrange
        viewModel.addTask("Eat")

        // Action
        viewModel.removeTask(99)

        // Assert
        assertEquals(1,viewModel.getTaskCount())
        assertTrue(viewModel.containsTask("Eat"))
    }
}