/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author architgarg
 */
public class Library extends Applet implements ActionListener,ItemListener{
     Label lbid,lbnm,lbs,lbc;
     TextField tbid,tbnm,tbs,tbc;
     Button bs,bv,bd;
    List lst;
     Choice c;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     @Override
    public void init() 
    {
        setLayout(null);
        lbid=new Label("Book ID");
        lbid.setBounds(400,150,150,50);
        lbnm=new Label("Book Name");
        lbnm.setBounds(400,210,150,50);
        lbs=new Label("Book Shelf");
        lbs.setBounds(400,270,150,50);
        lbc=new Label("Book Cost");
        lbc.setBounds(400,330,150,50);
     //   tbid=new TextField(6);
        c=new Choice();
        c.setBounds(600,160,140,25);
        tbnm=new TextField(20);
        tbnm.setBounds(600,220,140,25);
        tbs=new TextField(6);
        tbs.setBounds(600,280,140,25);
        tbc=new TextField(10);
        tbc.setBounds(600,340,140,25);
        bs=new Button("Submit");
        bs.setBounds(420,400,100,40);
        bv=new Button("View");
        bv.setBounds(600,400,100,40);
        lst=new List();
        lst.setBounds(870,160,100,200);
        bd=new Button("Delete");
        bd.setBounds(420,460,100,40);
        c.add("Select");
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","mysql");
                PreparedStatement ps=con.prepareStatement("select book_id from Books");
              //  ps.setInt(1,Integer.parseInt(tbid.getText()));
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    c.add(String.valueOf(rs.getInt(1)));
                    lst.add(String.valueOf(rs.getInt(1)));
                   
                }
                JOptionPane.showMessageDialog(lbnm,"Deleted");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        add(lbid);
        add(c);
        add(lbnm);
        add(tbnm);
        add(lbs);
        add(tbs);
        add(lbc);
        add(tbc);
        add(bs);
        add(bv);
        add(bd);
        add(lst);
        bs.addActionListener(this);
        bv.addActionListener(this);
        bd.addActionListener(this);
        lst.addItemListener(this);
        c.addItemListener(this);
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bs)
        {
        try{
            Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","mysql");
PreparedStatement ps=con.prepareStatement("insert into Books values(?,?,?,?)");
ps.setInt(1,Integer.parseInt(tbid.getText()));
ps.setString(2,tbnm.getText());
ps.setString(3,tbs.getText());
ps.setDouble(4,Double.parseDouble(tbc.getText()));
ps.executeUpdate();
        }
        catch(Exception e1)
                {
                    System.out.println(e1);
                }
    }
        if(e.getSource()==bv)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","mysql");
                PreparedStatement ps=con.prepareStatement("select * from Books where book_id=?");
                ps.setInt(1,Integer.parseInt(tbid.getText()));
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    tbnm.setText(rs.getString(2));
                    tbs.setText(rs.getString(3));
                    tbc.setText(rs.getString(4));
                }
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        if(e.getSource()==bd)
        {
            try{
              //  String s=c.getSelectedItem();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","mysql");
                PreparedStatement ps=con.prepareStatement("delete from Books where book_id=?");
                ps.setInt(1,Integer.parseInt(c.getSelectedItem()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this,"Record Deleted");
                    tbnm.setText("");
                    tbs.setText("");
                    tbc.setText("");
                    lst.removeAll();
                    getlistdata();
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==lst)
        {
        try{
        String s=lst.getSelectedItem();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from Books where book_id=?");
        ps.setInt(1,Integer.parseInt(s));
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            //tbid.setText(rs.getString(1));
            tbnm.setText(rs.getString(2));
            tbs.setText(rs.getString(3));
            tbc.setText(rs.getString(4));
        }
        }
        catch(Exception e1){
                System.out.println(e1);
            }
        }
        if(e.getSource()==c)
        {
            try{
                String s=c.getSelectedItem();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from Books where book_id=?");
        ps.setInt(1,Integer.parseInt(s));
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            tbnm.setText(rs.getString(2));
            tbs.setText(rs.getString(3));
            tbc.setText(rs.getString(4));
        }
        }
                    catch(Exception e1){
                System.out.println(e1);
            }
        }
    }
    void getlistdata()
    {
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
                PreparedStatement ps=con.prepareStatement("select book_id from Books");
           
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                   lst.addItem(String.valueOf(rs.getInt(1)));
                }
            }
            catch(Exception g)
            {
                System.out.println((g));
            }

    }
}

