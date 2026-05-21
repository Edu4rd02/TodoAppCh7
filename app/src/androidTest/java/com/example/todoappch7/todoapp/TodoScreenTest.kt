package com.example.todoappch7.todoapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todoappch7.TodoViewModel
import com.example.todoappch7.ui.screens.TodoScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class TodoScreenTest {
    // This rule launches the composable in a test environment
    @get:Rule
    val composeTestRule = createComposeRule()

    // A fresh ViewModel for each Test
    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp(){
        viewModel = TodoViewModel()

        // Set the content to Display -- Same as MainActivity Does
        composeTestRule.setContent{
            TodoScreen(viewModel = viewModel)
        }
    }

    @Test
    fun addTask_userTypesAndClicksAdd_taskAppearsInList(){
        // Arrange - the setUp() already launched TodoScreen

        // Action -
        // Verify the task does not exist yet
        composeTestRule.onNodeWithText("Do Homework").assertDoesNotExist()

        // Act find the input field by its testTag and type text
        composeTestRule
            .onNodeWithTag("input_field")
            .performTextInput("Do Homework")

        // Act find the Add button and click it
        composeTestRule
            .onNodeWithTag("add_button")
            .performClick()

        // Assert - Verify the task now appears on screen
        composeTestRule
            .onNodeWithText("Do Homework")
            .assertIsDisplayed()
    }

    @Test
    fun addTask_withBlankInput_taskDoesNotAppear() {
        // Arrange - the setUp() already launched TodoScreen

        // Action -
        // Act find the input field by its testTag and type text
        composeTestRule
            .onNodeWithTag("input_field")
            .performTextInput("    ")

        // Act find the Add button and click it
        composeTestRule
            .onNodeWithTag("add_button")
            .performClick()

        // Assert - Verify the task was no added
        composeTestRule
            .onNodeWithText("0")
            .assertIsDisplayed()
    }
}