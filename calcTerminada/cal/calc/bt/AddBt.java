package calc.bt;

import calc.btnum.BotaoNumerico;
import calc.Janela;
public class AddBt {

    public AddBt(Janela janela){
        janela.numeros.add(new BotaoNumerico("7"));
        janela.numeros.add(new BotaoNumerico("8"));
        janela.numeros.add(new BotaoNumerico("9"));
        janela.numeros.add(new BotaoNumerico("4"));
        janela.numeros.add(new BotaoNumerico("5"));
        janela.numeros.add(new BotaoNumerico("6"));
        janela.numeros.add(new BotaoNumerico("1"));
        janela.numeros.add(new BotaoNumerico("2"));
        janela.numeros.add(new BotaoNumerico("3"));
        janela.numeros.add(new BotaoNumerico("."));        
        janela.numeros.add(new BotaoNumerico("0"));
        
        // janela.pointer(point);
    }
    

}