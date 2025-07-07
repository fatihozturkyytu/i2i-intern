package kafkaexample;

public class Student {
    public int id;
    public String name;

    public Student() {}  // GSON için boş constructor

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
