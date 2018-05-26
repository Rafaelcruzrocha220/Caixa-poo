package CaixaEletronico;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Saldo extends JInternalFrame {

    List<String> atm_saldo = new ArrayList<>();

    public Saldo(List<String> atm_saldo) {

        this.atm_saldo = atm_saldo;

        Bandeja bandeja100 = new Bandeja(100,20);
        Bandeja bandeja50 = new Bandeja(50,20);
        Bandeja bandeja20 = new Bandeja(20,20);
        Bandeja bandeja10 = new Bandeja(10,20);

        Caixa caixa1 = new Caixa("AB100","logradouro1",10,"cidade1","estado1",bandeja100,bandeja50,bandeja20,bandeja10);

         JOptionPane.showMessageDialog(null,"Saldo total do caixa é " + caixa1.saldo() +
        "\n \nSaldo da bandeja de notas de R$ 10: " + caixa1.saldoB10() + "\n Saldo da bandeja de notas de R$ 20: " + caixa1.saldoB20() +
                "\n Saldo da bandeja de notas de R$ 50: " + caixa1.saldoB50() + "\n Saldo da bandeja de notas de R$ 100: " + caixa1.saldoB100());

     

        System.exit(0);


    }


}