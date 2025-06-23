public class Student{
    public static void main(String[] args) {
        
    }

    private String id;
    private String name;
    private String dateOfBirth;
    private String classList;
    

    public Student(String id, String name, String dateOfBirth, String classList){
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classList = classList;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public String getClassList(){
        return this.classList;
    }

    @Override
    public String toString(){
        return "Student = { id=" +id+
        ",\nname=" +name+ ",\ndateOfBirth=" +dateOfBirth+ ",\nclassList=" +classList+ "\n}";
    }
}