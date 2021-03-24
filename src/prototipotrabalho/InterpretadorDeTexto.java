/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import java.util.ArrayList;
import java.util.List;

public class InterpretadorDeTexto {
    
    //atributos da classe
    
    private String inputTextoPrincipal;
    
    //métodos da classe
    
    public InterpretadorDeTexto(){
        this.inputTextoPrincipal = "";
    }
    
    public void defineInputPrincipal(InterpretadorDeTexto interpretador, String input){
        interpretador.inputTextoPrincipal = input;
    }
    
    public List<String> decompoeTextos(InterpretadorDeTexto interpretador){
        
        List<String> listaDeStaccatos = new ArrayList<String>();
        StaccatoString staccato = new StaccatoString();
        
        for(int i = 0; i < interpretador.inputTextoPrincipal.length(); i++){
            switch (interpretador.inputTextoPrincipal.toLowerCase().charAt(i)){
                case 'a' -> {
                    staccato.adicionaNotas(staccato, "A ");
                    break;
                }
                case 'b' -> {
                    staccato.adicionaNotas(staccato, "B ");
                    break;
                }
                case 'c' -> {
                    staccato.adicionaNotas(staccato, "C ");
                    break;
                }
                case 'd' -> {
                    staccato.adicionaNotas(staccato, "D ");
                    break;
                }
                case 'e' -> {
                    staccato.adicionaNotas(staccato, "E ");
                    break;
                }
                case 'f' -> {
                    staccato.adicionaNotas(staccato, "F ");
                    break;
                }
                case 'g' -> {
                    staccato.adicionaNotas(staccato, "G ");
                    break;
                }
                case '+' -> {
                    //listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                    //staccato.defineSequenciaDeNotas(staccato, "");
                    staccato.defineBPM(staccato, 120);
                }
                default -> {
                    continue;
                }
            }           
        }
        listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
        return listaDeStaccatos;
    }
}
