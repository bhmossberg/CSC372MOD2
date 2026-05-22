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
        GridBagConstraints layoutConst = null;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        setTitle("Bank Balance");
        // Input fields
        initialBalanceField = new JFormattedTextField(currencyFormat);
        initialBalanceField.setValue(500.00);
        amountField = new JFormattedTextField(currencyFormat);
        amountField.setValue(0.00);

        // JPanel that will show the balance when button is pressed
        balancePanel = new JPanel();
        balanceDisplayLabel = new JLabel("Balance will appear here");
        balancePanel.add(new JLabel("Current Balance: "));
        balancePanel.add(balanceDisplayLabel);

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

        // Layout
        setLayout(new GridBagLayout());

        // Row 0: Initial Balance
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 5, 10);
        layoutConst.gridx = 0; 
        layoutConst.gridy = 0;
        add(new JLabel("Initial Balance:"), layoutConst);
        
        layoutConst.gridx = 1; // Reuse gridy until next row
        add(initialBalanceField, layoutConst);

        layoutConst.gridx = 2;
        add(initializeBalanceButton, layoutConst);

        // Row 1: Amount input
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 5, 5);
        layoutConst.gridx = 0; 
        layoutConst.gridy = 1;
        add(new JLabel("Amount:"), layoutConst);

        layoutConst.gridx = 1;
        add(amountField, layoutConst);

        // Row 2: Deposit/Withdraw/Show Balance buttons
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(5, 5, 5, 5);
        layoutConst.gridx = 0; layoutConst.gridy = 2;
        add(depositButton, layoutConst);

        layoutConst.gridx = 1;
        add(withdrawButton, layoutConst);

        layoutConst.gridx = 2;
        add(showBalanceButton, layoutConst);

        // Row 3: JPanel for balance display
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(15, 10, 10, 10);
        layoutConst.gridx = 0; 
        layoutConst.gridy = 3;
        layoutConst.gridwidth = 3;
        add(balancePanel, layoutConst);

        // Quit button
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 2; 
        layoutConst.gridy = 4;
        add(quitButton, layoutConst);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton source = (JButton) event.getSource();
        double amount = ((Number) amountField.getValue()).doubleValue();
        // Initialize Balance
        if (source == initializeBalanceButton) {
            double initial = ((Number) initialBalanceField.getValue()).doubleValue();
            account = new BankAccount(initial);
            JOptionPane.showMessageDialog(this, "Initial balance set successfully!");
        }
        // Make Deposit
        else if (source == depositButton) {
            if (account == null) {
                JOptionPane.showMessageDialog(this, "Set initial balance first!");
                return;
            }
            if (amount > 0) {
                account.deposit(amount);
                JOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        }
        // Make Withdrawl
        else if (source == withdrawButton) {
            if (account == null) {
                JOptionPane.showMessageDialog(this, "Set initial balance first!");
                return;
            }
            if (amount > 0) {
                if (amount <= account.getBalance()) {
                    account.withdraw(amount);
                    JOptionPane.showMessageDialog(this, "Withdrawal successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!");
                }
            }
        }
        // Display Balance
        else if (source == showBalanceButton) {
            if (account == null) {
                JOptionPane.showMessageDialog(this, "Set initial balance first!");
                return;
            }
            // Display balance inside the JPanel
            balanceDisplayLabel.setText(
                NumberFormat.getCurrencyInstance().format(account.getBalance())
            );
        }
        // Quit (Displays balance on exit)
        else if (source == quitButton) {
            if (account != null) {
                JOptionPane.showMessageDialog(this,
                    "Remaining Balance: " +
                    NumberFormat.getCurrencyInstance().format(account.getBalance()) +
                    "\n\nThank you!");
            }
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