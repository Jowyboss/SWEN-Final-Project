import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class main_menu {

	private JFrame frame;
	
	//list to have all the orders
	static ArrayList<order> lst = new ArrayList<order>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					readData();
					main_menu window = new main_menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static void readData() {
		try {
			Scanner sc = new Scanner(new File("data.txt"));
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String v[] = data.split(",");
				lst.add(new order(v[0],Integer.parseInt(v[1]),Double.parseDouble(v[2]),v[3]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void writeData() {
		try {
		      FileWriter myWriter = new FileWriter("data.txt");
		      for(int i=0;i<lst.size();i++) {
		    	  myWriter.write(lst.get(i).getName()+","+String.valueOf(lst.get(i).getSize())+","+String.valueOf(lst.get(i).getPrice())+","+lst.get(i).getType());
		    	  if(i+1 != lst.size()) {
		    		  myWriter.write("\n");
		    	  }
		      }
		      myWriter.close();
		 }catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
	}

	//this constructor is called when the object is created
	public main_menu() {
		initialize();
		frame.setVisible(true);
	}
	
	//this method will make the GUI
	private void initialize() {
		//create the frame object
		frame = new JFrame();
		//set its position, width and height 
		frame.setBounds(300, 70, 800, 600); // x-axis, y-axis, width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this method will close the frame on pressing cross button in upper corner
		frame.getContentPane().setLayout(null); //layout manager is set to null
		
		
		//label is used to add A label message
		JLabel lblNewLabel = new JLabel("Hello, Welcome to Tricor Order List: ");
		//set bound function defines the position and size, like we did for frame above
		lblNewLabel.setBounds(301, 60, 411, 16);
		//once we are done with label creation, position and its size. then we will add this to the main frame
		frame.getContentPane().add(lblNewLabel);
		
		//Jbutton will create a button and its constructor will take in the name of button
		JButton btnNewButton = new JButton("Add Order");
		
		//this is the event handler code for this button, when we click on this button the following function will 
		//execute and we can write code we want, like for this one we close this frame(window) and open the window of familybudget
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new addOrder();
			}
		});
		//then its position and size setting
		btnNewButton.setBounds(316, 165, 173, 29);
		//then adding to frame
		frame.getContentPane().add(btnNewButton);
		
		//this is the second button in gui which will direct us to the all the orders window when we click it 
		JButton btnNewButton_1 = new JButton("All Tricor Orders");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new displayOrder();
			}
		});
		btnNewButton_1.setBounds(316, 269, 173, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		//this is the button in gui which will direct us to the all the deliveries window when we click it
		JButton btnNewButton_5 = new JButton("All Tricor Deliveries");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new displayOrder();
			}
		});
		btnNewButton_5.setBounds(316, 269, 173, 29);
		frame.getContentPane().add(btnNewButton_5);
				
		//each of the following button has a name and an action to perform when clicked, for every button we have some
		//action which is defined along that function
		
		JButton btnNewButton_2 = new JButton("Remove Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new removeOrder();
			}
		});
		btnNewButton_2.setBounds(316, 374, 173, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Order");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new updateprice();
			}
		});
		btnNewButton_3.setBounds(316, 477, 173, 29);
		frame.getContentPane().add(btnNewButton_3);
	}
}
