
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TanqueView extends JFrame implements ActionListener {

    public static Container ctnTanque;
    public static JLabel lblTitulo, lblInvalido, lblCapEta, lblCapGas, lblCapAdt, lblCapDis;
    public static JButton btnEta, btnGas, btnAdt, btnDis, btnVolta, btnConcluir, btnAbastecer;
    public static JTextField txtLitros;

    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static Font fntDados = new Font("Calibri",Font.BOLD, 12);
    public static int tmpComb, tmpQnt, tmpParte;

    public TanqueView() {
        super("Abastecer Tanque");
        ctnTanque = new Container();
        ctnTanque.setLayout(null);
        this.add(ctnTanque);

        lblTitulo = new JLabel("Abastecer Tanque");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(200, 20, 250, 30);
        ctnTanque.add(lblTitulo);

        lblInvalido = new JLabel("");
        lblInvalido.setFont(fntTexto);
        lblInvalido.setForeground(new Color(250, 60, 60));
        lblInvalido.setBounds(50, 60, 200, 20);
        ctnTanque.add(lblInvalido);

        txtLitros = new JTextField();
        txtLitros.setFont(fntTexto);
        txtLitros.setForeground(new Color(60, 60, 60));
        txtLitros.setBounds(50, 80, 200, 40);
        txtLitros.setEnabled(false);
        ctnTanque.add(txtLitros);

        btnAbastecer = new JButton("Abastecer");
        btnAbastecer.setFont(fntTexto);
        btnAbastecer.setForeground(new Color(60, 60, 60));
        btnAbastecer.setBounds(50, 125, 200, 40);
        btnAbastecer.setEnabled(false);
        btnAbastecer.addActionListener(this);
        ctnTanque.add(btnAbastecer);

        btnEta = new JButton("Etanol");
        btnEta.setFont(fntTexto);
        btnEta.addActionListener(this);
        btnEta.setForeground(new Color(60, 60, 60));
        btnEta.setBounds(350, 80, 200, 40);
        ctnTanque.add(btnEta);
        if (SistemaControl.objPosto.tanques[0] >= 15000) {
            btnEta.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[0] >= 5000) {
            btnEta.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[0] < 5000) {
            btnEta.setBackground(new Color(252, 179, 179));
        }
        lblCapEta = new JLabel("");
        lblCapEta.setText(SistemaControl.objPosto.tanques[0] + " / 20000");
        lblCapEta.setFont(fntDados);
        lblCapEta.setForeground(new Color(60, 60, 60));
        lblCapEta.setBounds(420, 115, 200, 20);
        ctnTanque.add(lblCapEta);

        btnGas = new JButton("Gasolina Comum");
        btnGas.setFont(fntTexto);
        btnGas.addActionListener(this);
        btnGas.setForeground(new Color(60, 60, 60));
        btnGas.setBounds(350, 130, 200, 40);
        ctnTanque.add(btnGas);
        if (SistemaControl.objPosto.tanques[1] >= 15000) {
            btnGas.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[1] >= 5000) {
            btnGas.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[1] < 5000) {
            btnGas.setBackground(new Color(252, 179, 179));
        }
        lblCapGas = new JLabel("");
        lblCapGas.setText(SistemaControl.objPosto.tanques[1] + " / 20000");
        lblCapGas.setFont(fntDados);
        lblCapGas.setForeground(new Color(60, 60, 60));
        lblCapGas.setBounds(420, 165, 200, 20);
        ctnTanque.add(lblCapGas);
        

        btnAdt = new JButton("Gasolina Aditivada");
        btnAdt.addActionListener(this);
        btnAdt.setFont(fntTexto);
        btnAdt.setForeground(new Color(60, 60, 60));
        btnAdt.setBounds(350, 180, 200, 40);
        ctnTanque.add(btnAdt);
        if (SistemaControl.objPosto.tanques[2] >= 15000) {
            btnAdt.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[2] >= 5000) {
            btnAdt.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[2] < 5000) {
            btnAdt.setBackground(new Color(252, 179, 179));
        }
        
        lblCapAdt = new JLabel("");
        lblCapAdt.setText(SistemaControl.objPosto.tanques[2] + " / 20000");
        lblCapAdt.setFont(fntDados);
        lblCapAdt.setForeground(new Color(60, 60, 60));
        lblCapAdt.setBounds(420, 215, 200, 20);
        ctnTanque.add(lblCapAdt);

        btnDis = new JButton("Diesel");
        btnDis.setFont(fntTexto);
        btnDis.addActionListener(this);
        btnDis.setForeground(new Color(60, 60, 60));
        btnDis.setBounds(350, 230, 200, 40);
        ctnTanque.add(btnDis);
        if (SistemaControl.objPosto.tanques[3] >= 15000) {
            btnDis.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[3] >= 5000) {
            btnDis.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[3] < 5000) {
            btnDis.setBackground(new Color(252, 179, 179));
        }
        lblCapDis = new JLabel("");
        lblCapDis.setText(SistemaControl.objPosto.tanques[3] + " / 20000");
        lblCapDis.setFont(fntDados);
        lblCapDis.setForeground(new Color(60, 60, 60));
        lblCapDis.setBounds(420, 265, 200, 20);
        ctnTanque.add(lblCapDis);
        
        
        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);

        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(50, 240, 100, 30);
        btnVolta.addActionListener(this);
        ctnTanque.add(btnVolta);

        this.setLocation(600, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 340);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnVolta) {
            this.dispose();
            new MenuView().setVisible(true);
        } else if (evt.getSource() == btnEta) {
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            btnAdt.setEnabled(false);
            btnDis.setEnabled(false);
            btnGas.setEnabled(false);
            btnEta.setEnabled(false);
            tmpComb = 0;

        } else if (evt.getSource() == btnGas) {
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            btnAdt.setEnabled(false);
            btnDis.setEnabled(false);
            btnGas.setEnabled(false);
            btnEta.setEnabled(false);
            tmpComb = 1;

        } else if (evt.getSource() == btnAdt) {
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            btnAdt.setEnabled(false);
            btnDis.setEnabled(false);
            btnGas.setEnabled(false);
            btnEta.setEnabled(false);
            tmpComb = 2;

        } else if (evt.getSource() == btnDis) {
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            btnAdt.setEnabled(false);
            btnDis.setEnabled(false);
            btnGas.setEnabled(false);
            btnEta.setEnabled(false);
            tmpComb = 3;

        } else if (evt.getSource() == btnAbastecer) {
            try {
                tmpQnt = Integer.parseInt(txtLitros.getText());
                lblInvalido.setText("");
            } catch (NumberFormatException e) {
                lblInvalido.setText("Número Inválido");
            }
            lblCapEta.setText(SistemaControl.objPosto.tanques[0] + " / 20000");
            lblCapGas.setText(SistemaControl.objPosto.tanques[1] + " / 20000");
            lblCapAdt.setText(SistemaControl.objPosto.tanques[2] + " / 20000");
            lblCapDis.setText(SistemaControl.objPosto.tanques[3] + " / 20000");
            txtLitros.setEnabled(false);
            txtLitros.setText("");
            btnAbastecer.setEnabled(false);
            btnAdt.setEnabled(true);
            btnDis.setEnabled(true);
            btnGas.setEnabled(true);
            btnEta.setEnabled(true);
            SistemaControl.objPosto.abastecerTanque(tmpComb, tmpQnt);
        }

    }
}
