import java.sql.*;
import java.lang.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class UpdateRecords extends JFrame implements KeyListener,ActionListener 
{
	Container con = getContentPane();
	JLabel rno   = new JLabel("Stud_Roll No.");
    JLabel sname = new JLabel("Student Name");
    JLabel clas = new JLabel("Class");
    JLabel sub = new JLabel("Subject");
    JLabel ia = new JLabel("Increase Attendance by");
    JLabel da = new JLabel("Decrease Attendance by");
    JLabel l = new JLabel("lectures");
    JLabel l1 = new JLabel("lectures");
    JPanel titalPan,pan1;
    JTextField rnot,snamet,clast,iat,dat;
    JLabel titalLab;
	JButton reset,back,add,sub1;
	JComboBox subt;
    
	public UpdateRecords()
	{
		con.setLayout(null); 
		titalPan = new JPanel();
		titalPan.setBorder(new EtchedBorder());
		
		titalLab = new JLabel("Attendance Management System");
		titalLab.setFont(new Font("Times New Roman",Font.BOLD,22));
		titalPan.add(titalLab);
		titalPan.setBounds(10,10,400,60);
		
		pan1 = new JPanel();
		pan1.setLayout(null);
		pan1.setBounds(10,70,400,370);
		pan1.setBorder(new EtchedBorder());
		
		
		rnot  = new JTextField();
		snamet = new JTextField();
		clast = new JTextField();
		iat = new JTextField();
		dat = new JTextField();
		
		rno.setBounds(50,40,120,30);
		pan1.add(rno);
		sname.setBounds(50,80,120,30);
		pan1.add(sname);
		clas.setBounds(50,120,120,30);
		pan1.add(clas);
		sub.setBounds(50,160,120,30);
		pan1.add(sub);
		ia.setBounds(50,200,150,30);
		pan1.add(ia);
		da.setBounds(50,240,150,30);
		pan1.add(da);
		
		
		rnot.setBounds(210,40,100,25);
		pan1.add(rnot);
		snamet.setBounds(210,80,100,25);
		pan1.add(snamet);
		clast.setBounds(210,120,100,25);
		pan1.add(clast);
		
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
		
		subt.setBounds(210,160,100,25);
		pan1.add(subt);
		iat.setBounds(210,200,50,25);
		pan1.add(iat);
		l.setBounds(270,200,100,25);
		pan1.add(l);
		dat.setBounds(210,240,50,25);
		pan1.add(dat);
		l1.setBounds(270,240,100,25);
		pan1.add(l1);
		
		
		reset = new JButton("Reset");
		back = new JButton("Back");
		add = new JButton("Add");
		sub1 = new JButton("Sub");
		
		reset.setBounds(80,290,80,20);
		back.setBounds(210,290,80,20);
		add.setBounds(330,200,60,20);
		sub1.setBounds(330,240,60,20);
		pan1.add(reset);
		pan1.add(back);
		pan1.add(add);
		pan1.add(sub1);
		reset.addActionListener(this);
		back.addActionListener(this);
		add.addActionListener(this);
		sub1.addActionListener(this);
		rnot.addKeyListener(this);
		iat.addKeyListener(this);
		dat.addKeyListener(this);
		
		con.add(titalPan);
		con.add(pan1);
		setSize(423,480);
		setVisible(true);
		setResizable(false);
		
		
		snamet.disable();
		clast.disable();
		subt.disable();
		iat.disable();
		dat.disable();	
	}
	
	int set;
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar()=='\n')
		{
			  Login l = new Login();
			  int ud = l.send();
			  
			  	
			  rnot.disable();
		      snamet.disable();
		      clast.disable();
		      subt.disable();
		      iat.disable();
		      dat.disable();		
			  	
			  			  
			  boolean cntr=true;
			    
			  if(ud!=0)
			  {			    	
			  	System.out.println(ud);
			  	l.setVisible(false); 
			  	
			 	rnot.enable();
		      	snamet.disable();
		      	clast.disable();
		      	subt.setSelectedIndex(ud);
		      	subt.disable();
		      	iat.disable();
		      	dat.disable();		
			  
			 	cntr=false;
			  	String rno = rnot.getText();
			  			  
			    char ch[];
		   	  	ch = new char[20];
		   	  	int i;
		   
		   	    for(i=0;i<rno.length();i++)
		   		ch[i] = rno.charAt(i);
		   	  			   		
		    	int flag=0;
		      	for(int k=0;k<i;k++)
		      	{
		   	    	for(char m=33;m<48;m++)
		   			{
		   				if(ch[k]==m)
		   				flag--;
		   			}
		   			for(char m=58;m<127;m++)
		   			{
		   				if(ch[k]==m)
		   				flag--;
		   			}
		   		
		   		
			  	}
		   	  	
		   	  	if(flag<0)
		      	{
		   			JOptionPane.showMessageDialog(null,"Plaese enter an integers only in RollNo field!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   			rnot.setText(null);
		   			   	   
		      	}
		       	int no = Integer.parseInt(rno);
			  	Database db = new Database();
			  	if(db.searchStudent(no))
			  	{
			  		Connection con;
			  		int id1;
			  		
					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					
						ResultSet rs;
						Statement s = con.createStatement();
						rs = s.executeQuery("select * from student where s_rno="+no);
						
						while(rs.next())
						{                           
							id1 = rs.getInt(1);
							String name = rs.getString(2);
							String clas1 = rs.getString(3);
							System.out.println(id1+"\t"+name+"\t"+clas1);
							rnot.disable();
							snamet.setText(name);
							snamet.setFont(new Font("Ariel Black",Font.BOLD,12));
							snamet.disable();
							clast.setText(clas1);
							clast.setFont(new Font("Ariel Black",Font.BOLD,12));
							clast.disable();
								
			  
						}
			
					}
					catch(Exception ee)
					{
						System.out.println(ee); 
					}
					
			  	}
			    else
			    {
			  	  JOptionPane.showMessageDialog(null,"Student of such RollNo doesn,t exist.!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 	
			  	  rnot.setText(null);
			    }
			    
			    	
			    	Connection con;
			  		int d1=0,d2=0,d3=0,d4=0;
			  		
					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					
						ResultSet rs;
						Statement s = con.createStatement();
						rs = s.executeQuery("select * from stu_lect where s_rno="+no+" and sub_id="+ud);
						while(rs.next())
						{   
							d1 = rs.getInt(3);
							d2 = rs.getInt(4);
						}
			
					}
					catch(Exception ee)
					{
						System.out.println(ee); 
					}
					
					System.out.println("\t"+set);
					if(set==0)
					{
					
						String iatt = iat.getText();
						int iatt1 = Integer.parseInt(iatt);  
						d3 = iatt1+d1;
						if(d3<=d2)
						{
														
				  			try
							{
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
								PreparedStatement s = con.prepareStatement("update stu_lect set lect_attended="+d3+" where s_rno="+no+" and sub_id="+ud);
								s.executeUpdate();
								s.close();
								JOptionPane.showMessageDialog(null,"Attendance Incremented.!!","Updation Report!!",JOptionPane.INFORMATION_MESSAGE);
								iat.setText(null);
							}
				
							catch(Exception ee)
							{
								System.out.println(ee); 
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid increment of Attendance.!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 	
							iat.setText(null);
						}	
					}
					
					else
					{
							
						String datt = dat.getText();
						int datt1 = Integer.parseInt(datt);  
						d4 = d1-datt1;
						if(d4>=0)
						{
						
							try
							{
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
						
								PreparedStatement s = con.prepareStatement("update stu_lect set lect_attended="+d4+" where s_rno="+no+" and sub_id="+ud);
								s.executeUpdate();
								s.close();
								JOptionPane.showMessageDialog(null,"Attendance Decremented.!!","Updation Report!!",JOptionPane.INFORMATION_MESSAGE); 	
								dat.setText(null);
								
							}
				
							catch(Exception ee)
							{
								System.out.println(ee); 
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid decrement of Attendance.!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 	
							dat.setText(null);
						}	
					}	
		     }
		     
		 }		
	}
	
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}	
	 
	/* public void itemStateChanged(ItemEvent e)
	 {  
	  int n,flag=0,flag1=0;
	  if(flag1==0)
	  {
	  
	  	if(e.getStateChange()==ItemEvent.SELECTED)
	  	{	
	  		//boolean cntr=true;
	  		flag1=1;
	  		String ln = (String)e.getItem();
	  		String ln1="Ppl";
	  		String ln2="Adc";
	  		String ln3="Daa";
	  		String ln4="Oose";
	  		String ln5="Unix";
	  		String ln6="Adv.Net";
	  		
	  		System.out.println(ud);
	  		//String ln7=
	  		//String ln8=
	  		//String ln9=
	  		//String ln10=
	  		
	  	
	  	
	  		n=0;
	  		if(ln.equals(ln1))
	  		{
	  			n=1;
	  			subt.disable();
	  			
	  		}
	  		else if(ln.equals(ln2))
	  		{
	  			n=2;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln3))
	  		{
	  			n=3;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln4))
	  		{
	  			n=4;
	  			subt.disable();
	  		}
	  	  	else if(ln.equals(ln5))
	  		{
	  			n=5;
	  			subt.disable();
	  		}
	  		else 
	  		{
	  			n=6;
	  			subt.disable();
	  		}
	  	
	  		
	  		//if(cntr)
	  	//	{
	  		
	  			if(number==1&&n==5||number==1&&n==6||number==2&&n==1||number==2&&n==2||number==2&&n==3||number==2&&n==4)		
	  			{
	  				JOptionPane.showMessageDialog(null,"Invalid Combination of Class Name & Subject Name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 	
	  				subt.enable();
	  			}
	  		
	  			else
	  			{
	  				Connection con;
			  		int id1,id2;
			  		String rno = rnot.getText();
			  		int no = Integer.parseInt(rno);
			  		
			  		//String name,name1;
					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						con = DriverManager.getConnection("jdbc:odbc:dsnconnection");
					
						ResultSet rs;
						Statement s = con.createStatement();
						rs = s.executeQuery("select * from lecture where sub_name="+"'"+ln+"'");
						//System.out.println(id+"\t"+uname);
						while(rs.next())
						{                           
							id1 = rs.getInt(1);
													
							String str1="fymcs";
							String str2="symcs";
							
							if(clas.equals(str1))
								{ number=1;}
							else 
								{ number=2;}
								
							System.out.println(number);
							
							
						}
			
					}
					catch(Exception ee)
					{
						System.out.println(ee); 
					}
	  			}
	  		//}
	  	}
	}  	
 }*/
 	public void actionPerformed(ActionEvent ae)
 	{
 		if(ae.getSource()==reset)
 		{
 			     
		      	   		
		      	   		
		      	   		rnot.enable();
		      	   		snamet.disable();
		      	   		clast.disable();
		      	   		subt.disable();
		      	   		iat.disable();
		      	   		dat.disable();
		      	   		
		      	   		
		      	   		rnot.setText(null);
		      	   		snamet.setText(null);
		      	   		clast.setText(null);
		      	   		iat.setText(null);
		      	   		dat.setText(null);
		      	   		subt.setSelectedIndex(0);
		      	   		
		     
		      	
 		}
 		
 		if(ae.getSource()==back)
 		{
 			setVisible(false);
 			new Transaction();		      	
 		}
 		
 		if(ae.getSource()==add)
 		{
 			iat.enable();
 			dat.disable();
 			iat.setText(null);
 			//iat.setCursor();
 			set=0;
 		}
 		
 		if(ae.getSource()==sub1)
 		{
 			dat.enable();
 			iat.disable();
 			dat.setText(null);
 			set=1;
 		}
 	}
 
	public static void main(String args[])
	{
		new UpdateRecords();
	}
}