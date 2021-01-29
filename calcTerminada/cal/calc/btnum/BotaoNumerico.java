package calc.btnum;

import javax.swing.JButton;
import calc.Janela;
import javax.swing.SwingUtilities;

public class BotaoNumerico extends JButton {
    public BotaoNumerico(String text) {
        this.setText(text);
        this.addActionListener(evt -> {
            Janela janelaPai = (Janela) SwingUtilities.getRoot(this);
            janelaPai.setDisplay(text);
        });
    }
}