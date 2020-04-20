import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class ServicosView extends JFrame implements ActionListener{
    public static Container ctnServicos;
    public static JLabel lblTitulo, lblInvalido;
    public static JButton btnCafe, btnDucha, btnBalanceamento, btnTroca, btnVolta;
    public static JTextField txtTotal;
    
    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static int tmpComb, tmpQnt, tmpParte;
    
    public ServicosView (){
        super("Serviços");
        ctnServicos = new Container(); 
        ctnServicos.setLayout(null);
        this.add(ctnServicos);
        
        lblTitulo = new JLabel("Serviços do Posto");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(80, 10, 250, 30);
        ctnServicos.add(lblTitulo);
        
        lblTitulo = new JLabel("total:");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(200, 265, 100, 40);
        ctnServicos.add(lblTitulo);
        
        lblInvalido = new JLabel("");
        lblInvalido.setFont(fntTexto);
        lblInvalido.setForeground(new Color(250, 60, 60));
        lblInvalido.setBounds(50,60,200,20);
        ctnServicos.add(lblInvalido);
        
        txtTotal = new JTextField();
        txtTotal.setFont(fntTexto);
        txtTotal.setForeground(new Color(60, 60, 60));
        txtTotal.setBounds(275, 265, 100, 40);
        txtTotal.setEnabled(false);
        
        ctnServicos.add(txtTotal);
        
        btnCafe = new JButton("Café");
        btnCafe.setFont(fntTexto);
        btnCafe.addActionListener(this);
        btnCafe.setForeground(new Color(60, 60, 60));
        btnCafe.setBounds(5, 65, 180, 40);
        ctnServicos.add(btnCafe);
        
        btnCafe = new JButton("RS2,00");
        btnCafe.setFont(fntTexto);
        btnCafe.addActionListener(this);
        btnCafe.setEnabled(false);
        btnCafe.setForeground(new Color(60, 60, 60));
        btnCafe.setBounds(275, 65, 100, 40);
        ctnServicos.add(btnCafe);
        
        btnDucha = new JButton("Ducha ecólogica");
        btnDucha.setFont(fntTexto);
        btnDucha.addActionListener(this);
        btnDucha.setForeground(new Color(60, 60, 60));
        btnDucha.setBounds(5, 110, 180, 40);
        ctnServicos.add(btnDucha);
        
        btnDucha = new JButton("RS8,00");
        btnDucha.setFont(fntTexto);
        btnDucha.addActionListener(this);
        btnDucha.setForeground(new Color(60, 60, 60));
        btnDucha.setEnabled(false);
        btnDucha.setBounds(275, 110, 100, 40);
        ctnServicos.add(btnDucha);
        
        btnBalanceamento = new JButton("Balanceamento");
        btnBalanceamento.addActionListener(this);
        btnBalanceamento.setFont(fntTexto);
        btnBalanceamento.setForeground(new Color(60, 60, 60));
        btnBalanceamento.setBounds(5, 155, 180, 40);
        ctnServicos.add(btnBalanceamento);
        
        btnBalanceamento = new JButton("RS35,00");
        btnBalanceamento.setFont(fntTexto);
        btnBalanceamento.addActionListener(this);
        btnBalanceamento.setForeground(new Color(60, 60, 60));
        btnBalanceamento.setEnabled(false);
        btnBalanceamento.setBounds(275, 155, 100, 40);
        ctnServicos.add(btnBalanceamento);
        
        btnTroca = new JButton("Troca de óleo");
        btnTroca.setFont(fntTexto);
        btnTroca.addActionListener(this);
        btnTroca.setForeground(new Color(60, 60, 60));
        btnTroca.setBounds(5, 200, 180, 40);
        ctnServicos.add(btnTroca);
        
        btnTroca = new JButton("RS50,00");
        btnTroca.setFont(fntTexto);
        btnTroca.addActionListener(this);
        btnTroca.setForeground(new Color(60, 60, 60));
        btnTroca.setEnabled(false);
        btnTroca.setBounds(275, 200, 100, 40);
        ctnServicos.add(btnTroca);
        
        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);
        
        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(5, 275, 100, 30);
        btnVolta.addActionListener(this);
        ctnServicos.add(btnVolta);
        
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 340);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == btnVolta){
            this.dispose();
            new MenuView().setVisible(true);
        }else if(evt.getSource() == btnCafe){
            
            tmpComb = 0;
            habilitarCampos(tmpComb);
        }else if(evt.getSource() == btnDucha){
            
            tmpComb = 1;
            habilitarCampos(tmpComb);
        }else if(evt.getSource() == btnBalanceamento){
            
            tmpComb = 2;
            habilitarCampos(tmpComb);
        }else if(evt.getSource() == btnTroca){
            
            tmpComb = 3;
            habilitarCampos(tmpComb);
        }   
    }
    
    public void habilitarCampos(int tmpComb) {
        
        switch (tmpComb) {
            case 0:
                btnBalanceamento.setEnabled(false);
                btnTroca.setEnabled(false);
                btnDucha.setEnabled(false);
                break;
            case 1:
                btnBalanceamento.setEnabled(false);
                btnTroca.setEnabled(false);
               btnCafe.setEnabled(false);
                break;
            case 2:
                btnDucha.setEnabled(false);
                btnCafe.setEnabled(false);
                btnTroca.setEnabled(false);
                break;
            case 3:
                btnBalanceamento.setEnabled(false);
                btnCafe.setEnabled(false);
                btnDucha.setEnabled(false);
                break;
            default:
                btnBalanceamento.setEnabled(true);
                btnCafe.setEnabled(true);
                btnDucha.setEnabled(true);
                btnTroca.setEnabled(true);
                break;
        }
    }  
}
