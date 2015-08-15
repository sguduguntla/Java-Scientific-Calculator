import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class CalculatorFrame implements KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549320861627671027L;

	private JFrame frame;
	public static JTextField textfield;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton divideButton;
	private JButton equalsButton;
	private JButton ansButton;
	private JButton onButton;
	private JButton clearButton;
	private JButton fourBtn;
	private JButton fiveBtn;
	private JButton sixBtn;
	private JButton oneBtn;
	private JButton twoBtn;
	private JButton threeBtn;
	private JButton zeroBtn;
	private JButton decPointBtn;
	private JButton expBtn;
	private JButton sevenBtn;
	private JButton eightBtn;
	private JButton nineBtn;
	private boolean isOn = false;
	private int onPressed = 0;
	private int modeChosen = 0;
	private double answer = 0;
	private JButton piBtn;
	private JButton eBtn;
	public static boolean onDegrees = true;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		System.out.println(Math.toDegrees(Math.asin(0.5)));
		Interpreter parse = new Interpreter();
		try {
			System.out.println(parse.eval("Math.sqrt(4)"));
		} catch (EvalError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Expression expression = new Expression("3 + 4");
		System.out.println(expression.evaluate());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorFrame window = new CalculatorFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public CalculatorFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 240));
		frame.setBounds(100, 100, 516, 507);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Scientific Calculator");
		frame.setVisible(true);

		UIManager.put("ToolTip.foreground", Color.blue);
		UIManager.put("ToolTip.background", Color.WHITE);

		textfield = new JTextField();
		textfield.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (isOn) {

						calculateExpression(textfield.getText());

					}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		textfield.addMouseListener(this);
		textfield.setText("Off");
		textfield.setEditable(false);
		textfield.setFont(new Font("Letter Gothic Std", Font.BOLD, 32));
		textfield.setForeground(new Color(50, 205, 50));
		textfield.setCaretColor(new Color(50, 205, 50));
		textfield.setSelectionColor(new Color(152, 251, 152));
		textfield.setBackground(UIManager.getColor("Button.darkShadow"));
		textfield.setBounds(16, 6, 483, 102);
		frame.getContentPane().add(textfield);
		textfield.setColumns(10);

		final JButton addButton = new JButton("+");
		addButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(Color.WHITE);
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		addButton.setOpaque(true);
		addButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
				50)));
		addButton.setForeground(new Color(50, 205, 50));
		addButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
		addButton.setBackground(UIManager.getColor("Button.darkShadow"));
		addButton.setToolTipText("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					textfield.setText(textfield.getText() + " + ");
				}
			}
		});
		addButton.setBounds(416, 326, 75, 38);
		frame.getContentPane().add(addButton);

		subtractButton = new JButton("-");
		subtractButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(Color.WHITE);
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					textfield.setText(textfield.getText() + " - ");
				}
			}
		});
		subtractButton.setToolTipText("Subtract");
		subtractButton.setOpaque(true);
		subtractButton.setForeground(new Color(50, 205, 50));
		subtractButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
		subtractButton.setBorder(BorderFactory.createLineBorder(new Color(50,
				205, 50)));
		subtractButton.setBackground(Color.BLACK);
		subtractButton.setBounds(416, 276, 75, 38);
		frame.getContentPane().add(subtractButton);

		multiplyButton = new JButton("x");
		multiplyButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(Color.WHITE);
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					textfield.setText(textfield.getText() + " * ");
				}
			}
		});
		multiplyButton.setToolTipText("Multiply");
		multiplyButton.setOpaque(true);
		multiplyButton.setForeground(new Color(50, 205, 50));
		multiplyButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
		multiplyButton.setBorder(BorderFactory.createLineBorder(new Color(50,
				205, 50)));
		multiplyButton.setBackground(Color.BLACK);
		multiplyButton.setBounds(416, 226, 75, 38);
		frame.getContentPane().add(multiplyButton);

		divideButton = new JButton("/");
		divideButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(Color.WHITE);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					textfield.setText(textfield.getText() + " / ");
				}

			}
		});
		divideButton.setToolTipText("Divide");
		divideButton.setOpaque(true);
		divideButton.setForeground(new Color(50, 205, 50));
		divideButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
		divideButton.setBorder(BorderFactory.createLineBorder(new Color(50,
				205, 50)));
		divideButton.setBackground(Color.BLACK);
		divideButton.setBounds(416, 176, 75, 38);
		frame.getContentPane().add(divideButton);

		equalsButton = new JButton("=");
		equalsButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				equalsButton.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				equalsButton.setBackground(UIManager
						.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					calculateExpression(textfield.getText());

				}
			}
		});
		equalsButton.setToolTipText("Equals");
		equalsButton.setOpaque(true);
		equalsButton.setForeground(new Color(50, 205, 50));
		equalsButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
		equalsButton.setBorder(BorderFactory.createLineBorder(new Color(50,
				205, 50)));
		equalsButton.setBackground(Color.BLACK);
		equalsButton.setBounds(416, 376, 75, 38);
		frame.getContentPane().add(equalsButton);

		ansButton = new JButton("Ans");
		ansButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				ansButton.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				ansButton.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				ansButton.setOpaque(true);
				ansButton.setBackground(null);
				ansButton.setBounds(ansButton.getX() + 5, ansButton.getY(),
						ansButton.getWidth() - 10, ansButton.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				ansButton.setOpaque(true);
				ansButton.setBackground(UIManager.getColor("Button.darkShadow"));
				ansButton.setBounds(ansButton.getX() - 5, ansButton.getY(),
						ansButton.getWidth() + 10, ansButton.getHeight());
			}

		});
		ansButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "Ans");
				}
			}
		});
		ansButton.setToolTipText("Previous Answer");
		ansButton.setOpaque(true);
		ansButton.setForeground(new Color(50, 205, 50));
		ansButton.setFont(new Font("Lucida Console", Font.BOLD, 28));
		ansButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
				50)));
		ansButton.setBackground(Color.BLACK);
		ansButton.setBounds(416, 426, 75, 38);
		frame.getContentPane().add(ansButton);

		onButton = new JButton("Off");
		onButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				onButton.setForeground(Color.BLACK);
				if (isOn) {
					onButton.setBackground(Color.GREEN);
					onButton.setText("Off");
				} else {
					onButton.setBackground(Color.RED);
					onButton.setText("On");
				}
				onButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				onButton.setBounds(onButton.getX() + 5, onButton.getY(),
						onButton.getWidth() - 10, onButton.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				onButton.setForeground(new Color(50, 205, 50));
				onButton.setText("Off");
				if (onPressed > 0) {
					onButton.setForeground(Color.BLACK);
					if (isOn) {
						onButton.setBackground(Color.RED);
						onButton.setText("On");
					} else {
						onButton.setBackground(Color.GREEN);
						onButton.setText("Off");
					}
				} else {
					onButton.setBorder(BorderFactory
							.createLineBorder(new Color(50, 205, 50)));
					onButton.setBackground(UIManager
							.getColor("Button.darkShadow"));
				}
				onButton.setBounds(onButton.getX() - 5, onButton.getY(),
						onButton.getWidth() + 10, onButton.getHeight());
			}

		});
		onButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onPressed++;
				if (isOn == false) {
					isOn = true;
					textfield.setEditable(true);
					textfield.setText("0");
					onButton.setToolTipText("Off");
					onButton.setText("Off");
					onButton.setBackground(Color.GREEN);
					onButton.setForeground(Color.BLACK);
					onButton.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
					textfield.setBackground(Color.BLACK);
				} else {
					isOn = false;
					textfield.setEditable(false);
					textfield.setBackground(Color.BLACK);
					textfield.setText("Off");
					onButton.setToolTipText("On");
					onButton.setForeground(Color.BLACK);
					onButton.setBackground(Color.RED);
					onButton.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
					onButton.setText("On");
				}
			}
		});
		onButton.setToolTipText("On");
		onButton.setOpaque(true);
		onButton.setForeground(new Color(50, 205, 50));
		onButton.setFont(new Font("Lucida Console", Font.BOLD, 22));
		onButton.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		onButton.setBackground(Color.BLACK);
		onButton.setBounds(28, 428, 75, 38);
		frame.getContentPane().add(onButton);

		clearButton = new JButton("AC");
		clearButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				clearButton.setBackground(Color.YELLOW);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				clearButton.setBackground(UIManager
						.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearButton.setForeground(Color.BLACK);
				clearButton.setBackground(Color.YELLOW);
				clearButton.setBorder(BorderFactory
						.createLineBorder(Color.BLACK));
				clearButton.setBounds(clearButton.getX() + 5,
						clearButton.getY(), clearButton.getWidth() - 10,
						clearButton.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				clearButton.setForeground(new Color(50, 205, 50));
				clearButton.setBorder(BorderFactory.createLineBorder(new Color(
						50, 205, 50)));
				clearButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				clearButton.setBounds(clearButton.getX() - 5,
						clearButton.getY(), clearButton.getWidth() + 10,
						clearButton.getHeight());
			}

		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearButton.setForeground(new Color(50, 205, 50));
				if (isOn) {
					textfield.setText("");
				}
			}
		});
		clearButton.setToolTipText("Clear");
		clearButton.setOpaque(true);
		clearButton.setForeground(new Color(50, 205, 50));
		clearButton.setFont(new Font("Lucida Console", Font.BOLD, 25));
		clearButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
				50)));
		clearButton.setBackground(Color.BLACK);
		clearButton.setBounds(416, 126, 75, 38);
		frame.getContentPane().add(clearButton);

		fourBtn = new JButton("4");
		fourBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				fourBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				fourBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fourBtn.setOpaque(true);
				fourBtn.setBackground(null);
				fourBtn.setBounds(fourBtn.getX() + 5, fourBtn.getY(),
						fourBtn.getWidth() - 10, fourBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				fourBtn.setOpaque(true);
				fourBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				fourBtn.setBounds(fourBtn.getX() - 5, fourBtn.getY(),
						fourBtn.getWidth() + 10, fourBtn.getHeight());
			}

		});
		fourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "4");
				}
			}
		});
		fourBtn.setToolTipText("4");
		fourBtn.setOpaque(true);
		fourBtn.setForeground(new Color(50, 205, 50));
		fourBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		fourBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		fourBtn.setBackground(Color.BLACK);
		fourBtn.setBounds(137, 328, 75, 38);
		frame.getContentPane().add(fourBtn);

		fiveBtn = new JButton("5");
		fiveBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				fiveBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				fiveBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fiveBtn.setOpaque(true);
				fiveBtn.setBackground(null);
				fiveBtn.setBounds(fiveBtn.getX() + 5, fiveBtn.getY(),
						fiveBtn.getWidth() - 10, fiveBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				fiveBtn.setOpaque(true);
				fiveBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				fiveBtn.setBounds(fiveBtn.getX() - 5, fiveBtn.getY(),
						fiveBtn.getWidth() + 10, fiveBtn.getHeight());
			}

		});
		fiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "5");
				}
			}
		});
		fiveBtn.setToolTipText("5");
		fiveBtn.setOpaque(true);
		fiveBtn.setForeground(new Color(50, 205, 50));
		fiveBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		fiveBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		fiveBtn.setBackground(Color.BLACK);
		fiveBtn.setBounds(231, 328, 75, 38);
		frame.getContentPane().add(fiveBtn);

		sixBtn = new JButton("6");
		sixBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				sixBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				sixBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				sixBtn.setOpaque(true);
				sixBtn.setBackground(null);
				sixBtn.setBounds(sixBtn.getX() + 5, sixBtn.getY(),
						sixBtn.getWidth() - 10, sixBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				sixBtn.setOpaque(true);
				sixBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				sixBtn.setBounds(sixBtn.getX() - 5, sixBtn.getY(),
						sixBtn.getWidth() + 10, sixBtn.getHeight());
			}

		});
		sixBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "6");
				}
			}
		});
		sixBtn.setToolTipText("6");
		sixBtn.setOpaque(true);
		sixBtn.setForeground(new Color(50, 205, 50));
		sixBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		sixBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		sixBtn.setBackground(Color.BLACK);
		sixBtn.setBounds(318, 328, 75, 38);
		frame.getContentPane().add(sixBtn);

		oneBtn = new JButton("1");
		oneBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				oneBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				oneBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				oneBtn.setOpaque(true);
				oneBtn.setBackground(null);
				oneBtn.setBounds(oneBtn.getX() + 5, oneBtn.getY(),
						oneBtn.getWidth() - 10, oneBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				oneBtn.setOpaque(true);
				oneBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				oneBtn.setBounds(oneBtn.getX() - 5, oneBtn.getY(),
						oneBtn.getWidth() + 10, oneBtn.getHeight());
			}

		});
		oneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "1");
				}
			}
		});
		oneBtn.setToolTipText("1");
		oneBtn.setOpaque(true);
		oneBtn.setForeground(new Color(50, 205, 50));
		oneBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		oneBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		oneBtn.setBackground(Color.BLACK);
		oneBtn.setBounds(137, 378, 75, 38);
		frame.getContentPane().add(oneBtn);

		twoBtn = new JButton("2");
		twoBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				twoBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				twoBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				twoBtn.setOpaque(true);
				twoBtn.setBackground(null);
				twoBtn.setBounds(twoBtn.getX() + 5, twoBtn.getY(),
						twoBtn.getWidth() - 10, twoBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				twoBtn.setOpaque(true);
				twoBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				twoBtn.setBounds(twoBtn.getX() - 5, twoBtn.getY(),
						twoBtn.getWidth() + 10, twoBtn.getHeight());
			}

		});
		twoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "2");
				}
			}
		});
		twoBtn.setToolTipText("2");
		twoBtn.setOpaque(true);
		twoBtn.setForeground(new Color(50, 205, 50));
		twoBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		twoBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		twoBtn.setBackground(Color.BLACK);
		twoBtn.setBounds(230, 378, 75, 38);
		frame.getContentPane().add(twoBtn);

		threeBtn = new JButton("3");
		threeBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				threeBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				threeBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			public void mouseEntered(MouseEvent e) {
				threeBtn.setOpaque(true);
				threeBtn.setBackground(null);
				threeBtn.setBounds(threeBtn.getX() + 5, threeBtn.getY(),
						threeBtn.getWidth() - 10, threeBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				threeBtn.setOpaque(true);
				threeBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				threeBtn.setBounds(threeBtn.getX() - 5, threeBtn.getY(),
						threeBtn.getWidth() + 10, threeBtn.getHeight());
			}

		});
		threeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "3");
				}
			}
		});
		threeBtn.setToolTipText("3");
		threeBtn.setOpaque(true);
		threeBtn.setForeground(new Color(50, 205, 50));
		threeBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		threeBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		threeBtn.setBackground(Color.BLACK);
		threeBtn.setBounds(318, 378, 75, 38);
		frame.getContentPane().add(threeBtn);

		zeroBtn = new JButton("0");
		zeroBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				zeroBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				zeroBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			public void mouseEntered(MouseEvent e) {
				zeroBtn.setOpaque(true);
				zeroBtn.setBackground(null);
				zeroBtn.setBounds(zeroBtn.getX() + 5, zeroBtn.getY(),
						zeroBtn.getWidth() - 10, zeroBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				zeroBtn.setOpaque(true);
				zeroBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				zeroBtn.setBounds(zeroBtn.getX() - 5, zeroBtn.getY(),
						zeroBtn.getWidth() + 10, zeroBtn.getHeight());
			}

		});
		zeroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "0");
				}
			}
		});
		zeroBtn.setToolTipText("0");
		zeroBtn.setOpaque(true);
		zeroBtn.setForeground(new Color(50, 205, 50));
		zeroBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		zeroBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		zeroBtn.setBackground(Color.BLACK);
		zeroBtn.setBounds(137, 428, 75, 38);
		frame.getContentPane().add(zeroBtn);

		decPointBtn = new JButton(".");
		decPointBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				decPointBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				decPointBtn.setBackground(UIManager
						.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				decPointBtn.setOpaque(true);
				decPointBtn.setBackground(null);
				decPointBtn.setBounds(decPointBtn.getX() + 5,
						decPointBtn.getY(), decPointBtn.getWidth() - 10,
						decPointBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				decPointBtn.setOpaque(true);
				decPointBtn.setBackground(UIManager
						.getColor("Button.darkShadow"));
				decPointBtn.setBounds(decPointBtn.getX() - 5,
						decPointBtn.getY(), decPointBtn.getWidth() + 10,
						decPointBtn.getHeight());
			}

		});
		decPointBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + ".");
				}
			}
		});
		decPointBtn.setToolTipText(".");
		decPointBtn.setOpaque(true);
		decPointBtn.setForeground(new Color(50, 205, 50));
		decPointBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		decPointBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
				50)));
		decPointBtn.setBackground(Color.BLACK);
		decPointBtn.setBounds(230, 428, 75, 38);
		frame.getContentPane().add(decPointBtn);

		expBtn = new JButton("EXP");
		expBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				expBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				expBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				expBtn.setOpaque(true);
				expBtn.setBackground(null);
				expBtn.setBounds(expBtn.getX() + 5, expBtn.getY(),
						expBtn.getWidth() - 10, expBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				expBtn.setOpaque(true);
				expBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				expBtn.setBounds(expBtn.getX() - 5, expBtn.getY(),
						expBtn.getWidth() + 10, expBtn.getHeight());
			}

		});
		expBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					textfield.setText(textfield.getText() + "E");
				}
			}
		});
		expBtn.setToolTipText("EXP");
		expBtn.setOpaque(true);
		expBtn.setForeground(new Color(50, 205, 50));
		expBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
		expBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		expBtn.setBackground(Color.BLACK);
		expBtn.setBounds(318, 428, 75, 38);
		frame.getContentPane().add(expBtn);

		sevenBtn = new JButton("7");
		sevenBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				sevenBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				sevenBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				sevenBtn.setOpaque(true);
				sevenBtn.setBackground(null);
				sevenBtn.setBounds(sevenBtn.getX() + 5, sevenBtn.getY(),
						sevenBtn.getWidth() - 10, sevenBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				sevenBtn.setOpaque(true);
				sevenBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				sevenBtn.setBounds(sevenBtn.getX() - 5, sevenBtn.getY(),
						sevenBtn.getWidth() + 10, sevenBtn.getHeight());
			}

		});
		sevenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "7");
				}
			}
		});
		sevenBtn.setToolTipText("7");
		sevenBtn.setOpaque(true);
		sevenBtn.setForeground(new Color(50, 205, 50));
		sevenBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		sevenBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		sevenBtn.setBackground(Color.BLACK);
		sevenBtn.setBounds(137, 278, 75, 38);
		frame.getContentPane().add(sevenBtn);

		eightBtn = new JButton("8");
		eightBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				eightBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				eightBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				eightBtn.setOpaque(true);
				eightBtn.setBackground(null);
				eightBtn.setBounds(eightBtn.getX() + 5, eightBtn.getY(),
						eightBtn.getWidth() - 10, eightBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				eightBtn.setOpaque(true);
				eightBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				eightBtn.setBounds(eightBtn.getX() - 5, eightBtn.getY(),
						eightBtn.getWidth() + 10, eightBtn.getHeight());
			}

		});
		eightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "8");
				}
			}
		});
		eightBtn.setToolTipText("8");
		eightBtn.setOpaque(true);
		eightBtn.setForeground(new Color(50, 205, 50));
		eightBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		eightBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		eightBtn.setBackground(Color.BLACK);
		eightBtn.setBounds(231, 278, 75, 38);
		frame.getContentPane().add(eightBtn);

		nineBtn = new JButton("9");
		nineBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				nineBtn.setBackground(Color.WHITE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				nineBtn.setBackground(UIManager.getColor("Button.darkShadow"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				nineBtn.setOpaque(true);
				nineBtn.setBackground(null);
				nineBtn.setBounds(nineBtn.getX() + 5, nineBtn.getY(),
						nineBtn.getWidth() - 10, nineBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				nineBtn.setOpaque(true);
				nineBtn.setBackground(UIManager.getColor("Button.darkShadow"));
				nineBtn.setBounds(nineBtn.getX() - 5, nineBtn.getY(),
						nineBtn.getWidth() + 10, nineBtn.getHeight());
			}

		});
		nineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "9");
				}
			}
		});
		nineBtn.setToolTipText("9");
		nineBtn.setOpaque(true);
		nineBtn.setForeground(new Color(50, 205, 50));
		nineBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		nineBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		nineBtn.setBackground(Color.BLACK);
		nineBtn.setBounds(318, 278, 75, 38);
		frame.getContentPane().add(nineBtn);

		JButton exponentBtn = new JButton("^");
		exponentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "^");
				}
			}
		});
		exponentBtn.setToolTipText("^");
		exponentBtn.setOpaque(true);
		exponentBtn.setForeground(new Color(50, 205, 50));
		exponentBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		exponentBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
				50)));
		exponentBtn.setBackground(Color.BLACK);
		exponentBtn.setBounds(137, 226, 75, 38);
		frame.getContentPane().add(exponentBtn);

		JButton leftBraceBtn = new JButton("(");
		leftBraceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "(");
				}
			}
		});
		leftBraceBtn.setToolTipText("(");
		leftBraceBtn.setOpaque(true);
		leftBraceBtn.setForeground(new Color(50, 205, 50));
		leftBraceBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		leftBraceBtn.setBorder(BorderFactory.createLineBorder(new Color(50,
				205, 50)));
		leftBraceBtn.setBackground(Color.BLACK);
		leftBraceBtn.setBounds(231, 226, 75, 38);
		frame.getContentPane().add(leftBraceBtn);

		JButton rightBraceBtn = new JButton(")");
		rightBraceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + ")");
				}
			}
		});
		rightBraceBtn.setToolTipText(")");
		rightBraceBtn.setOpaque(true);
		rightBraceBtn.setForeground(new Color(50, 205, 50));
		rightBraceBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		rightBraceBtn.setBorder(BorderFactory.createLineBorder(new Color(50,
				205, 50)));
		rightBraceBtn.setBackground(Color.BLACK);
		rightBraceBtn.setBounds(318, 226, 75, 38);
		frame.getContentPane().add(rightBraceBtn);

		JButton sinBtn = new JButton("sin");
		sinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "sin(");
				}
			}
		});
		sinBtn.setToolTipText("sin");
		sinBtn.setOpaque(true);
		sinBtn.setForeground(new Color(50, 205, 50));
		sinBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
		sinBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		sinBtn.setBackground(Color.BLACK);
		sinBtn.setBounds(137, 126, 75, 38);
		frame.getContentPane().add(sinBtn);

		JButton cosBtn = new JButton("cos");
		cosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "cos(");
				}
			}
		});
		cosBtn.setToolTipText("cos");
		cosBtn.setOpaque(true);
		cosBtn.setForeground(new Color(50, 205, 50));
		cosBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
		cosBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		cosBtn.setBackground(Color.BLACK);
		cosBtn.setBounds(231, 126, 75, 38);
		frame.getContentPane().add(cosBtn);

		JButton tanBtn = new JButton("tan");
		tanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "tan(");
				}
			}
		});
		tanBtn.setToolTipText("tan");
		tanBtn.setOpaque(true);
		tanBtn.setForeground(new Color(50, 205, 50));
		tanBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
		tanBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		tanBtn.setBackground(Color.BLACK);
		tanBtn.setBounds(318, 126, 75, 38);
		frame.getContentPane().add(tanBtn);

		piBtn = new JButton("\u03C0");
		piBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "π");
				}
			}
		});
		piBtn.setToolTipText("pi");
		piBtn.setOpaque(true);
		piBtn.setForeground(new Color(50, 205, 50));
		piBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		piBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		piBtn.setBackground(Color.BLACK);
		piBtn.setBounds(28, 378, 75, 38);
		frame.getContentPane().add(piBtn);

		eBtn = new JButton("e");
		eBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "e");
				}
			}
		});
		eBtn.setToolTipText("e");
		eBtn.setOpaque(true);
		eBtn.setForeground(new Color(50, 205, 50));
		eBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		eBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		eBtn.setBackground(Color.BLACK);
		eBtn.setBounds(28, 328, 75, 38);
		frame.getContentPane().add(eBtn);

		JButton sqrtBtn = new JButton("√");
		sqrtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "√");
				}
			}
		});
		sqrtBtn.setToolTipText("√");
		sqrtBtn.setOpaque(true);
		sqrtBtn.setForeground(new Color(50, 205, 50));
		sqrtBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
		sqrtBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		sqrtBtn.setBackground(Color.BLACK);
		sqrtBtn.setBounds(28, 278, 75, 38);
		frame.getContentPane().add(sqrtBtn);

		final JButton modeBtn = new JButton("Degrees");
		modeBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(UIManager.getColor("Button.darkShadow"));
				subtractButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				multiplyButton.setBackground(UIManager
						.getColor("Button.darkShadow"));
				divideButton.setBackground(UIManager
						.getColor("Button.darkShadow"));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (onDegrees) {
					modeBtn.setForeground(Color.WHITE);
					modeBtn.setBackground(Color.BLUE);
					modeBtn.setText("Radians");
				} else {
					modeBtn.setForeground(Color.BLACK);
					modeBtn.setBackground(Color.MAGENTA);
					modeBtn.setText("Degrees");

				}
				modeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				modeBtn.setBounds(modeBtn.getX() + 5, modeBtn.getY(),
						modeBtn.getWidth() - 10, modeBtn.getHeight());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				modeBtn.setForeground(new Color(50, 205, 50));
				modeBtn.setText("Degrees");
				if (modeChosen > 0) {
					if (onDegrees) {
						modeBtn.setBackground(Color.MAGENTA);
						modeBtn.setText("Degrees");
						modeBtn.setForeground(Color.BLACK);
					} else {
						modeBtn.setForeground(Color.WHITE);
						modeBtn.setBackground(Color.BLUE);
						modeBtn.setText("Radians");
					}
				} else {
					modeBtn.setBorder(BorderFactory.createLineBorder(new Color(
							50, 205, 50)));
					modeBtn.setBackground(UIManager
							.getColor("Button.darkShadow"));
				}
				modeBtn.setBounds(modeBtn.getX() - 5, modeBtn.getY(),
						modeBtn.getWidth() + 10, modeBtn.getHeight());
			}

		});
		modeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeChosen++;
				if (onDegrees == false) {
					onDegrees = true;
					modeBtn.setToolTipText("Degrees");
					modeBtn.setText("Degrees");
					modeBtn.setBackground(Color.MAGENTA);
					modeBtn.setForeground(Color.BLACK);
					modeBtn.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else {
					onDegrees = false;
					modeBtn.setToolTipText("Radians");
					modeBtn.setText("Radians");
					modeBtn.setBackground(Color.BLUE);
					modeBtn.setForeground(Color.WHITE);
					modeBtn.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				}
			}
		});
		modeBtn.setToolTipText("On");
		modeBtn.setOpaque(true);
		modeBtn.setForeground(new Color(50, 205, 50));
		modeBtn.setFont(new Font("Lucida Console", Font.BOLD, 15));
		modeBtn.setBorder(BorderFactory
				.createLineBorder(new Color(50, 205, 50)));
		modeBtn.setBackground(Color.BLACK);
		modeBtn.setBounds(28, 226, 75, 38);
		frame.getContentPane().add(modeBtn);
		
		JButton invSin = new JButton("sin^-1");
		invSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOn) {
					if (textfield.getText().equals("0")) {
						textfield.setText("");
					}
					textfield.setText(textfield.getText() + "arcsin(");
				}
			}
		});
		invSin.setToolTipText("arcsin");
		invSin.setOpaque(true);
		invSin.setForeground(new Color(50, 205, 50));
		invSin.setFont(new Font("Lucida Console", Font.BOLD, 18));
		invSin.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		invSin.setBackground(Color.BLACK);
		invSin.setBounds(137, 176, 75, 38);
		frame.getContentPane().add(invSin);
		
		JButton invTan = new JButton("tan^-1");
		invTan.setToolTipText("arctan");
		invTan.setOpaque(true);
		invTan.setForeground(new Color(50, 205, 50));
		invTan.setFont(new Font("Lucida Console", Font.BOLD, 18));
		invTan.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		invTan.setBackground(Color.BLACK);
		invTan.setBounds(318, 176, 75, 38);
		frame.getContentPane().add(invTan);
		
		JButton invCos = new JButton("cos^-1");
		invCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		invCos.setToolTipText("arccos");
		invCos.setOpaque(true);
		invCos.setForeground(new Color(50, 205, 50));
		invCos.setFont(new Font("Lucida Console", Font.BOLD, 18));
		invCos.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
		invCos.setBackground(Color.BLACK);
		invCos.setBounds(231, 176, 75, 38);
		frame.getContentPane().add(invCos);
	}

	private void calculateExpression(String expression) {
		String newExpression1 = "";
		String[] values = textfield.getText().split("\\s");
		for (int i = 0; i < values.length; i++) {
			if (values[i].trim().equals("Ans")) {
				newExpression1 += answer;
			} else {
				newExpression1 += values[i];
			}
		}

		String newExpression2 = "";
		for (int j = 0; j < newExpression1.length(); j++) {
			if (newExpression1.charAt(j) == 'π') {
				newExpression2 += Math.PI;
			} else if (newExpression1.charAt(j) == 'e') {
				newExpression2 += Math.E;
			} else {
				newExpression2 += newExpression1.charAt(j);
			}
		}

		try {
			Expression e = new Expression(newExpression2);
			double ans = e.evaluate();
			answer = ans;
			textfield.setText(Double.toString(ans));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Please enter a valid number! You have entered: " + "\""
							+ textfield.getText() + "\"");
			textfield.setText("");
		}

		/*
		 * boolean powPressed = false; Interpreter parse = new Interpreter();
		 * 
		 * char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		 * boolean timeToBreak = false; String firstexp = expression; String
		 * firstpart = ""; String secondpart = ""; StringBuffer buf = new
		 * StringBuffer(expression); for (int j = 0; j < expression.length();
		 * j++) { for (int k = 0; k < nums.length; k++) { if
		 * (expression.charAt(j) == nums[k]) { secondpart =
		 * expression.substring(j); timeToBreak = true; break; } } if
		 * (timeToBreak) { break; } else { firstpart += expression.charAt(j); }
		 * } expression = firstpart + ".0" + secondpart;
		 */

		/*
		 * parse.eval("result = " + expression + " + 0.0"); parse.set("result",
		 * Double.class); System.out.println(parse.get("result")); if
		 * (isDouble(parse.get("result"))) { System.out.println("I got here!");
		 * double ans = (double) parse.get("result"); answer = ans;
		 * textfield.setText(Double.toString(ans)); } else if
		 * (isInteger(parse.get("result"))) { int ans = (int)
		 * parse.get("result"); answer = ans;
		 * textfield.setText(Integer.toString(ans)); } } catch (EvalError e1) {
		 * String[] values = textfield.getText().trim().split(" "); String
		 * newExpression = ""; for (int i = 0; i < values.length - 1; i++) { if
		 * (values[i].trim().equals("Ans")) { newExpression += answer; } else if
		 * (values[i].trim().equals("sin")) { newExpression += "Math.sin"; }
		 * else if (values[i].trim().equals("cos")) { newExpression +=
		 * "Math.cos"; } else if (values[i].trim().equals("tan")) {
		 * newExpression += "Math.tan"; } else if (values[i].trim().equals("^"))
		 * { int numParentheses = 0; String firstVal = values[i - 1];
		 * StringBuffer value1Buf = new StringBuffer(firstVal); for (int j = 0;
		 * j < values[i - 1].length(); j++) { if (values[i - 1].charAt(j) ==
		 * '(') { numParentheses++; value1Buf.deleteCharAt(0); } } values[i - 1]
		 * = value1Buf.toString();
		 * 
		 * String secondVal = values[i + 1]; StringBuffer value2Buf = new
		 * StringBuffer(secondVal); for (int k = 0; k < values[i + 1].length();
		 * k++) { if (values[i + 1].charAt(k) == ')') {
		 * value2Buf.deleteCharAt(value2Buf.length() - 1); } } values[i + 1] =
		 * value2Buf.toString();
		 * 
		 * newExpression += "Math.pow(" + values[i - 1] + ", " + values[i + 1] +
		 * ")"; for (int b = 0; b < numParentheses; b++) { newExpression += ")";
		 * }
		 * 
		 * StringBuffer buf = new StringBuffer(newExpression);
		 * buf.deleteCharAt(newExpression.indexOf("Math.pow(") - 1);
		 * newExpression = buf.toString(); powPressed = true; } else { if
		 * (powPressed) { if (!values[i + 1].trim().equals("")) { newExpression
		 * += values[i + 1]; } } else { newExpression += values[i]; } } }
		 * 
		 * try { parse.eval("result = " + newExpression); if
		 * (isDouble(parse.get("result"))) { Double ans = (Double)
		 * parse.get("result"); answer = ans;
		 * textfield.setText(Double.toString(ans)); } else { Integer ans =
		 * (Integer) parse.get("result"); answer = ans;
		 * textfield.setText(Integer.toString(ans)); } } catch (EvalError e2) {
		 * JOptionPane.showMessageDialog(null,
		 * "Please enter a valid number! You have entered: " + "\"" +
		 * textfield.getText() + "\""); textfield.setText("");
		 * 
		 * } } decimalPressed = false;
		 */

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (textfield.getText().equals("0")) {
			textfield.setText("");
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	boolean isDouble(Object str) {
		try {
			Double.toString((Double) str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	boolean isInteger(Object str) {
		try {
			Integer.toString((Integer) str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
