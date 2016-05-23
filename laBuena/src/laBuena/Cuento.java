package laBuena;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Cuento extends JFrame {

    private JPanel contentPane;

    Cuento frame;
        
    
    

    public Cuento(String Cuento) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 768, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        LectorCuentos lect = new LectorCuentos(Cuento,this);
        contentPane.add(lect);
        
        try {
            frame = this;
            frame.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setVisible(){frame.setVisible(true);}
    
    

}