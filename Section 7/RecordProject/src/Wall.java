public class Wall{
    
    private double height;
    private double width;

    public Wall(){
        this(0, 0);
    }
    
    public Wall(double width, double height){
        if (height < 0){
            this.height = 0;
        } else {
            this.height = height;
        }

        if (width < 0){
            this.width = 0;
        } else {
            this.width = width;
        }
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public void setWidth(double width){
        if (width >= 0){
            this.width = width;
        } else {
            this.width = 0;
        }
        System.out.println("The width has been set to " +this.width);
    }

    public void setHeight(double height){
        if (height >= 0){
            this.height = height;
        } else {
            this.height = 0;
        }
        System.out.println("The height has been set to " +this.height);
    }

    public double getArea(){
        return (this.width * this.height);
    }
}