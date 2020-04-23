import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class ServicosView extends JFrame implements ActionListener {
    
    DecimalFormat rs = new DecimalFormat("0.00");
    public static Container ctnServicos;
    public static JLabel lblTitulo, lblInvalido, lblTotal, lblStotal, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5;
    public static JButton btnCafe, btnSalgado, btnDucha, btnBalanceamento, 
            btnTroca, btnVolta, btnConcluir,btnVCafe, btnVSalgado, btnVDucha, 
            btnVBalanceamento, btnVTroca;
    public static JTextField txtTotal;

    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static Font fntTotal = new Font("Arial", Font.BOLD, 24);
    public static Font fntSeta = new Font("Arial", Font.BOLD, 18);
    public static Font fntStotal = new Font("Arial", Font.BOLD, 26);

    public int servicos[] = new int[6]; //0 = Ducha | 1 = Óleo | 2 = Balanceamento | 3 = Café | 4 = Total | 5 = Salgados
    public float Stotal;

    public static int tmpServ, tmpQnt, tmpParte, tmpTotal;

    public ServicosView() {
        super("Serviços");
        ctnServicos = new Container();
        ctnServicos.setLayout(null);
        this.add(ctnServicos);

        lblTitulo = new JLabel("Serviços do Posto");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(115, 10, 250, 30);
        ctnServicos.add(lblTitulo);

        lblTotal = new JLabel("TOTAL:");
        lblTotal.setFont(fntTotal);
        lblTotal.setForeground(new Color(0, 0, 60));
        lblTotal.setBounds(250, 310, 100, 40);
        ctnServicos.add(lblTotal);
        
        lblStotal = new JLabel("");// aqui ta a caixa em branco do total garai
        lblStotal.setFont(fntStotal);
        lblStotal.setForeground(new Color(60, 60, 60));
        lblStotal.setBounds(340, 310, 150, 40);
        ctnServicos.add(lblStotal);

        btnCafe = new JButton("Café");
        btnCafe.setFont(fntTexto);
        btnCafe.addActionListener(this);
        btnCafe.setForeground(new Color(60, 60, 60));
        btnCafe.setBounds(15, 65, 200, 40);
        ctnServicos.add(btnCafe);
        
        lblSeta1 = new JLabel("----------->");
        lblSeta1.setFont(fntSeta);
        lblSeta1.setForeground(new Color(0, 0, 60));
        lblSeta1.setBounds(220, 65, 200, 40);
        ctnServicos.add(lblSeta1);
        
        btnVCafe = new JButton("R$ 2,00");
        btnVCafe.setFont(fntTexto);
        btnVCafe.setEnabled(false);
        btnVCafe.setForeground(new Color(60, 60, 60));
        btnVCafe.setBounds(340, 65, 110, 40);
        ctnServicos.add(btnVCafe);

        btnSalgado = new JButton("Salgado");
        btnSalgado.setFont(fntTexto);
        btnSalgado.addActionListener(this);
        btnSalgado.setForeground(new Color(60, 60, 60));
        btnSalgado.setBounds(15, 110, 200, 40);
        ctnServicos.add(btnSalgado);
        
        lblSeta2 = new JLabel("----------->");
        lblSeta2.setFont(fntSeta);
        lblSeta2.setForeground(new Color(0, 0, 60));
        lblSeta2.setBounds(220, 110, 200, 40);
        ctnServicos.add(lblSeta2);

        btnVSalgado = new JButton("R$ 4,00");
        btnVSalgado.setFont(fntTexto);
        btnVSalgado.setEnabled(false);
        btnVSalgado.setForeground(new Color(60, 60, 60));
        btnVSalgado.setBounds(340, 110, 110, 40);
        ctnServicos.add(btnVSalgado);

        btnDucha = new JButton("Ducha ecólogica");
        btnDucha.setFont(fntTexto);
        btnDucha.addActionListener(this);
        btnDucha.setForeground(new Color(60, 60, 60));
        btnDucha.setBounds(15, 155, 200, 40);
        ctnServicos.add(btnDucha);
        
        lblSeta3 = new JLabel("----------->");
        lblSeta3.setFont(fntSeta);
        lblSeta3.setForeground(new Color(0, 0, 60));
        lblSeta3.setBounds(220, 155, 200, 40);
        ctnServicos.add(lblSeta3);

        btnVDucha = new JButton("R$ 8,00");
        btnVDucha.setFont(fntTexto);
        btnVDucha.setForeground(new Color(60, 60, 60));
        btnVDucha.setEnabled(false);
        btnVDucha.setBounds(340, 155, 110, 40);
        ctnServicos.add(btnVDucha);

        btnBalanceamento = new JButton("Balanceamento");
        btnBalanceamento.addActionListener(this);
        btnBalanceamento.setFont(fntTexto);
        btnBalanceamento.setForeground(new Color(60, 60, 60));
        btnBalanceamento.setBounds(15, 200, 200, 40);
        ctnServicos.add(btnBalanceamento);
        
        lblSeta4 = new JLabel("----------->");
        lblSeta4.setFont(fntSeta);
        lblSeta4.setForeground(new Color(0, 0, 60));
        lblSeta4.setBounds(220, 200, 200, 40);
        ctnServicos.add(lblSeta4);

        btnVBalanceamento = new JButton("R$ 35,00");
        btnVBalanceamento.setFont(fntTexto);
        btnVBalanceamento.setForeground(new Color(60, 60, 60));
        btnVBalanceamento.setEnabled(false);
        btnVBalanceamento.setBounds(340, 200, 110, 40);
        ctnServicos.add(btnVBalanceamento);

        btnTroca = new JButton("Troca de óleo");
        btnTroca.setFont(fntTexto);
        btnTroca.addActionListener(this);
        btnTroca.setForeground(new Color(60, 60, 60));
        btnTroca.setBounds(15, 245, 200, 40);
        ctnServicos.add(btnTroca);
        
        lblSeta5 = new JLabel("----------->");
        lblSeta5.setFont(fntSeta);
        lblSeta5.setForeground(new Color(0, 0, 60));
        lblSeta5.setBounds(220, 245, 200, 40);
        ctnServicos.add(lblSeta5);

        btnVTroca = new JButton("R$ 50,00");
        btnVTroca.setFont(fntTexto);
        btnVTroca.setForeground(new Color(60, 60, 60));
        btnVTroca.setEnabled(false);
        btnVTroca.setBounds(340, 245, 110, 40);
        ctnServicos.add(btnVTroca);

        btnConcluir = new JButton("Concluir");
        btnConcluir.setFont(fntTexto);
        btnConcluir.addActionListener(this);
        btnConcluir.setForeground(new Color(60, 60, 60));
        btnConcluir.setBounds(117, 315, 97, 35);
        btnConcluir.setEnabled(false);
        ctnServicos.add(btnConcluir);

        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);
        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(15, 315, 97, 35);
        btnVolta.addActionListener(this);
        ctnServicos.add(btnVolta);

        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(470, 390);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnVolta) {

            this.dispose();
            new MenuView().setVisible(true);
        } else if (evt.getSource() == btnCafe) {
            tmpTotal += 2;
            lblStotal.setText("R$ " + rs.format(tmpTotal));
            tmpServ = 0;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Café comprado !!!\nValor: RS 2,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evt.getSource() == btnSalgado) {
            tmpTotal += 4;
            lblStotal.setText("R$ " + rs.format(tmpTotal));
            tmpServ = 1;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Salgado comprado !!!\nValor: RS 4,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evt.getSource() == btnDucha) {
            tmpTotal += 8;
            lblStotal.setText("R$ " + rs.format(tmpTotal));
            tmpServ = 2;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Ducha Concluída !!!\nValor: RS 8,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);

        } else if (evt.getSource() == btnBalanceamento) {
            tmpTotal += 35;
            lblStotal.setText("R$ " + rs.format(tmpTotal));
            tmpServ = 3;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Balanceamento Concluído !!!\nValor: RS 35,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evt.getSource() == btnTroca) {
            tmpTotal += 50;
            lblStotal.setText("R$ " + rs.format(tmpTotal));
            tmpServ = 4;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Troca de óleo efetuada !!!\nValor: R$ 50,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);

        } else if (evt.getSource() == btnConcluir) {
            
            ServicosView telaServicos = new ServicosView();
            this.dispose();
            
        }
    }
}