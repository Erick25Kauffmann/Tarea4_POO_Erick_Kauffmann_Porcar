import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton implements ActionListener {
	
	JFrame frame;
    JButton button;
    JPanel panel;
    
    boolean activo = false;
    
    public Boton(){
        frame = new JFrame("Boton (Client)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Enceder");
        button.addActionListener(this);
        button.setActionCommand("encender");

        panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.EAST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getActionCommand().equals("encender")){
            button.setText("apagar");
            button.setActionCommand("apagar");
            activo = true;
        }
        else{
            button.setText("encender");
            button.setActionCommand("encender");
            activo = false;
        }
    }

}
