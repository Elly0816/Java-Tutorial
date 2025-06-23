public class NumberOfDaysInMonth{
    public static void main(String[] args) {
        int month = 2;
        int year = 2024;
        int daysInMonth = getDaysInMonth(month, year);
        System.out.println(month+"/"+year+ " has " +daysInMonth+ " days");
    }

    public static boolean isLeapYear(int year) {
        boolean isInvalid = (year < 1) || (year > 9999);
        boolean isLeap;
        if (isInvalid){
            return false;
        } else {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
                isLeap = true;
            } else {
                isLeap = false;
            }
            return isLeap;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        if ((month < 1) || (month > 12)){
            return -1;
        }

        if ((year < 1) || (year > 9999)){
            return -1;
        }

        boolean isLeapYear = isLeapYear(year);
        int numOfDays;
        switch(month){
            case 1:
                numOfDays = 31;
                break;
            case 2:
                numOfDays = isLeapYear ? 29 : 28;
                break;
            case 3:
                numOfDays = 31;
                break;
            case 4:
                numOfDays = 30;
                break;
            case 5:
                numOfDays = 31;
                break;
            case 6:
                numOfDays = 30;
                break;
            case 7:
                numOfDays = 31;
                break;
            case 8:
                numOfDays = 31;
                break;
            case 9:
                numOfDays = 30;
                break;
            case 10:
                numOfDays = 31;
                break;
            case 11:
                numOfDays = 30;
                break;
            case 12:
                numOfDays = 31;
                break;
            default:
                numOfDays= -1;
                break;
        }
        return numOfDays;
    }
}