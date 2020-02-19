public class Evaluator {
    public static int Apply(char op, int OperatorTwo, int OperatorOne) {
        int Result = 0;
        if (op == '+') {
            Result = OperatorOne + OperatorTwo;
        }
        if (op == '-') {
            Result = OperatorOne - OperatorTwo;
        }
        if (op == '*') {
            Result = OperatorOne * OperatorTwo;
        }
        if (op == '/') {
            if (OperatorTwo == 0)
                throw new
                        UnsupportedOperationException("Cannot divide by zero");
            Result = OperatorOne / OperatorTwo;
        }
        return Result;
    }
}