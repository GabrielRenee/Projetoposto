
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;


public class AbastecerView extends JFrame implements ActionListener {

    DecimalFormat df = new DecimalFormat("0.000"); //Litros
    DecimalFormat rs = new DecimalFormat("0.00"); //Preços
    public static Container ctnAbastecer;
    public static JLabel lblTitulo, lblInvalido, lblCapEta, lblCapGas,
            lblCapAdt, lblCapDis, lblRS;

    public static JButton btnEta, btnGas, btnAdt, btnDis, btnVolta, btnAbastecer;
    public static JTextField txtLitros, txtTotal;

    public static Font fntDados = new Font("Calibri", Font.BOLD, 12);
    public static Font fntTexto = new Font("Tahoma", Font.PLAIN, 18);
    public static Font fntTitulos = new Font("Arial", Font.BOLD, 26);
    public static int tmpComb, tmpParte;
    public static float tmpValor, tmpLitros;

    public AbastecerView() {
        super("Abastecer Carro");
        ctnAbastecer = new Container();
        ctnAbastecer.setLayout(null);
        this.add(ctnAbastecer);

        lblTitulo = new JLabel("Abastecer Carro");
        lblTitulo.setFont(fntTitulos);
        lblTitulo.setForeground(new Color(0, 0, 60));
        lblTitulo.setBounds(200, 20, 250, 30);
        ctnAbastecer.add(lblTitulo);

        lblInvalido = new JLabel("");
        lblInvalido.setFont(fntTexto);
        lblInvalido.setForeground(new Color(250, 60, 60));
        lblInvalido.setBounds(40, 60, 200, 20);
        ctnAbastecer.add(lblInvalido);

        txtLitros = new JTextField();
        txtLitros.setFont(fntTexto);
        txtLitros.setForeground(new Color(60, 60, 60));
        txtLitros.setBounds(40, 80, 200, 40);
        txtLitros.setEnabled(false);
        ctnAbastecer.add(txtLitros);

        lblRS = new JLabel("R$");
        lblRS.setFont(fntTitulos);
        lblRS.setForeground(new Color(60, 60, 60));
        lblRS.setBounds(245, 80, 200, 40);
        lblRS.setEnabled(true);
        ctnAbastecer.add(lblRS);

        btnAbastecer = new JButton("Abastecer");
        btnAbastecer.setFont(fntTexto);
        btnAbastecer.setForeground(new Color(60, 60, 60));
        btnAbastecer.setBounds(40, 125, 200, 40);
        btnAbastecer.setEnabled(false);
        btnAbastecer.addActionListener(this);
        ctnAbastecer.add(btnAbastecer);

        btnEta = new JButton("Etanol -- R$ 2,39");
        btnEta.setFont(fntTexto);
        btnEta.addActionListener(this);
        btnEta.setForeground(new Color(60, 60, 60));
        btnEta.setBounds(300, 80, 275, 40);
        ctnAbastecer.add(btnEta);
        if (SistemaControl.objPosto.tanques[0] >= 15000) {
            btnEta.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[0] >= 5000) {
            btnEta.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[0] < 5000) {
            btnEta.setBackground(new Color(252, 179, 179));
        }
        if (SistemaControl.objPosto.tanques[0] == 0) {
            btnEta.setEnabled(false);
        }
        lblCapEta = new JLabel("");
        lblCapEta.setText(SistemaControl.objPosto.tanques[0] + " / 20000");
        lblCapEta.setFont(fntDados);
        lblCapEta.setForeground(new Color(60, 60, 60));
        lblCapEta.setBounds(420, 115, 200, 20);
        ctnAbastecer.add(lblCapEta);

        btnGas = new JButton("Gasolina Comum -- R$ 3,49");
        btnGas.setFont(fntTexto);
        btnGas.addActionListener(this);
        btnGas.setForeground(new Color(60, 60, 60));
        btnGas.setBounds(300, 130, 275, 40);
        ctnAbastecer.add(btnGas);
        if (SistemaControl.objPosto.tanques[1] >= 15000) {
            btnGas.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[1] >= 5000) {
            btnGas.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[1] < 5000) {
            btnGas.setBackground(new Color(252, 179, 179));
        }

        if (SistemaControl.objPosto.tanques[1] == 0) {
            btnGas.setEnabled(false);
        }
        lblCapGas = new JLabel("");
        lblCapGas.setText(SistemaControl.objPosto.tanques[1] + " / 20000");
        lblCapGas.setFont(fntDados);
        lblCapGas.setForeground(new Color(60, 60, 60));
        lblCapGas.setBounds(420, 165, 200, 20);
        ctnAbastecer.add(lblCapGas);

        btnAdt = new JButton("Gasolina Aditivada -- R$ 3,69");
        btnAdt.addActionListener(this);
        btnAdt.setFont(fntTexto);
        btnAdt.setForeground(new Color(60, 60, 60));
        btnAdt.setBounds(300, 180, 275, 40);
        ctnAbastecer.add(btnAdt);

        if (SistemaControl.objPosto.tanques[2] >= 15000) {
            btnAdt.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[2] >= 5000) {
            btnAdt.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[2] < 5000) {
            btnAdt.setBackground(new Color(252, 179, 179));
        }
        if (SistemaControl.objPosto.tanques[2] == 0) {
            btnAdt.setEnabled(false);
        }
        lblCapAdt = new JLabel("");
        lblCapAdt.setText(SistemaControl.objPosto.tanques[2] + " / 20000");
        lblCapAdt.setFont(fntDados);
        lblCapAdt.setForeground(new Color(60, 60, 60));
        lblCapAdt.setBounds(420, 215, 200, 20);
        ctnAbastecer.add(lblCapAdt);

        btnDis = new JButton("Diesel -- R$ 2,89");
        btnDis.setFont(fntTexto);
        btnDis.addActionListener(this);
        btnDis.setForeground(new Color(60, 60, 60));
        btnDis.setBounds(300, 230, 275, 40);
        ctnAbastecer.add(btnDis);
        if (SistemaControl.objPosto.tanques[3] >= 15000) {
            btnDis.setBackground(new Color(221, 255, 209));
        } else if (SistemaControl.objPosto.tanques[3] >= 5000) {
            btnDis.setBackground(new Color(247, 239, 198));
        } else if (SistemaControl.objPosto.tanques[3] < 5000) {
            btnDis.setBackground(new Color(252, 179, 179));
        }
        if (SistemaControl.objPosto.tanques[3] == 0) {
            btnDis.setEnabled(false);
        }

        lblCapDis = new JLabel("");
        lblCapDis.setText(SistemaControl.objPosto.tanques[3] + " / 20000");
        lblCapDis.setFont(fntDados);
        lblCapDis.setForeground(new Color(60, 60, 60));
        lblCapDis.setBounds(420, 265, 200, 20);
        ctnAbastecer.add(lblCapDis);

        btnVolta = new JButton("Voltar");
        btnVolta.setFont(fntTexto);

        btnVolta.setForeground(new Color(250, 60, 60));
        btnVolta.setBounds(40, 240, 100, 30);
        btnVolta.addActionListener(this);
        ctnAbastecer.add(btnVolta);

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

            btnAdt.setEnabled(false);
            btnEta.setEnabled(false);
            btnGas.setEnabled(false);
            btnDis.setEnabled(false);
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            tmpComb = 0;

        } else if (evt.getSource() == btnGas) {
            btnAdt.setEnabled(false);
            btnEta.setEnabled(false);
            btnGas.setEnabled(false);
            btnDis.setEnabled(false);
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            tmpComb = 1;

        } else if (evt.getSource() == btnAdt) {
            btnAdt.setEnabled(false);
            btnEta.setEnabled(false);
            btnGas.setEnabled(false);
            btnDis.setEnabled(false);
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            tmpComb = 2;

        } else if (evt.getSource() == btnDis) {
            btnAdt.setEnabled(false);
            btnEta.setEnabled(false);
            btnGas.setEnabled(false);
            btnDis.setEnabled(false);
            txtLitros.setEnabled(true);
            btnAbastecer.setEnabled(true);
            tmpComb = 3;
        } else if (evt.getSource() == btnAbastecer) {
            try {
                tmpValor = Float.parseFloat(txtLitros.getText());
                lblInvalido.setText("");
            } catch (NumberFormatException e) {
                lblInvalido.setText("Número Inválido");
            }
            switch (tmpComb) {
                
                case 0:
                    tmpLitros = tmpValor / SistemaControl.objPosto.valorVend[0];
                    switch (SistemaControl.objPosto.abastecerCarro(tmpComb, tmpValor)) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!\n" + df.format(tmpLitros) + " de etanol", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "A bomba de Etanol está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;
                case 1:
                    tmpLitros = tmpValor / SistemaControl.objPosto.valorVend[1];
                    switch (SistemaControl.objPosto.abastecerCarro(tmpComb, tmpValor)) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!\n" + df.format(tmpLitros) + " de gasolina", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "A bomba de Etanol está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;
                case 2:
                    tmpLitros = tmpValor / SistemaControl.objPosto.valorVend[2];
                    switch (SistemaControl.objPosto.abastecerCarro(tmpComb, tmpValor)) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!\n" + df.format(tmpLitros) + " de aditivada", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "A bomba de Etanol está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;
                case 3:
                    tmpLitros = tmpValor / SistemaControl.objPosto.valorVend[3];
                    switch (SistemaControl.objPosto.abastecerCarro(tmpComb, tmpValor)) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!\n" + df.format(tmpLitros) + " de diesel", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "A bomba de Etanol está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Digite um número válido !!!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                break;
            };
            txtLitros.setEnabled(false);
            txtLitros.setText("");
            btnAbastecer.setEnabled(false);
            btnAdt.setEnabled(true);
            btnEta.setEnabled(true);
            btnGas.setEnabled(true);
            btnDis.setEnabled(true);

            AbastecerView telaAbastecer = new AbastecerView();
            this.dispose();
        }

    }
}
