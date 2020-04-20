
import java.awt.event.*; 
import java.awt.*; 
import java.text.DecimalFormat;
import javax.swing.*; 

public class RelatorioView extends JFrame implements ActionListener{
    public static Container ctnRelatorio;
    public static JLabel lblTitulo;
    public static JTextPane txtTanques, txtVendas, txtDespesas, txtLucros;
    public static JButton btnVendas, btnTanques, btnDespesas,btnLucros, btnVolta;
    
    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    DecimalFormat df = new DecimalFormat("0.000"); //Preços
    DecimalFormat rs = new DecimalFormat("0.00"); //Litros
    
    public RelatorioView(){
        super("Relatório");
        ctnRelatorio = new Container();
        ctnRelatorio.setLayout(null);
        this.add(ctnRelatorio);
        
        lblTitulo = new JLabel("Relatórios");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(230, 20, 250, 30);
        ctnRelatorio.add(lblTitulo);
        
        btnTanques = new JButton("Tanques");
        btnTanques.setFont(fntTexto);
        btnTanques.setForeground(new Color(60, 60, 60));
        btnTanques.setBounds(37, 60, 120, 40);
        btnTanques.addActionListener(this);
        ctnRelatorio.add(btnTanques);
        
        btnVendas = new JButton("Vendas");
        btnVendas.setFont(fntTexto);
        btnVendas.setForeground(new Color(60, 60, 60));
        btnVendas.setBounds(167, 60, 120, 40);
        ctnRelatorio.add(btnVendas);
        btnVendas.addActionListener(this);
        
        btnLucros = new JButton("Lucros");
        btnLucros.setFont(fntTexto);
        btnLucros.setForeground(new Color(60, 60, 60));
        btnLucros.setBounds(297, 60, 120, 40);
        ctnRelatorio.add(btnLucros);
        btnLucros.addActionListener(this);

        btnDespesas = new JButton("Despesas");
        btnDespesas.setFont(fntTexto);
        btnDespesas.setForeground(new Color(60, 60, 60));
        btnDespesas.setBounds(427, 60, 120, 40);
        ctnRelatorio.add(btnDespesas);
        
        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);
        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(37, 110, 100, 30);
        btnVolta.addActionListener(this);
        ctnRelatorio.add(btnVolta);
                
        txtTanques = new JTextPane();
        txtTanques.setEditable(false);
        txtTanques.setForeground(new Color(0, 0, 0));
        txtTanques.setBounds(37,120,510,150);
        txtTanques.setFont(fntTexto);
        ctnRelatorio.add(txtTanques);
        txtTanques.setVisible(false);
        txtTanques.setText("Situação atual dos tanques:\n\n"
                + "1 - Etanol  -------------------------------------- " + df.format(SistemaControl.objPosto.tanques[0]) + " litros\n"
                + "2 - Gasolina Comum  -------------------------- " + df.format(SistemaControl.objPosto.tanques[1]) + " litros\n"
                + "3 - Gasolina Aditivada  ------------------------ " + df.format(SistemaControl.objPosto.tanques[2]) + " litros\n"
                + "4 - Diesel  -------------------------------------- " + df.format(SistemaControl.objPosto.tanques[3]) + " litros"
        );
        
        txtVendas = new JTextPane();
        txtVendas.setEditable(false);
        txtVendas.setForeground(new Color(0, 0, 0));
        txtVendas.setBounds(37,120,510,360);
        txtVendas.setFont(fntTexto);
        ctnRelatorio.add(txtVendas);
        txtVendas.setVisible(false);
        txtVendas.setText("Combustíveis vendidos:\n\n" +
                "Etanol --------------------------------- " + df.format(SistemaControl.objPosto.lVend[0]) + " litros | R$ " + rs.format(SistemaControl.objPosto.lVend[0] * SistemaControl.objPosto.valorVend[0]) + "\n"+
                "Gasolina Comum --------------------- " + df.format(SistemaControl.objPosto.lVend[1]) + " litros | R$ " + rs.format(SistemaControl.objPosto.lVend[1] * SistemaControl.objPosto.valorVend[1]) + "\n"+
                "Gasolina Aditivada ------------------- " + df.format(SistemaControl.objPosto.lVend[2]) + " litros  | R$ " + rs.format(SistemaControl.objPosto.lVend[2] * SistemaControl.objPosto.valorVend[2]) + "\n"+
                "Diesel --------------------------------- " + df.format(SistemaControl.objPosto.lVend[3]) + " litros  | R$ " + rs.format(SistemaControl.objPosto.lVend[3] * SistemaControl.objPosto.valorVend[3]) + "\n"+
                "Total  --------------------------------- " + df.format(SistemaControl.objPosto.lVend[4]) + " litros  | R$ " + rs.format(SistemaControl.objPosto.lucros) + "\n"+
                " ------------------------------------------------------------------------\n"+
                "Serviços vendidos:\n\n"+
                "Ducha Ecológica --------------------------------  " + SistemaControl.objPosto.servicos[0] + " | R$" + rs.format(SistemaControl.objPosto.servicos[0] * 8.00) + "\n" +
                "Troca de óleo -----------------------------------  " + SistemaControl.objPosto.servicos[1] + " | R$" + rs.format(SistemaControl.objPosto.servicos[1] * 50.00) + "\n" +
                "Balanceamento ---------------------------------  " + SistemaControl.objPosto.servicos[2] + " | R$" + rs.format(SistemaControl.objPosto.servicos[2] * 35.00) + "\n" +
                "Café ---------------------------------------------  " + SistemaControl.objPosto.servicos[3] + " | R$" + rs.format(SistemaControl.objPosto.servicos[3] * 2.00) + "\n" +
                "Total --------------------------------------------- " + SistemaControl.objPosto.servicos[4] + " | R$ " + rs.format(SistemaControl.objPosto.lucroServ) + "\n");
        
        txtLucros = new JTextPane();
        txtLucros.setEditable(false);
        txtLucros.setForeground(new Color(0, 0, 0));
        txtLucros.setBounds(37,120,510,500);
        txtLucros.setFont(fntTexto);
        ctnRelatorio.add(txtLucros);
        txtLucros.setVisible(false);
        txtLucros.setText("Combustíveis:\n\n"+
                "Lucro bruto = R$ " + rs.format(SistemaControl.objPosto.lucros) + "\n"+
                "Lucro líquido = R$ " + rs.format((SistemaControl.objPosto.lucros - SistemaControl.objPosto.despesas)) + "\n"+
                " ------------------------------------------------------------------------\n"+
                "Serviços:\n\n"+
                "Lucro bruto: R$ " + rs.format(SistemaControl.objPosto.lucroServ) + "\n"+ //Como não há despesas com serviços, o lucro é bruto
                "-------------------------\n"+
                "Total:\n"+
                "Lucros Brutos: R$ " + rs.format((SistemaControl.objPosto.lucros + SistemaControl.objPosto.lucroServ)) + "\n" +
                "Lucros Líquidos: R$ " + rs.format(((SistemaControl.objPosto.lucros - SistemaControl.objPosto.despesas) + SistemaControl.objPosto.lucroServ)) + "\n");
        
        txtDespesas = new JTextPane();
        txtDespesas.setEditable(false);
        txtDespesas.setForeground(new Color(0, 0, 0));
        txtDespesas.setBounds(37,120,547,200);
        txtDespesas.setFont(fntTexto);
        ctnRelatorio.add(txtDespesas);
        txtDespesas.setVisible(false);
        txtDespesas.setText("Despesas:\n\n"
                + "1 - Etanol  -------------------------------------- " + df.format(SistemaControl.objPosto.lCmp[0]) + " litros | R$"+ rs.format(SistemaControl.objPosto.lCmp[0]*SistemaControl.objPosto.valorCmp[0])+ "\n"
                + "2 - Gasolina Comum  -------------------------- " + df.format(SistemaControl.objPosto.lCmp[1]) + " litros | R$"+ rs.format(SistemaControl.objPosto.lCmp[1]*SistemaControl.objPosto.valorCmp[1])+ "\n"
                + "3 - Gasolina Aditivada  ------------------------ " + df.format(SistemaControl.objPosto.lCmp[2]) + " litros | R$"+ rs.format(SistemaControl.objPosto.lCmp[2]*SistemaControl.objPosto.valorCmp[2])+ "\n"
                + "4 - Diesel  -------------------------------------- " + df.format(SistemaControl.objPosto.lCmp[3]) + " litros | R$" + rs.format(SistemaControl.objPosto.lCmp[3]*SistemaControl.objPosto.valorCmp[3])
                + "\n Total - " + df.format(SistemaControl.objPosto.lCmp[4]) + " litros | R$" + rs.format(SistemaControl.objPosto.despesas)
        );
        
        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 180);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == btnVolta){
            this.dispose();
            new MenuView().setVisible(true);
        }else if(evt.getSource() == btnTanques){
            this.setSize(600,340);
            txtTanques.setVisible(true);
            txtVendas.setVisible(false);
            txtLucros.setVisible(false);
            txtDespesas.setVisible(false);
            
            btnVolta.setBounds(37, 275, 100, 30); 
        }else if(evt.getSource() == btnVendas){
            this.setSize(600,550);
            txtTanques.setVisible(false);
            txtVendas.setVisible(true);
            txtLucros.setVisible(false);
            txtDespesas.setVisible(false);
            
            btnVolta.setBounds(37, 485, 100, 30);
        }else if(evt.getSource() == btnLucros){
            this.setSize(600,550);
            txtTanques.setVisible(false);
            txtVendas.setVisible(false);
            txtLucros.setVisible(true);
            txtDespesas.setVisible(false);
            
            btnVolta.setBounds(37, 485, 100, 30);
        }else if(evt.getSource() == btnDespesas){
            this.setSize(600,550);
            txtTanques.setVisible(false);
            txtVendas.setVisible(false);
            txtLucros.setVisible(false);
            txtDespesas.setVisible(true);
            
            btnVolta.setBounds(37, 485, 100, 30);
        }
    }
}
