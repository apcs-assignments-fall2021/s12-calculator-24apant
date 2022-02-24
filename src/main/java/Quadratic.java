import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quadratic {
    LTPanel aPanel;
    LTPanel bPanel;
    LTPanel cPanel;
    LTPanel answerPanel;
    JButton calculateButton;
    public Quadratic() {
        // Set up the frame
        JFrame frame = new JFrame("Quadratic Formula");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up and add the panels
        JPanel formulaPanel = new JPanel();
         aPanel = new LTPanel("a =", 10);
         bPanel = new LTPanel("b =", 10);
         cPanel = new LTPanel("c =", 10);
        JPanel buttonPanel = new JPanel();
        answerPanel = new LTPanel("Answer:", 10);

        frame.add(formulaPanel);
        frame.add(aPanel);
        frame.add(bPanel);
        frame.add(cPanel);
        frame.add(buttonPanel);
        frame.add(answerPanel);

        // Set up individual panels
        // formulaPanel code
        JLabel formulaLabel = new JLabel("ax^2 + bx + c = 0");
        formulaPanel.add(formulaLabel);

        // buttonPanel code
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                aPanel.setText("");
                bPanel.setText("");
                cPanel.setText("");
            }
        });

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Potentially a lot of code here
                // But just add code to call quadForm
                quadForm();
                // YOUR CODE HERE
            }
        });

        buttonPanel.add(clearButton);
        buttonPanel.add(calculateButton);

        // pack and show
        frame.pack();
        frame.setVisible(true);
    }

    public void quadForm() {
        double a = Double.parseDouble(aPanel.getText());
        double b = Double.parseDouble(bPanel.getText());
        double c = Double.parseDouble(cPanel.getText());
        double discriminant = (b * b) - (4 * a * c);
        if (discriminant < 0){
            answerPanel.setText("Error: Discriminant");
        }
        else{
            double root1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            double root2 = (-b - Math.sqrt(discriminant)) / 2 * a;
            answerPanel.setText(root1 + "  " + root2);
        }
    }

    public static void main(String[] args) {
        Quadratic q = new Quadratic();
    }
}
