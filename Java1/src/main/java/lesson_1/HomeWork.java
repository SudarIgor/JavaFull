package lesson_1;

public class HomeWork {

    public static void main(String[] args) {
    /* start of the exercise 2. types of data */
    byte byteType = 127;
    short shotType = 30540;
    int intType = 10;
    long longType = 22L;
    float  floatType = 0.5f;
    double doubleType =0.4454;
    char charType ='f';
    boolean booleanType = true;
    /* the end of the exercise 2.*/

    }

    /* start of the exercise 3. calculation: a * (b + (c / d))*/
    public static double calculation (double a, double b, double c, double d) {
        return a * (b + (c / d));
    } /* the end of the exercise 3.*/


    /* start of the exercise 4. if the number is between 10 and 20, then true*/
    public static boolean betweenFrom10To20 (int a, int b){
        return (a > 10 && b <= 20);
    }/* the end of the exercise 4.*/


    /* start of the exercise 5. positive or negative number*/
    public static boolean isPositive (long number){
        return number >= 0;
    }/* the end of the exercise 5.*/

    /* start of the exercise 6. positive or negative number*/
    public static boolean isNegative (long number){
        return number < 0;
    }/* the end of the exercise 6.*/

    /* start of the exercise 7. print: Привет + Name */
    public static void print (String name){
        System.out.println("Привет " + name);
    }/* the end of the exercise 7.*/

    /*  start of the exercise 8. leap year*/
    public static boolean leapYear (int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }/* the end of the exercise 8.*/


}