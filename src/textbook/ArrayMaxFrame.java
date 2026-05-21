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
import javax.swing.JTable;

public class ArrayMaxFrame extends JFrame implements ActionListener {
   private JLabel maxLabel;              // Label for max array element
   private JFormattedTextField maxField; // Holds max array element
   private JButton maxButton;            // Triggers search for max array element
   private JTable arrayValsTable;        // Table of array values
   private final int numElements = 8;    // Number of array elemeents
   private String[] columnHeadings;      // Stores the table's column headings
   private String[][] tableVals;         // Stores the table's values
 
   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   ArrayMaxFrame() {
      GridBagConstraints layoutConst = null; // GUI component layout
      int i;                      

      // Set frame's title
      setTitle("Array maximum");

      // Create label
      maxLabel = new JLabel("Max:");

      // Create field
      maxField = new JFormattedTextField(NumberFormat.getIntegerInstance());
      maxField.setColumns(15);
      maxField.setEditable(false);
      maxField.setValue(0);

      // Create button
      maxButton = new JButton("Find max");
      maxButton.addActionListener(this);

      // Table headings and values
      columnHeadings = new String[1];
      tableVals = new String[8][1];

      // Initialize column heading(s)
      columnHeadings[0] = "Element";

      // Initialize table values
      for (i = 0; i < numElements; ++i) {
         tableVals[i][0] = "0";
      }

      // Create a table with the specified values and column headings
      arrayValsTable = new JTable(tableVals, columnHeadings);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Add table header
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 2;
      add(arrayValsTable.getTableHeader(), layoutConst);

      // Add table itself
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 2;
      add(arrayValsTable, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(maxButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(maxLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 2;
      add(maxField, layoutConst);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      int i;               // Loop index
      int maxElement;      // Max value found
      String strElem;      // Array element value (string)
      int elemVal;         // Array element value (int)

      strElem = tableVals[0][0];              // Get table value (String)
      maxElement = Integer.parseInt(strElem); // Convert to Integer

      // Iterate through table values to find max
      for (i = 1; i < numElements; ++i) {
         strElem = tableVals[i][0];           // Get table value (String)
         elemVal = Integer.parseInt(strElem); // Convert to Integer
         if (elemVal > maxElement) {          // Check if new max value found
            maxElement = elemVal;             // If so, update max
         }
      }

      // Display maximum value
      maxField.setValue(maxElement);
   }

   /* Creates a ArrayMaxFrame and makes it visible */
   public static void main(String[] args) {
      // Creates ArrayMaxFrame and its components
      ArrayMaxFrame myFrame = new ArrayMaxFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}