package calc.lookandfeel;

import calc.Janela;

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

public class Layout{
        public Layout(Janela janela){

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(300, 400);
        janela.setTitle("Calculosa");
        janela.setLayout(new GridBagLayout());


        janela.display.setEditable(false);
        // janela.display.setEnabled(false);
        janela.display.setBackground(Color.white);
        janela.display.setFont(new Font("Tahoma", 0, 36));
        janela.display.setHorizontalAlignment(SwingConstants.RIGHT);
        janela.historico.setEditable(false);
        janela.historico.setEnabled(false);
        janela.historico.setHorizontalAlignment(SwingConstants.RIGHT);
        
        gbc(janela);
    }
    public void gbc(Janela janelinha){
        // Janela janelinha = (Janela) SwingUtilities.getRoot(this);

        GridBagConstraints gbcNumerosAcoes = new GridBagConstraints();
        janelinha.numerosAcoes.setLayout(new GridBagLayout());
        gbcNumerosAcoes.insets = new Insets(0, 0, 0, 0);
        gbcNumerosAcoes.gridx = 1;
        gbcNumerosAcoes.weighty = 1;
        gbcNumerosAcoes.weightx = 1;
        gbcNumerosAcoes.fill = GridBagConstraints.BOTH;
        janelinha.numerosAcoes.add(janelinha.numeros, gbcNumerosAcoes);
        
        gbcNumerosAcoes.gridx = 2;
        gbcNumerosAcoes.weighty = 1;
        gbcNumerosAcoes.weightx = 0.2;
        janelinha.numerosAcoes.add(janelinha.acoes, gbcNumerosAcoes);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH; 
        janelinha.add(janelinha.historico, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.4;
        janelinha.add(janelinha.display, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.5;
        janelinha.add(janelinha.numerosAcoes, gbc);
    }
}