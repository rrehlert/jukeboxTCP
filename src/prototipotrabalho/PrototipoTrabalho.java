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
        String bpm = "100";
        String instrumento = "Violao";
        InterpretadorDeTexto interpretador = new InterpretadorDeTexto();
        interpretador.defineTextoInput(interpretador, inputUsuario);
        String textoMusical = interpretador.geraTextoParametrizado(interpretador, bpm, instrumento);
        
        TocadorDeMusica jukebox = new TocadorDeMusica();
        jukebox.defineStaccato(jukebox, textoMusical);
        jukebox.TocaMusica(jukebox);
        
    }
    
}
