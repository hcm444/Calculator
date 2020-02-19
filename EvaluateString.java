import java.util.Stack;

public class EvaluateString {
	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();
		Stack < Integer > OperandValues;
		OperandValues = new Stack < Integer > ();
		Stack < Character > OperatorValues;
		OperatorValues = new Stack < Character > ();
		int i = 0;
		while (i < tokens.length) {
			switch (tokens[i]) {
				case ' ':
					i++;
					continue;
				case '(':
					OperatorValues.push(tokens[i]);
					break;
				default:
					if (tokens[i] >= '0' && tokens[i] <= '9') {
						StringBuffer buffer = new StringBuffer();
						if (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
							do buffer.append(tokens[i++]);
							while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9');
						OperandValues.push(Integer.parseInt(buffer.toString()));
					} else if (tokens[i] == ')') {
						while (true) {
							if (OperatorValues.peek() == '(') break;
							OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
						}
						OperatorValues.pop();
					} else switch (tokens[i]) {
						case '+':
						case '-':
						case '*':
						case '/':

							if (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek())) do {
								OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
							}
							while (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek()));
							OperatorValues.push(tokens[i]);
							break;
					}
					break;
			}
			i++;
		}
		while (!OperatorValues.empty())
			OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));


		return OperandValues.pop();
	}

}
