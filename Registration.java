
import java.io.*;
import java.lang.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class Registration extends JFrame implements ActionListener,ItemListener 
{
	Container con = getContentPane();
	//JLabel uid = new JLabel("UserID");
    JLabel uname = new JLabel("Loginname");
    JLabel pass = new JLabel("Password");
    JLabel cpass = new JLabel("Confirm Password");
    JLabel sub = new JLabel("Subject");
    JLabel fname = new JLabel("First Name");
	JLabel lname = new JLabel("Last Name");
		
    JPanel titalPan, icoPan, btnPan, pan1;
    JTextField uidt,unamet,fnamet,lnamet;
    JPasswordField passt,cpasst; 
	JLabel titalLab, icoLab;
	JButton subm,reset,cancel;
	JComboBox subt;
	
	/*public void send(int idd)
	{
		int no = idd;
		System.out.println(""+no);
	}*/
    	
	public Registration()
	{
		con.setLayout(null);
		
		//uidt = new JTextField();
		fnamet = new JTextField();
		lnamet = new JTextField();
		unamet = new JTextField();
		passt = new JPasswordField();
		cpasst = new JPasswordField();
		subt = new JComboBox();
		subt.addItem(" ");
		subt.addItem("fymath");
		subt.addItem("fystat");
		subt.addItem("fycomp");
		subt.addItem("fyelect");
		subt.addItem("symath");
		subt.addItem("sycomp");
		subt.addItem("syeng");
		subt.addItem("syelect");
		subt.addItem("tytcs");
		subt.addItem("tysys");
		subt.addItem("tynet");
		subt.addItem("tydb/php");
		subt.addItem("tyjava");
		subt.addItem("tysoft");
				
		subm = new JButton("Submit");
		reset = new JButton("Reset");
		cancel = new JButton("Cancel");
		
		titalPan = new JPanel();
		titalPan.setBorder(new EtchedBorder());
		
		titalLab = new JLabel("Student Attendance Management System");
		titalLab.setFont(new Font("Times New Roman",Font.BOLD,18));
		titalPan.add(titalLab);
		titalPan.setBounds(10,10,400,60);
		
		
		pan1 = new JPanel();
		pan1.setLayout(null);
		pan1.setBounds(10,70,400,380);
		pan1.setBorder(new EtchedBorder());
		
		JLabel msg = new JLabel("Please fill the details correctly.....");
		msg.setFont(new Font("Book Antiqua",Font.BOLD,14));
		pan1.add(msg);
		msg.setBounds(90,0,350,40);
		
		
		//uid.setBounds(90,40,120,30);
		//pan1.add(uid);
		//uidt.setBounds(210,40,100,25);
		//pan1.add(uidt);
		
		
		fname.setBounds(90,80,120,30);
		pan1.add(fname);
		fnamet.setBounds(210,80,100,25);
		pan1.add(fnamet);
		
		lname.setBounds(90,120,120,30);
		pan1.add(lname);
		lnamet.setBounds(210,120,100,25);
		pan1.add(lnamet);
		
		uname.setBounds(90,160,120,30);
		pan1.add(uname);
		unamet.setBounds(210,160,100,25);
		pan1.add(unamet);
		
		pass.setBounds(90,200,120,30);
		pan1.add(pass);
		passt.setBounds(210,200,100,25);
		pan1.add(passt);
		
		cpass.setBounds(90,240,120,30);
		pan1.add(cpass);
		cpasst.setBounds(210,240,100,25);
		pan1.add(cpasst);
		
		sub.setBounds(90,280,120,30);
		pan1.add(sub);
		subt.setBounds(210,280,100,25);
		pan1.add(subt);
		
		subm.setBounds(70,340,75,20);
		pan1.add(subm);
		reset.setBounds(170,340,75,20);
		pan1.add(reset);
		cancel.setBounds(270,340,75,20);
		pan1.add(cancel);
		
		con.add(titalPan);
		con.add(pan1);
		subm.addActionListener(this);
		reset.addActionListener(this);
		cancel.addActionListener(this);
		subt.addItemListener(this);
		
		setSize(423,490);
		setVisible(true);
		setResizable(false);
		
	
	}
	
	static String ssub;		    
		
	public void actionPerformed(ActionEvent ae)
	{
		
	    if(ae.getSource()==subm)
		   {  
		   
		   	  	
		   	 // System.out.println("^^^^^ "+ssub);
			//  String num    = uidt.getText();
			  String fuser  = fnamet.getText();
			  String luser  = lnamet.getText();		  
			  String suser  = unamet.getText();
			  String spass  = passt.getText();
			  String scpass = cpasst.getText();
			  
			  boolean cntr=true;
	  		  
	  		  String ln1  = "fymath";
	  		  String ln2  = "fystat";
	  		  String ln3  = "fycomp";
	  		  String ln4  = "fyelect";
	  		  String ln5  = "symath";
	  		  String ln6  = "sycomp";
	  		  String ln7  = "syeng";
	  		  String ln8  = "syelect";
	  		  String ln9  = "tytcs";
	  		  String ln10 = "tysys";
	  		  String ln11 = "tynet";
	  		  String ln12 = "tydb/php";
	  		  String ln13 = "tyjava";
	  		  String ln14 = "tysoft";
	  		  
	  		 	  			  		
	  		int set=0,uid=0;
	  		
	  		if(ssub.equals(ln1))
	  		{
	  			set=1;
	  			uid=1;
	  		}
	  		else if(ssub.equals(ln2))
	  		{
	  			set=1;
	  			uid=2;
	  		}
	  		else if(ssub.equals(ln3))
	  		{
	  			set=1;
	  			uid=3;
	  		}
	  		else if(ssub.equals(ln4))
	  		{
	  			set=1;
	  			uid=4;
	  		}
	  		else if(ssub.equals(ln5))
	  		{
	  			set=1;
	  			uid=5;
	  		}
	  		else if(ssub.equals(ln6))
	  		{
	  			set=1;
	  			uid=6;
	  		}
	  		else if(ssub.equals(ln7))
	  		{
	  			set=1;
	  			uid=7;
	  		}
	  		else if(ssub.equals(ln8))
	  		{
	  			set=1;
	  			uid=8;
	  		}
	  		else if(ssub.equals(ln9))
	  		{
	  			set=1;
	  			uid=9;
	  		}
	  		else if(ssub.equals(ln10))
	  		{
	  			set=1;
	  			uid=10;
	  		}
	  		else if(ssub.equals(ln11))
	  		{
	  			set=1;
	  			uid=11;
	  		}
	  		else if(ssub.equals(ln12))
	  		{
	  			set=1;
	  			uid=12;
	  		}
	  		else if(ssub.equals(ln13))
	  		{
	  			set=1;
	  			uid=13;
	  		}
	  		else if(ssub.equals(ln14))
	  		{
	  			set=1;
	  			uid=14;
	  		}
	  		else
	  		{
	  			set=0;
	  		}
	  		

			  
			  char ch[];
		   	  ch = new char[20];
		   	  int i;
		   	  int flag=0;
		      /*for(i=0;i<num.length();i++)
		   	  ch[i] = num.charAt(i);
		   	  	//System.out.println(ch[i]);
		   		
		      
		      for(int k=0;k<i;k++)
		      {
		   	    for(char m=33;m<48;m++)
		   		{
		   			//System.out.println(" "+ch[k]+" = "+m);
		   			if(ch[k]==m)
		   			flag--;
		   		}
		   		for(char m=58;m<127;m++)
		   		{
		   			//System.out.println(" "+ch[k]+" = "+m);
		   			if(ch[k]==m)
		   			flag--;
		   		}
		   		
		   		
			  }
		   	  
		   	  if(cntr)
		   	  {
			   	  if(flag<0)
			      {
			   		JOptionPane.showMessageDialog(null,"Plaese enter an integers only in UserID field!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
			   		uidt.setText(null);
			   	    cntr=false; 
			   	    set=0;
			      }
			      
			  }*/
		      
		      
		      
		      for(i=0;i<fuser.length();i++)
		   	  ch[i] = fuser.charAt(i);
		   		
		      flag=0;
		      for(int k=0;k<i;k++)
		      {
		   	    for(char m=65,n=97;m<91;m++,n++)
		   		{
		   			if(ch[k]==m||ch[k]==n)
		   			flag++;
		   		}
		   			
		      }
			  
			  
		   	if(cntr)
		   	 {
		   	  if(flag!=i)
		      {
		   		JOptionPane.showMessageDialog(null,"Plaese enter valid first name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   		fnamet.setText(null);
		   	    cntr=false; 
		   	    set=0;
		      }
		      
			 } 
			  
			  
		      		   
		      for(i=0;i<luser.length();i++)
		   	  ch[i] = luser.charAt(i);
		   		
		      flag=0;
		      for(int k=0;k<i;k++)
		      {
		   	    for(char m=65,n=97;m<91;m++,n++)
		   		{
		   			if(ch[k]==m||ch[k]==n)
		   			flag++;
		   		}
		   			
		      }
			  
			  
		      if(cntr)
		      {
		      
		      	if(flag!=i)
		      	{
		   			JOptionPane.showMessageDialog(null,"Plaese enter valid last name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   			lnamet.setText(null);
		   			cntr=false;
		   			set=0;
		   	   	}
		   	   	
		   	  }
					 
				for(i=0;i<suser.length();i++)
		   	  ch[i] = suser.charAt(i);
		   		
		      flag=0;
		      for(int k=0;k<i;k++)
		      {
		   	    for(char m=65,n=97;m<91;m++,n++)
		   		{
		   			if(ch[k]==m||ch[k]==n)
		   			flag++;
		   		}
		   			
		      }
			  
			  
		      if(cntr)
		      {
		      
		      	if(flag!=i)
		      	{
		   			JOptionPane.showMessageDialog(null,"Plaese enter valid login name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   			unamet.setText(null);
		   			cntr=false;
		   			set=0;
		   	   	}
		   	   	
		   	  }
		   	  
		   	  		   	  
			  if(cntr)
			  {
			  
			  	if(fuser.length()==0||luser.length()==0||suser.length()==0||spass.length()==0||scpass.length()==0) 
			  	{
			    	  JOptionPane.showMessageDialog(null,"Please fill the all fields!!","Error!Error!!",JOptionPane.ERROR_MESSAGE);  	
			    	  cntr=false;
			    	  set=0;
			  	}
			  	
			  }		  
			  
			  
			  for(i=0;i<spass.length();i++)
		   	   	  ch[i] = spass.charAt(i);
		   	 
		   	  	
		   	  char ch1[];
		   	  ch1 = new char[20];
		   	  
		   	  int j;
		   	  
		   	  for(j=0;j<scpass.length();j++)
		   	   	ch1[j] = scpass.charAt(j);
		   	 		   	  
		   	  boolean chk=true;
		   	  
		   	  if(i!=j)
		   	  {
		   	   	chk=false;flag=1;
		   	  }	
		      
		      
		      if(chk==true)
		      {
		      	flag=0;
		        for(int k=0;k<i;k++)
		         {
		   	    
		   			if(ch[k]!=ch1[k])
		   			flag=1;
		   	   			
		         }
		      }   	
		     
		         if(cntr)
		         {
		           if(flag==1)
		      	   {
		      	 	JOptionPane.showMessageDialog(null,"Password not confirmed, Retype please.!!","Error!Error!!",JOptionPane.ERROR_MESSAGE);  	
			    	cntr=false;
			    	cpasst.setText(null);
			    	set=0;
		           }  	
		      	 			  
		         }
		         
		    if(set==1)
	  		{
	  			
		  		//int uid1 = uid;
		  		
			  	Database db = new Database();
			  	if(db.chkUser(uid,suser,ssub)==1)
			  	{
			  		
			  		int uid1 = uid;
			  		db.addUser(uid1,fuser,luser,suser,spass,ssub);
			  		JOptionPane.showMessageDialog(null,"Registration Successfull!!!","Congratulations!!!",JOptionPane.INFORMATION_MESSAGE);
		  			setVisible(false);
		  			new Login();
		  		}
		  		else
		  		{
		  			cntr=false;
		  		}
		  	}
	  	   
	  	 }
	  	 
	  	 if(ae.getSource()==reset)
	  	 {
	  	 	 uidt.setText(null);
			 fnamet.setText(null);
			 lnamet.setText(null);		  
			 unamet.setText(null);
			 passt.setText(null);
			 cpasst.setText(null);
			 subt.setSelectedIndex(0);
	  	 }
		 
		 if(ae.getSource()==cancel)
		 {  
			   setVisible(false);
			   new SAMS();
		 }
	}
	
	public void itemStateChanged(ItemEvent e)
	 {  
	  	
	  	if(e.getStateChange()==ItemEvent.SELECTED)
	  	{	
	  		ssub = (String)e.getItem();
	  		
	    }
	}
		
	public static void main(String args[])
	{
		new Registration();
	}
}
