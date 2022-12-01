import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class displayOrder {

	private JFrame frame;

	public displayOrder() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(119, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(260, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(404, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		// this variable is for vertical positioning of labels 
		int y = 123+22; 
		
		
		//loop through the list and display it
		for(int i=0;i<main_menu.lst.size();i++) {
			order g = main_menu.lst.get(i);
			lblNewLabel_1 = new JLabel(g.getName());
			lblNewLabel_1.setBounds(119, y, 101, 16);
			frame.getContentPane().add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel(String.valueOf(g.getPrice())+" Jmd");
			lblNewLabel_2.setBounds(260, y, 117, 16);
			frame.getContentPane().add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel(g.getType());
			lblNewLabel_3.setBounds(404, y, 251, 16);
			frame.getContentPane().add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel(String.valueOf(g.getSize()));
			lblNewLabel_4.setBounds(570, y, 251, 16);
			frame.getContentPane().add(lblNewLabel_4);
			
			y+=22;
		}
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new main_menu();
			}
		});
		btnNewButton_3.setBounds(349, 530, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Sort By ->");
		lblNewLabel_5.setBounds(551, 69, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Sort");
		comboBox.addItem("Price");
		comboBox.addItem("Type");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(((String) comboBox.getSelectedItem()).compareTo("Type") == 0) {
					main_menu.lst.sort((a, b)
		                      -> a.getType().compareTo(
		                    		  b.getType()));
					frame.dispose();
					new displayOrder();
				}
				if(((String) comboBox.getSelectedItem()).compareTo("Price") == 0) {
					main_menu.lst.sort((a, b)
		                      -> (int)(b.getPrice() - a.getPrice()));
					frame.dispose();
					new displayOrder();
				}
			}
		});
		comboBox.setBounds(614, 64, 123, 29);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("All Tricor Orders");
		lblNewLabel_6.setBounds(333, 41, 206, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Size");
		lblNewLabel_7.setBounds(570, 123, 61, 16);
		frame.getContentPane().add(lblNewLabel_7);
	}
}
