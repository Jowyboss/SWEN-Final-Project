/*Tristan Eunick, 620148693 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class removeOrder {

	private JFrame frame;
	private JTextField name;
	private JTextField size;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeOrder window = new removeOrder();
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
	public removeOrder() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(277, 126, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(277, 154, 245, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setBounds(277, 204, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		size = new JTextField();
		size.setBounds(277, 235, 245, 26);
		frame.getContentPane().add(size);
		size.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Remove Order");
		lblNewLabel_4.setBounds(347, 51, 110, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(352, 288, 120, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("");
				boolean found = false;
				for(int i=0;i<main_menu.lst.size();i++) {
					if(main_menu.lst.get(i).getSize() == Integer.parseInt(size.getText()) &&
							main_menu.lst.get(i).getName().compareTo(name.getText()) == 0) {
						main_menu.lst.remove(i);
						lblNewLabel.setText("Order Removed");
						found = true;
						main_menu.writeData();
						break;
					}
				}if(!found){
					lblNewLabel.setText("Order not found");
				}size.setText("");
				name.setText("");	
			}
		});
		btnNewButton.setBounds(340, 331, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new main_menu();
			}
		});
		btnNewButton_1.setBounds(340, 374, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
