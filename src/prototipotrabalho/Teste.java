package prototipotrabalho;

import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Teste {
    private JButton Arquivo;
    private JPanel painel;

    public Teste(escolheArquivo txt)  {
        Arquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                    txt.escolhe();

            }
        });
    }

    public static void botao(escolheArquivo txt) {
        JFrame frame = new JFrame ("Teste");
        frame.setContentPane(new Teste(txt).painel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
