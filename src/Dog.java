public class Dog extends Animal{

    Dog(String name) {
        super(name);
    }

    //Как бегают собаки
    void run(int distance) {
        if (distance > 500){
            System.out.println("Собака не может бегать больше 500 м.");
        } else {
            super.run(distance);
        }
    }

    //Как плавают собаки
    void swim(int distance) {
        if (distance > 10){
            System.out.println("Собака не может проплыть больше 10 м.");
        } else {
            super.swim(distance);
        }
    }
}
