
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.lang.*;

public class Transaction extends JFrame implements ActionListener
{
	JFrame jf;
	
	Container con;
	JPanel titalPan,pan1;
	JLabel titalLab;
	JButton add1,upd,src,cancel;
	
	public Transaction() 
	{
		jf = new JFrame("Transaction");
		
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
		
		
		
		add1 = new JButton("Add Records");
		add1.setBounds(40,20,100,25);
		pan1.add(add1);
		upd = new JButton("Update Records");
		upd.setBounds(150,85,100,25);
		pan1.add(upd);
		src = new JButton("Search Records");
		src.setBounds(250,150,100,25);
		pan1.add(src);
		cancel = new JButton("cancel");
		cancel.setBounds(170,280,80,25);
		con.add(cancel);
		
		con.add(titalPan);
		con.add(pan1);
		
		add1.addActionListener(this);
		upd.addActionListener(this);
		src.addActionListener(this);
		cancel.addActionListener(this);
		
		jf.setSize(423,350);
		jf.setVisible(true);
		jf.setResizable(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
    public void actionPerformed(ActionEvent ae)
   {
   	      if(ae.getSource()==add1)
   	      {
   	            jf.setVisible(false);
   	            new AddRecords();   
   	      }
   	      else if(ae.getSource()==upd)
   	      {
   	    	  jf.setVisible(false);
   	    	  new UpdateRecords();
   	      }
   	      else if(ae.getSource()==src)
   	      {
   	    	  jf.setVisible(false);
   	    	  new SearchRecords();
   	      }
   	      else if(ae.getSource()==cancel)
   	      {
   	    	  jf.setVisible(false);
   	    	  new SAMS();
   	      }
   }
	public static void main(String args[]) 
	{
		new Transaction();
	}
}
