Feature: Tmobile testy

  Scenario: Wybranie telefonu z listy ofer
    When Uzytkownik wchodzi na strone tmobile
    Then Strona glowa jest widoczna
    When Z gornej belki rozwin liste "Sklep"
    Then Widoczna jest rozwijana lista produktow
    When Kliknij "Bez abonamentu" z sekcji "Smartfony"
    Then Widoczna jest lista smartfonow
    When Kliknij element z listy o nazwie "Xiaomi Redmi Note 15 Pro 5G" i zapisz dane "TAK"
    Then Widoczna strona produktu
    When Kliknij 'Dodaj do koszyka'
    Then Widoczna strona Twoj koszyk
    And Cena urzadzenia "Xiaomi Redmi Note 15 Pro 5G" w koszyku zgadzaja sie z cena ze strony produktu
    When Przejdz na strone glowna TMobile
    Then Strona glowa jest widoczna
    When Kliknij Koszyk
    Then Koszyk zawiera
      | Xiaomi Redmi Note 15 Pro 5G |
