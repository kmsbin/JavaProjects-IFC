import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Window;


class Botoes extends JFrame {
    //private final long serialVersionUID = 6071060574511908810L;
    public JPanel tela = new JPanel();
    public boolean player = true;
    public char[] verific = new char[9];
    public JOptionPane opane = new JOptionPane();

    public Bt bt1 = new Bt(0, this);
    public Bt bt2 = new Bt(1, this);
    public Bt bt3 = new Bt(2, this);
    public Bt bt4 = new Bt(3, this);
    public Bt bt5 = new Bt(4, this);
    public Bt bt6 = new Bt(5, this);
    public Bt bt7 = new Bt(6, this);
    public Bt bt8 = new Bt(7, this);
    public Bt bt9 = new Bt(8, this);

    Botoes() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("tic tac");
        this.setSize(400, 400);
        this.setLayout(new GridLayout(3,3));

        this.add(bt1);
        this.add(bt2);
        this.add(bt3);
        this.add(bt4);
        this.add(bt5);
        this.add(bt6);
        this.add(bt7);
        this.add(bt8);
        this.add(bt9);
        

        this.setVisible(true);
    }


        public void fechar(Botoes teste){
        teste.dispose();
        }
    
     void inspec() {
        if(verific[0]=='x'&& verific[1]=='x'&&verific[2]=='x'  ||
            verific[3]=='x'&&verific[4]=='x'&&verific[5]=='x' ||
            verific[6]=='x'&&verific[7]=='x'&&verific[8]=='x'||
            verific[0]=='x'&&verific[3]=='x'&&verific[6]=='x' ||
            verific[1]=='x'&&verific[4]=='x'&&verific[7]=='x' ||
            verific[2]=='x'&&verific[5]=='x'&&verific[8]=='x' ||
            verific[0]=='x'&&verific[4]=='x'&&verific[8]=='x' ||
            verific[2]=='x'&&verific[4]=='x'&&verific[6]=='x'){
                int i = JOptionPane.showConfirmDialog(null, "ganhador x, quer jogar mais uma ?","TexEditor",0);
                    if(i==0) {
                        for(int j=0;j<=8;j++){
                            this.verific[j] = ' ';
                        }
                        new Botoes();
			this.dispose();
                    }
                    if(i==1) {
                        System.exit(0);
                        return;
                    }
            
        }
        if(verific[0]=='0'&& verific[1]=='0'&&verific[2]=='0'  ||
            verific[3]=='0'&&verific[4]=='0'&&verific[5]=='0' ||
            verific[6]=='0'&&verific[7]=='0'&&verific[8]=='0' ||
            verific[0]=='0'&&verific[3]=='0'&&verific[6]=='0' ||
            verific[1]=='0'&&verific[4]=='0'&&verific[7]=='0' ||
            verific[2]=='0'&&verific[5]=='0'&&verific[8]=='0' ||
            verific[0]=='0'&&verific[4]=='0'&&verific[8]=='0' ||
            verific[2]=='0'&&verific[4]=='0'&&verific[6]=='0')
        {
            int i = JOptionPane.showConfirmDialog(null, "ganhador 0, quer jogar mais uma ?","TexEditor",0);
            if(i==0) {
                for(int j=0;j<=8;j++){
                    this.verific[j] = ' ';
                }
                new Botoes();
                this.dispose();

            }
            if(i==1) {
                System.exit(0);
                return;
            }

    }

    }
    class setVer {
        public void setVerific(boolean i) {
            if(i){
                 new Botoes();
                 return;
            }
            return;
    }
        
    }
    
}



class Bt extends JButton{
//    private final long serialVersionUID = -7180881389303672887L;
    public boolean alter = false;
    public boolean se = false;
    Botoes botoes;
    Bt(int pst, Botoes botoes) {
        this.botoes = botoes;
        this.addActionListener(evt -> setXorO(pst));
        setEnable(this.extracted());
    }

    private boolean extracted() {
        return se;
    }
        
    void setXorO(int recep) {
        if(botoes.player){
            this.setText("X");
            this.setEnabled(false);
            this.setVerific(recep);
            botoes.player = false;
            return;
        }
        this.setText("O");
        this.setEnabled(false);
        this.setVerific(recep);
        botoes.player = true;
        
    }
    void setVerific(int posit) {
        for(int i=0;i<=8;i++){
            if(posit==i){
                if(botoes.player)
                    botoes.verific[i] = 'x';
                else
                    botoes.verific[i] = '0';
                botoes.inspec();
                }
        }
    }
    void setEnable(boolean se) {
        if(se){
            this.setEnabled(true);
        }
    }

    
}

class Main{
    static public void main(String args[]){
        new Botoes();
    }
}
