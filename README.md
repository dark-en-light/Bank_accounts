# Банковские счета

Одно из заданий для закрепления раздела "Принципы ООП" на курсе "Java-разработка" от Digital Spirit. Его описание представлено ниже.

<details>
  <summary><h2>Задание</h2></summary>

Разработать программу, которая будет отслеживать все счета в банке. Банк поддерживает несколько различных типов счетов:

- Обычный счет - с этого счета взимается плата за обслуживание счета, которая составляет наименьшее из двух значений: 100 руб. или 10% от остатка на конец месяца. Существует штраф 100.00 руб., если баланс падает ниже минимума - 5000,00 руб.
- Счет продвинутый -  с этого счета взимается плата за обслуживание, которая составляет наименьшее из двух значений: 100 руб. или 10% от остатка на конец месяца. Кэшбек на все операции оплаты 1%, но не более 100 рублей, которые зачисляются на счет сразу после совершения операции оплаты. Требования минимального баланса отсутствуют. 
- Счет молодежный -  плата за обслуживание по счету отсутствует. Кэшбек 2%, которые зачисляются на счет сразу после совершения операции оплаты. Существует штраф 300.00 руб, если не было операций оплаты в течении месяца, снимается в конце месяца. За каждую операцию снятия денег взимается комиссия в размере 10 рублей.

Каждый из счетов защищен ПИН-кодом, который должен храниться в виде хеш-кода и требоваться для совершения следующих операций:

- Запрос баланса
- Снятие наличных
- Оплата
- Пополнение счета
- Детализация по счету

Атрибуты и методы:

Каждый счет должен иметь следующий минимальный набор данных:

- ФИО владельца счета
- Баланс
- пин-код
- количество месяцев с открытия счета
- комиссии, штрафы и иные условия по счету

Все виды счетов должны реализовывать минимальный набор операций:

- Открытие счета; 
- Пополнение счета;
- Операция снятия денег;
- Запрос баланса;
- Операция оплаты со счета, с указанием суммы, и названия магазина;
- Получение информации о владельце;
- Расчет комиссий и штрафов (при выполнении данной операции, считать, что месяц закончен);
- Вывод детализированной информации по счету (постарайтесь максимально чётко детализировать).

Операции указанные выше, должны быть защищены проверкой ПИН-кода.

Реализовать классы, а также реализовать программу, демонстрирующую работу с каждым видом счета, показывающую корректность расчета комиссий, штрафов, начислений и т.д.
</details>

<details>
  <summary><h2>Моё решение</h2></summary>

<div align="center">
      <a href="https://www.youtube.com/watch?v=elCPcZjmPhU">
         <img src="https://user-images.githubusercontent.com/78896984/224849162-3d74331e-3142-45cb-8335-cf2345333764.jpg" style="width:60%;">
      </a>
</div>
