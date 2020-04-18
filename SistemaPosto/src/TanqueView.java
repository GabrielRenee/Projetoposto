import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class TanqueView extends JFrame{
    public static Container ctnTanque;
    
    public TanqueView(){
        super("Abastecer Tanque");
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 340);
        this.setVisible(true);
    }

    
}
