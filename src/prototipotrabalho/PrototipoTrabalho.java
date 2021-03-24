/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import java.util.List;
import java.util.Scanner;

public class PrototipoTrabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o texto a ser convertido em música: ");
        String input = teclado.nextLine();
        
        InterpretadorDeTexto interpretador = new InterpretadorDeTexto();
        interpretador.defineInputPrincipal(interpretador, input);
        
        List<String> listaDeStaccatos = interpretador.decompoeTextos(interpretador);
        
        TocadorDeMusica jukebox = new TocadorDeMusica();
        
        for(String staccato : listaDeStaccatos){
            //System.out.println(staccato);
            jukebox.defineStringPrincipal(jukebox, staccato);
            jukebox.TocaMusica(jukebox);
        }
 
    }
    
}
