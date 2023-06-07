import java.io.*;
import java.lang.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class AddStudent extends JFrame implements ActionListener,ItemListener 
{
	//static int v=0;
	Container con = getContentPane();
	JLabel sno = new JLabel("Roll No.");
    JLabel sname = new JLabel("Student Name");
    JLabel clas = new JLabel("Class");
    	
    JPanel titalPan,btnPan, pan1;
    JTextField snot,snamet;
    JLabel titalLab;
	JButton reset,cancel;
	JComboBox clast; 
	/*public void send(int idd)
	{
		int no = idd;
		System.out.println(""+no);
	}*/
    
	public AddStudent()
	{
		con.setLayout(null);
		snamet = new JTextField();
		clast = new JComboBox();
		clast.addItem(" ");
		clast.addItem("fybcs");
		clast.addItem("sybcs");
		clast.addItem("tybcs");
		
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
		pan1.setBounds(10,70,400,240);
		pan1.setBorder(new EtchedBorder());
		
		JLabel msg = new JLabel("Please fill the details correctly.....");
		msg.setFont(new Font("Book Antiqua",Font.BOLD,14));
		pan1.add(msg);
		msg.setBounds(90,0,350,40);
		
		
		sname.setBounds(90,80,120,30);
		pan1.add(sname);
		snamet.setBounds(210,80,100,25);
		pan1.add(snamet);
		
		clas.setBounds(90,120,120,30);
		pan1.add(clas);
		clast.setBounds(210,120,100,25);
		pan1.add(clast);
		
		reset.setBounds(110,190,75,20);
		pan1.add(reset);
		cancel.setBounds(210,190,75,20);
		pan1.add(cancel);
		
		con.add(titalPan);
		con.add(pan1);
		reset.addActionListener(this);
		cancel.addActionListener(this);
		clast.addItemListener(this);
		setSize(423,350);
		setVisible(true);
		setResizable(false);
		
	
	}
	
	String num,snamme;
	//static int v=0;
	public void actionPerformed(ActionEvent ae)
	{		
			
		   if(ae.getSource()==reset)
		   {  
			   snamet.setText(null);
			   clast.setSelectedIndex(0);
			   //v++;
		   }
		   if(ae.getSource()==cancel)
		   {  
			   setVisible(false);
			   new SAMS();
		   }
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		
		boolean cntr=true;
		if(e.getStateChange()==ItemEvent.SELECTED)
		  {
			  snamme = snamet.getText();
			  //String cllas  = clast.getText();
			  
			    			        
		      //int uid = Integer.parseInt(num); 
		      
		      	      
		      char ch[];
		   	  ch = new char[20];
		   	  int i;
		   
		      
		      for(i=0;i<snamme.length();i++)
		   	  ch[i] = snamme.charAt(i);
		   		
		      int flag=0;
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
		   		JOptionPane.showMessageDialog(null,"Plaese enter valid name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   		snamet.setText(null);
		   	    cntr=false; 
		      }
			 } 
			 
			 if(cntr)
			  {
			   	if(snamme.length()==0) 
			  	{
			    	  JOptionPane.showMessageDialog(null,"Please enter the student name !!","Error!Error!!",JOptionPane.ERROR_MESSAGE);  	
			    	  cntr=false;
			  	}
			  }		  
			  
	 		  String cls = (String)e.getItem();
			  String str =" ";
			  String str1 ="fybcs";
			  String str2 ="sybcs";
			  String str3 ="tybcs";
			  snamme = snamet.getText();
			  
			  int set=0;
			  			  
			   
			  	if(cls.equals(str))
			  	{
			  		set=0;
			  	}
			  	else if(cls.equals(str1)) 
			  	{
			  		set=1;
			  	}
			  	else if(cls.equals(str2))
			  	{
			  		set=1;
			   	}
			   	else if(cls.equals(str3))
			  	{
			  		set=1;
			   	} 
			  	
			  	
			  if(cntr)
			  {				  
				  if(set==0)
			      {
			   			cntr=false;		
			   	  }
			   	  
		      }
	  		  
	  		  if(cntr)
		      {		   
		       	Database db = new Database();
			    db.addStudent(snamme,cls);
			    JOptionPane.showMessageDialog(null,"Student Inserted Successfully!!!","O.K.",JOptionPane.INFORMATION_MESSAGE);
	  		  }
	  			  		 
	   }
	}
	public static void main(String args[])
	{
		new AddStudent();
	}
}
