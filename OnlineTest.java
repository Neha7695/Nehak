import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OnlineTest extends JFrame implements ActionListener {

	JLabel label;
	JRadioButton Btn[] = new JRadioButton[5];
	JButton BtnNext ,BtnBookMark;
	ButtonGroup bg;
	int count = 0,current=0,x=1 ,y=1,now=0;
	int m[] = new int[10];
	
	
	OnlineTest(String message) {
		super(message);
		label = new JLabel();
		add(label);
		bg= new ButtonGroup();
		for(int i=0;i<5;i++) {
			Btn [i] = new JRadioButton();
			add(Btn[i]);
			bg.add(Btn[i]);
			}
		BtnNext= new JButton("Next");
		BtnBookMark= new JButton("BookMark");
		BtnNext.addActionListener(this);
		BtnBookMark.addActionListener(this);
		add(BtnNext);
		add(BtnBookMark);
		set();
		label.setBounds(30,40,450,20);
		Btn[0].setBounds(50,80,100,20);
		Btn[1].setBounds(50,110,100,20);
		Btn[2].setBounds(50,140,100,20);
		Btn[3].setBounds(50,170,100,20);
		BtnNext.setBounds(100,240,100,30);
		BtnBookMark.setBounds(270, 240, 100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);	
	}

	public OnlineTest() {
		// TODO Auto-generated constructor stub
	}

	void set() {
		Btn[4].setSelected(true);

		if (current==0){
			label.setText("Q.1 Which of the following is not a Java feature");
			Btn[0].setText("Dynamic");
			Btn[1].setText("Architecture Neutral");
			Btn[2].setText("Use of pointers");
			Btn[3].setText("Object-oriented");	
		}
		if (current==1){
			label.setText("Q.2 What is the return type of the hashCode() method in the Object class?");
			Btn[0].setText("Object");
			Btn[1].setText("Int");
			Btn[2].setText("Long");
			Btn[3].setText("Void");		
		}
		if (current==2){
			label.setText("Q.3 What does the expression float a = 35 / 0 return?");
			Btn[0].setText("0");
			Btn[1].setText("Not a Number");
			Btn[2].setText("Infinity");
			Btn[3].setText("Run time exception");		
		}
		if (current==3){
			label.setText("Q.4 Which of the following tool is used to generate API documentation in HTML format from doc comments in source code? ");
			Btn[0].setText("javap tool");
			Btn[1].setText("javaw command");
			Btn[2].setText("javah command");
			Btn[3].setText("Javadoc tool");		
		}
		if (current==4){
			label.setText("Q.5 In which process, a local variable has the same name as one of the instance variables?");
			Btn[0].setText("Serialization");
			Btn[1].setText("Variable Shadowing");
			Btn[2].setText("Abstraction");
			Btn[3].setText("Multi-threading");		
		}
		if (current==5){
			label.setText("Q.6 Which of the following is true about the anonymous inner class?");
			Btn[0].setText("It has only methods");
			Btn[1].setText("Objects can't be created");
			Btn[2].setText("It has a fixed class name");
			Btn[3].setText("It has no class name");		
		}
		if (current==6){
			label.setText("Q.7 An interface with no fields or methods is known as a ______");
			Btn[0].setText("Runnable Interface");
			Btn[1].setText("Marker Interface");
			Btn[2].setText("Abstract Interface");
			Btn[3].setText("CharSequence Interface");		
		}
		if (current==7){
			label.setText("Q.8 Which of the following is an immediate subclass of the Panel class?");
			Btn[0].setText("Dialog class");
			Btn[1].setText("Window class");
			Btn[2].setText("Frame class");
			Btn[3].setText("Applet class");		
		}
		if (current==8){
			label.setText("Q.9 Which of the following is a valid syntax to synchronize the HashMap?");
			Btn[0].setText("Map m1 = Collections.synchronizedMap(hashMap);");
			Btn[1].setText("HashMap map =hashMap.synchronizeMap();");
			Btn[2].setText("Map m = hashMap.synchronizeMap();");
			Btn[3].setText("Map m2 = Collection.synchronizeMap(hashMap);");		
		}
		if (current==9){
			label.setText("Q.10 ) Given,  ArrayList list = new ArrayList(); What is the initial quantity of the ArrayList list?  ");
			Btn[0].setText("5");
			Btn[1].setText("0");
			Btn[2].setText("10");
			Btn[3].setText("100");		
	}
	
		label.setBounds(30, 40, 450, 20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			Btn[j].setBounds(50,80+i, 200, 20);
		
	}
   boolean check() {
	   if (current==0)
		   return (Btn[2].isSelected());
	   if (current==1)
		   return (Btn[1].isSelected());
	   if (current==2)
		   return (Btn[2].isSelected());
	   if (current==3)
		   return (Btn[3].isSelected());
	   if (current==4)
		   return (Btn[1].isSelected());
	   if (current==5)
		   return (Btn[2].isSelected());
	   if (current==6)
		   return (Btn[1].isSelected());
	   if (current==7)
		   return (Btn[3].isSelected());
	   if (current==8)
		   return (Btn[1].isSelected());
	   if (current==9)
		   return (Btn[2].isSelected());	 
	   return false;
   }
   
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				BtnNext.setEnabled(false);
				BtnBookMark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				BtnBookMark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
		try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                "root", "root1");

            PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("Select name, password from Signup UserName=? and Password=?");

            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                dispose();
                
              
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		
		
	}
   
	public static void main (String[]args) {
		new OnlineTest("Online Test Application");
		
	}
}

