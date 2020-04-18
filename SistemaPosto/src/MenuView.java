import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 


public class MenuView extends JFrame implements ActionListener{
    
    public static Container ctnTela;
    public static JLabel lblTitulo;
    public static JButton btnTanque,btnAbastecer, btnServicos, btnRelatorio;
    
    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    
    public MenuView() {
        super("Sistema Posto de Gasolina");
        ctnTela = new Container(); 
        ctnTela.setLayout(null);
        this.add(ctnTela);
        
        lblTitulo = new JLabel("Posto de Gasolina");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(285, 20, 230, 30);
        ctnTela.add(lblTitulo);
        
        btnTanque = new JButton("Abastecer tanque");
        btnTanque.setFont(fntTexto);
        btnTanque.addActionListener(this);
        btnTanque.setForeground(new Color(60, 60, 60));
        btnTanque.setBounds(90, 80, 300, 60);
        ctnTela.add(btnTanque);
        
        btnAbastecer = new JButton("Abastecer Carro");
        btnAbastecer.setFont(fntTexto);
        btnAbastecer.addActionListener(this);
        btnAbastecer.setForeground(new Color(60, 60, 60));
        btnAbastecer.setBounds(410, 80, 300, 60);
        ctnTela.add(btnAbastecer);
        
        btnServicos = new JButton("Serviços adicionais");
        btnServicos.setFont(fntTexto);
        btnServicos.addActionListener(this);
        btnServicos.setForeground(new Color(60, 60, 60));
        btnServicos.setBounds(90, 150, 620, 60);
        ctnTela.add(btnServicos);
        
        btnRelatorio = new JButton("Relatórios de venda");
        btnRelatorio.setFont(fntTexto);
        btnRelatorio.addActionListener(this);
        btnRelatorio.setForeground(new Color(60, 60, 60));
        btnRelatorio.setBounds(90, 220, 620, 60);
        ctnTela.add(btnRelatorio);
        
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 340);
        this.setVisible(true);
        
    }

    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == btnTanque){   
            TanqueView telaTanque = new TanqueView();
            JOptionPane.showMessageDialog(null, "Selecione o combustível que irá abastecer", "AVISO", JOptionPane.WARNING_MESSAGE);
            dispose();
        }else if (evt.getSource() == btnAbastecer){
            AbastecerView telaAbastecer = new AbastecerView();
            dispose();
        }else if (evt.getSource()==btnServicos){
            ServicosView telaServicos = new ServicosView();
            dispose();
        }else if (evt.getSource()==btnRelatorio){
            RelatorioView telaRelatorio = new RelatorioView();
            dispose();
        }
    }

 
}
