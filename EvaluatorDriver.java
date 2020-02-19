public class EvaluatorDriver {
    public static void main(String[] args) {
        System.out.println(EvaluateString.evaluate("9 + 9 + 9 * ( 8 * 3 )"));
        System.out.println(EvaluateString.evaluate("9 + 9 - 9 * ( 9 / 9 ) + 9 + 9 - 9 * ( 9 / 9 ) - 9 + 9 - 9 * ( 9 / 9 )"));
        System.out.println(EvaluateString.evaluate("1 * 2 + 12"));
    }
}