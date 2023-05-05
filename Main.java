import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main implements Runnable {
    JFrame frame;
    Thread t=null;
    int h=0,m=0,s=0;
    String timeString=" ";
    JButton b;
    Main() {
        frame=new JFrame();
        t=new Thread(this);
        t.start();
        b=new JButton();
        b.setBounds(100,100,100,50);
        frame.add(b);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void run() {
        try {
            while(true) {
                Calendar cal= Calendar.getInstance();
                h=cal.get(Calendar.HOUR_OF_DAY);
                if(h>12) h-=12;
                m=cal.get(Calendar.MINUTE);
                s=cal.get(Calendar.SECOND);


                SimpleDateFormat formater=new SimpleDateFormat("hh:mm:ss");
                Date date=cal.getTime();
                timeString=formater.format(date);
                printTime();
                t.sleep(1000);
            }
        }
        catch(Exception e) {}
    }
    public void printTime() {
        b.setText(timeString);

    }
    public static void main(String[] args) {
        new Main();

    }
}