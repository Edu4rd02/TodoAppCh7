package com.example.todoappch7.todoapp

import com.example.todoappch7.TodoViewModel
import junit.framework.TestCase.assertEquals
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
}