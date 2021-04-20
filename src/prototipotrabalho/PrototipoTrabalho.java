/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class PrototipoTrabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Selecione o arquivo a ser convertido: ");
        String inputUsuario = null;
        escolheArquivo txt = new escolheArquivo();

        //String comando = teclado.nextLine();
        //Teste.botao(txt);
        txt.escolhe();


        if (txt.getArquivo() == null) {
               System.out.println("Nenhum arquivo selecionado, digite o texto a ser convertido:");
               inputUsuario = teclado.nextLine();
        }
        else {
            File entrada = new File(txt.getArquivo());

            //File entrada = new File("C:\\Users\\ricar\\Desktop\\Ricardo\\GitHUb\\JukeboxTCP\\jukeboxTCP\\src\\prototipotrabalho\\" + teclado.nextLine());
            Scanner arquivo = new Scanner(entrada);
            arquivo.useDelimiter("\\Z");
            inputUsuario = arquivo.next();
        }


        InterpretadorDeTexto interpretador = new InterpretadorDeTexto();
        interpretador.defineTextoInput(interpretador, inputUsuario);
        String textoMusical = interpretador.geraTextoParametrizado(interpretador);

        TocadorDeMusica jukebox = new TocadorDeMusica();
        jukebox.defineStaccato(jukebox, textoMusical);
        jukebox.TocaMusica(jukebox);



        
    }
}
