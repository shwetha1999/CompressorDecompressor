/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compressor.compressor;
import compressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppFrame extends JFrame implements ActionListener{
    //inherete JFrame - It is a top level container that provides a window on screen
    JButton compressButton;//creat button
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //to close the output window with exit or close button
        this.setLayout(null);
        //setting up the layout

        compressButton=new JButton("Select file to compress");
        //creating JButton object
        compressButton.addActionListener(this);
        //when compressButton will be clicked that action will be noted
        //that perticular action will be noted
        compressButton.setBounds(20,100,200,30);
        //to give button dimension

        decompressButton=new JButton("Select file to decpmpress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);

        this.add(compressButton);//adding buttons in JFrame(Visibility)
        this.add(decompressButton);
        this.setSize(500,200);//size of JFrame
        this.getContentPane().setBackground(Color.black);
        //getContentPane() is used to hold the components present in My JFrame
        this.setVisible(true);
        // setting the visibility of JFrame which I have Built so far as true
    }

    @Override
    //Marker Annotations, No Values or element
    //to tell compiler to make sure method is overridden properly else generate error
    
    public void actionPerformed(ActionEvent e) {
        //ActionEvent --> A semantic event which indicates that a component - defined actoin occurred
        if(e.getSource()==compressButton){
            //when compressed button is clicked
            JFileChooser filechooser=new JFileChooser();
            //open an window for user to choose any kind of file from system
            int response=filechooser.showSaveDialog(null);
            //select file from system to save (or create a new one and save)
            if(response==JFileChooser.APPROVE_OPTION){
                //if selected file is use vaild  or if response =0;
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                //get the  path name of selected file
                System.out.println(file);
                //to path of file in console
                try{
                    compressor.method(file);
                     //perform compress operation
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }            
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }

        }
    }
    
}
