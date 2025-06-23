public class Fish extends Animal{

    private int fins;
    private int gills;
 
    
    // public Fish(){
    //     this("Fish", );
    // }
    
    public Fish(String type, Double weight, int fins, int gills){
        super(type, "small", weight);
        this.fins = fins;
        this.gills = gills;
    }

    private void moveMuscles(){
        System.out.println("Muscles moving");
    }

    private void moveBackFin(){
        System.out.println("Back fins moving");
    }


    public void move(String speed){
        super.move(speed);
        moveMuscles();
        if (speed == "fast"){
        moveBackFin();
        }
    }


    @Override
    public String toString() {
        return "{" +
            " fins='" + fins + "'" +
            ", gills='" + gills + "'" +
            "}" +super.toString();
    }


}