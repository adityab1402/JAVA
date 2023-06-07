import java.sql.*;
import java.lang.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class SearchRecords extends JFrame implements KeyListener,ItemListener,ActionListener 
{
	JFrame jf;
	Container con;
    JLabel rno,sname,clas,sub,la,ta,pa;
    JPanel titalPan,pan1;
    JTextField rnot,snamet,clast,lat,tat,pat;
    JLabel titalLab;
	JButton reset,back;
	JComboBox subt;
    
	public SearchRecords()
	{
		jf = new JFrame("SearchRecords");
		
		con = jf.getContentPane();
		con.setLayout(null);
		
		titalPan = new JPanel();
		titalPan.setBorder(new EtchedBorder());
		
		titalLab = new JLabel("Attendance Management System");
		titalLab.setFont(new Font("Times New Roman",Font.BOLD,22));
		titalPan.add(titalLab);
		titalPan.setBounds(10,10,395,60);
		
		rno = new JLabel("Roll No.");
		rno.setBounds(80,100,150,25);
		con.add(rno);
		
		sname = new JLabel("Student Name");
		sname.setBounds(80,140,150,25);
		con.add(sname);
		
		clas = new JLabel("Class");
		clas.setBounds(80,180,150,25);
		con.add(clas);
		
		sub = new JLabel("Subject");
		sub.setBounds(80,220,150,25);
		con.add(sub);
		
		la = new JLabel("Lectures Attended");
		la.setBounds(80,260,150,25);
		con.add(la);
		
		ta = new JLabel("Total Lectures");
		ta.setBounds(80,300,150,25);
		con.add(ta);
		
		pa = new JLabel("Percentage Of Attendance");
		pa.setBounds(80,340,150,25);
		con.add(pa);
		
		rnot  = new JTextField();
		rnot.setBounds(230,100,100,25);
		con.add(rnot);
		
		snamet = new JTextField();
		snamet.setBounds(230,140,100,25);
		con.add(snamet);
		
		clast = new JTextField();
		clast.setBounds(230,180,100,25);
		con.add(clast);
		
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
		subt.setBounds(230,220,100,25);
		con.add(subt);
		
		lat = new JTextField();
		lat.setBounds(230,260,100,25);
		con.add(lat);
		
		tat = new JTextField();
		tat.setBounds(230,300,100,25);
		con.add(tat);
		
		pat = new JTextField();
		pat.setBounds(230,340,100,25);
		con.add(pat);
		
		
		reset = new JButton("Reset");
		back = new JButton("Back");
		
		reset.setBounds(120,380,80,25);
		back.setBounds(220,380,80,25);
		reset.addActionListener(this);
		back.addActionListener(this);
		subt.addItemListener(this);
		rnot.addKeyListener(this);
		
		con.add(reset);
		con.add(back);
		con.add(titalPan);
		jf.setSize(423,490);
		jf.setVisible(true);
		jf.setResizable(true);
		
		snamet.disable();
		clast.disable();
		subt.disable();
		lat.disable();
		tat.disable();
		pat.disable();
	}
	int number = 0;
	
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar()=='\n')
		{
			  System.out.println("char = "+e.getKeyChar());
			  subt.disable();	
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
		   	  boolean cntr=true;
		   	  if(flag<0)
		      {
		   		JOptionPane.showMessageDialog(null,"Plaese enter an integers only RollNo field!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 
		   		rnot.setText(null);
		   		cntr=false;
		   	   
		      }
		      
		      if(cntr)
		      {
		      	if(rno.length()==0)
		      	{
		      	   	JOptionPane.showMessageDialog(null,"Plaese enter Roll Number!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 	
		        }
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
							String clas = rs.getString(3);
							rnot.disable();
							snamet.setText(name);
							snamet.setFont(new Font("Ariel Black",Font.BOLD,12));	
							clast.setText(clas);
							clast.setFont(new Font("Ariel Black",Font.BOLD,12));
							subt.enable();
							String str1="fybcs";
							String str2="sybcs";
							String str3="tybcs";
							
							if(clas.equals(str1))
								{ number=1;}
							else if(clas.equals(str2))
								{ number=2;}
							else if(clas.equals(str3))
								{ number=3;}
								
										
							
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
			  
			 
		}	  
	}
	
	 	
	
	public void itemStateChanged(ItemEvent e)
	 {  
	  	
	  	if(e.getStateChange()==ItemEvent.SELECTED)
	  	{	
	  		
	  		String ln = (String)e.getItem();
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
	  	
	  	
	  		int n=0;
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
	  		else if(ln.equals(ln6)) 
	  		{
	  			n=6;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln7))
	  		{
	  			n=7;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln8))
	  		{
	  			n=8;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln9))
	  		{
	  			n=9;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln10))
	  		{
	  			n=10;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln11))
	  		{
	  			n=11;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln12))
	  		{
	  			n=12;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln13))
	  		{
	  			n=13;
	  			subt.disable();
	  		}
	  		else if(ln.equals(ln14))
	  		{
	  			n=14;
	  			subt.disable();
	  		}
	  	
	  		
	  		  			
	  				if(number==1&&n==5||number==1&&n==6||number==1&&n==7||number==1&&n==8||number==1&&n==9||number==1&&n==10||number==1&&n==11||number==1&&n==12||number==1&&n==13||number==1&&n==14||number==2&&n==1||number==2&&n==2||number==2&&n==3||number==2&&n==4||number==2&&n==9||number==2&&n==10||number==2&&n==11||number==2&&n==12||number==2&&n==13||number==2&&n==14||number==3&&n==1||number==3&&n==2||number==3&&n==3||number==3&&n==4||number==3&&n==5||number==3&&n==6||number==3&&n==7||number==3&&n==8)		
	  				{	
	  					number=0;
	  					subt.setSelectedIndex(0);
	  					System.out.println(" "+n+"=>"+" "+number);
	  					JOptionPane.showMessageDialog(null,"Invalid Combination of Class Name & Subject Name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE); 	
	  					subt.disable();
	  				}
	  				
	  				
	  			
	  		
	  			else
	  			{
	  				Connection con;
			  		String rno = rnot.getText();
			  		int no = Integer.parseInt(rno);
			  		
			  		int id2=0;
			  		String sg1=null;
			  		try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					
						ResultSet rs;
						Statement s = con.createStatement();
						rs = s.executeQuery("select * from stu_lect where s_rno="+no+"and sub_id="+n);
						while(rs.next())
						{                           
							id2 = rs.getInt(3);
							sg1 = String.valueOf(id2);
						}
			
					}
					catch(Exception ee)
					{
						System.out.println(ee); 
					}
					
					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					
						ResultSet rs;
						Statement s = con.createStatement();
						rs = s.executeQuery("select * from stu_lect where s_rno="+no+"and sub_id="+n);
						while(rs.next())
						{                           
							int id3 = rs.getInt(4);
							String sg2 = String.valueOf(id3);
						
							lat.setText(sg1);	
							lat.disable();
							tat.setText(sg2);
							tat.disable();
							int res = (id2*100)/id3;
							String sg3 = String.valueOf(res);
							String sg4 = "%";
							String sg5 = sg3.concat(sg4);
							pat.setText(sg5);
							pat.disable();
							if(res<75)
							{
								JOptionPane.showMessageDialog(null,"DEFAULTER  STUDENT!!","Messege!!",JOptionPane.ERROR_MESSAGE); 	
							}
							String str1="fybcs";
							String str2="sybcs";
							String str3="tybcs";
							
							if(clas.equals(str1))
								{ number=1;}
							else if(clas.equals(str2))
								{ number=2;}
							else if(clas.equals(str3))
								{ number=3;}
								
							System.out.println(number);
							
							
						}
			
					}
					catch(Exception ee)
					{
						System.out.println(ee); 
					}
	  			}
	  		}
	  	}
	  	
 
 	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==reset)
		{
			number=0;
			subt.setSelectedIndex(0);
			rnot.setText(null); 
			rnot.enable();
			snamet.setText(null);
			clast.setText(null);
			subt.disable(); 
			lat.setText(null);
			tat.setText(null);
			pat.setText(null);
		
		}
		
		if(ae.getSource()==back)
		{
			jf.setVisible(false);
			new Transaction();
		}
	}
	
	public static void main(String args[])
	{
		new SearchRecords();
	}
}