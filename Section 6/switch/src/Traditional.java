public class Traditional{
    public static void main(String[] args) {
        String nato = nato('f');
        System.out.println(nato);
    }

    public static String nato(char phonetic) {
        switch(phonetic){
            case 'a':
            case 'A':
                return "Able";
            case 'b':
            case 'B':
                return "Baker";
            case 'c':
            case 'C':
                return "Charlie";
            case 'd':
            case 'D':
                return "Dog";
            case 'e':
            case 'E':
                return "Easy";
            case 'f':
            case 'F':
                return "Fox";                 
            default:
                return "Not found";
        }
    }
}