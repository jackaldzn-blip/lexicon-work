package se.lexicon;

import java.awt.*;
import java.util.Locale;
import javax.swing.*;

// Challenge 5: GUI uses the same Order class as the console app.
public class CafeGui extends JFrame {
    JTextField name = new JTextField();
    JCheckBox member = new JCheckBox("Loyalty member");
    JSpinner quantity = new JSpinner(new SpinnerNumberModel(1, 1, CafeApp.MAX_QUANTITY, 1));
    JTextArea receipt = new JTextArea();
    JLabel summary = new JLabel("Customers: 0 | Revenue: 0.00 SEK");
    Order order;
    int customers = 0;
    double revenue = 0;

    CafeGui() {
        super("Lexicon Cafe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Show all café products with their prices before an order is placed.
        DefaultListModel<String> menu = new DefaultListModel<>();
        for (int i = 0; i < CafeApp.ITEMS.length; i++) {
            menu.addElement(String.format(Locale.US, "%d. %s - %.2f SEK",
                    i + 1, CafeApp.ITEMS[i], CafeApp.PRICES[i]));
        }
        JList<String> products = new JList<>(menu);
        products.setSelectedIndex(0);
        products.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // The order panel keeps its width; the menu takes up the middle area.
        JPanel left = new JPanel(new BorderLayout(8, 8));
        left.setPreferredSize(new Dimension(290, 0));
        JPanel details = new JPanel(new GridLayout(0, 1, 4, 4));
        details.add(new JLabel("Customer name:"));
        details.add(name);
        details.add(member);
        details.add(new JLabel("Menu (select a product):"));
        left.add(details, BorderLayout.NORTH);
        left.add(new JScrollPane(products), BorderLayout.CENTER);

        JPanel actions = new JPanel(new GridLayout(0, 1, 5, 5));
        actions.add(new JLabel("Quantity:"));
        actions.add(quantity);
        JButton add = new JButton("Add item");
        JButton finish = new JButton("Finish order");
        JButton closeDay = new JButton("End of day");
        actions.add(add);
        actions.add(finish);
        actions.add(closeDay);
        left.add(actions, BorderLayout.SOUTH);

        receipt.setEditable(false);
        receipt.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        receipt.setText("Select a product and click Add item.\n");
        JScrollPane receiptPane = new JScrollPane(receipt);
        receiptPane.setBorder(BorderFactory.createTitledBorder("Receipt"));

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        content.add(left, BorderLayout.WEST);
        content.add(receiptPane, BorderLayout.CENTER);
        content.add(summary, BorderLayout.SOUTH);
        setContentPane(content);

        add.addActionListener(e -> {
            if (name.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Enter the customer's name.");
                return;
            }
            if (order == null) order = new Order(name.getText().trim(), member.isSelected());
            int selected = products.getSelectedIndex();
            if (selected < 0) return;
            order.addItem(CafeApp.ITEMS[selected], CafeApp.PRICES[selected], (int) quantity.getValue());
            receipt.setText(order.receipt());
            name.setEnabled(false);
            member.setEnabled(false);
        });

        finish.addActionListener(e -> {
            if (order == null || order.items.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Add a product first.");
                return;
            }
            receipt.setText(order.receipt());
            customers++;
            revenue += order.total();
            summary.setText(String.format(Locale.US, "Customers: %d | Revenue: %.2f SEK", customers, revenue));
            order = null;
            name.setText("");
            member.setSelected(false);
            name.setEnabled(true);
            member.setEnabled(true);
            quantity.setValue(1);
        });

        closeDay.addActionListener(e -> {
            if (order != null) {
                JOptionPane.showMessageDialog(this, "Finish the current order first.");
                return;
            }
            JOptionPane.showMessageDialog(this, summary.getText(), "End of day", JOptionPane.INFORMATION_MESSAGE);
        });

        setSize(800, 540);
        setMinimumSize(new Dimension(650, 450));
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CafeGui().setVisible(true));
    }
}
