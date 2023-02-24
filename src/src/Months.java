//Класс в котором хранятся названия месяцев.
public class Months {
    int numberOfMonths; //Поле для хранения номера месяца.
    //Конструктор класса "Months", здесь записывается номер месяца.
    Months(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }
    //Метод для вывода названия месяца в зависимости от номера месяца.
    public String nameOfMonths() {
        String[] months = new String[12]; //Массив названий месяцев.
        months[0] = "Январь";
        months[1] = "Февраль";
        months[2] = "Март";
        months[3] = "Апрель";
        months[4] = "Май";
        months[5] = "Июнь";
        months[6] = "Июль";
        months[7] = "Август";
        months[8] = "Сентябрь";
        months[9] = "Октябрь";
        months[10] = "Ноябрь";
        months[11] = "Декабрь";
        return months[numberOfMonths];
    }
}
