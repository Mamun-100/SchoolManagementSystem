/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_notepade;

import com.sun.glass.events.KeyEvent;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 *
 * @author Os-10
 */
public class Java_Notepade extends JFrame {
    
    JTextArea mainarea;
    JMenuBar mbar;
    JMenu mnuFile, mnuEdit, mnuFormat,mnuHelp;
    JMenuItem itmNew, itmOpen,itmSave,itmSaveas,itmExit;
    String filename;
    JFileChooser jc;

    public Java_Notepade(){
        initComponent();
        itmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                save();
            }
        });
        itmSaveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saveAs();
            }
        });
        itmOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               open();
            }
        });
    }
    private void initComponent(){
        jc = new JFileChooser(".");
    mainarea = new JTextArea();
    getContentPane().add(mainarea);
    getContentPane().add(new JScrollPane(mainarea),BorderLayout.CENTER);
    setTitle("Untitle Notepade");
    setSize(600,600);
    //menubar
    mbar = new JMenuBar();
    //menu
    mnuFile = new JMenu("File");
    mnuEdit = new JMenu("Edit");
    mnuFormat = new JMenu("Format");
    mnuHelp = new JMenu("Help");
    //add icon to menu icon
    ImageIcon newIcon = new ImageIcon(getClass().getResource("/images/new.png"));
    ImageIcon openIcon = new ImageIcon(getClass().getResource("/images/open.png"));
    ImageIcon saveIcon = new ImageIcon(getClass().getResource("/images/save.png"));
    ImageIcon saveasIcon = new ImageIcon(getClass().getResource("/images/saveas.png"));
    //menuItem
    itmNew = new JMenuItem("New",newIcon);
    itmOpen = new JMenuItem("Open",openIcon);
    itmSave = new JMenuItem("Save",saveIcon);
    itmSaveas = new JMenuItem("Save As",saveasIcon);
    // add shortcut
    itmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    itmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    itmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    //add menu item
    mnuFile.add(itmNew);
    mnuFile.add(itmOpen);
    mnuFile.add(itmSave);
    mnuFile.add(itmSaveas);
    
    //add menu item to menu bar
    mbar.add(mnuFile);
    mbar.add(mnuEdit);
    mbar.add(mnuFormat);
    mbar.add(mnuHelp);
    //add menubar to frame
    setJMenuBar(mbar);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    
    }
    
    // save file
    private void save(){
        PrintWriter fout = null;
        int retval = -1;
        try{
           
        if(filename == null){
            saveAs();
            retval = jc.showSaveDialog(this);
        if(retval == JFileChooser.APPROVE_OPTION){
        fout = new PrintWriter(new FileWriter(jc.getSelectedFile()));
        }
        String s = mainarea.getText();
        StringTokenizer st = new StringTokenizer(s,System.getProperty("line.separator"));
            while (st.hasMoreElements()) {
                fout.println(st.nextToken());
            }
            JOptionPane.showMessageDialog(rootPane, "File saved");
            filename = jc.getSelectedFile().getName();
            setTitle( filename = jc.getSelectedFile().getName());
        }else{      
         fout = new PrintWriter(new FileWriter(filename));
          String s = mainarea.getText();
        StringTokenizer st = new StringTokenizer(s,System.getProperty("line.separator"));
            while (st.hasMoreElements()) {
                fout.println(st.nextToken());
            }
            JOptionPane.showMessageDialog(rootPane, "File saved");
        }
        
        }catch(IOException e){
        
        }finally{
        fout.close();
        }
    }
    
    //saveAs method
    
    private void saveAs(){
         PrintWriter fout = null;
        int retval = -1;
        try {
            retval = jc.showSaveDialog(this);
        if(retval == JFileChooser.APPROVE_OPTION){
        fout = new PrintWriter(new FileWriter(jc.getSelectedFile()));
        }
        String s = mainarea.getText();
        StringTokenizer st = new StringTokenizer(s,System.getProperty("line.separator"));
            while (st.hasMoreElements()) {
                fout.println(st.nextToken());
            }
            JOptionPane.showMessageDialog(rootPane, "File saved");
            filename = jc.getSelectedFile().getName();
            setTitle( filename = jc.getSelectedFile().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // open method
    private  void open(){
        try {
            int retval = jc.showOpenDialog(this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                mainarea.setText(null);
                Reader in = new FileReader(jc.getSelectedFile());
                char[] buff = new char[100000];
                int nch;
                while((nch = in.read(buff,0,buff.length)) != -1){
                mainarea.append(new String(buff,0, nch));
                }
            }
             filename = jc.getSelectedFile().getName();
            setTitle( filename = jc.getSelectedFile().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Java_Notepade jn = new Java_Notepade();
        
    }
}
