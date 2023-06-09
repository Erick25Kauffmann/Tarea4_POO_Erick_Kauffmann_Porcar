import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Etiqueta implements Runnable{
	JFrame frame;
    JLabel blinker;
    JPanel panel;
    
    boolean activo = false;
    
    public Etiqueta(){
        frame = new JFrame("Etiqueta (Server)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        blinker = new JLabel();
        blinker.setPreferredSize(new Dimension(100, 100));
        blinker.setOpaque(true);
        blinker.setBackground(Color.WHITE);

        panel = new JPanel(new BorderLayout());
        panel.add(blinker, BorderLayout.WEST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        //blink();
    }
    
    private void blink(){
        while(true){
            //OJO, se necesita esta pausa
            //System.out.println(activo);
        	try {
	            if (activo){
	                try {
	                    blinker.setBackground(Color.YELLOW);
	                    Thread.sleep(500);
	                    blinker.setBackground(Color.WHITE);
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {   
	                    e.printStackTrace();
	                }
	            }
        	Thread.sleep(500);
        	} catch (InterruptedException e) {   
                e.printStackTrace();
            }
        }
    }
    
    

	@Override
	public void run() {
		blink();
		
	}
}
