import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class book extends Frame implements ActionListener{
	String message;
	Button b1=new Button("Book Ticket");
	Button b2=new Button("Cancel");
	Label head=new Label("Air India",Label.CENTER);
	//Label l1=new label("Journey Type: ",Label.LEFT);
	Label l2=new label("From: ",Label.LEFT);
	Label l3=new label("To: ",Label.LEFT);
	Label l4=new label("Depart: ",Label.LEFT);
	Label l5=new label("Return: ",Label.LEFT);
	//Label l6=new label("Travellers: ",Label.LEFT);
	Label l7=new label("Cabin: ",Label.LEFT);
	Label l8=new label("Select Flight: ",Label.LEFT);
	Label l9=new label("Passenger Name: ",Label.LEFT);
	Label l10=new label("Age: ",Label.LEFT);
	Label l11=new label("Mobile No: ",Label.LEFT);
	Label l12=new label("Email: ",Label.LEFT);
	Label l13=new label("Sex: ",Label.LEFT);
	TextField t1=new TextField();
	Choice c1=new Choice();
	CheckboxGroup cbg=new CheckboxGroup();
	Checkbox c1=new Checkbox("Male",false,cbg);
	Checkbox c2=new Checkbox("Female",false,cbg);
	Choice from=new Choice();
	Choice to=new Choice();
	Choice cabin=new Choice();
	Choice flight=new Choice();
	public book()
	{
		addWindowListener(new myWindowAdapter());
 		setBackground(Color.white);
		setForeground(Color.black);
	}
}
