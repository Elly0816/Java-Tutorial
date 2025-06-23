public class Main{
    public static void main(String[] args) {

        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        one.subtract(number);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        number.subtract(one);
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());
        // for (int i=1; i<=5; i++){
        //     LPAStudent s = new LPAStudent("592300"+i,
        //      switch(i){
        //         case 1 -> "Mary";
        //         case 2 -> "John";
        //         case 3 -> "Peter";
        //         case 4 -> "Elly";
        //         case 5 -> "James";
        //         default -> "Default";
        //      },
        //      "05/11/1985",
        //       "Java MasterClass");
        // System.out.println(s+"\n");
        // }    

        // Student pojoStudent = new Student("592300", "Mary", "05/11/1985",
        // "Java MasterClass");

        // LPAStudent recordStudent = new LPAStudent("592305", "John", "05/11/1985",
        // "Java MasterClass");

        // System.out.println(pojoStudent);
        // System.out.println("\n");
        // System.out.println(recordStudent);


        // System.out.println(pojoStudent.getName()+ " is taking " +pojoStudent.getClassList());
        // System.out.println(recordStudent.name()+ " is taking " +recordStudent.classList());


    }

}