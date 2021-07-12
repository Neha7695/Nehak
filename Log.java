import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Log extends JFrame implements ActionListener {
            JFrame f;

   JLabel l1, l2, l3,l4;

   JTextField t1;

   JButton sub;

   JPasswordField p1;

Log(){
f=new JFrame("Sign in ");
l1=new JLabel("Username");
l1.setBounds(90,50,250,80);
f.add(l1);

t1 = new JTextField(40);
t1.setBounds(180,50,250,80);
f.add(t1);

l2=new JLabel("Password");
l2.setBounds(90,170,250,80);
f.add(l2);

p1 = new JPasswordField(40);
p1.setBounds(180,170,250,80);
f.add(p1);

    sub = new JButton("Submit");
    sub.setBounds(120,290,250,80);
f.add(sub);
sub.addActionListener(this);

l3 = new JLabel("");
l3.setBounds(120,380,250,80);
f.add(l3);

l4 = new JLabel("");
l4.setBounds(400,380,250,80);
f.add(l4);

f.setLayout(null);
f.setVisible(true);
f.setSize(300,500);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getSource()==sub)
showData();
 new OnlineTest();
}
public void showData()
{    JFrame f1 = new JFrame();

       JLabel l, l0;

 

        String str1 = t1.getText();

        char[] p = p1.getPassword();

        String str2 = new String(p);

 
try

     {

         Class.forName("com.mysql.jdbc.Driver");

         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinTest1,"root","Nehak@123");

         PreparedStatement ps = con.prepareStatement("Select * from email where email=? and password=?");

         ps.setString(1, str1);

         ps.setString(2, str2);

         ResultSet rs = ps.executeQuery();

         if (rs.next())

         {
        	JOptionPane.showMessageDialog(null,

                     "succesfully login");

             
         } else

         {

             JOptionPane.showMessageDialog(null,

                "Incorrect email-Id or password..Try Again with correct detail");

         }

     }

     catch (Exception ex)

     {

         System.out.println(ex);

     }

 }



 public static void main(String arr[])

 {

     new Log();

 }

}
	
	
	
