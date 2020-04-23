
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ServicosView extends JFrame implements ActionListener {

    public static Container ctnServicos;
    public static JLabel lblTitulo, lblInvalido, lblSeta, lblTotal;
    public static JButton btnCafe, btnSalgado, btnDucha, btnBalanceamento, 
            btnTroca, btnVolta, btnConcluir,btnVCafe, btnVSalgado, btnVDucha, 
            btnVBalanceamento, btnVTroca;
    public static JTextField txtTotal;

    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static Font fntTotal = new Font("Arial", Font.BOLD, 18);
    public static Font fntSeta = new Font("Arial", Font.BOLD, 18);

    public int servicos[] = new int[6]; //0 = Ducha | 1 = Óleo | 2 = Balanceamento | 3 = Café | 4 = Total
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
        lblTitulo.setBounds(100, 10, 250, 30);
        ctnServicos.add(lblTitulo);

        lblTotal = new JLabel("TOTAL:");
        lblTotal.setFont(fntTotal);
        lblTotal.setForeground(new Color(0, 0, 60));
        lblTotal.setBounds(215, 285, 100, 40);
        ctnServicos.add(lblTotal);

        txtTotal = new JTextField();// aqui ta a caixa em branco do total garai
        txtTotal.setFont(fntTexto);
        txtTotal.setForeground(new Color(60, 60, 60));
        txtTotal.setBounds(310, 295, 110, 55);
        txtTotal.setEditable(false);

        ctnServicos.add(txtTotal);

        btnCafe = new JButton("Café");
        btnCafe.setFont(fntTexto);
        btnCafe.addActionListener(this);
        btnCafe.setForeground(new Color(60, 60, 60));
        btnCafe.setBounds(15, 65, 180, 40);
        ctnServicos.add(btnCafe);

        btnVCafe = new JButton("R$2,00");
        btnVCafe.setFont(fntTexto);
        btnVCafe.setEnabled(false);
        btnVCafe.setForeground(new Color(60, 60, 60));
        btnVCafe.setBounds(310, 65, 110, 40);
        ctnServicos.add(btnVCafe);

        btnSalgado = new JButton("Salgado");
        btnSalgado.setFont(fntTexto);
        btnSalgado.addActionListener(this);
        btnSalgado.setForeground(new Color(60, 60, 60));
        btnSalgado.setBounds(15, 110, 180, 40);
        ctnServicos.add(btnSalgado);

        btnVSalgado = new JButton("R$4,00");
        btnVSalgado.setFont(fntTexto);
        btnVSalgado.setEnabled(false);
        btnVSalgado.setForeground(new Color(60, 60, 60));
        btnVSalgado.setBounds(310, 110, 110, 40);
        ctnServicos.add(btnVSalgado);

        btnDucha = new JButton("Ducha ecólogica");
        btnDucha.setFont(fntTexto);
        btnDucha.addActionListener(this);
        btnDucha.setForeground(new Color(60, 60, 60));
        btnDucha.setBounds(15, 155, 180, 40);
        ctnServicos.add(btnDucha);

        btnVDucha = new JButton("R$8,00");
        btnVDucha.setFont(fntTexto);
        btnVDucha.setForeground(new Color(60, 60, 60));
        btnVDucha.setEnabled(false);
        btnVDucha.setBounds(310, 155, 110, 40);
        ctnServicos.add(btnVDucha);

        btnBalanceamento = new JButton("Balanceamento");
        btnBalanceamento.addActionListener(this);
        btnBalanceamento.setFont(fntTexto);
        btnBalanceamento.setForeground(new Color(60, 60, 60));
        btnBalanceamento.setBounds(15, 200, 180, 40);
        ctnServicos.add(btnBalanceamento);

        btnVBalanceamento = new JButton("R$35,00");
        btnVBalanceamento.setFont(fntTexto);
        btnVBalanceamento.setForeground(new Color(60, 60, 60));
        btnVBalanceamento.setEnabled(false);
        btnVBalanceamento.setBounds(310, 200, 110, 40);
        ctnServicos.add(btnVBalanceamento);

        btnTroca = new JButton("Troca de óleo");
        btnTroca.setFont(fntTexto);
        btnTroca.addActionListener(this);
        btnTroca.setForeground(new Color(60, 60, 60));
        btnTroca.setBounds(15, 245, 180, 40);
        ctnServicos.add(btnTroca);

        btnVTroca = new JButton("R$ 50,00");
        btnVTroca.setFont(fntTexto);
        btnVTroca.setForeground(new Color(60, 60, 60));
        btnVTroca.setEnabled(false);
        btnVTroca.setBounds(310, 245, 110, 40);
        ctnServicos.add(btnVTroca);

        btnConcluir = new JButton("Concluir");
        btnConcluir.setFont(fntTexto);
        btnConcluir.addActionListener(this);
        btnConcluir.setForeground(new Color(60, 60, 60));
        btnConcluir.setBounds(200, 315, 97, 35);
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
        this.setSize(440, 390);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnVolta) {

            this.dispose();
            new MenuView().setVisible(true);
        } else if (evt.getSource() == btnCafe) {
            tmpTotal += 2;
            txtTotal.setText(Integer.toString(tmpTotal));
            tmpServ = 0;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Café comprado !!!\nValor: RS 2,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evt.getSource() == btnSalgado) {
            tmpTotal += 4;
            txtTotal.setText(Integer.toString(tmpTotal));
            tmpServ = 1;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Salgado comprado !!!\nValor: RS 4,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evt.getSource() == btnDucha) {
            tmpTotal += 8;
            txtTotal.setText(Integer.toString(tmpTotal));
            tmpServ = 2;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Ducha Concluída !!!\nValor: RS 8,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);

        } else if (evt.getSource() == btnBalanceamento) {
            tmpTotal += 35;
            txtTotal.setText(Integer.toString(tmpTotal));
            tmpServ = 3;
            btnConcluir.setEnabled(true);
            SistemaControl.objPosto.venderServiços(tmpServ);
            JOptionPane.showMessageDialog(null, "Balanceamento Concluído !!!\nValor: RS 35,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evt.getSource() == btnTroca) {
            tmpTotal += 50;
            txtTotal.setText(Integer.toString(tmpTotal));
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
