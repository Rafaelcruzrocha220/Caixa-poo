package CaixaEletronico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MenuPrincipal extends JFrame {
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnPrincipal;
    private JMenuItem miSair, miMenuP;
    List<String> atm_saque =new ArrayList<>();
    List<String> atm_saldo =new ArrayList<>();
    private JButton btSaldo, btSaque;
    private static MenuPrincipal frame;

    public MenuPrincipal(){
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){
        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("C:/Users/Camila Grandini/Desktop/caixa.jpg"));
        add(background);


        setTitle("Caixa Eletrônico");
        setBounds(0, 0, 800, 700);

        contentPane = getContentPane();
        mnBarra = new JMenuBar();

        mnArquivo = new JMenu("SAIR");
        mnArquivo.setMnemonic('A');
        miSair = new JMenuItem("Sair", new ImageIcon("C:/Users/Camila Grandini/Desktop/desligar.jpg"));
        miSair.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));

        mnPrincipal = new JMenu("MENU PRINCIPAL");
        mnPrincipal.setMnemonic('M');
        miMenuP = new JMenuItem("Menu Principal");


        mnArquivo.add (miSair);
        mnPrincipal.add(miMenuP);

        mnBarra.add (mnArquivo);
        mnBarra.add(mnPrincipal);

        setJMenuBar(mnBarra);

        btSaldo = new JButton("SALDO");
        btSaldo.setBounds(50, 450, 98, 30);
        background.add(btSaldo);

        btSaque = new JButton("SAQUE");
        btSaque.setBounds(650, 450, 115, 30);
        background.add(btSaque);


    }

    private void definirEventos(){
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        miMenuP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menu = new MenuPrincipal();
                menu.show();
            }
        });

        btSaldo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Saldo saldo__ = new Saldo(atm_saldo);
                contentPane.removeAll();;
                contentPane.add(saldo__);
                contentPane.validate();

            }
        });

        btSaque.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Atm saque__ = new Atm(atm_saque);
                contentPane.removeAll();;
                contentPane.add(saque__);
                contentPane.validate();

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                frame = new MenuPrincipal();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2,
                        (tela.height - frame.getSize().height) / 2);
                frame.setVisible(true);
            }
        });;



    }
}
