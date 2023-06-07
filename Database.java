import java.sql.*;
import java.lang.*;
import javax.swing.*;

public class Database
{
	Connection con;
	
	public Database()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(Exception e)
		{
			System.out.println("exception"); 
		}
		try
		{
			con = DriverManager.getConnection("jdbc:odbc:dsn1connection");
		
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
	}	
	
	public int chkUser(int uid,String suser,String ssub)
	{
		int set=1;
		try
		{	
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from lecturer");
			//System.out.println(id+"\t"+uname);
			while(rs.next())
			{                           
			    int id = rs.getInt(1);
				String name = rs.getString(4);
				String subj = rs.getString(6);
				
				char ch[];
		   	    ch = new char[20];
		   	    int i;
		   	    
				char ch1[];
		   	    ch1 = new char[20];
		   	    int j;
		   	  
		   	    
		          for(i=0;i<subj.length();i++)
		   	   	  ch[i] = subj.charAt(i);			
				
				
		   	    for(j=0;j<ssub.length();j++)
		   	   	  ch1[j] = ssub.charAt(j);
		   	 		   	  
		   	    boolean chk1=true;
		   	  	
		   	  	
		   	    if(i!=j)
		   	    {
		   	   	  chk1=false;
		   	    }	
		      
		       int cnt1=0;
		        if(chk1==true)
		        {
		      	
		          for(int k=0;k<i;k++)
		          {
		   	    
		   			if(ch[k]==ch1[k])
		   			cnt1++;
		   	   			
		          }
		        }   	
		     
		        System.out.println("i= "+i+"cnt1= "+cnt1);
		        boolean cntr=true;
		        
		        
		        
		        if(cntr)
		        {
		        	if(id==uid)
		        	{
		      	 	 JOptionPane.showMessageDialog(null,"Lecturer already exist.!!","Error!Error!!",JOptionPane.ERROR_MESSAGE);  	
			    	 cntr=false;
			    	 set=0;
			        }
		        }
		        
		        if(cntr)
		        {
		           if(cnt1==i)
		      	   {
		      	 	JOptionPane.showMessageDialog(null,"Cann't insert two users of same subject.!!","Error!Error!!",JOptionPane.ERROR_MESSAGE);  	
			    	cntr=false;
			    	set=0;
			       }  			  
		        }
		        
		       // System.out.println(id+"\t"+name);
			 }
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		if(set==1)
			return 1;
		else
			return 0;
	
	}
	
	public void addUser(int uid1,String fuser,String luser,String suser,String spass,String ssub)	
	{
			String cls=null;
			String ln = ssub;
			String ln15 = ln.toLowerCase();
			//System.out.println("@@@@@@"+ln12);
			
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
	  		  
			if(ln15.equals(ln1)||ln15.equals(ln2)||ln15.equals(ln3)||ln15.equals(ln4))
			{
				cls="fybcs";
			}
			else if(ln15.equals(ln5)||ln15.equals(ln6)||ln15.equals(ln7)||ln15.equals(ln8))
			{
				cls="sybcs";
			}
			else
			{
				cls="tybcs";
			}
			
		try
		{
			
			PreparedStatement pt = con.prepareStatement("INSERT INTO lecturer VALUES(?,?,?,?,?,?,?)");
			pt.setInt(1,uid1);
			pt.setString(2,fuser);
			pt.setString(3,luser);
			pt.setString(4,suser);
			pt.setString(5,spass);
			pt.setString(6,ssub);
			pt.setString(7,cls);
			
			pt.executeUpdate();
			
			Statement s = con.createStatement();
			ResultSet rs= s.executeQuery("select * from lecturer");
			while(rs.next())
			{                           
				int id = rs.getInt(1);
				String name = rs.getString(3);
				//System.out.println(id+"\t"+name);
				
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		int id=0;
		try
		{
				
			if(ln15.equals(ln1))
			{
				id=1;
			}
			else if(ln15.equals(ln2))
			{
				id=2;
			}
			else if(ln15.equals(ln3))
			{
				id=3;
			}
			else if(ln15.equals(ln4))
			{
				id=4;
			}
			else if(ln15.equals(ln5))
			{
				id=5;
			}
			else if(ln15.equals(ln6))
			{
				id=6;
			}
			else if(ln15.equals(ln7))
			{
				id=7;
			}
			else if(ln15.equals(ln8))
			{
				id=8;
			}
			else if(ln15.equals(ln9))
			{
				id=9;
			}
			else if(ln15.equals(ln10))
			{
				id=10;
			}
			else if(ln15.equals(ln11))
			{
				id=11;
			}
			else if(ln15.equals(ln12))
			{
				id=12;
			}
			else if(ln15.equals(ln13))
			{
				id=13;
			}
			else
			{
				id=14;
			}
			
			if(id!=0)
			{
			    PreparedStatement pt = con.prepareStatement("INSERT INTO lecture VALUES(?,?)");
				pt.setInt(1,id);
				pt.setString(2,ln15);
				
				pt.executeUpdate();
				
				Statement s = con.createStatement();
				ResultSet rs= s.executeQuery("select * from lecturer");
				while(rs.next())
				{                           
					int d = rs.getInt(1);
					String name = rs.getString(3);
			//		System.out.println(id+"\t"+name);
					
				}
			}
			
			else
			{
				 	JOptionPane.showMessageDialog(null,"Invalid subject name!!","Error!Error!!",JOptionPane.ERROR_MESSAGE);  	
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		
		if(id!=0)
		{
			int sr[] = new int[100];
			//int sr1[] = new int[100];
			int l=1;
			try
			{	//nm1=1;
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery("select s_rno from student where class ="+"'"+cls+"'"); 
				//System.out.println(id+"\t"+uname);
				while(rs.next())
				{                           
					sr[l++] = rs.getInt(1);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
			
			
			try
			{
				for(int i=1;sr[i]!='\0';i++)
				{
					PreparedStatement pt = con.prepareStatement("INSERT INTO stu_lect VALUES(?,?,?,?)");
					pt.setInt(1,sr[i]);
					pt.setInt(2,id);
					pt.setInt(3,0);
					pt.setInt(4,0);
									
					pt.executeUpdate();
					
					Statement s = con.createStatement();
					ResultSet rs= s.executeQuery("select * from stu_lect");
					while(rs.next())
					{                           
						int idr = rs.getInt(1);
						String name = rs.getString(3);
				//		System.out.println(id+"\t"+name);
						
					}
				
				}
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
			
			try
			{
					PreparedStatement pt = con.prepareStatement("INSERT INTO lect_lect VALUES(?,?)");
					pt.setInt(1,uid1);
					pt.setInt(2,id);
														
					pt.executeUpdate();
					
					Statement s = con.createStatement();
					ResultSet rs= s.executeQuery("select * from lect_lect");
					while(rs.next())
					{                           
						int idr = rs.getInt(1);
						String name = rs.getString(3);
				//		System.out.println(id+"\t"+name);
						
					}
				
				
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
		}
	
	}
	
	public void addStudent(String snamme,String cls)
	{
		System.out.println("Sname = "+snamme+"\t"+"class = "+cls);
		//int var=1;
		int id=0;
		ResultSet rs;
		//int md[] = new int[60];
		//int i=1;
		//int flag=1,set=0;
			try
			{	
				Statement s = con.createStatement();
				rs= s.executeQuery("select * from student");
				while(rs.next())
				{                           
					id = rs.getInt(1);
				}
				id++;
				
				PreparedStatement pt = con.prepareStatement("INSERT INTO student(s_rno,s_name,class) VALUES(?,?,?)");
				pt.setInt(1,id);
				pt.setString(2,snamme);
				pt.setString(3,cls);
				
				pt.executeUpdate();
				
				
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
			
			
			int i=0;
			int uno[] = new int[1000];
					
			try
			{	
				Statement s = con.createStatement();
				rs= s.executeQuery("select * from lecturer where class ="+"'"+cls+"'");
				while(rs.next())
				{                           
					uno[++i] = rs.getInt(1);
				}
			}
		
			catch(Exception e)
			{
				System.out.println(e); 
			}
			
			
			try
			{	
				for(int k=1;k<=i;k++)
				{
					PreparedStatement pt = con.prepareStatement("INSERT INTO stu_lect VALUES(?,?,?,?)");
					pt.setInt(1,id);
					pt.setInt(2,uno[k]);
					pt.setInt(3,0);
					pt.setInt(4,0);
								
					pt.executeUpdate();
							
				}	
			}
		
			catch(Exception e)
			{
				System.out.println(e); 
			}
			
			try
			{
				
				//System.out.println(s_no+"\t"+uno[k]+"\t"+subn[k]);
				PreparedStatement pt = con.prepareStatement("DELETE * FROM stu_lect where sub_id=0");
				
				pt.executeUpdate();
					
				Statement s = con.createStatement();
				rs= s.executeQuery("select * from stu_lect");
					while(rs.next())
					{                           
					int i_d = rs.getInt(1);
					//String name = rs.getString(3);
					//System.out.println(id+"\t"+name);
					
					}		
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
	}
	
	 public int searchUser(String un,String ps)
	{
		ResultSet rs;
		int id = 0;
		try
		{	//nm1=1;
			Statement s = con.createStatement();
			rs = s.executeQuery("select * from lecturer where u_name ="+"'"+un+"'"+"and passwd ="+"'"+ps+"'"); 
			//System.out.println(id+"\t"+uname);
			while(rs.next())
			{                           
				id = rs.getInt(1);
				String name = rs.getString(4);
				String pss = rs.getString(5);
				//System.out.println(id1+"\t"+name+"\t"+pss);
				//id=1;
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e); 
			e.printStackTrace();
		}
		
		System.out.println("\t "+id);
		return id;
	}
	
	public boolean searchStudent(int no)
	{
		ResultSet rs;
		int id = 0;
		try
		{	//nm1=1;
			Statement s = con.createStatement();
			rs = s.executeQuery("select * from student where s_rno="+no);
			//System.out.println(id+"\t"+uname);
			while(rs.next())
			{                           
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(id1+"\t"+name);
				id=1;
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		
		if(id != 0)
			return true;
		else
			return false;
	}
	
	public int n_student(int ud)
	{
		int flag=0;
		ResultSet rs;
			try
			{	
				Statement s = con.createStatement();
				rs= s.executeQuery("select s_rno from stu_lect where sub_id ="+ud);
				while(rs.next())
				{                           
					int id = rs.getInt(1);
					flag++;
				}
		
						
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
			
			return flag;
	}

	public static void main(String args[])
	{
		new Database();
		
	}	
}
