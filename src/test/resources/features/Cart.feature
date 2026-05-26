Feature: Tmobile testy

  Scenario Outline: Wybranie telefonu z listy ofer
    When Uzytkownik wchodzi na strone tmobile
    Then Strona glowa jest widoczna
    When Z gornej belki rozwin liste "Sklep"
    Then Widoczna jest rozwijana lista produktow
    When Kliknij "Bez abonamentu" z sekcji "Smartfony"
    Then Widoczna jest lista smartfonow
    When Kliknij element z listy o nazwie "<urzadzenie>" i zapisz dane "TAK"
    Then Widoczna strona produktu
    When Kliknij 'Dodaj do koszyka'
    Then Widoczna strona Twoj koszyk
    And Cena urzadzenia "<urzadzenie>" w koszyku zgadzaja sie z cena ze strony produktu
    When Przejdz na strone glowna TMobile
    Then Strona glowa jest widoczna
    When Kliknij Koszyk
    Then Koszyk zawiera
      | <urzadzenie> |

    Examples:
      | urzadzenie                      |
      | Xiaomi Redmi Note 15 Pro 5G |
