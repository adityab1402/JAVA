import java.io.*;
import java.lang.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{	
	int chs=0; static int ut;
    Container con= getContentPane();
	JPanel titalPan, icoPan, btnPan, pan1;
	JLabel name,pass;
	JButton login,reset,reg;
    JTextField namet = new JTextField();
    JPasswordField passt = new JPasswordField();
    JLabel titalLab, icoLab;
	public Login()
	{
		con.setLayout(null);
		
		titalPan = new JPanel();
		titalPan.setBorder(new EtchedBorder());
		
		titalLab = new JLabel("Student Attendance Management System");
		titalLab.setFont(new Font("Times New Roman",Font.BOLD,18));
		titalPan.add(titalLab);
		titalPan.setBounds(10,10,400,60);
		
		
		pan1 = new JPanel();
		pan1.setLayout(null);
		pan1.setBounds(10,70,400,250);
		pan1.setBorder(new EtchedBorder());
		
		
		name = new JLabel("LoginName");
		pass = new JLabel("Password");
		login = new JButton("Login");
		reset = new JButton("Reset");
		reg = new JButton("Register");
		
		name.setBounds(100,60,120,30);
		pan1.add(name);
		pass.setBounds(100,120,120,30);
		pan1.add(pass);
		
		namet.setBounds(180,60,100,25);
		pan1.add(namet);
		passt.setBounds(180,120,100,25);
		pan1.add(passt);
		
		login.setBounds(70,210,85,20);
		pan1.add(login);
		reset.setBounds(170,210,85,20);
		pan1.add(reset);
		reg.setBounds(270,210,85,20);
		pan1.add(reg);
		
		con.add(titalPan);
		con.add(pan1);
		login.addActionListener(this);
		reset.addActionListener(this);
		reg.addActionListener(this);
		setSize(423,370);
		setVisible(true);
		setResizable(false);
		//setDefaultClose(false);
	}
		static int temp;
	  public void actionPerformed(ActionEvent ae)
 	  {	  
 	  	  
 	  	  if(ae.getSource()==login)
	      {
		  	
		   //String nm = u_idt.getText(); 	
		   String un = namet.getText();
		   String ps = passt.getText();
		   
		   int i;
		   char ch[];
		   ch = new char[20];
		 
		   
		   boolean cntr=true;  
		   for(i=0;i<un.length();i++)
		   		ch[i] = un.charAt(i);
		   		
		   int flag=0;
		   for( int k=0;k<i;k++)
		   {
		   		for(char m=65,n=97;m<91;m++,n++)
		   		{
		   			if(ch[k]==m||ch[k]==n)
		   			flag++;
		   		}
		   			
		   }
		   
		   	   
		   if(flag!=i)
		   {
		   		JOptionPane.showMessageDialog(null,"Plaese enter valid login name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   		cntr=false;
		   		namet.setText(null);
		   	
		   }
		   if(cntr)
		   {
		   
		   		if(un.length()==0&&ps.length()!=0)
		   		{
		  			JOptionPane.showMessageDialog(null,"Enter the login name please!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		  			cntr=false;
		   		}
		  
		   }
		   
		  
		   if(cntr)
		   {
		   
		   		if(un.length()!=0&&ps.length()==0)
		   		{
		  			JOptionPane.showMessageDialog(null,"Enter the password please!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		  			cntr=false;
		   		}
		  
		   }
		   
		   
		   if(cntr)
		   {
		   
		   		if(un.length()==0||ps.length()==0)
		   		{
		  			JOptionPane.showMessageDialog(null,"Please fill the all fields!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		  			cntr=false;
		   		}
		  
		   }

		   
		   
		  if(cntr==true)
		   {	
		   		
		   		Database db = new Database();
		   		temp = db.searchUser(un,ps);
		   		//System.out.println("\ttemp =  "+temp);
		   		if (temp!=0)
		   		{
		   			
		   			setVisible(false);
			  		new Transaction();
			 		 send(); 		
			  	}
			  	else
			  	{
			  		JOptionPane.showMessageDialog(null,"InvalidUser!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
			  		chs++;
			  	}
			  	
			  	
		   		if(chs==3)
		   		{
		   			JOptionPane.showMessageDialog(null,"Sorry!!You are not Authorised User!!","Error!!Error",JOptionPane.ERROR_MESSAGE); 
		   			System.exit(0);
		   		}
		   }
	   }
	 
	   if(ae.getSource()==reset)
	   {  
		  // u_idt.setText(null);
		   namet.setText(null);
		   passt.setText(null);
	   }
	  
	  if(ae.getSource()==reg)
	   {  
		   setVisible(false);
		   new Registration();   
	   }
    }
    
    
    public static int send()
    {
    	//System.out.println("\ttemp =  "+temp);
       	return temp;
    }
    
       
    public static void main(String args[])
    {
    	
    	new Login();
        	
    }

	
}