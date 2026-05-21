package textbook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryLabelFrame extends JFrame {
   private JLabel wageLabel;     // Label for hourly salary
   private JLabel salLabel;      // Label for yearly salary
   private JTextField salField;  // Displays hourly salary 
   private JTextField wageField; // Displays yearly salary

   /* Constructor initializes the SalaryLabelFrame, 
      creates GUI components, and adds them
      using a GridBagLayout. */
   SalaryLabelFrame() {
      int hourlyWage;                  // Hourly wage
      GridBagConstraints layoutConst;  // Used to specify GUI component layout

      hourlyWage = 20;

      // Set frame's title
      setTitle("Salary");

      // Set hourly and yearly salary
      wageLabel = new JLabel("Hourly wage:");
      salLabel = new JLabel("Yearly salary:");

      wageField = new JTextField(15);
      wageField.setEditable(false);
      wageField.setText(Integer.toString(hourlyWage));

      salField = new JTextField(15);
      salField.setEditable(false);
      salField.setText(Integer.toString((hourlyWage * 40 * 50)));

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Create GridBagConstraints
      layoutConst = new GridBagConstraints();
      
      // Specify component's grid location
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;

      // 10 pixels of padding around component
      layoutConst.insets = new Insets(10, 10, 10, 10);

      // Add component using the specified constraints
      add(wageLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(wageField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(salLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(salField, layoutConst);
   }

   /* Creates a SalarLabelFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SalaryLabelFrame and its components
      SalaryLabelFrame myFrame = new SalaryLabelFrame();

      // Terminate program when window closes
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Resize window to fit components
      myFrame.pack();

      // Display window
      myFrame.setVisible(true);
   }
}