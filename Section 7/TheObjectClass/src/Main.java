public class Main extends Object {

    public static void main(String[] args) {

        Student max = new Student("Max", 21);
        System.out.println(max);

        PrimarySchoolStudent jeff = new PrimarySchoolStudent("Jeff", 8, "Maria");
        System.out.println(jeff);
    }

}

class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName() + " is " + this.getAge();
        // return "{" +
        // " name='" + getName() + "'" +
        // ", age='" + getAge() + "'" +
        // "}";
    }
}

class PrimarySchoolStudent extends Student {

    private String parentName;

    public PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    public String getParentName() {
        return this.parentName;
    }

    @Override
    public String toString() {
        return this.getParentName() + "'s kid; " + super.toString();
    }

}