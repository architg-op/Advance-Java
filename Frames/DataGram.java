/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagram;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author architgarg
 */
//Main Window
public class DataGram extends Frame implements ActionListener {
    Label lusnm,lpass,lor,ldont;
    TextField tusnm,tpass;
    Button bl,br,bc;
    DataGram()
    {
        setTitle("Login Window");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        lusnm=new Label("Username");
        lpass=new Label("Password");
        tusnm=new TextField(20);
        tpass=new TextField(20);
        bl=new Button("Log In");
        br=new Button("Register");
        bc=new Button("Close this tab");
        lor=new Label("OR");
        ldont=new Label("Don't have an account?");
        lusnm.setBounds(500,250,150,50);
        lpass.setBounds(500,300,150,50);
        tusnm.setBounds(650,260,150,30);
        tpass.setBounds(650,305,150,30);
        bl.setBounds(500,360,300,50);
        bc.setBounds(0,25,150,35);
        lor.setBounds(630,415,200,30);
        ldont.setBounds(570,450,200,40);
        br.setBounds(500,480,300,50);
        add(lusnm);
        add(lpass);
        add(tusnm);
        add(tpass);
        add(bl);
        add(br);
        add(bc);
        add(lor);
        add(ldont);
        bc.addActionListener(this);
        br.addActionListener(this);
        bl.addActionListener(this);
    }
    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataGram dt=new DataGram();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       //Close Button
        if(e.getSource()==bc)
        {
           // JOptionPane.showConfirmDialog(this,"Are u Sure to Close");
            this.dispose();
        }
        //Register Button
        if(e.getSource()==br)
        {
            this.dispose();
            Reg r=new Reg();
        }
        //Login Button
        if(e.getSource()==bl)
        {
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Datagram","root","mysql");
            PreparedStatement ps=con.prepareStatement("");
            ResultSet rs=ps.executeQuery("select * from datagram where username='"+tusnm.getText()+"' and password='"+tpass.getText()+"'");
        if(rs.next())
        {
           // JOptionPane.showMessageDialog(this,"Successfully Logged In!");
            this.dispose();
            LogIn l=new LogIn(tusnm.getText(),tpass.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Invalid Username and Password");
            tusnm.setText("");
            tpass.setText("");
        }
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            }
    }
    
}
//Registration Screen
 class Reg extends Frame implements ActionListener {
     Button bb,bsup;
     Label lem,lmb,lfnm,lusnm,lpass;
     TextField tem,tmb,tfnm,tusnm,tpass;
     Reg()
     {
         setVisible(true);
         setSize(1425,600);
         setTitle("Registeration");
         setLayout(null);
         bb=new Button("<");
         bsup=new Button("Sign Up");
         lem=new Label("Email");
         lmb=new Label("Mobile Number");
         lfnm=new Label("First Name");
         lusnm=new Label("UserName");
         lpass=new Label("Password");
         tem=new TextField(20);
         tmb=new TextField(20);
         tfnm=new TextField(20);
         tusnm=new TextField(20);
         tpass=new TextField(20);
         bb.setBounds(5,25,70,40);
         lem.setBounds(500,200,100,50);
         lmb.setBounds(500,260,100,50);
         lfnm.setBounds(500,320,100,50);
         lusnm.setBounds(500,380,100,50);
         lpass.setBounds(500,440,100,50);
         tem.setBounds(650,205,200,30);
         tmb.setBounds(650,265,200,30);
         tfnm.setBounds(650,325,200,30);
         tusnm.setBounds(650,385,200,30);
         tpass.setBounds(650,445,200,30);
         bsup.setBounds(500,500,350,50);
         add(bb);
         add(lem);
         add(tem);
         add(lmb);
         add(tmb);
         add(lfnm);
         add(tfnm);
         add(lusnm);
          add(tusnm);
         add(lpass);
         add(tpass);
         add(bsup);
         bb.addActionListener(this);
         bsup.addActionListener(this);
     }
    @Override
    public void actionPerformed(ActionEvent e) {
      //Back Button
      if(e.getSource()==bb)
        {
            this.dispose();
            DataGram dt=new DataGram();
        }
      //Sign Up Button
        if(e.getSource()==bsup)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Datagram","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into datagram values(?,?,?,?,?)");
        ps.setString(1,tem.getText());
        ps.setDouble(2,Double.parseDouble(tmb.getText()));
        ps.setString(3,tfnm.getText());
        ps.setString(4,tusnm.getText());
        ps.setString(5,tpass.getText());
        ps.executeUpdate();
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        }
    
    }
//LogInScreen
 class LogIn extends Frame implements ActionListener,ItemListener{
     Font f1=new Font("Courier",Font.ITALIC,20);
        Label lwel,lscs,lnm;
        Choice c;
        //char ch='\u2699';
      //  String s=String.valueOf(ch);
       LogIn(String s1,String s2)
       {
           setLayout(null);
           setSize(1425,600);
           setTitle("Dashboard");
           setVisible(true);
           try{
               Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Datagram","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from datagram where username='"+s1+"' and password='"+s2+"' ");
        lwel=new Label("Welcome, "+s1);
        lwel.setBounds(1150,10,150,50);
        lscs=new Label("Successfully Logged In!");
        lscs.setBounds(630,10,200,50);
        c=new Choice();
        c.setBounds(1300,10,120,50);
        c.addItem("Options");
        c.addItem("Log Out");
        add(c);
        add(lscs);
        add(lwel);
        c.addItemListener(this);
           }
           catch(Exception e1){
                System.out.println(e1);
            }
       }
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
       // LogIn m=new LogIn("hi","hello");
        String s1=c.getSelectedItem();
        String s2="Log Out";
        if(s1.equals(s2))
        {
            this.dispose();
            DataGram dt=new DataGram();
        }
    }
     
 }