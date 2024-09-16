public class HomeWorkTwo {
    public static void main(String[] args) {

        //Передаем данные
        boolean flag = countC(5, 19);
        //Выводим результат в консоль
        System.out.println(flag);

        printMessage(-26);

        boolean output = printKjj(-25);
        System.out.println(output);

        printMess(7, "Hello");

        System.out.println(isLeap(1704));
    }

    //Задание №1
    //Создаем метод принимащий на вход два целых числа
    public static boolean countC(int a, int b) {
        // Создаем переменныю с суммой целых чисел
        int C = a + b;
        //Возвращаем значения
        return (C >= 10 && C <= 20);
    }

    //Задание №2
    public static void printMessage(int x) {
        if (x >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //Задание №3
    public static boolean printKjj(int y) {
        return (y < 0);
    }

    //Задание №4
    public static void printMess(int z, String massage) {
        int z1 = 0;
        while (z1 < z) {
            System.out.println(massage);
            z1++;
        }
    }

    //Задача №5
    public static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 100 == 0) {
            return false;
        }

        return (year % 4 == 0);
    }
}