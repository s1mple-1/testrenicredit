#language: ru
Функционал: Вклад

  @all
  Сценарий: Рассчет вклада в Рублях

    Когда Переходим на страницу Вклады
    И Выбираем валюту "RUB"
    И Заполняем поля калькулятора вкладов
      | Сумма вклада           | 300000 |
      | На срок                | 9      |
      | Ежемесячное пополнение | 50000  |
    И Выбираем опцию "Ежемесячная капитализация"

    Тогда Проверяем поля результатов калькулятора вкладов
      | Начислено % | 18 056,35  |
      | Пополнение  | 400 000    |
      | К снятию    | 718 056,35 |


  Сценарий: Рассчет вклада в Долларах

    Когда Переходим на страницу Вклады
    И Выбираем валюту "USD"
    И Заполняем поля калькулятора вкладов
      | Сумма вклада           | 500000 |
      | На срок                | 9      |
      | Ежемесячное пополнение | 5000   |
    И Выбираем опцию "Ежемесячная капитализация"

    Тогда Проверяем поля результатов калькулятора вкладов
      | Начислено % | 1 159,38   |
      | Пополнение  | 40 000     |
      | К снятию    | 541 159,38 |

