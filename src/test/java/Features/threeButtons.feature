Feature: Trzy przyciski

  Scenario: Poprawne wykonanie zadania
    Given Uzytkownik jest na stronie
    When Uzytkownik pierwszy raz klika w odpowiedni przycisk
    And Uzytkownik drugi raz klika w odpowiedni przycisk
    And Uzytkownik trzeci raz klika w odpowiedni przycisk
    And Uzytkownik klika w przycisk check solution
    Then Uzytkownikowi pokazuje sie napis OK. Good answer
