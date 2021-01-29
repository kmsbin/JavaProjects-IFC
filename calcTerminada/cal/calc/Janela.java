package calc;

import calc.bt.AddBt;
import calc.lookandfeel.Layout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Janela extends JFrame {
    
    public JPanel numeros = new JPanel();
    public JTextField display = new JTextField(0d+"");
    public JTextField historico = new JTextField();
    public JPanel numerosAcoes = new JPanel();
    public JPanel acoes = new JPanel();

    Color campoDeTexto = new Color(236, 240, 241);


    private double total = 0;
    private double fator = 0;
    private char operacao = ' ';
    private boolean limpar = true;
    private double result = 0;
    private int ope;
    
    public Janela() {
        Color campoDeTexto = new Color(236, 40, 241);

        historico.setBackground(campoDeTexto);
        display.setBackground(campoDeTexto);

        JPanel apagar = new JPanel();
        JButton btIgual = new JButton("=");

        numeros.setLayout(new GridLayout(4, 3));
        new AddBt(this);
        numeros.add(btIgual);

        apagar.setLayout(new GridLayout(1, 2));
        JButton Ca = new JButton("CA");
        JButton Cl = new JButton("CL");
        apagar.add(Ca);
        apagar.add(Cl);

        Cl.addActionListener(evt -> clear());
        Ca.addActionListener(evt ->{
            this.display.setText("0");
            this.historico.setText("");
            this.result = 0;
            this.limpar = true;
        });

        JButton btMais = new JButton("+");
        btMais.addActionListener(evt ->{ 
            this.operar('+');
            this.ope = 1;
        });

        JButton btMenos = new JButton("-");
        btMenos.addActionListener(evt ->{ 
            this.operar('-');
            this.ope = 2;
        });

        JButton btDiv = new JButton("/");
        btDiv.addActionListener(evt ->{ 
            this.operar('/');
            this.ope = 3;
        });

        JButton btMult = new JButton("*");
        btMult.addActionListener(evt ->{ 
            this.operar('*');
            this.ope = 4;
        });

        btIgual.addActionListener(evt ->{
            if (ope == 1) {
                this.result += Double.parseDouble(this.display.getText());
                this.historico.setText(this.historico.getText() + " " + this.display.getText() + " " + "=" + " " + this.result);
                this.display.setText("0");
            }
            if (ope == 2) {
                this.result -= Double.parseDouble(this.display.getText());
                this.historico.setText(this.historico.getText() + " " + this.display.getText() + " " + "=" + " " + this.result);
                this.display.setText("0");
            }
            if (ope == 3) {
                this.result = this.result/Double.parseDouble(this.display.getText());
                this.historico.setText(this.historico.getText() + " " + this.display.getText() + " " + "=" + " " + this.result);
                this.display.setText("0");
            }
            if (ope == 4) {
                this.result = this.result*Double.parseDouble(this.display.getText());
                this.historico.setText(this.historico.getText() + " " + this.display.getText() + " " + "=" + " " + this.result);
                this.display.setText("0");
            }
        });

        acoes.setLayout(new GridLayout(5, 1));
        acoes.add(apagar);
        acoes.add(btMais);
        acoes.add(btMenos);
        acoes.add(btDiv);
        acoes.add(btMult);
        new Layout(this);

        this.setVisible(true);
    }

    public void clear(){
        String raw = this.display.getText();
        int leng = raw.length()-1; 
        if(raw.length()>1){
            this.display.setText(raw.substring(0, leng));
            return;
        }
        if(raw!="0"){
            this.display.setText("");
        }
        
        
    }

    private void operar(char op) {
        if (!this.display.getText().equals("0")) {
            this.historico.setText(this.historico.getText() + " " + this.display.getText() + " " + op);
        } else {
            this.historico.setText(this.historico.getText() + " " + op);
        }
        this.result += Double.parseDouble(this.display.getText());
        this.display.setText("0");
        this.limpar = true;
    }

    public void setDisplay(String novoValor) {
        if (this.limpar) {
            this.limpar = false;
            this.display.setText(novoValor);
        } else {
            this.display.setText(this.display.getText() + novoValor);
        }
        this.fator = Double.parseDouble(this.display.getText());
    }
}