
import java.util.Stack; 

public class EvaluateString {
	public static int evaluate(String expression) 
	{ 
		char[] tokens = expression.toCharArray(); 


		Stack<Integer> OperandValues;
		OperandValues = new Stack<Integer>();


		Stack<Character> OperatorValues;
		OperatorValues = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++)
		{

			if (tokens[i] == ' ')
				continue;


			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (true) {
					if (i >= tokens.length || tokens[i] < '0' || tokens[i] > '9') break;
					sbuf.append(tokens[i++]);
				}
				OperandValues.push(Integer.parseInt(sbuf.toString()));
			}


			else if (tokens[i] == '(')
				OperatorValues.push(tokens[i]);


			else if (tokens[i] == ')') {
				while (OperatorValues.peek() != '(')
					OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));
				OperatorValues.pop();
			}


			else if (tokens[i] == '+' || tokens[i] == '-' ||
					tokens[i] == '*' || tokens[i] == '/') {

				while (!OperatorValues.empty() && Priority.Order(tokens[i], OperatorValues.peek()))
					OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));


				OperatorValues.push(tokens[i]);
			}
		}


		while (!OperatorValues.empty())
			OperandValues.push(Evaluator.Apply(OperatorValues.pop(), OperandValues.pop(), OperandValues.pop()));


		return OperandValues.pop();
	}

}
