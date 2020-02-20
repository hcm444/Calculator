import java.util.Stack;
@SuppressWarnings("ConditionalBreakInInfiniteLoop")
public class EvaluateString {
	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();
		Stack < Integer > OperandValues;
		OperandValues = new Stack<>();
		Stack < Character > OperatorValues;
		OperatorValues = new Stack<>();
		int i = 0;
		if (i < tokens.length) {
			do {
				if (tokens[i] == ' ') {
					i++;
					continue;
				}
				if (tokens[i] == '(') {
					OperatorValues.push(tokens[i]);
				}
				if (tokens[i] < '0') {
					if (tokens[i] == ')') {
						while (true) {
							if (OperatorValues.peek() == '(') break;
							OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
						}
						OperatorValues.pop();
					}
					if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
						if (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek())) {
							OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
							while (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek())) {
								OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
							}
						}
						OperatorValues.push(tokens[i]);
					}
				} else if (tokens[i] > '9') {
					if (tokens[i] == ')') {
						while (true) {
							if (OperatorValues.peek() == '(') break;
							OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
						}
						OperatorValues.pop();
					}
					if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
						if (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek())) {
							OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
							while (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek())) {
								OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
							}
						}
						OperatorValues.push(tokens[i]);
					}
				} else {
					StringBuilder buffer = new StringBuilder();
					if (tokens[i] >= '0' && tokens[i] <= '9') {
						buffer.append(tokens[i++]);
						while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') buffer.append(tokens[i++]);
					}
					OperandValues.push(Integer.parseInt(buffer.toString()));
				}
				i++;
			} while (i < tokens.length);
		}
		while (!OperatorValues.empty())
			OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
		return OperandValues.pop();
	}

}
