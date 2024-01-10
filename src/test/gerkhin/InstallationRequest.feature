Feature: Installation Requests

  Scenario: Requesting Installation
    Given the user wants to request installation
    When the user provides installation details
    Then the installation request should be created and awaiting confirmation

  Scenario: Confirming Installation Request
    Given an installation request is awaiting confirmation
    When the installer confirms the installation request
    Then the request status should be marked as confirmed