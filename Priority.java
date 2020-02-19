public class Priority {
    public static boolean Order(char op1, char op2) {
        return op2 != '(' && op2 != ')' && ((op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-'));
    }
}