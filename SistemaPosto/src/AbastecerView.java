import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class AbastecerView extends JFrame implements ActionListener{
    public static Container ctnAbastecer;
    public static JLabel lblTitulo, lblInvalido;
    public static JButton btnEta, btnGas, btnAdt, btnDis, btnVolta, btnAbastecer;
    public static JTextField txtLitros, txtTotal;
    
    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static int tmpComb, tmpQnt, tmpParte;
    
    public AbastecerView(){
        super("Abastecer Tanque");
        ctnAbastecer = new Container(); 
        ctnAbastecer.setLayout(null);
        this.add(ctnAbastecer);
        
        
        
        
        lblTitulo = new JLabel("Abastecer Tanque");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(200, 20, 250, 30);
        ctnAbastecer.add(lblTitulo);
        
        
        lblInvalido = new JLabel("");
        lblInvalido.setFont(fntTexto);
        lblInvalido.setForeground(new Color(250, 60, 60));
        lblInvalido.setBounds(50,60,200,20);
        ctnAbastecer.add(lblInvalido);
        
        txtLitros = new JTextField();
        txtLitros.setFont(fntTexto);
        txtLitros.setForeground(new Color(60, 60, 60));
        txtLitros.setBounds(50, 80, 200, 40);
        txtLitros.setEnabled(false);
        
        ctnAbastecer.add(txtLitros);

        txtTotal = new JTextField();
        txtTotal.setFont(fntTexto);
        txtTotal.setForeground(new Color(60, 60, 60));
        txtTotal.setBounds(50, 180, 200, 40);
        txtTotal.setEnabled(false);
        
        ctnAbastecer.add(txtTotal);
        
        btnAbastecer = new JButton("Abastecer");
        btnAbastecer.setFont(fntTexto);
        btnAbastecer.setForeground(new Color(60, 60, 60));
        btnAbastecer.setBounds(50, 130, 200, 40);
        btnAbastecer.setEnabled(false);
        ctnAbastecer.add(btnAbastecer);
        
        btnEta = new JButton("Etanol");
        btnEta.setFont(fntTexto);
        btnEta.addActionListener(this);
        btnEta.setForeground(new Color(60, 60, 60));
        btnEta.setBounds(350, 80, 200, 40);
        ctnAbastecer.add(btnEta);
        
        btnGas = new JButton("Gasolina Comum");
        btnGas.setFont(fntTexto);
        btnGas.addActionListener(this);
        btnGas.setForeground(new Color(60, 60, 60));
        btnGas.setBounds(350, 125, 200, 40);
        ctnAbastecer.add(btnGas);
        
        btnAdt = new JButton("Gasolina Aditivada");
        btnAdt.addActionListener(this);
        btnAdt.setFont(fntTexto);
        btnAdt.setForeground(new Color(60, 60, 60));
        btnAdt.setBounds(350, 170, 200, 40);
        ctnAbastecer.add(btnAdt);
        
        btnDis = new JButton("Diesel");
        btnDis.setFont(fntTexto);
        btnDis.addActionListener(this);
        btnDis.setForeground(new Color(60, 60, 60));
        btnDis.setBounds(350, 215, 200, 40);
        ctnAbastecer.add(btnDis);
        
        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);
        
        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(50, 255, 100, 30);
        btnVolta.addActionListener(this);
        ctnAbastecer.add(btnVolta);
        
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 340);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == btnVolta){
            this.dispose();
            new MenuView().setVisible(true);
        }else if(evt.getSource() == btnEta){
            
            tmpComb = 0;
            habilitarCampos(tmpComb);
        }else if(evt.getSource() == btnGas){
            
            tmpComb = 1;
            habilitarCampos(tmpComb);
        }else if(evt.getSource() == btnAdt){
            
            tmpComb = 2;
            habilitarCampos(tmpComb);
        }else if(evt.getSource() == btnDis){
            
            tmpComb = 3;
            habilitarCampos(tmpComb);
        }
        
        if(evt.getSource() == btnAbastecer){
            try{
                tmpQnt = Integer.parseInt(txtLitros.getText());
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
                txtLitros.setEnabled(true);
                btnAbastecer.setEnabled(true);
                btnAdt.setEnabled(false);
                btnDis.setEnabled(false);
                btnGas.setEnabled(false);
                break;
            case 1:
                txtLitros.setEnabled(true);
                btnAbastecer.setEnabled(true);
                btnAdt.setEnabled(false);
                btnDis.setEnabled(false);
                btnEta.setEnabled(false);
                break;
            case 2:
                txtLitros.setEnabled(true);
                btnAbastecer.setEnabled(true);
                btnGas.setEnabled(false);
                btnEta.setEnabled(false);
                btnDis.setEnabled(false);
                break;
            case 3:
                txtLitros.setEnabled(true);
                btnAbastecer.setEnabled(true);
                btnAdt.setEnabled(false);
                btnEta.setEnabled(false);
                btnGas.setEnabled(false);
                break;
            default:
                txtLitros.setEnabled(false);
                txtLitros.setText("");
                btnAbastecer.setEnabled(false);
                btnAdt.setEnabled(true);
                btnEta.setEnabled(true);
                btnGas.setEnabled(true);
                btnDis.setEnabled(true);
                break;
        }
    }
}