import java.util.Arrays;

public class HomeWorkThree {
    public static void main(String[] args) {
        //Вызов задания №1
        int[] invertible = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertValue(invertible);

        //Вызов задания №2
        printArr(makeArray(100));
        System.out.println();

        //Вызов задания №3
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multipleLessThan(numbers, 6);

        //Вызов задания №4
        fillDiagonals(5);

        //Вызов задания №5
        int[] arr = makeArrayWithValue(5, 6);
        printArr(arr);
        System.out.println();

        //Вызов задания №6
        findExtremes();

        //Вызов задания №7
        int[] balanced = {5, 6, 8, 1, 2, 1};
        if (checkBalance(balanced)) {
            System.out.println("В массиве есть точка равновесия");
        } else {
            System.out.println("В массиве нет точки равновесия");
        }
        System.out.println();

        //Вызов задания №8a
        int[] switcherA = {1, 2, 3, 4, 5};
        shiftArrayA(switcherA, -3);

        //Вызов задания №8b
        int[] switcherB = {1, 2, 3, 4, 5, 6, 7};
        shiftArrayB(switcherB, -2);
    }

    //Задание №1. Изменение чисел в массиве
    public static void invertValue(int[] arr) {
        System.out.println("Задание 1");

        //С помощью цикла переходим от одного элемента массива к другому
        for (int i = 0; i < arr.length; i++) {
            // Условие для заменяемых элементов массива
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        //Вывод в консоль для проверки
        printArr(arr);
        System.out.println();
    }

    //Задание №2. Заполнение массива значениями
    public static int[] makeArray(int len) {
        System.out.println("Задание 2");

        //Задаем пустой массив
        int[] arr = new int[len];

        //С помощью цикла заполняем значениями
        for (int i = 0; i < len; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    //Задание №3. Умножение значения массива если оно меньше указанного значения
    public static void multipleLessThan(int[] arr, int checkpoint) {
        System.out.println("Задание 3");

        for (int i = 0; i < arr.length; i++) {
            // Умножаем элемент если он меньше требуемого значения
            if (arr[i] < checkpoint) {
                arr[i] *= 2;
            }
        }

        //Вывод в консоль для проверки
        printArr(arr);
        System.out.println();
    }

    //Задание №4. Заполнение диагоналей массива единицами
    public static void fillDiagonals(int len) {
        System.out.println("Задание 4");

        int[][] num = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // Одна диагональ определяется как равенство индексов, вторая как сумма индексов равная длине массивов.
                if (i == j || i + j == len - 1) {
                    num[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            printArr(num[i]);
        }

        System.out.println();
    }

    //Задание №5. Создание массива заданной длины с инициализирующим значением
    public static int[] makeArrayWithValue(int len, int initialValue) {
        System.out.println("Задание 5");

        int[] num = new int[len];

        for (int i = 0; i < len; i++) {
            num[i] = initialValue;
        }

        return num;
    }

    //Задание №6. Нахождение экстремумов в массиве
    public static void findExtremes() {
        System.out.println("Задание 6");

        int[] num = {6, 5, 15, 6, 7, 5, 3};

        int min = num[0], max = num[0];

        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
            if (num[i] > max) {
                max = num[i];
            }
        }

        System.out.println("Минимальное значение: " + min + ", максимальное значение: " + max);

        System.out.println();
    }

    //Задание №7. Нахождение точки равновесия в массиве.
    public static boolean checkBalance(int[] arr) {
        System.out.println("Задание 7");

        if (arr.length == 0) {
            System.out.println("Ошибка, массив пустой");
            return false;
        }

        if (arr.length == 1) {
            return false;
        }

        int sum1 = 0, sum2;

        // До последнего элемента доходить нет смысла
        for (int i = 0; i < arr.length - 1; i++) {
            sum1 += arr[i];
            sum2 = 0;
            // Начинаем складывать элементы с последнего
            for (int j = arr.length - 1; j > i; j--) {
                sum2 += arr[j];
                if (sum1 < sum2) {
                    break;
                }
            }

            // цикл заканчивается либо на границе элементов, либо когда сумма2 превысила сумму1,
            // поэтому просто сравниваем суммы на условие выполнения
            if (sum1 == sum2) {
                return true;
            }
        }

        // Если циклы отработали, но подходящих сумм не нашлось, массив не подходит под условия
        return false;
    }

    //Задание №8a. Смешение значений массива на указанную величину по индексу.
    public static void shiftArrayA(int[] arr, int offset) {
        System.out.println("Задание 8a");

        int[] bb = new int[arr.length];

        int idx;

        for (int i = 0; i < arr.length; i++) {
            idx = i + offset;
            if (idx < 0) {
                idx += arr.length;
            }
            if (idx >= arr.length) {
                idx -= arr.length;
            }

            bb[idx] = arr[i];
        }

        printArr(bb);

        System.out.println();
    }

    //Задание №8b. Смешение значений массива на указанную величину по индексу.
    public static void shiftArrayB(int[] arr, int offset) {
        System.out.println("Задание 8b");

        if (offset == 0) {
            return;
        }

        int m = 0;

        if (offset < 0) {
            for (int k = offset; k < 0; k++) {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        m = arr[i];
                        continue;
                    }

                    arr[i - 1] = arr[i];

                    if (i == arr.length - 1) {
                        arr[i] = m;
                    }
                }
            }
        } else {
            for (int k = 0; k < offset; k++) {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (i == arr.length - 1) {
                        m = arr[i];
                        continue;
                    }

                    arr[i + 1] = arr[i];

                    if (i == 0) {
                        arr[i] = m;
                    }
                }
            }
        }

        printArr(arr);

        System.out.println();
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
