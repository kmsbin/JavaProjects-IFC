package view;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.ArrayList;

class JPanelBts extends javax.swing.JPanel {
    public ArrayList<JButton> bts = new ArrayList<>();

    private char letras[] = {
        'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'H', 
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public JPanelBts() {
        this.setLayout(new java.awt.GridLayout(3, 9));
        for(char letra: letras) {
            JButton bt = new JButton(letra+"");
            this.bts.add(bt);
            this.add(bt);
        }
    }
}

public class Jogo extends javax.swing.JFrame {
    protected JLabel label = new JLabel("_ _ _ _ _ _");
    private JPanelBts jPanelBts = new JPanelBts();
    protected ArrayList<JButton> bts = this.jPanelBts.bts;
    protected JMenuItem miPalavras = new JMenuItem("Palavras");

    public Jogo() {
        JMenuBar barra = new JMenuBar();
        JMenu menuJogo = new JMenu("Jogo");
        JMenuItem miRanking = new JMenuItem("Ranking");

        barra.add(menuJogo);
		menuJogo.add(this.miPalavras);
        menuJogo.add(miRanking);
        
        this.setJMenuBar(barra);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500); 
        this.setLocationRelativeTo(null);
        this.setTitle("FORCA");
        this.setLayout(new java.awt.GridLayout(2, 1));

        this.add(this.label);
        this.add(this.jPanelBts);

        this.setVisible(true);
    }
}