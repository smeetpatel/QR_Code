import javax.swing.*;  
import java.awt.event.*; 
import java.awt.*;

class book extends JFrame implements ActionListener{  
String confirmMessage;
String NAME,AGE,DEPART,ARRIVE,FLIGHT,GENDER;
static String qrCodeData;
String airports[] ={"Mumbai","Vadodara","Ahmedabad","Delhi","Banglore"};
String cab[] = {"First Class","Economy Class"," Premium Economy Class","Buisness Class"};
String Flight[] = {"AI 4125","AI 4175","AI 4200"};
JButton bookTicket = new JButton("Book Ticket");
JButton cancelBooking = new JButton("Cancel");  
JLabel head = new JLabel("Air India",JLabel.CENTER);
JLabel from = new JLabel("From",JLabel.LEFT);
JLabel to = new JLabel("To",JLabel.LEFT);
JLabel depart = new JLabel("Depart",JLabel.LEFT);
JLabel arrive = new JLabel("Arrive",JLabel.LEFT);
JLabel cabin = new JLabel("Cabin",JLabel.LEFT);
JLabel selectFlight = new JLabel("Select Flight",JLabel.LEFT);
JLabel passengerName = new JLabel("Passenger Name",JLabel.LEFT);
JLabel age = new JLabel("Age",JLabel.LEFT);
JLabel mobileNumber = new JLabel("Mobile Number",JLabel.LEFT);
JLabel email = new JLabel("Email",JLabel.LEFT);
JLabel sex = new JLabel("Sex",JLabel.LEFT);

JRadioButton genderChoice1 = new JRadioButton("Male");
JRadioButton genderChoice2 = new JRadioButton("Female");

JComboBox<String> departAirport = new JComboBox<String>(airports);
JComboBox<String> arriveAirport = new JComboBox<String>(airports);
JComboBox<String> Cabin = new JComboBox<String>(cab);
JComboBox<String> flight = new JComboBox<String>(Flight);

JTextField pName = new JTextField();
JTextField pAge = new JTextField();
JTextField pMob = new JTextField();
JTextField pEmail = new JTextField();
JTextField pDepart = new JTextField();
JTextField pArrive = new JTextField();


book(){ 
	setTitle("Ticket Booking Portal");
	setSize(800,800);  
	setLayout(null);  
	setVisible(true);
  
	from.setBounds(25,65,90,20);
	to.setBounds(25,90,90,20);
	depart.setBounds(25,115,90,20);
	arrive.setBounds(25,140,90,20);
	cabin.setBounds(25,165,90,20);
	selectFlight.setBounds(25,190,90,20);
	passengerName.setBounds(25,215,140,20);
	age.setBounds(25,240,90,20);
	mobileNumber.setBounds(25,265,150,20);
	email.setBounds(25,290,90,20);
	sex.setBounds(25,315,90,20);
	
	head.setBounds(100,30,280,20);
	
	departAirport.setBounds(170,65,100,20);
	arriveAirport.setBounds(170,90,100,20);
	Cabin.setBounds(170,165,200,20);
	flight.setBounds(170,190,100,20);
	
	pName.setBounds(170,215,170,20);
	pAge.setBounds(170,240,40,20);
	pMob.setBounds(170,265,100,20);
	pEmail.setBounds(170,290,150,20);
	pDepart.setBounds(170,115,60,20);
	pArrive.setBounds(170,140,60,20);
	
	ButtonGroup bg=new ButtonGroup();  
	bg.add(genderChoice1);
	bg.add(genderChoice2);
	genderChoice1.setBounds(170,315,90,20);
	genderChoice2.setBounds(260,315,120,20);
	
	bookTicket.setBounds(170,365,140,20);
	cancelBooking.setBounds(330,365,90,20);
	 
	bookTicket.addActionListener(this);
	cancelBooking.addActionListener(this);  
  	
  	add(from);	
	add(to);
	add(depart);
	add(arrive);
	add(cabin);
	add(selectFlight);
	add(passengerName);
	add(age);
	add(mobileNumber);
	add(email);
	add(sex);
	add(head);
	add(departAirport);
	add(arriveAirport);
	add(Cabin);
	add(flight);
	add(pName);
	add(pAge);
	add(pMob);
	add(pEmail);
	add(pDepart);
	add(pArrive);
	add(genderChoice1);
	add(genderChoice2);
	add(cancelBooking);
	add(bookTicket);
}  

public void actionPerformed(ActionEvent e)
{  
	if(e.getActionCommand().equals("Book Ticket"))
	{
		confirmMessage="Ticket Booked";
		JOptionPane.showMessageDialog(this,confirmMessage);
   		//setForeground(Color.blue);
   		NAME = pName.getText();
   		AGE = pAge.getText();
   		DEPART = pDepart.getText();
   		ARRIVE = pArrive.getText();
   		FLIGHT = (String)flight.getSelectedItem();
   		if(genderChoice1.isSelected())
   			GENDER="Male";
   		else if(genderChoice2.isSelected())
   			GENDER="Female";
   		book.qrCodeData=NAME+AGE+GENDER+DEPART+ARRIVE+FLIGHT;
   		try{
			QRCAES.initiateQR(book.qrCodeData);
		}catch(Exception ex)
		{
			System.out.println("Exception Issued");
		}
	}
	else if(e.getActionCommand().equals("Cancel"))
	{
		confirmMessage="Cancelled";
		JOptionPane.showMessageDialog(this,confirmMessage);
	}
}  
public static void main(String args[]) {  
		new book();  
	}

}  
