/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesdemo;

import java.awt.*;
import java.awt.event.*;
public class Framesdemo extends Frame implements ActionListener
{
    Button b1,b2;
    Framesdemo()
    {
        setSize(1425,600);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        b1=new Button("close");
        b2=new Button("next");  
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
        
    }

    public static void main(String[] args)
    {
       Framesdemo d1=new Framesdemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==b1)
  {
      this.dispose();
  }
     if(e.getSource()==b2)
  {
      this.dispose();
      new First();
  }
    }
    
}

class First extends Frame implements ActionListener
{
    Button b1,b2;
    First()
    {
        setSize(1425,600);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        b1=new Button("close");
        b2=new Button("previous");  
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
        
    }

    public static void main(String[] args)
    {
       Framesdemo d1=new Framesdemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==b1)
  {
      this.dispose();
  }
   if(e.getSource()==b2)
  {
      new Framesdemo();
  }
    }
    
}


