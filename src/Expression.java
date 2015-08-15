import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Expression {
	/*
	 * Strings used for storing expression.
	 */
	String s, x;

	/*
	 * Term evaluator for number literals.
	 */
	double term() {
		double ans = 0;
		StringBuffer temp = new StringBuffer();
		while (s.length() > 0 && Character.isDigit(s.charAt(0))) {
			temp.append(Integer.parseInt("" + s.charAt(0)));
			s = s.substring(1);
		}
		if (s.length() > 0 && s.charAt(0) == '.') {
			temp.append('.');
			s = s.substring(1);
			while (s.length() > 0 && Character.isDigit(s.charAt(0))) {
				temp.append(Integer.parseInt("" + s.charAt(0)));
				s = s.substring(1);
			}
		}
		if (s.length() > 0 && (s.charAt(0) == 'e' || s.charAt(0) == 'E')) {
			temp.append('e');
			s = s.substring(1);
			temp.append(s.charAt(0));
			s = s.substring(1);
			while (s.length() > 0 && Character.isDigit(s.charAt(0))) {
				temp.append(Integer.parseInt("" + s.charAt(0)));
				s = s.substring(1);
			}
		}
		ans = Double.valueOf(temp.toString()).doubleValue();
		return ans;
	}

	/*
	 * Parentheses solver.
	 */
	double paren() {
		double ans;
		if (s.charAt(0) == '(') {
			s = s.substring(1);
			ans = add();
			s = s.substring(1);
		} else {
			ans = term();
		}
		return ans;
	}

	/*
	 * double sqrt() { double ans = exp(); if (s.charAt(0) == '-') {
	 * JOptionPane.showMessageDialog(null,
	 * "Please enter a valid number! You have entered: " + "\"" +
	 * CalculatorFrame.textfield.getText() + "\"");
	 * CalculatorFrame.textfield.setText(""); } while (s.length() > 0) { if
	 * (s.charAt(0) == '√') { s = s.substring(1); ans +=
	 * Math.sqrt(Double.parseDouble(s.charAt(0) + "")); } else { break; } }
	 * return ans;
	 * 
	 * }
	 */

	/*
	 * Exponentiation solver.
	 */
	double exp() {
		boolean neg = false;
		if (s.charAt(0) == '-') {
			neg = true;
			s = s.substring(1);
		}
		double ans = paren(); // double ans = paren();
		while (s.length() > 0) {
			if (s.charAt(0) == '^') {
				s = s.substring(1);
				boolean expNeg = false;
				if (s.charAt(0) == '-') {
					expNeg = true;
					s = s.substring(1);
				}
				double e = paren();
				if (ans < 0) { // if it's negative
					double x = 1;
					if (Math.ceil(e) == e) { // only raise to an integer
						if (expNeg)
							e *= -1;
						if (e == 0)
							ans = 1;
						else if (e > 0)
							for (int i = 0; i < e; i++)
								x *= ans;
						else
							for (int i = 0; i < -e; i++)
								x /= ans;
						ans = x;
					} else {
						ans = Math.log(-1); // otherwise make it NaN
					}
				} else if (expNeg)
					ans = Math.exp(-e * Math.log(ans));
				else
					ans = Math.exp(e * Math.log(ans));
			} else
				break;
		}
		DecimalFormat df = new DecimalFormat("#.#############");
		if (neg)
			ans *= -1;
		return Double.parseDouble(df.format(ans));
	}

	/*
	 * Trigonometric function solver.
	 */
	double trig() {
		double ans = 0;
		boolean found = false;
		DecimalFormat df = new DecimalFormat("#.#############");
		df.setRoundingMode(RoundingMode.UP);
		if (s.indexOf("sin") == 0) {
			s = s.substring(3);
			if (CalculatorFrame.onDegrees) {
				ans = Double.parseDouble(df.format(Math.sin(Math
						.toRadians(trig()))));
			} else {
				ans = Double.parseDouble(df.format(Math.sin(trig())));
			}
			found = true;
		} else if (s.indexOf("cos") == 0) {
			s = s.substring(3);
			if (CalculatorFrame.onDegrees) {
				ans = Double.parseDouble(df.format(Math.cos(Math
						.toRadians(trig()))));
			} else {
				ans = Double.parseDouble(df.format(Math.cos(trig())));
			}
			found = true;
		} else if (s.indexOf("tan") == 0) {
			s = s.substring(3);
			if (CalculatorFrame.onDegrees) {
				ans = Double.parseDouble(df.format(Math.tan(Math
						.toRadians(trig()))));
			} else {
				ans = Double.parseDouble(df.format(Math.tan(trig())));
			}
			found = true;
		}  else if (s.indexOf("arctan") == 0) {
			s = s.substring(6);
			if (CalculatorFrame.onDegrees) {
				ans = Math.toDegrees(Double.parseDouble(df.format(Math.atan(trig()))));
			} else {
				ans = Double.parseDouble(df.format(Math.atan(trig())));
			}
			found = true;
		} else if (s.indexOf("arcsin") == 0) {
			s = s.substring(6);
			if (CalculatorFrame.onDegrees) {
				ans = Math.toDegrees(Double.parseDouble(df.format(Math.asin(trig()))));
			} else {
				ans = Double.parseDouble(df.format(Math.asin(trig())));
			}
			found = true;
		} else if (s.indexOf("arccos") == 0) {
			s = s.substring(6);
			if (CalculatorFrame.onDegrees) {
				ans = Math.toDegrees(Double.parseDouble(df.format(Math.acos(trig()))));
			} else {
				ans = Double.parseDouble(df.format(Math.acos(trig())));
			}
			found = true;
		}
		if (!found) {
			ans = exp();
		}
		return ans;
	}

	/*
	 * Multiplication, division expression solver.
	 */
	double mul() {
		double ans = trig();
		if (s.length() > 0) {
			while (s.length() > 0) {
				if (s.charAt(0) == '*') {
					s = s.substring(1);
					ans *= trig();
				} else if (s.charAt(0) == '/') {
					s = s.substring(1);
					ans /= trig();
				} else
					break;
			}
		}
		return ans;
	}

	/*
	 * Addition, subtraction expression solver.
	 */
	double add() {
		double ans = mul();
		while (s.length() > 0) {
			if (s.charAt(0) == '+') {
				s = s.substring(1);
				ans += mul();
			} else if (s.charAt(0) == '-') {
				s = s.substring(1);
				ans -= mul();
			} else {
				break;
			}
		}
		return ans;
	}

	/*
	 * Public access method to evaluate this expression.
	 */
	public double evaluate() {
		s = x.intern();
		double last = add();
		return last;
	}

	/*
	 * Creates new Expression.
	 */
	public Expression(String s) { // 5 + 4
		// remove white space, assume only spaces or tabs
		StringBuffer b = new StringBuffer();
		StringTokenizer t = new StringTokenizer(s, " "); // s = "5 + 4"
		while (t.hasMoreElements())
			b.append(t.nextToken());
		t = new StringTokenizer(b.toString(), "\t");
		b = new StringBuffer();
		while (t.hasMoreElements())
			b.append(t.nextToken());

		x = b.toString();
	}

	/*
	 * The String value of this Expression.
	 */
	public String toString() {
		return x.intern();
	}

	/*
	 * Test our Expression class by evaluating the command-line argument and
	 * then returning.
	 */
}