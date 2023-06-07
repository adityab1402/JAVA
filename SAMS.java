
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class SAMS extends JFrame implements ActionListener
{
	JFrame jf;
	
	Container con;
	JPanel titalPan,btnPan, pan1;
	JLabel titalLab;
	JButton login, regi,addb;
	
	public SAMS() 
	{
		jf = new JFrame("SAMS");
		
		con = jf.getContentPane();
		con.setLayout(null);
		
		titalPan = new JPanel();
		titalPan.setBorder(new EtchedBorder());
		
		titalLab = new JLabel("Student Attendance Management System");
		titalLab.setFont(new Font("Times New Roman",Font.BOLD,18));
		//titalLab.setBounds(0,0,500,10);
		titalPan.add(titalLab);
		titalPan.setBounds(10,10,400,60);
		
		pan1 = new JPanel();
		pan1.setLayout(new GridLayout(1,2));
		pan1.setBounds(10,70,400,200);
		
		
		
		btnPan = new JPanel();
		btnPan.setLayout(null);
		btnPan.setBounds(130,50,120,30);
		login = new JButton("Login");
		regi = new JButton("Registration");
		addb = new JButton("AddStudent");
		login.setBounds(140,20,120,30);
		regi.setBounds(140,80,120,30);
		addb.setBounds(140,140,120,30);
		btnPan.setBorder(new EtchedBorder());
		pan1.add(btnPan);
		
		btnPan.add(login);
		btnPan.add(regi);
		btnPan.add(addb);
		
		con.add(titalPan);
		con.add(pan1);
		//con.add(login);
		//con.add(regi);		
		login.addActionListener(this);
		regi.addActionListener(this);
		addb.addActionListener(this);
		jf.setSize(423,315);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
    public void actionPerformed(ActionEvent ae)
   {
   	      if(ae.getSource()==login)
   	      {
   	           //System.out.println("In login");
   	           jf.setVisible(false);
   	            new Login();   
   	      }
   	      if(ae.getSource()==regi)
   	      {
   	    	  jf.setVisible(false);
   	    	  new Registration();
   	      }
   	      if(ae.getSource()==addb)
   	      {
   	    	  jf.setVisible(false);
   	    	  new AddStudent();
   	      }
   }
	public static void main(String args[]) 
	{
		System.out.println("Starting SAMS...");
		new SAMS();
	}
}
