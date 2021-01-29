package botaonumerico;
import javax.swing.JButton;
import janela.Janela;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;

public class BotaoNumerico extends JButton {
    public BotaoNumerico(String text) {
        this.setText(text);
        this.addActionListener(evt -> {
            Janela janelaPai = (Janela) SwingUtilities.getRoot(this);
            janelaPai.setDisplay(text);
        });
    }
}