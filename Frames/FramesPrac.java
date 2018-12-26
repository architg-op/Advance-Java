/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesprac;
import java.awt.*;
import java.awt.event.*;
/**
 
 * @author architgarg
 */
public class FramesPrac extends Frame implements ActionListener {
    Button b1,b2;
    
    FramesPrac()
    {
        setTitle("I am First");
        setVisible(true);
        setSize(1425,600);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        b1=new Button("Close");
        b2=new Button("Next");
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FramesPrac f=new FramesPrac();
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
            Sec c=new Sec();
        }
    }
    
}
 class Sec extends Frame implements ActionListener {
    Button b1,b2;
    
    Sec()
    {
        setTitle("I am Second");
        setVisible(true);
        setSize(1425,600);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        b1=new Button("Close");
        b2=new Button("Previous");
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    /**
     * @param args the command line arguments
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
        this.dispose();
        }
        if(e.getSource()==b2)
        {
            this.dispose();
            FramesPrac f=new FramesPrac();
        }
    }
    
}
