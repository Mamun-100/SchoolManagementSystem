/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproject;
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  
import static javax.swing.JFrame.EXIT_ON_CLOSE;

    public class WordCharCount extends JFrame implements ActionListener{  
        JLabel lb1,lb2;  
        JTextArea ta;  
        JButton b;  
        JButton pad,text;  
        WordCharCount(){  
            super("Word Count");  
            lb1=new JLabel("Characters: ");  
            lb1.setBounds(50,20,100,20);  
            lb2=new JLabel("Words: ");  
            lb2.setBounds(50,70,100,20);  
              
            ta=new JTextArea();  
            ta.setBounds(50,110,300,200);  
              
            b=new JButton("click");  
            b.setBounds(50,340, 80,30);
            b.addActionListener(this);  
          
            pad=new JButton("Background Color");  
            pad.setBounds(140,340, 110,30);
            pad.addActionListener(this);  
      
            text=new JButton("Text Color");  
            text.setBounds(260,340, 110,30);
            text.addActionListener(this);  
      
            add(lb1);add(lb2);add(ta);add(b);add(pad);add(text);  
              
            setSize(400,450);  
            setLayout(null);
            setLocation(480,150);
            setVisible(true);  
            setDefaultCloseOperation(EXIT_ON_CLOSE);  
        }  
        public void actionPerformed(ActionEvent e){  
            if(e.getSource()==b){  
            String text=ta.getText();  
            lb1.setText("Characters: "+text.length());  
            String words[]=text.split("\\s");  
            lb2.setText("Words: "+words.length);  
            }else if(e.getSource()==pad){  
                Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
                ta.setBackground(c);  
            }else if(e.getSource()==text){  
                Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
                ta.setForeground(c);  
            }  
        }  
    public static void main(String[] args) {  
        new WordCharCount();  
    }  

   
}
