Feature: Tmobile testy
Background:
  Given Uzytkownik jest na stronie tmobile


  Scenario: Wybranie telefonu z listy ofer
    When Uzytkownik jest na stronie tmobile
    When Rozwin liste "Sklep"
#    Then Lista jest widoczna
