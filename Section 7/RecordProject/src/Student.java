public class Student {

    private String id;
    private String name;
    private String dateOfBirth;
    private String classList;

    public Student(String id, String name, String dateOfBirth, String classList) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classList = classList;

    }

    /**
     * @return the classList
     */
    public String getClassList() {
        return classList;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    // public String toString() {
    // return "Id=" + this.id + ", name=" + this.name + ", DoB=" + this.dateOfBirth
    // + ", classList=" + this.classList;
    // }

    /**
     * @param classList the classList to set
     */
    public void setClassList(String classList) {
        this.classList = classList;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", dateOfBirth='" + getDateOfBirth() + "'" +
                ", classList='" + getClassList() + "'" +
                "}";
    }

}