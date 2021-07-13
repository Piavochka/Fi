public class Animal {

    //Описание животных
    String name;

    Animal(String name){
        this.name = name;
    }

    //Животные умеют бегать
    void run(int distance){
        System.out.println(this.name + " пробежал " + distance + " м.");
    }

    //Животные умеют плавать
    void swim(int distance){
        System.out.println(this.name + " проплыл " + distance + " м.");
    }
}
