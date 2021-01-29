package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JLabel;

public class Palavra extends javax.swing.JFrame {
    // private javax.swing.JTextField jtext = new javax.swing.JTextField();

    public Palavra() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500); 
        this.setLocationRelativeTo(null);
        this.setTitle("FORCA");
        this.setLayout(new java.awt.GridLayout(10, 1));

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM palavras");
                while(rs.next()) {
                    this.add(new label(rs.getString("palavra")));
                }
            
        } catch(Exception e) {
            System.out.println("ERRO: "+e);
        }






        this.setVisible(true);
    }

    class label extends JLabel {
        label(String a){
            this.setText(a);

        }

    }


}
