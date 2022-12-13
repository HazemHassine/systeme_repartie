package h06;

import javax.xml.transform.Result;

import static org.tudalgo.algoutils.student.Student.crash;
import static h06.EvaluationResult.Type.*;

public class BracketExpression {


    private final char[] expression;

    public BracketExpression(String expression) {
        this.expression = expression.toCharArray();
    }

    public final EvaluationResult evaluate() {
        return evaluate(0);
    }

    public final EvaluationResult evaluate(int i) {
        EvaluationResult r;

        if (expression[i] != '(' && expression[i] != ')' && expression[i] != '[' && expression[i] != ']' && expression[i] != '{' && expression[i] != '}')
              return new EvaluationResult(INVALID_CHARACTER, i);
        else if (expression[i] == ')' || expression[i] == ']' || expression[i] == '}')
              return new EvaluationResult(NO_OPENING_BRACKET, i);
        else if ( i== expression.length-1)
              return new EvaluationResult(NO_CLOSING_BRACKET, i);



else {
            if ((expression[i + 1] == ')' && expression[i] == '(') || (expression[i + 1] == ']' && expression[i] == '[') || (expression[i + 1] == '}' && expression[i] == '{'))
                return new EvaluationResult(CORRECT, i + 2);
            else if ((expression[i + 1] == ')' && expression[i] != '(') || (expression[i + 1] == ']' && expression[i] != '[') || (expression[i + 1] == '}' && expression[i] != '{'))
                return new EvaluationResult(INVALID_CLOSING_BRACKET, i + 1);



           r = evaluate(i +1);

            if (r.type() != CORRECT)
                      return r;
                 else if (r.nextIndex() >= expression.length)
                     return new EvaluationResult(NO_CLOSING_BRACKET, r.nextIndex());

        if ((expression[r.nextIndex()] == ')'&&expression[i] == '(')|| (expression[r.nextIndex()] == ']'&&expression[i] == '[')||(expression[r.nextIndex()] == '}'&&expression[i] == '{'))
            return new EvaluationResult(CORRECT, r.nextIndex() + 1);
        else  if ((expression[r.nextIndex()] == ')'&&expression[i] != '(')|| (expression[r.nextIndex()] == ']'&&expression[i] != '[')||(expression[r.nextIndex()] == '}'&&expression[i] != '{'))
            return new EvaluationResult(INVALID_CLOSING_BRACKET, r.nextIndex());

                    else   if (expression[r.nextIndex()] == '(' || expression[r.nextIndex()] == '[' || expression[r.nextIndex()] == '{')
                           return new EvaluationResult(NO_CLOSING_BRACKET, r.nextIndex());

                           else    return new EvaluationResult(INVALID_CHARACTER, r.nextIndex());

    }

    }
}

CORRECT,
INVALID_CHARACTER,
NO_OPENING_BRACKET,
NO_CLOSING_BRACKET,
INVALID_CLOSING_BRACKET