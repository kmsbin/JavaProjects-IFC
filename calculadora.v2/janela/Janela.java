package janela;

import addbt.AddBt;
import layout.Layout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;

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
    private double total = 0;
    private double fator = 0;
    private char operacao = ' ';
    private boolean limpar = true;
    
    public Janela() {        
        JPanel apagar = new JPanel();
        JButton btIgual = new JButton("=");
        btIgual.addActionListener(evt -> setHis(true));
        numeros.setLayout(new GridLayout(4, 3));
        new addbt.AddBt(this);
        numeros.add(btIgual);

        apagar.setLayout(new GridLayout(1, 2));
        JButton Ca = new JButton("CA");
        JButton Cl = new JButton("CL");
        apagar.add(Ca);
        apagar.add(Cl);
        // Ca.addActionListener(evt -> this);
        Cl.addActionListener(evt -> clear());
        Ca.addActionListener(evt -> this.display.setText("0"));

        JButton btMais = new JButton("+");
        btMais.addActionListener(evt -> this.calcular('+'));

        JButton btMenos = new JButton("-");
        btMenos.addActionListener(evt -> this.calcular('-'));

        JButton btDiv = new JButton("/");
        btDiv.addActionListener(evt -> this.calcular('/'));

        JButton btMult = new JButton("*");
        btMult.addActionListener(evt -> this.calcular('*'));

        acoes.setLayout(new GridLayout(5, 1));
        acoes.add(apagar);
        acoes.add(btMais);
        acoes.add(btMenos);
        acoes.add(btDiv);
        acoes.add(btMult);
        new Layout(this);

        this.setVisible(true);
    }
    public void pointer(JButton point) {
        point.addActionListener(evt -> {System.out.println("fui clicado");});        
    }

    public void setHis(boolean exib) {
        if(exib){
            this.historico.setText((this.fator+"")+this.operacao+this.total);
            this.calcular(this.operacao);

        } 
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

    private void calcular(char proximaOperacao) {

        if (this.operacao != proximaOperacao && this.limpar) {
            this.operacao = proximaOperacao;
            return;
        }

        if (this.operacao == ' ') {
            this.total = this.fator;
            this.fator = 0;
        }

        if (this.operacao == '+'){
            this.total += this.fator;
        } 
        if (this.operacao == '-'){
            this.total -= this.fator;
        }    
        if (this.operacao == '/') {
            this.total /= this.fator;
        }
        if (this.operacao == '*') {
            this.total *= this.fator;
        }
        
        this.limpar = true;

        this.operacao = proximaOperacao;

        this.display.setText(this.total+"");
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
