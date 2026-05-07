Feature: Tmobile testy

  Scenario: Wybranie telefonu z listy ofer
    When Uzytkownik wchodzi na strone tmobile
    Then Strona glowa jest widoczna
    When Z gornej belki rozwin liste "Sklep"
    Then Widoczna jest rozwijana lista produktow
    When Kliknij "Bez abonamentu" z sekcji "Smartfony"