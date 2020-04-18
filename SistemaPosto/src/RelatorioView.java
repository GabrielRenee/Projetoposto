import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
public class RelatorioView extends JFrame{
    public static Container ctnRelatorio;
    
    public RelatorioView(){
        super("Relatório");
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 340);
        this.setVisible(true);
    }
}
