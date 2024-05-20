Feature: Rename playlist
  Scenario: Rename playlist test
    Given I open Koel Website with valid credentials and located at Home Page
    When I double clicked for playlist name, delete previous playlist name, generate new and write
    Then Success notification is displayed