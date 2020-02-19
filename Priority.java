public class Priority {
    public static boolean Order(char X, char Y) {
        return Y != '(' && Y != ')' && ((X != '*' && X != '/') || (Y != '+' && Y != '-'));
    }
}