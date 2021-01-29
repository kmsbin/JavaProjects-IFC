

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;
// import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        // try {
        //     Class.forName("org.sqlite.JDBC");
        //     Connection conn = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
        //     Statement stmt = conn.createStatement();
        //     ResultSet rs = stmt.executeQuery("SELECT * FROM palavras");
        //         while(rs.next()) {
        //             labelTabelaId.setText(rs.getString("id"));
        //             labelTabelaPalavra.setText(rs.getString("palavra"));
        //         }
            
        // } catch(Exception e) {
        //     System.out.println("ERRO: "+e);
        // }

        new controller.Jogo();
    }
}
