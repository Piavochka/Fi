public class HomeWorkApp {
    // Задание №1
    public static void main(String[] args) {
        //Задание №6, методы из пунктов 2-6 вызвоны из main
        printTheeWords();
        checkSumSign();
        printColor9();
        compareNumbers();
    }

    //Задание №2
    public static void printTheeWords() {
        System.out.println("-Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }

    //Задание №3
    public static void checkSumSign() {
        int a = 15;
        int b = -27;
        System.out.println(a+b);
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } if (a + b < 0) {
            System.out.println("Сумма отричательная");
        }

    }

    //Задание №4
    public static void printColor9() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        }if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    //Задание №5
    public static void compareNumbers() {
        int a = 13;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }
}
