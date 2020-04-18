import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class AbastecerView extends JFrame{
    public static Container ctnAbastecer;
    
    public AbastecerView(){
        super("Abastecer Carro");
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 340);
        this.setVisible(true);
    }
}
