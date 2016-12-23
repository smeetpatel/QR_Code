import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class book extends Frame implements ActionListener{
	String confirmMessage;
	Button b1=new Button("Book Ticket");
	Button b2=new Button("Cancel");
	Label head=new Label("Air India",Label.CENTER);
	//Label l1=new label("Journey Type: ",Label.LEFT);
	Label l2=new Label("From: ",Label.LEFT);
	Label l3=new Label("To: ",Label.LEFT);
	Label l4=new Label("Depart: ",Label.LEFT);
	Label l5=new Label("Arrive: ",Label.LEFT);
	//Label l6=new label("Travellers: ",Label.LEFT);
	Label l7=new Label("Cabin: ",Label.LEFT);
	Label l8=new Label("Select Flight: ",Label.LEFT);
	Label l9=new Label("Passenger Name: ",Label.LEFT);
	Label l10=new Label("Age: ",Label.LEFT);
	Label l11=new Label("Mobile No: ",Label.LEFT);
	Label l12=new Label("Email: ",Label.LEFT);
	Label l13=new Label("Sex: ",Label.LEFT);
	TextField t1=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	TextField t4=new TextField();
	Choice c1=new Choice();
	CheckboxGroup cbg=new CheckboxGroup();
	Checkbox c2=new Checkbox("Male",false,cbg);
	Checkbox c3=new Checkbox("Female",false,cbg);
	Choice from=new Choice();
	Choice to=new Choice();
	Choice cabin=new Choice();
	Choice flight=new Choice();
	public book()
	{
		addWindowListener(new myWindowAdapter());
 		setBackground(Color.white);
		setForeground(Color.black);
		//setup the page
		add(head);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		//add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(c2);
		add(c3);
		add(from);
		add(to);
		add(cabin);
		add(flight);
		add(b1);
		b1.addActionListener(this);
		add(b1);
		add(b2);
		b2.addActionListener(this);
		add(b2);
		
		from.add("Mumbai");
		from.add("Vadodara");
		from.add("Ahmedabad");
		from.add("Delhi");
		from.add("Banglore");
		
		to.add("Mumbai");
		to.add("Vadodara");
		to.add("Ahmedabad");
		to.add("Delhi");
		to.add("Banglore");
		
		cabin.add("First Class");
		cabin.add("Economy Class");
		cabin.add("Premium Economy Class");
		cabin.add("Buisness Class");
		
		flight.add("AI 4125");
		flight.add("AI 4175");
		flight.add("AI 4621");
		
		l2.setBounds(25,65,90,20);
		l3.setBounds(25,90,90,20);
		l4.setBounds(25,115,90,20);
		l5.setBounds(25,140,90,20);
		//l6.setBounds(25,165,90,20);
		l7.setBounds(25,165,90,20);
		l8.setBounds(25,190,90,20);
		l9.setBounds(25,215,140,20);
		l10.setBounds(25,240,90,20);
		l11.setBounds(25,265,90,20);
		l12.setBounds(25,290,90,20);
		l13.setBounds(25,315,90,20);
		head.setBounds(10,40,280,20);
		from.setBounds(120,65,100,20);
		to.setBounds(120,90,100,20);
		cabin.setBounds(120,165,100,20);
		flight.setBounds(120,190,100,20);
		t1.setBounds(170,215,170,20);
		t2.setBounds(120,240,40,20);
		t3.setBounds(120,265,100,20);
		t4.setBounds(120,290,150,20);
		c2.setBounds(120,315,50,20);
		c3.setBounds(170,315,60,20);
		b1.setBounds(80,365,90,20);
		b2.setBounds(150,400,90,20);
	}
	public void paint(Graphics g)
	{
		g.drawString(confirmMessage,25,365);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Book Ticket"))
 		{
 			confirmMessage="Ticket Booked";
   			setForeground(Color.blue);
   		}
   		else if(ae.getActionCommand().equals("Cancel"))
   		{
   			confirmMessage="Cancelled";
   			setForeground(Color.red);
   		}
	}
	
	public static void main(String g[])
	{
		book boo=new book();
	 	boo.setSize(new Dimension(500,500));
 		boo.setTitle("Ticket Booking Portal");
		boo.setVisible(true);
	}
}

class myWindowAdapter extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	 {
	  System.exit(0);
	 }
}
