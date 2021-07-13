public class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    //Как бегают каты
    void run(int distance) {
        if (distance > 200){
            System.out.println("Кот не может бегать больше 200 м.");
        } else {
            super.run(distance);
        }
    }

    //Как плавают коты
    void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }
}
