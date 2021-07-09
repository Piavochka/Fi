public class HomeworkFive {
    public static void main(String[] args) {
        Person[] list = {
                new Person("Иванов И.И.", "Сам!", "ivanov@mail.org", "000001", 100500, 55),
                new Person("Петров И.С.", "Зам", "ivanov@mail.org", "000002", 100500 / 2, 38),
                new Person("Сидоров И.Ф.", "Главный по уборке", "ivanov@mail.org", "000003", 1500, 41),
                new Person("Череззабрногузадирищенко И.К.", "Тот, кто все делает", "ivanov@mail.org", "000004", 1000, 25),
                new Person("Иванова К.И.", "Тётя Клава", "ivanov@mail.org", "000005", 100500 * 2, 18),
        };

        for (Person p: list) {
            if (p.age > 40) {
                p.println();
            }
        }
    }
}
