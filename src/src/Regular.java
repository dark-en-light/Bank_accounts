import java.util.ArrayList;
import java.text.DecimalFormat;
//Класс реализующий счёт "Обычный". Здесь хранятся данные пользователя по данному счёту и обрабатываются все операции над счётом.
public class Regular {
    private String name; //Поле для хранения имени владельца.
    private String surname; //Поле для хранения фамилии владельца.
    private String patronymic; //Поле для хранения отчества владельца.
    private double balance; //Поле для хранения баланса.
    private int pinCode; //Поле для хранения ПИН-кода.
    private String shopName; //Поле для хранения названия магазина.
    private double lastBalance; //Поле для хранения исходного баланса.
    private int numberOfMonths = 0; //Поле для хранения количества месяцев с открытия счета.
    private double maintenance; //Поле для хранения суммы обслуживания счёта.
    private double fine = 100; //Поле хранящее сумму штрафа.
    private ArrayList<String> detailing = new ArrayList<>(); //Массив для хранения детализации по счёту.
    DecimalFormat decimalFormat = new DecimalFormat( "###,###.##" ); //Форматирование числа для вывода.
    public Months months; //Объявление класса "Months".

    //Конструктор класса "Regular". Здесь записывается имя, фамилия, отчество, баланс и ПИН-код пользователя.
    public Regular(String name, String surname, String patronymic, double balance, int pinCode) {
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
        System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " + decimalFormat.format(lastBalance) + " руб.\nВы положили: " +  decimalFormat.format(replenishment) + " руб.\nСтало: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Чек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nВы положили: " +  decimalFormat.format(replenishment) + " руб.\nСтало: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
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
        System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nВы сняли со счёта: " +  decimalFormat.format(replenishment) + " руб.\nСтало: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Чек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nВы сняли со счёта: " +  decimalFormat.format(replenishment) + " руб.\nСтало: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }
    //Метод реализующий операцию "Оплатить покупку с помощью счёта".
    public void payForThePurchase(double replenishment) {
        //Запись исходного баланса.
        lastBalance = balance;
        //Вычитаем сумму оплаты покупки.
        balance -= replenishment;
        //Объявление класса "Months".
        months = new Months(numberOfMonths);
        //Вывод сообщения об успешно завершённой операции, баланса до операции, переведённой суммы и баланса после операции.
        System.out.println("\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНаименование магазина: " + shopName + "\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nСумма вашей покупки составила: " +  decimalFormat.format(replenishment) + " руб.\nСтало: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        //Запись информации об операции в массив для детализации счёта.
        detailing.add("\n" + months.nameOfMonths() + " месяц\n\nЧек\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНаименование магазина: " + shopName + "\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nСумма вашей покупки составила: " +  decimalFormat.format(replenishment) + " руб.\nСтало: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }
    //Метод реализующий операцию "Получить информацию о владельце счёта".
    public void getInformationAboutTheOwner() {
        //Вывод информации о владельце счёта.
        System.out.println("\nВладельцем данного счёта является: " + surname + " " + name + " " + patronymic);
    }
    //Метод реализующий операцию "Рассчитать штраф".
    public void getFine() {
        //Запись исходного баланса.
        lastBalance = balance;
        //Объявление класса "Months".
        months = new Months(numberOfMonths);
        //Условие на выписку штрафа, если общий баланс счёта меньше 5000.
        if (balance < 5000) {
            //Вычитаем сумму штрафа
            balance -= fine;
            //Вывод информации о штрафе.
            System.out.println("\nВам выписан штраф, так как сумма вашего баланса меньше 5000 руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nШтраф составил: " +  decimalFormat.format(fine) + " руб.\nОбщий баланс после списания составил: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\nВам выписан штраф, так как сумма вашего баланса меньше 5000 руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nШтраф составил: " +  decimalFormat.format(fine) + " руб.\nОбщий баланс после списания составил: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        }
        //Если общий баланс больше или равен 5000.
        else {
            //Вывод информации о штрафе.
            System.out.println("\nСумма штрафа равна 0 руб.");
        }
        //Вызов метода по расчёту сумму обслуживания счёта из класса "Regular".
        getMaintenance();
        //Увеличиваем количество месяцев, прошедших с открытия счёта, так как считается, что после выполнения операции "Рассчитать штраф и комиссию" предыдущий месяц закончен.
        numberOfMonths++;
    }
    //Метод реализующий операцию "Рассчитать сумму обслуживания счёта".
    public void getMaintenance() {
        if (balance <= 0) {
            //Так как переменная "число месяцев" увеличилась, то создаём новый класс месяцев.
            months = new Months(numberOfMonths);
            //Запись исходного баланса.
            lastBalance = balance;
            //Расчёт общей суммы платы за обслуживание.
            maintenance = 100;
            //Вычитаем плату за обслуживание.
            balance -= maintenance;
            //Объявление класса "Months".
            months = new Months(numberOfMonths);
            //Вывод информации о плате за обслуживание счёта.
            System.out.println("\nОбслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " +  decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\n" + "Обслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " +  decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        } else {
            //Запись исходного баланса.
            lastBalance = balance;
            //Расчёт общей суммы платы за обслуживание.
            maintenance = Math.abs(Math.min(100, balance * 0.1));
            //Вычитаем плату за обслуживание.
            balance -= maintenance;
            //Объявление класса "Months".
            months = new Months(numberOfMonths);
            //Вывод информации о плате за обслуживание счёта.
            System.out.println("\nОбслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " +  decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Запись информации об операции в массив для детализации счёта.
            detailing.add("\n" + months.nameOfMonths() + " месяц\n\nОбслуживание счёта\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nНа вашем счёте было: " +  decimalFormat.format(lastBalance) + " руб.\nПлата за обслуживание составила: " +  decimalFormat.format(maintenance) + " руб.\nОбщий баланс после списания составил: " +  decimalFormat.format(balance) + " руб.\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            //Условие исключающее ошибку "Сумма взимающаяся за обслуживания счёта, если баланс счёта нулевой."
        }
    }
    //Метод реализующий операцию "Детализация счёта".
    public void getDetailing() {
        //Условие исключающее ошибку "если в массиве "detailing" нет ещё ни одного элемента":
        if (detailing.size() == 0) {
            System.out.println("\nВы ещё не совершили ни одной операции над счётом");
        } else {
            //Вывод информации по счёту.
            System.out.println("\nДетализация по счёту \"Обычный\"\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*\nПрошло " + numberOfMonths + " месяцев с момента, как вы открыли этот счёт.\nДалее выведен список совершённых вами операций над счётом: ");
            //Вывод детализации по счёту.
            for (int i = 0; i < detailing.size(); i++) {
                String conclusion = detailing.get(i);
                System.out.println(conclusion);
            }
            System.out.println("\nКонец детализации по счёту \"Обычный\"\n*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        }
    }
}
