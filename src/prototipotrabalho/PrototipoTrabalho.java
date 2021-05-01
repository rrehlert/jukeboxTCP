/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import java.util.Scanner;

public class PrototipoTrabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite o texto a ser convertido em música: ");
        String inputUsuario = teclado.nextLine();
        
        System.out.println("Deseja fazer a gravação? (NÃO = 0, SIM = 1) ");
        int gravar = teclado.nextInt();
        
        InterpretadorDeTexto interpretador = new InterpretadorDeTexto();
        interpretador.defineTextoInput(inputUsuario);
        String textoMusical = interpretador.geraTextoParametrizado(interpretador);
        
        if(gravar == 1){
            GravadorDeMusica recorder = new GravadorDeMusica();
            recorder.defineNomeArquivo("minhaMusica.mid");
            recorder.gravaMusica(textoMusical);
        }
        
        TocadorDeMusica jukebox = new TocadorDeMusica();
        jukebox.defineStaccato(textoMusical);
        jukebox.tocaMusica();
        
    }
    
}
