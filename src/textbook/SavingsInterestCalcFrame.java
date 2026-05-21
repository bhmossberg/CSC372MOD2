package textbook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SavingsInterestCalcFrame extends JFrame implements ActionListener {
   private JTextArea outputArea;                  // Displays yearly savings
   private JButton calcButton;                    // Triggers savings calculation
   private JFormattedTextField initSavingsField;  // Holds savings amount
   private JFormattedTextField interestRateField; // Holds interest amount
   private JFormattedTextField yearsField;        // Holds num years

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SavingsInterestCalcFrame() {
      GridBagConstraints layoutConst = null; // Used to specify GUI component layout
      JScrollPane scrollPane = null;         // Container that adds a scroll bar
      JLabel initSavingsLabel = null;        // Label for savings
      JLabel interestRateLabel = null;       // Label for interest
      JLabel yearsLabel = null;              // Label for num years
      JLabel outputLabel = null;             // Label for yearly savings

      // Format for the savings input
      NumberFormat currencyFormat = null;
      
      // Format for the interest rate input
      NumberFormat percentFormat = null;
      
      // Format for the years input
      NumberFormat integerFormat = null;

      // Set frame's title
      setTitle("Savings calculator");

      // Create labels
      initSavingsLabel = new JLabel("Initial savings:");
      interestRateLabel = new JLabel("Interest rate:");
      yearsLabel = new JLabel("Years:");
      outputLabel = new JLabel("Yearly savings:");

      // Create output area and add it to scroll pane
      outputArea = new JTextArea(10, 15);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);

      calcButton = new JButton("Calculate");
      calcButton.addActionListener(this);

      // Create savings field and specify the currency format
      currencyFormat = NumberFormat.getCurrencyInstance();
      initSavingsField = new JFormattedTextField(currencyFormat);
      initSavingsField.setEditable(true);
      initSavingsField.setColumns(10); // Initial width of 10 units
      initSavingsField.setValue(0);

      // Create rate field and specify the percent format
      percentFormat = NumberFormat.getPercentInstance();
      percentFormat.setMinimumFractionDigits(1);
      interestRateField = new JFormattedTextField(percentFormat);
      interestRateField.setEditable(true);
      interestRateField.setValue(0.0);

      // Create years field and specify the default number (for doubles) format
      integerFormat = NumberFormat.getIntegerInstance();
      yearsField = new JFormattedTextField(integerFormat);
      yearsField.setEditable(true);
      yearsField.setValue(0);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(initSavingsLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(initSavingsField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(interestRateLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(interestRateField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(yearsLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(yearsField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 0, 10);
      layoutConst.fill = GridBagConstraints.BOTH;
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      add(calcButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      layoutConst.gridwidth = 3; // 3 cells wide
      add(scrollPane, layoutConst);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      int i;                       // Loop index
      double savingsDollars;       // Yearly savings
      double interestRate;         // Annual interest rate
      int numYears;                // Num years to calc savings

      // Get values from fields
      savingsDollars = ((Number) initSavingsField.getValue()).intValue();
      interestRate = ((Number) interestRateField.getValue()).doubleValue();
      numYears = ((Number) yearsField.getValue()).intValue();

      // Clear the text area
      outputArea.setText("");

      // Calculate savings iteratively in a while loop
      i = 1;
      while (i <= numYears) {
         outputArea.append("Savings in year " + i +
                           ": $" + savingsDollars + "\n");
         savingsDollars = savingsDollars + (savingsDollars * interestRate);

         i = i + 1;
      }
   }

   /* Creates a SavingsInterestCalcFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SavingsInterestCalcFrame and its components
      SavingsInterestCalcFrame myFrame = new SavingsInterestCalcFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}