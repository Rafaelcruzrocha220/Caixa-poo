package CaixaEletronico;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Atm extends JInternalFrame {

    List<String> atm_saque = new ArrayList<>();


    public Atm(List<String> atm_saque) {

        this.atm_saque = atm_saque;
        inicializarComponentes();

    }

    private void inicializarComponentes() {


        Bandeja bandeja100 = new Bandeja(100,20);
        Bandeja bandeja50 = new Bandeja(50,20);
        Bandeja bandeja20 = new Bandeja(20,20);
        Bandeja bandeja10 = new Bandeja(10,20);

        Caixa caixa1 = new Caixa("ab100","logradouro1",10,"cidade1","estado1",bandeja100,bandeja50,bandeja20,bandeja10);

        JOptionPane.showMessageDialog(null, caixa1.sacar(20));

        double sacar =Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser sacado: "));
        
       JOptionPane.showMessageDialog(null, caixa1.sacar(sacar));

       System.exit(0);

    }


}