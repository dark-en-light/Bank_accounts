import java.util.ArrayList;
import java.text.DecimalFormat;
//Класс реализующий счёт "Продвинутый". Здесь хранятся данные пользователя по данному счёту и обрабатываются все операции над счётом.
public class Advanced {
    private String name; //Поле для хранения имени владельца.
    private String surname; //Поле для хранения фамилии владельца.
    private String patronymic; //Поле для хранения отчества владельца.
    private double balance; //Поле для хранения баланса.
    private int pinCode; //Поле для хранения ПИН-кода.
    private String shopName; //Поле для хранения названия магазина.
    private int numberOfMonths = 0; //Поле для хранения количества месяцев с открытия счета.
    private double cashback; //Поле для хранения суммы кэшбэка.
    private double lastBalance; //Поле для хранения исходного баланса.
    private double maintenance; //Поле для хранения суммы обслуживания счёта.
    private ArrayList<String> detailing = new ArrayList<>(); //Массив для хранения детализации по счёту.
    DecimalFormat decimalFormat = new DecimalFormat( "###,###.##" ); //Форматирование числа для вывода.
    public Months months; //Объявление класса "Months".

    //Конструктор класса "Advanced". Здесь записывается имя, фамилия, отчество, баланс и ПИН-код пользователя.
    public Advanced(String name, String surname, String patronymic, double balance, int pinCode) {
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
        //Вывод сообщения об успешно завершённой операции, баланса до операции, снятой суммы и баланса после операции.
        System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы сняли со счёта: " + decimalFormat.format(replenishment) + " руб.\nСтало: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Чек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНаименование магазина: " + shopName + " руб.\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы сняли со счёта: " + decimalFormat.format(replenishment) + " руб.\nСтало: " + decimalFormat.format(balance) + "\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }
    //Метод реализующий операцию "Оплатить покупку с помощью счёта".
    public void payForThePurchase(double replenishment) {
        //Запись исходного баланса.
        lastBalance = balance;
        //Расчёт кэшбэка.
        cashback = Math.min(100, replenishment * 0.01);
        //Вычитаем сумму оплаты покупки.
        balance -= replenishment;
        //Добавляем кэшбэк.
        balance += cashback;
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
    //Метод реализующий операцию "Рассчитать сумму обслуживания счёта".
    public void getMaintenance() {
        if (balance <= 0) {
            //Запись исходного баланса.
            lastBalance = balance;
            //Расчёт общей суммы платы за обслуживание.
            maintenance = 100;
            //Вычитаем плату за обслуживание.
            balance -= maintenance;
            //Объявление класса "Months".
            months = new Months(numberOfMonths);
            //Вывод информации о плате за обслуживание счёта.
            System.out.println("\nОбслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " + decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Обслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " + decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        } else {
            //Увеличиваем число месяцев с момента открытия счёта.
            numberOfMonths++;
            //Запись исходного баланса.
            lastBalance = balance;
            //Расчёт общей суммы платы за обслуживание.
            maintenance = Math.abs(Math.min(100, balance * 0.1));
            //Вычитаем плату за обслуживание.
            balance -= maintenance;
            //Объявление класса "Months".
            months = new Months(numberOfMonths);
            //Вывод информации о плате за обслуживание счёта.
            System.out.println("\nОбслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " + decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Обслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " + decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " + decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Условие исключающее ошибку "Сумма взимающаяся за обслуживания счёта, если баланс счёта нулевой."
        }
        //Увеличиваем количество месяцев, прошедших с открытия счёта, так как считается, что после выполнения операции "Рассчитать штраф и комиссию" предыдущий месяц закончен.
        numberOfMonths++;
    }
    //Метод реализующий операцию "Детализация счёта".
    public void getDetailing() {
        //Условие исключающее ошибку "если в массиве "detailing" нет ещё ни одного элемента":
        if (detailing.size() == 0) {
            System.out.println("\nВы ещё не совершили ни одной операции над счётом");
        } else {
            //Вывод информации по счёту.
            System.out.println("\nДетализация по счёту \"Продвинутый\"\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nПрошло " + numberOfMonths + " месяцев с момента как вы открыли этот счёт.\nДалее выведен список совершённых вами операций над счётом: ");
            //Вывод детализации по счёту.
            for (int i = 0; i < detailing.size(); i++) {
                String conclusion = detailing.get(i);
                System.out.println(conclusion);
            }
            System.out.println("\nКонец детализации по счёту \"Продвинутый\"\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        }
    }
}
