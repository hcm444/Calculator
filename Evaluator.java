public class Evaluator {
    public static int Apply(char op, int OperatorTwo, int OperatorOne) {
        int result = 0;
        if (op == '+') {
            result = OperatorOne + OperatorTwo;
        } else if (op == '-') {
            result = OperatorOne - OperatorTwo;
        } else if (op == '*') {
            result = OperatorOne * OperatorTwo;
        } else if (op == '/') {
            if (OperatorTwo == 0)
                throw new
                        UnsupportedOperationException("Cannot divide by zero");
            result = OperatorOne / OperatorTwo;
        }
        return result;
    }
}