import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addOrder {

	private JFrame frame;
	private JTextField type;
	private JTextField name;
	private JTextField size;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addOrder window = new addOrder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addOrder() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		type = new JTextField();
		type.setBounds(277, 135, 245, 26);
		frame.getContentPane().add(type);
		type.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(277, 107, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(277, 184, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(277, 212, 245, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setBounds(277, 260, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		size = new JTextField();
		size.setBounds(277, 295, 245, 26);
		frame.getContentPane().add(size);
		size.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(277, 345, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		price = new JTextField();
		price.setBounds(277, 373, 245, 26);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Add new Order");
		lblNewLabel_4.setBounds(340, 51, 110, 16);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(356, 424, 120, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_5.setText("");
				order v = new order(name.getText(),Integer.parseInt(size.getText()),Double.parseDouble(price.getText()),type.getText());
				main_menu.lst.add(v);
				lblNewLabel_5.setText("Order Added");
				name.setText("");
				size.setText("");
				price.setText("");
				type.setText("");
				main_menu.writeData();
			}
		});
		btnNewButton.setBounds(340, 464, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new main_menu();
			}
		});
		btnNewButton_1.setBounds(340, 505, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
