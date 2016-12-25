
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;



class QRCAES {
	public QRCAES(String data1) throws WriterException, IOException, NotFoundException,Exception {
		String qrCodeData = data1;
		System.out.println(qrCodeData);
		try{
			SecretKey key=AESEncryption.getSecretEncryptionKey();
			byte[] cipherText=AESEncryption.encryptText(qrCodeData,key);
			String filePath = "qrcode.jpg";
			String charset = "UTF-8";
		
			Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
			createQRCode(cipherText, filePath, charset, hintMap, 200, 200);
			
			System.out.println("QR Code created successfully, Thanks!");	
			String decryptedText = AESEncryption.decryptText(cipherText,key);
			System.out.println("Encrypted Text (Binary Form):"+cipherText);
       			System.out.println("Descrypted Text:"+decryptedText);
       		
		}catch(Exception e)
		{
			System.out.println("Exception Issued");
		}
	}

	public static void createQRCode(byte[] cipherText, String filePath, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hintMap, int qrCodeheight, int qrCodewidth) throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode( new String(cipherText, charset), BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	}
}

public class book extends Frame implements ActionListener, ItemListener{
	String confirmMessage,name,age,mobile,email,sex,f_code,arrtime,depttime,to1,from1,cabin1;
	Button b2=new Button("Cancel");
	Button b1=new Button("Book Ticket");
	
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
	TextField t6=new TextField();
	TextField t5=new TextField();
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
		setLayout(null);
		addWindowListener(new myWindowAdapter());
 		setBackground(Color.white);
		setForeground(Color.black);
		//setup the page
		add(head);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
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
		add(t5);
		add(t6);
		add(c1);
		add(c2);
		add(c3);
		add(from);
		from.addItemListener(this);
		add(to);
		to.addItemListener(this);
		add(cabin);
		cabin.addItemListener(this);
		add(flight);
		flight.addItemListener(this);
		
		
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
		head.setBounds(100,30,280,20);
		from.setBounds(170,65,100,20);
		to.setBounds(170,90,100,20);
		cabin.setBounds(170,165,100,20);
		flight.setBounds(170,190,100,20);
		t1.setBounds(170,215,170,20);
		t2.setBounds(170,240,40,20);
		t3.setBounds(170,265,100,20);
		t4.setBounds(170,290,150,20);
		t5.setBounds(170,115,60,20);
		t6.setBounds(170,145,60,20);
		c2.setBounds(170,315,50,20);
		c3.setBounds(220,315,60,20);
		b2.setBounds(180,365,90,20);
		b1.setBounds(80,365,90,20);
		add(b1);
		b1.addActionListener(this);
		
		add(b2);
		b2.addActionListener(this);
	}
	public void paint(Graphics g)
	{
		g.drawString(confirmMessage,25,365);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		name = t1.getText();
		age = t2.getText();
		mobile = t3.getText();
		email = t4.getText();
		arrtime= t6.getText();
		depttime=t5.getText();
		from1 = from.getSelectedItem();
		to1 = to.getSelectedItem();
		cabin1 = cabin.getSelectedItem();
		f_code = flight.getSelectedItem();
		
		if(ae.getActionCommand().equals("Book Ticket"))
 		{
 			confirmMessage="Ticket Booked";
   			setForeground(Color.blue);
   			
			if(cbg.getSelectedCheckbox().equals(c2))
			sex="Male";
			else	
			sex="Female";   			
   			
   			String data = name+age+sex+f_code+arrtime+depttime;
   			
   		
   			
   			try{
   				QRCAES ob1 = new QRCAES(data);
   				}
   				catch(Exception e){
   					System.out.println("here");
   				}
   		
   		
   		
   		}
   		else if(ae.getActionCommand().equals("Cancel"))
   		{
   			confirmMessage="Cancelled";
   			setForeground(Color.red);
   		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		
		if(cbg.getSelectedCheckbox().equals(c2))
			sex="Male";
		else	
			sex="Female";
			
		
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



