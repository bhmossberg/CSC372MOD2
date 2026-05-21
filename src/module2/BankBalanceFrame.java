package module2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

public class BankBalanceFrame extends JFrame implements ActionListener {

    private BankAccount account;						// BankAccount instance
    private JFormattedTextField initialBalanceField;	// Currency field for initial balance
    private JFormattedTextField amountField;			// Currency field for withdrawal/deposit
    private JPanel balancePanel;           				// JPanel to display balance
    private JLabel balanceDisplayLabel;    				// Label inside the JPanel
    private JButton initializeBalanceButton;			// Button to set initial balance
    private JButton depositButton;						// Button to perform deposit(double)
    private JButton withdrawButton;						// Button to perform withdraw(double)
    private JButton showBalanceButton;     				// Button to perform setText() for JPanel
    private JButton quitButton;							// Button to perform dispose()

    public BankBalanceFrame() {
        // Implement GridBag and Layout
    	// Implement number format	
        setTitle("Bank Balance");
        // Implement Fields

        // JPanel to show balance
        balancePanel = new JPanel();
        	// Add labels

        // Buttons
        initializeBalanceButton = new JButton("Set Initial Balance");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        showBalanceButton = new JButton("Show Balance");
        quitButton = new JButton("Quit");
        // ActionListeners
        initializeBalanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        showBalanceButton.addActionListener(this);
        quitButton.addActionListener(this);


        // Row 0: Initial Balance
        //To Do: set spacing and constraints
        add(new JLabel("Initial Balance:"), layoutConst);
        // Add balance field
        add(initialBalanceField, layoutConst);

        // Add BalanceButton
        add(initializeBalanceButton, layoutConst);

        // Row 1: Amount input
        //To Do: set spacing and constraints
        add(new JLabel("Amount:"), layoutConst);

        add(amountField, layoutConst);

        // Row 2: Deposit/Withdraw/Show Balance buttons
        //To Do: set spacing and constraints
        add(depositButton, layoutConst);

        add(withdrawButton, layoutConst);

        add(showBalanceButton, layoutConst);

        // Row 3: JPanel for balance display
        //To Do: set spacing and constraints
        add(balancePanel, layoutConst);

        // Quit button
        //To Do: set spacing and constraints
        add(quitButton, layoutConst);
    }
    
    // ActionEvent implementation
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton source = (JButton) event.getSource();
        double amount = ((Number) amountField.getValue()).doubleValue();
        // Initialize balance
        if (source == initializeBalanceButton) {
            double initial = ((Number) initialBalanceField.getValue()).doubleValue();
            account = new BankAccount(initial);
            JOptionPane.showMessageDialog(this, "Initial balance set successfully!");
        }
        
        // Deposit
        else if (source == depositButton) {
            if (amount > 0) {
                account.deposit(amount);
                JOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        }
        
        // Withdraw
        else if (source == withdrawButton) {

            if (amount > 0) {
                if (amount <= account.getBalance()) {
                    account.withdraw(amount);
                    JOptionPane.showMessageDialog(this, "Withdrawal successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!");
                }
            }
        }
        
        // Show Balance
        else if (source == showBalanceButton) {
            // Display balance inside the JPanel
            balanceDisplayLabel.setText(
                NumberFormat.getCurrencyInstance().format(account.getBalance())
            );
        }
        
        // Quit
        else if (source == quitButton) {
        	JOptionPane.showMessageDialog(this, "Remaining Balance: " + NumberFormat.getCurrencyInstance().format(account.getBalance()));
            dispose();
        }
    }

    public static void main(String[] args) {
        BankBalanceFrame frame = new BankBalanceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}