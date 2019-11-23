@SmokeTesting 
Feature: TaskWorld Login Scenarios

  @validateLoginAndTaskCreation
  Scenario: User creates task after login
	Given User Navigates to Home Page and Logs in
	When An existing user logs into the system
	And The user creates a new project
	And The user creates a new tasklist in the project
	And The user adds a new task to the tasklist
	And The user marks the task as completed
	Then The user opens the completed task to see its details
  
     