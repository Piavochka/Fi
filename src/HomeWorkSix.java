public class HomeWorkSix {
    public static void main(String[] args) {

        //Массив животных
        Animal[] animals = {
                new Dog("Бобик"),
                new Cat("Алиса"),
                new Cat("Барс"),
                new Dog("Шарик"),
                new Dog("Барбос"),
        };

        //Подсчет количества кошек, собак и животных в общем
        int cats = 0, dogs = 0;
        for (Animal animal : animals) {
            animal.swim(5);
            animal.run(100);
            if (animal instanceof Cat) {
                cats++;
            }
            if (animal instanceof Dog) {
                dogs++;
            }
        }

        System.out.println("Всего кошек: " + cats );
        System.out.println("Всего собак: " + dogs );
        System.out.println("Всего животных: " + animals.length);
    }
}
