import java.util.ArrayList;
import java.text.DecimalFormat;
//Класс реализующий счёт "Молодёжный". Здесь хранятся данные пользователя по данному счёту и обрабатываются все операции над счётом.
public class Junior {
    private String name; //Поле для хранения имени владельца.
    private String surname; //Поле для хранения фамилии владельца.
    private String patronymic; //Поле для хранения отчества владельца.
    private double balance; //Поле для хранения баланса.
    private int pinCode; //Поле для хранения ПИН-кода.
    private String shopName; //Поле для хранения названия магазина.
    private int numberOfMonths = 0; //Поле для хранения количества месяцев с открытия счета.
    private boolean paidThisMonth; //Поле для проверки оплаты покупки в текущем месяце.
    private double cashback; //Поле для хранения суммы кэшбэка.
    private double lastBalance; //Поле для хранения исходного баланса.
    private static double fine = 300; //Поле хранящее сумму штрафа.
    private static double commission = 10; //Поле хранящее сумму комиссии.
    private int count = 0; //Поле для хранения количества раз совершения операции "Снять деньги".
    private double commissionSum = 0; //Поле для хранения общей суммы комиссий за месяц.
    private ArrayList<String> detailing = new ArrayList<>(); //Массив для хранения детализации по счёту.
    DecimalFormat decimalFormat = new DecimalFormat( "###,###.##" ); //Форматирование числа для вывода.
    public Months months; //Объявление класса "Months".

    //Конструктор класса "Junior". Здесь записывается имя, фамилия, отчество, баланс и ПИН-код пользователя.
    Junior(String name, String surname, String patronymic, double balance, int pinCode) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.balance = balance;
        this.pinCode = pinCode;
    }
    //Записывает название магазина, которому были переведены деньги.
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    //Возвращает баланс счёта.
    public double getBalance() {
        return balance;
    }
    //Возвращает ПИН-код счёта.
    public int getPinCode() {
        return pinCode;
    }
    //Метод реализующий операцию "Пополнить счёт".
    public void topUpAccount(double replenishment) {
        //Запись исходного баланса.
        lastBalance = balance;
        //Добавляем сумму пополнения.
        balance += replenishment;
        //Объявление класса "Months".
        months = new Months(numberOfMonths);
        //Вывод сообщения об успешно завершённой операции, баланса до операции, суммы пополнения и баланса после операции.
        System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы положили: " + decimalFormat.format(replenishment) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Чек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы положили: " + decimalFormat.format(replenishment) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }
    //Метод реализующий операцию "Списать деньги".
    public void withdrawMoney(double replenishment) {
        //Запись исходного баланса.
        lastBalance = balance;
        //Вычитаем сумму списания.
        balance -= replenishment;
        //Объявление класса "Months".
        months = new Months(numberOfMonths);
        //Условие исключающее ошибку списание комиссии, если сумма списания равна нулю.
        if(replenishment == 0) {
            //Вывод информации о комиссии.
            System.out.println("\nКомиссия не взимается, так как сумма снимаемых денег составила: 0.");
        }
        //Если сумма списания больше нуля.
        else {
            //Вычитаем сумму комиссии.
            balance -= commission;
            //Увеличиваем счётчик количества раз списания комиссии.
            count++;
            //Увеличиваем общую сумму всех комиссий.
            commissionSum += 10;
            //Вывод сообщения об успешно завершённой операции, баланса до операции, снятой суммы и баланса после операции.
            System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы сняли со счёта: " + decimalFormat.format(replenishment) +" руб.\nКомиссия составила: " + decimalFormat.format(commission) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Чек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы сняли со счёта: " + decimalFormat.format(replenishment) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        }
    }
    //Метод реализующий операцию "Оплатить покупку с помощью счёта".
    public void payForThePurchase(double replenishment) {
        //Запись исходного баланса.
        lastBalance = balance;
        //Расчёт кэшбэка.
        cashback = Math.min(100, replenishment * 0.02);
        //Вычитаем сумму оплаты покупки.
        balance -= replenishment;
        //Добавляем кэшбэк.
        balance += cashback;
        //Подтверждение того, что в этом месяце была оплачена покупка с МОЛОДЁЖНОГО счёта.
        paidThisMonth = true;
        //Объявление класса "Months".
        months = new Months(numberOfMonths);
        //Вывод сообщения об успешно завершённой операции, баланса до операции, переведённой суммы и баланса после операции.
        System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНаименование магазина: " + shopName + "\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nСумма вашей покупки составила: " + decimalFormat.format(replenishment) + " руб.\nКэшбэк за покупку составил: " + decimalFormat.format(cashback) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Чек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНаименование магазина: " + shopName + "\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nСумма вашей покупки составила: " + decimalFormat.format(replenishment) + " руб.\nКэшбэк за покупку составил: " + decimalFormat.format(cashback) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }
    //Метод реализующий операцию "Получить информацию о владельце счёта".
    public void getInformationAboutTheOwner() {
        //Вывод информации о владельце счёта.
        System.out.println("\nВладельцем данного счёта является: " + surname + " " + name + " " + patronymic);
    }
    //Метод реализующий операцию "Рассчитать комиссию и штраф".
    public void getFine () {
        //Вызываем метод рассчитывающий общую комиссию.
        getCommission();
        //Условие исключающее ошибку если владелец счёта ни разу не заплатил в этом месяце с данного счёта за покупку.
        if (!paidThisMonth) {
            //Запись исходного баланса.
            lastBalance = balance;
            //Вычитаем сумму штрафа.
            balance -= fine;
            //Объявление класса "Months".
            months = new Months(numberOfMonths);
            //Вывод информации о штрафе.
            System.out.println("\nВам выписан штраф, так как в течение месяца не было совершено ни одной операций оплаты.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nСумма штрафа составила: " + decimalFormat.format(fine) + " руб.\nОбщий баланс после списания составил: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Вам выписан штраф, так как в течение месяца не было совершено ни одной операций оплаты.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nСумма штрафа составила: " + decimalFormat.format(fine) + " руб.\nОбщий баланс после списания составил: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        }
        //Если владелец счёта заплатил в этом месяце за покупку хоть раз.
        else {
            //Вывод информации о штрафе.
            System.out.println("\nСумма штрафа равна 0 руб.");
        }
        //Увеличиваем количество месяцев, прошедших с открытия счёта, так как считается, что после выполнения операции "Рассчитать штраф и комиссию" предыдущий месяц закончен.
        numberOfMonths++;
        //После совершения операции "Рассчитать комиссию и штраф" считаем, что начался новый месяц, а значит в новом месяце владелец счёта ещё не оплачивал ни одной покупки, поэтому переменной проверки оплаты присваиваем "false".
        paidThisMonth = false;
    }
    //Метод рассчитывающий общую комиссию.
    public void getCommission() {
        //Объявление класса "Months".
        months = new Months(numberOfMonths);
        //Вывод информации о комиссии.
        System.out.println("\nВ этом месяце вы пользовались услугой \"Снять деньги\" " + count + "раз, поэтому общая сумма комиссии составила: " + decimalFormat.format(commissionSum) + " руб.");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nВ этом месяце вы пользовались услугой \"Снять деньги\" " + count + "раз, поэтому общая сумма комиссии составила: " + decimalFormat.format(commissionSum) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\n");
        //Обнуление счётчика количества раз снятия денег.
        count = 0;
        //Обнуление счётчика общей суммы комиссии.
        commissionSum = 0;
    }
    //Метод реализующий операцию "Детализация счёта".
    public void getDetailing() {
        //Условие исключающее ошибку "если в массиве "detailing" нет ещё ни одного элемента":
        if (detailing.size() == 0) {
            System.out.println("\nВы ещё не совершили ни одной операции над счётом");
        } else {
            //Вывод информации по счёту.
            System.out.println("\nДетализация по счёту \"Молодёжный\"\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nПрошло " + numberOfMonths + " месяцев с момента как вы открыли этот счёт.\nДалее выведен список совершённых вами операций над счётом: ");
            //Вывод детализации по счёту.
            for (int i = 0; i < detailing.size(); i++) {
                String conclusion = detailing.get(i);
                System.out.println(conclusion);
            }
            System.out.println("\nКонец детализации по счёту \"Молодёжный\"\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        }
    }
}
