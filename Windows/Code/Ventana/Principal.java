/*
Created-By : Emmanuel Acoltzi Bautista
Date: 15-03-2021
email: basedeemma@gmail.com
*/
package Ventana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Principal extends JFrame implements ActionListener{
    private JButton BOTON1;
    private JTextField TEXTO1;
    public Principal(){
    setLayout(null);
    setTitle("C");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    TEXTO1=new JTextField();
    TEXTO1.setEditable(false);
    TEXTO1.setBounds(10,10,200,30);
    add(TEXTO1);
    
    BOTON1=new JButton("...");
    BOTON1.setBounds(210,10,25,30);
    BOTON1.addActionListener(this);
    add(BOTON1);
    
    
    }
    @Override
    public void actionPerformed(ActionEvent A){
    if(A.getSource()==BOTON1){
        JFileChooser BUSCAR=new JFileChooser();
          BUSCAR.showOpenDialog(this);
          //direccion y archiv
           File archivo=BUSCAR.getSelectedFile();
            String root=archivo.getAbsolutePath();
          //direccion
          File rutaArchivo=BUSCAR.getCurrentDirectory();
          String DireccionArchivo=rutaArchivo.getAbsolutePath();
          
         System.out.println(root);
         System.out.println(DireccionArchivo);
         
          
          
          int cantidadTotal=(int) (DireccionArchivo.length());
          int cantidadArchivo=(int) root.length();
          System.out.println(cantidadTotal);
          System.out.println(cantidadArchivo);
          
          String archivoSolo="";
          
          for(int i=cantidadTotal+1;i<=cantidadArchivo-1;i++){
          archivoSolo+=root.substring(i, i+1);
          }
          System.out.println(archivoSolo);
          
          TEXTO1.setText(root);
          
          String c1="gcc -o pru "+archivoSolo;
          System.out.println(c1);
          try{
             ProcessBuilder lsProcessBuilder = new ProcessBuilder("cmd","/c",c1);
                
                // Establece el directorio de trabajo para el proceso ls
                lsProcessBuilder.directory(new File(DireccionArchivo+"/"));
                
                // Inicia el proceso ls
                Process lsProcess = lsProcessBuilder.start();
                lsProcess.waitFor();
           
          }catch(Exception E){
              System.out.println("error "+E);
          }finally{
              System.out.println("finalizo");
          }
          
    
    }
    }
public static void main(String args[]){

Principal Pi =new Principal();
Pi.setBounds(0,0,400,100);
Pi.setResizable(false);
Pi.setLocationRelativeTo(null);
Pi.setVisible(true);
}    
}
