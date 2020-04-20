import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class ServicosView extends JFrame implements ActionListener{
    public static Container ctnServicos;
    public static JLabel lblTitulo, lblInvalido;
    public static JButton btnCafe, btnDucha, btnBalanceamento, btnTroca, btnVolta, btnConcluir;
    public static JTextField txtTotal;
    
    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static Font fntTotal = new Font("Arial", Font.BOLD, 18);
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
        
        lblTitulo = new JLabel("TOTAL:");
        lblTitulo.setFont(fntTotal);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(215, 250, 100, 40);
        ctnServicos.add(lblTitulo);
        
        lblInvalido = new JLabel("");
        lblInvalido.setFont(fntTexto);
        lblInvalido.setForeground(new Color(250, 60, 60));
        lblInvalido.setBounds(50,60,200,20);
        ctnServicos.add(lblInvalido);
        
        txtTotal = new JTextField();
        txtTotal.setFont(fntTexto);
        txtTotal.setForeground(new Color(60, 60, 60));
        txtTotal.setBounds(310, 260, 110, 55);
        txtTotal.setEnabled(false);
        
        ctnServicos.add(txtTotal);
        
        btnCafe = new JButton("Café");
        btnCafe.setFont(fntTexto);
        btnCafe.addActionListener(this);
        btnCafe.setForeground(new Color(60, 60, 60));
        btnCafe.setBounds(15, 65, 180, 40);
        ctnServicos.add(btnCafe);
        
        btnCafe = new JButton("R$2,00");
        btnCafe.setFont(fntTexto);
        btnCafe.addActionListener(this);
        btnCafe.setEnabled(false);
        btnCafe.setForeground(new Color(60, 60, 60));
        btnCafe.setBounds(310, 65, 110, 40);
        ctnServicos.add(btnCafe);
        
        btnDucha = new JButton("Ducha ecólogica");
        btnDucha.setFont(fntTexto);
        btnDucha.addActionListener(this);
        btnDucha.setForeground(new Color(60, 60, 60));
        btnDucha.setBounds(15, 110, 180, 40);
        ctnServicos.add(btnDucha);
        
        btnDucha = new JButton("R$8,00");
        btnDucha.setFont(fntTexto);
        btnDucha.addActionListener(this);
        btnDucha.setForeground(new Color(60, 60, 60));
        btnDucha.setEnabled(false);
        btnDucha.setBounds(310, 110, 110, 40);
        ctnServicos.add(btnDucha);
        
        btnBalanceamento = new JButton("Balanceamento");
        btnBalanceamento.addActionListener(this);
        btnBalanceamento.setFont(fntTexto);
        btnBalanceamento.setForeground(new Color(60, 60, 60));
        btnBalanceamento.setBounds(15, 155, 180, 40);
        ctnServicos.add(btnBalanceamento);
        
        btnBalanceamento = new JButton("R$35,00");
        btnBalanceamento.setFont(fntTexto);
        btnBalanceamento.addActionListener(this);
        btnBalanceamento.setForeground(new Color(60, 60, 60));
        btnBalanceamento.setEnabled(false);
        btnBalanceamento.setBounds(310, 155, 110, 40);
        ctnServicos.add(btnBalanceamento);
        
        btnTroca = new JButton("Troca de óleo");
        btnTroca.setFont(fntTexto);
        btnTroca.addActionListener(this);
        btnTroca.setForeground(new Color(60, 60, 60));
        btnTroca.setBounds(15, 200, 180, 40);
        ctnServicos.add(btnTroca);
        
        btnTroca = new JButton("R$ 50,00");
        btnTroca.setFont(fntTexto);
        btnTroca.addActionListener(this);
        btnTroca.setForeground(new Color(60, 60, 60));
        btnTroca.setEnabled(false);
        btnTroca.setBounds(310, 200, 110, 40);
        ctnServicos.add(btnTroca);
        
        btnConcluir = new JButton("Concluir");
        btnConcluir.setFont(fntTexto);
        btnConcluir.addActionListener(this);
        btnConcluir.setForeground(new Color(60, 60, 60));
        btnConcluir.setBounds(200, 280, 97, 35);
        btnConcluir.setEnabled(false);
        ctnServicos.add(btnConcluir);
        
        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);
        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(15, 280, 97, 35);
        btnVolta.addActionListener(this);
        ctnServicos.add(btnVolta);
        
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(440, 365);
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
        if(evt.getSource() == btnConcluir){
            try{
                tmpQnt = Integer.parseInt(txtTotal.getText());
                lblInvalido.setText("");
            }catch (NumberFormatException e){
                lblInvalido.setText("Número Inválido");
            }
            habilitarCampos(56);
            SistemaControl.objPosto.abastecerTanque(tmpComb, tmpQnt);
            
        }
    }
    
    public void habilitarCampos(int tmpComb) {
        
        switch (tmpComb) {
            case 0:
                btnConcluir.setEnabled(true);
                btnBalanceamento.setEnabled(false);
                btnTroca.setEnabled(false);
                btnDucha.setEnabled(false);
                break;
            case 1:
                btnConcluir.setEnabled(true);
                btnBalanceamento.setEnabled(false);
                btnTroca.setEnabled(false);
               btnCafe.setEnabled(false);
                break;
            case 2:
                btnConcluir.setEnabled(true);
                btnDucha.setEnabled(false);
                btnCafe.setEnabled(false);
                btnTroca.setEnabled(false);
                break;
            case 3:
                btnConcluir.setEnabled(true);
                btnBalanceamento.setEnabled(false);
                btnCafe.setEnabled(false);
                btnDucha.setEnabled(false);
                break;
            default:
                btnConcluir.setEnabled(false);
                btnBalanceamento.setEnabled(true);
                btnCafe.setEnabled(true);
                btnDucha.setEnabled(true);
                btnTroca.setEnabled(true);
                break;
        }
    }  
}