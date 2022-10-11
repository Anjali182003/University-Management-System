package university.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(725, 440, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        
        setVisible(true);
        
        int x=1;
        for (int i=4;i<=480; i+=5 ,x+=1){
            setLocation(480-((i+x)/3),400-(i/2));
            setSize(i + 3*x, i+x/2);
            
            try{
                Thread.sleep(10);             
            }catch (Exception e){}
        }
        t=new Thread(this);
        t.start();
        
    }
    public static void main(String args[]){
        new Splash();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(7000);
            setVisible(false);
            // Next Frame
            
            new login();
        }catch(Exception e){
            
        }
    }
}
