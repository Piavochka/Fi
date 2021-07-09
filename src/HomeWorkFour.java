import java.util.Random;
import java.util.Scanner;

public class HomeWorkFour {
    //Объявляем двумерный массив
    public static char[][] field;

    //Задаем размер массива
    public static final int SIZE = 5;

    //Какое количество фишек побеждает
    public static final int CHIPS_TO_WIN = 4;

    //Переменные для обозначения игроков
    public static final char DOTS_X = 'X';
    public static final char DOTS_O = 'O';
    //Переменная для обозначения пустоты
    public static final char DOTS_EMPTY = '.';

    public static final int COMPUTER = 1;
    public static final int HUMAN = 0;

    // текущий игрок
    public static int currentPlayer = HUMAN;
    // текущая фишка
    public static char currentChip = DOTS_X;


    public static void main(String[] args) {
        init();

        //Игра
        play();

        System.out.println("Победил " + ((currentPlayer == COMPUTER) ? "Компьютер" : "Игрок"));
    }

    //Метод для создания поля
    public static void init() {
        //Обращаемся к переменной и задаем размер
        field = new char[SIZE][SIZE];

        //Цикл для заполнения поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DOTS_EMPTY;
            }
        }

        //Выводим filed в консоль
        printField();
    }

    //Метод для вывода поля в консоль
    public static void printField() {
        //Вывод шапки игрового поля
        for (int i = 0; i <= SIZE; i++) {
            //Вывод поэлементно, через продел
            System.out.print(i + " ");
        }

        //Перенос на следующею строку
        System.out.println();

        //Цикл выводит нумерацию строк и поле map
        for (int i = 0; i < SIZE; i++) {
            //Вывод числа номера строки
            System.out.print((i + 1) + " ");

            //Вложенный цикл для вывода map
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }

            System.out.println();
        }
    }

    /**
     * Игра.
     * Делаем шаг
     * Проверка на победу.
     */
    public static void play() {
        while (true) {
            writeCoors(readCoors());
            if (checkToWin()) {
                break;
            }

            changePlayer();
        }
    }

    /**
     * Читаем
     * Если текущий игрок человек, то вводим координаты
     * Иначе вводим случайное значение
     * Если координаты валидные, выводим
     * просим ввести заново
     */
    public static int[] readCoors() {
        int[] coors;

        if (currentPlayer == HUMAN) {
            coors = inputCoors();
        } else {
            coors = randomCoors();
        }

        if (validateCoors(coors)) {
            return coors;
        }

        if (currentPlayer == HUMAN) {
            System.out.println("Введены некорректные координаты");
        }

        return readCoors();
    }

    public static void changePlayer() {
        currentPlayer = (currentPlayer == HUMAN) ? COMPUTER : HUMAN;
        currentChip = (currentChip == DOTS_X) ? DOTS_O : DOTS_X;

        System.out.println("Ход игрока " + ((currentPlayer == COMPUTER) ? "Компьютер" : "Игрок"));
    }

    //Не даём вводить не верные данные
    public static boolean validateCoors(int[] coors) {
        //Данные должны входить в наше поле
        if (coors[0] < 0 || coors[0] >= SIZE || coors[1] < 0 || coors[1] >= SIZE) {
            return false;
        }

        return field[coors[1]][coors[0]] == DOTS_EMPTY;
    }

    public static boolean checkToWin() {
        int horizontalSeries, verticalSeries;

        // Проверка строк
        for (int i = 0; i < SIZE; i++) {
            horizontalSeries = 0;
            verticalSeries = 0;

            for (int j = 0; j < SIZE; j++) {
                horizontalSeries = (field[i][j] == currentChip) ? horizontalSeries + 1 : 0;
                verticalSeries = (field[j][i] == currentChip) ? verticalSeries + 1 : 0;

                if (horizontalSeries == CHIPS_TO_WIN || verticalSeries == CHIPS_TO_WIN) {
                    return true;
                }
            }
        }

        if (SIZE == CHIPS_TO_WIN) {
            return checkDiagonals() || checkBackDiagonals();
        } else {
            return checkDiagonalsWithParallel() || checkBackDiagonalsWithParallel();
        }
    }

    public static boolean checkDiagonals() {
        int series = 0;

        // проверка диагонали
        for (int i = 0; i < SIZE; i++) {
            series = (field[i][i] == currentChip) ? series + 1 : 0;
            if (series == CHIPS_TO_WIN) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkDiagonalsWithParallel() {
        int series = 0;
        int rightSeries = 0;
        int leftSeries = 0;

        for (int j = 1; j <= SIZE - CHIPS_TO_WIN; j++) {
            for (int i = 0; i < SIZE; i++) {
                // проверить центральную диагональ
                series = (field[i][i] == currentChip) ? series + 1 : 0;

                if (i + j < SIZE) {
                    // проверить правую диагональ
                    rightSeries = (field[i][i + j] == currentChip) ? rightSeries + 1 : 0;
                    // проверить левую диагональ
                    leftSeries = (field[i + j][i] == currentChip) ? leftSeries + 1 : 0;
                }

                if (series == CHIPS_TO_WIN || leftSeries == CHIPS_TO_WIN || rightSeries == CHIPS_TO_WIN) {
                    return true;
                }
            }
        }

        return false;
    }

    // проверка обратной диагонали
    public static boolean checkBackDiagonals() {
        int series = 0;

        for (int i = SIZE - 1; i >= 0; i--) {
            series = (field[i][SIZE - i - 1] == currentChip) ? series + 1 : 0;

            if (series == CHIPS_TO_WIN) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkBackDiagonalsWithParallel() {
        int series = 0;
        int rightSeries = 0;
        int leftSeries = 0;

        int x, y;

        for (int j = 1; j <= SIZE - CHIPS_TO_WIN; j++) {
            for (int i = 0; i < SIZE; i++) {
                y = i;
                x = SIZE - i - 1;

                // проверить центральную диагональ
                series = (field[y][x] == currentChip) ? series + 1 : 0;

                if (x - j >= 0) {
                    // проверить правую диагональ
                    rightSeries = (field[y][x - j] == currentChip) ? rightSeries + 1 : 0;
                }

                if (y + j < SIZE) {
                    // проверить левую диагональ
                    leftSeries = (field[y + j][x] == currentChip) ? leftSeries + 1 : 0;
                }

                if (series == CHIPS_TO_WIN || rightSeries == CHIPS_TO_WIN || leftSeries == CHIPS_TO_WIN) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int[] inputCoors() {
        int[] coors = new int[2];
        Scanner r = new Scanner(System.in);

        System.out.println("Введите координату ячейки");

        coors[0] = r.nextInt() - 1;
        coors[1] = r.nextInt() - 1;

        return coors;
    }

    public static int[] randomCoors() {
        int[] coors = new int[2];
        Random r = new Random();

        coors[0] = r.nextInt(SIZE);
        coors[1] = r.nextInt(SIZE);

        return coors;
    }

    public static void writeCoors(int[] coors) {
        field[coors[1]][coors[0]] = currentChip;

        printField();
    }
}
