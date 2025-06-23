public class Main{
    public static void main(String[] args) {

        String entry = "Nothing";
        String month = getQuarter(entry); 
        System.out.println(month);
        // int value = 3;
        // switch (value){
        //     case 1 -> System.out.println("Value was 1");
        //     case 2 -> System.out.println("Value was 2");
        //     case 3, 4, 5 -> {
        //         System.out.println("Value was a 3, a 4, or a 5");
        //         System.out.println("Actually, the value was a " +value);
        //         }
        //     default -> System.out.println("Value was not 1 or 2 or 3 or 4 or 5");  
        // }
        // if (value==1){
        //     System.out.println("Value was 1");
        // } else if (value ==2){
        //     System.out.println("Value was 2");
        // } else {
        //     System.out.println("Value was not 1 or 2");
        // }
    }

    public static String getQuarter(String month) {
        return switch (month){
            case "January", "February", "March" ->month+ " is in the First Quarter";
            case "April", "May", "June" ->  month+ " is in the Second Quarter";
            case "July","August", "September" -> month+ " is in the Third Quarter";
            case "October", "November", "December" -> month+ " is in the Fourth Quarter";
            default -> {
                String badResponse = month+" is a bad month";
                yield badResponse;
            }
            };
    }
}
