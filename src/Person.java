public class Person {
    public String fullName;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void println() {
        System.out.println("ФИО: " + this.fullName +
                "Должность: " + this.position +
                "Email: " + this.email +
                "Телефон: " + this.phone +
                "ЗП: " + this.salary +
                "Возраст: " + this.age
        );
    }
}
