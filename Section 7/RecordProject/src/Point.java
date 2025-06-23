public class Point{


    private int x;
    private int y;

    public Point(){
        this(0, 0);
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
        System.out.println("The value for x is now "+this.x);
    }
    
    public void setY(int y){
        this.y = y;
        System.out.println("The value for y is now "+this.y);
    }

    public double distance(){
        return distance(0, 0);
    }

    public double distance(int x, int y){
        double distanceAB = Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
        return distanceAB;
    }
    
    public double distance(Point another){
        return distance(another.getX(), another.getY());

    }

}