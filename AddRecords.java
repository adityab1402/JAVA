import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.lang.*;

public class AddRecords extends JFrame implements ActionListener,ItemListener 
{
		
	Container con;
	int j,n;
	int subid,size;
	String name[],b[];
	int sr[];
	
	JScrollPane jsp1;	
	JPanel titalPan,pan1,pan2;
	JLabel titalLab;
		
	Checkbox cbp[],cba[],cbl[];
		
	JButton gen,back,res;
	JTextField jbt,jr[],jn[];
	JComboBox jb1;
	
	JFrame jf;
			
	public AddRecords() 
	{
		jf = new JFrame("Add Records");
		Login l1 = new Login();
		int ud = l1.send();	
		Database db = new Database();
		size = db.n_student(ud)+1;
	
		name = new String[size];
		sr = new int[size]; 
		b = new String[size];
	
		System.out.println("size = "+size);	
		con = jf.getContentPane();	
		con.setLayout(null);
		
		titalPan = new JPanel();
		titalPan.setBorder(new EtchedBorder());
		
		titalLab = new JLabel("Attendance Management System");
		titalLab.setFont(new Font("Times New Roman",Font.BOLD,25));
		titalPan.add(titalLab);
		titalPan.setBounds(20,20,500,60);
		
		JLabel jb = new JLabel("Subject");
		jb.setBounds(110,95,60,30);
		con.add(jb);
		
		jb1 = new JComboBox();
		jb1.addItem(" ");
		jb1.addItem("fymath");
		jb1.addItem("fystat");
		jb1.addItem("fycomp");
		jb1.addItem("fyelect");
		jb1.addItem("symath");
		jb1.addItem("sycomp");
		jb1.addItem("syeng");
		jb1.addItem("syelect");
		jb1.addItem("tytcs");
		jb1.addItem("tysys");
		jb1.addItem("tynet");
		jb1.addItem("tydb/php");
		jb1.addItem("tyjava");
		jb1.addItem("tysoft");
		con.add(jb1);
		jb1.setBounds(160,100,80,20);
		
		 	
		jb = new JLabel("Class");
		jb.setBounds(260,95,80,30);
		con.add(jb);
        jbt = new JTextField();
		jbt.setBounds(310,100,80,20);
		con.add(jbt);
			
		JLabel rn = new JLabel("Roll No.");
		rn.setBounds(53,140,80,50);
		con.add(rn);
		
		JLabel nm = new JLabel("Name");
		nm.setBounds(175,140,80,50);
		con.add(nm);
		
		JLabel at = new JLabel("Attendance");
		at.setBounds(360,125,80,50);
		con.add(at);
		
		JLabel p = new JLabel("P");
		p.setBounds(330,145,80,50);
		con.add(p);
		
		JLabel a = new JLabel("A");
		a.setBounds(395,145,80,50);
		con.add(a);
		
		
		JLabel l = new JLabel("L");
		l.setBounds(460,145,80,50);
		con.add(l);
		
		jr = new JTextField[size];
		jn = new JTextField[size];
		cbp = new Checkbox[size];
		cba = new Checkbox[size];
		cbl = new Checkbox[size];
		
		pan2 = new JPanel();
		pan2.setLayout(null);
		
		int i,y;
		for(i=1,y=10;i<size;i++,y+=30)
		{
			jr[i] = new JTextField(10);
			jr[i].setBounds(20,y,50,25);
			pan2.add(jr[i]);
			jr[i].disable();
			
			jn[i] = new JTextField(10);
			jn[i].setBounds(110,y,120,25);
			pan2.add(jn[i]);
			jn[i].disable();
			
			cbp[i] = new Checkbox();
			cbp[i].setBounds(300,y,20,20);
			pan2.add(cbp[i]);
			cbp[i].disable();
			
			cba[i] = new Checkbox();
			cba[i].setBounds(365,y,20,20);
			pan2.add(cba[i]);
			cba[i].disable();
		
			cbl[i] = new Checkbox();
			cbl[i].setBounds(430,y,20,20);
			pan2.add(cbl[i]);
			cbl[i].disable();
			
			cbp[i].addItemListener(this);
			cba[i].addItemListener(this);
			cbl[i].addItemListener(this);
		}
		jsp1 = new JScrollPane(pan2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(25,180,500,300);
		
		gen = new JButton("Generate");
		gen.setBounds(150,495,100,20);
		con.add(gen);
		gen.addActionListener(this);
		
		res = new JButton("Reset");
		res.setBounds(150,495,100,20);
		con.add(res);
		res.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(300,495,100,20);
		con.add(back);
		back.addActionListener(this);
		
		con.add(titalPan);
		con.add(jsp1);
		jsp1.setVisible(true);
		jf.setVisible(true);
		jf.setSize(550,570);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				l1.setVisible(false);
				
				if(ud==1)
				{
					subid=1;
					jb1.setSelectedIndex(1);
					jb1.disable();
				}
				else if(ud==2)
				{
					subid=2;
					jb1.setSelectedIndex(2);
					jb1.disable();
				}
				else if(ud==3)
				{
					subid=3;
					jb1.setSelectedIndex(3);
					jb1.disable();
				}
				else if(ud==4)
				{
					subid=4;
					jb1.setSelectedIndex(4);
					jb1.disable();
				}
				else if(ud==5)
				{
					subid=5;
					jb1.setSelectedIndex(5);
					jb1.disable();
				}
				else if(ud==6)
				{
					subid=6;
					jb1.setSelectedIndex(6);
					jb1.disable();
				}
				else if(ud==7)
				{
					subid=7;
					jb1.setSelectedIndex(7);
					jb1.disable();
				}
				else if(ud==8)
				{
					subid=8;
					jb1.setSelectedIndex(8);
					jb1.disable();
				}
				else if(ud==9)
				{
					subid=9;
					jb1.setSelectedIndex(9);
					jb1.disable();
				}
				else if(ud==10)
				{
					subid=10;
					jb1.setSelectedIndex(10);
					jb1.disable();
				}
				else if(ud==11)
				{
					subid=11;
					jb1.setSelectedIndex(11);
					jb1.disable();
				}
				else if(ud==12)
				{
					subid=12;
					jb1.setSelectedIndex(12);
					jb1.disable();
				}
				else if(ud==13)
				{
					subid=13;
					jb1.setSelectedIndex(13);
					jb1.disable();
				}
				else if(ud==14)
				{
					subid=14;
					jb1.setSelectedIndex(14);
					jb1.disable();
				}
				else
				{
					jb1.setSelectedIndex(0);
					jb1.disable();
				}
				
								
				if(subid==1||subid==2||subid==3||subid==4)
				{
					jbt.setText("fybcs");
					jbt.disable();
				}
				else if(subid==5||subid==6||subid==7||subid==8)
				{
					jbt.setText("sybcs");
					jbt.disable();
				}
				else if(subid==9||subid==10||subid==11||subid==12||subid==13||subid==14)
				{
					jbt.setText("tybcs");
					jbt.disable();
				}
				
				
				
				int id;
			  	
			  	//int d[] = new int[50];
			  	//int f=0;
				j=0;
					
				Connection con1;	
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con1 = DriverManager.getConnection("jdbc:odbc:dsn1connection");
				
					ResultSet rs;
					Statement s = con1.createStatement();
					System.out.println("subid = "+subid);
					rs = s.executeQuery("select s_rno from stu_lect where sub_id = "+subid);
					
					while(rs.next())
					{                           
						id = rs.getInt(1);
						sr[++j]=id;
						System.out.println("sr[j++] = "+sr[j]);	
					}
				
								
				}	
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				int id1;
				
												
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con1 = DriverManager.getConnection("jdbc:odbc:dsn1connection");
				
					ResultSet rs;
					Statement s = con1.createStatement();
					for(int k=1;k<=j;k++)
					{
						System.out.println("s_rno = "+sr[k]);
						rs = s.executeQuery("select * from student where s_rno="+sr[k]);
						
						while(rs.next())
						{                           
							name[k] = rs.getString(2);
								
						}
					System.out.println("name = "+name[k]);
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			
	}
	
	int cnt=0;
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==gen)
		{
			cnt++;
			for(int k=1;k<=j;k++)
			{
				String cg = String.valueOf(sr[k]);
				//System.out.println("k = "+k+"\t"+"b[k] = "+b[k]+"\t"+"name[k] = "+name[k]);
				jr[k].setText(cg);
				jr[k].disable();
				jn[k].setText(name[k]);
				jn[k].disable();
				cbl[k].disable();
				cbp[k].enable();
				cba[k].enable();
			}
			gen.setVisible(false);
			res.setVisible(true);
		}
		
		if(ae.getSource()==res)
		{
			for(int k=1;k<=j;k++)
			{
				jr[k].setText(null);
				jr[k].disable();
				jn[k].setText(null);
				jn[k].disable();
				cbl[k].setState(false);
				cbp[k].setState(false);
				cba[k].setState(false);
				cbl[k].disable();
				cbp[k].disable();
				cba[k].disable();
			}
			gen.setVisible(true);
			res.setVisible(false);
		}
		
		if(ae.getSource()==back)
		{
			jf.setVisible(false);
			new Transaction();
		}
				
}
		public void itemStateChanged(ItemEvent ie)
		{
			Login l1 = new Login();
			int ud = l1.send();
			l1.setVisible(false);
						
			System.out.println("sr[1] = "+sr[1]);
			for(int i=1;i<=j;i++)
			{
				cbl[i].disable();
				System.out.println("You are in for.& i= "+i);
				if(ie.getItemSelectable()==cbp[i])
				{
					cbp[i].disable();
					cba[i].disable();
					cbl[i].setState(true);
					cbl[i].disable();
				System.out.println("You are in if & i = "+i);
				
				int val=0,val1=0;
				try
				{	
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					Statement s = con.createStatement();
					ResultSet rs= s.executeQuery("select * from stu_lect where s_rno ="+sr[i]+"and sub_id ="+ud);
					while(rs.next())
					{	   
						val= rs.getInt(3);
						val1=rs.getInt(4);
					}	
					
					
				}
				catch(Exception ee)
				{
					System.out.println(ee); 
				}
				
				val++;
				val1++;
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					PreparedStatement s = con.prepareStatement("update stu_lect set lect_attended ="+val+" where s_rno ="+sr[i]+" and sub_id ="+ud);
					s.executeUpdate();
					s.close();
				}
				catch(Exception ee)
				{
					System.out.println(ee); 
				}
				
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					PreparedStatement s = con.prepareStatement("update stu_lect set total_lectures ="+val1+" where s_rno="+sr[i]+" and sub_id ="+ud);
					s.executeUpdate();
					s.close();
				}
				catch(Exception ee)
				{
					System.out.println(ee); 
				}

				
			}
			
			
			if(ie.getItemSelectable()==cba[i])
				{
					cbp[i].disable();
					cba[i].disable();
					cbl[i].setState(true);
					cbl[i].disable();
					System.out.println("You are in if & i = "+i);
				
					int val1=0;
				try
				{	
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					Statement s = con.createStatement();
					ResultSet rs= s.executeQuery("select * from stu_lect where s_rno ="+sr[i]+"and sub_id ="+ud);
					while(rs.next())
					{	   
						val1=rs.getInt(4);
					}	
					
					
				}
				catch(Exception ee)
				{
					System.out.println(ee); 
				}
				
				val1++;
				
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
					PreparedStatement s = con.prepareStatement("update stu_lect set total_lectures ="+val1+" where s_rno="+sr[i]+" and sub_id ="+ud);
					s.executeUpdate();
					s.close();
				}
				catch(Exception ee)
				{
					System.out.println(ee); 
				}

				
			}	
			
			
		}		
			
	}	
	
	public static void main(String args[])
	{
		new AddRecords();
	}

}
