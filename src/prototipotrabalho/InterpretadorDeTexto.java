/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterpretadorDeTexto {
    
    //atributos da classe
    
    private String textoInput;
    
    //métodos da classe
    
    public InterpretadorDeTexto(){
        this.textoInput = "";
    }
    
    public void defineTextoInput(InterpretadorDeTexto interpretador, String input){
        interpretador.textoInput = input;
    }
    
    private String randomizaNota(){
        
        Random geradorDeNumeros = new Random();
        int numeroAleatorio = geradorDeNumeros.nextInt(6);
        switch (numeroAleatorio){
            case 0 -> {
                return "A ";
            }
            case 1 -> {
                return "B ";
            }
            case 2 -> {
                return "C ";
            }
            case 3 -> {
                return "D ";
            }
            case 4 -> {
                return "E ";
            }
            case 5 -> {
                return "F ";
            }
            default -> {
                return "G ";
            }
        }
    }
    
    private List<String> decompoeTextoEmStaccatos(InterpretadorDeTexto interpretador){
        
        List<String> listaDeStaccatos = new ArrayList<>();
        StaccatoString staccato = new StaccatoString();
        
        for(int i = 0; i < interpretador.textoInput.length(); i++){
            
            switch (interpretador.textoInput.toLowerCase().charAt(i)){
                
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
                case '?' -> {
                    staccato.adicionaNotas(staccato, randomizaNota());
                    break;
                }
                case '+' -> {
                    if(i>0){
                        char caractereAnterior = interpretador.textoInput.toLowerCase().charAt(i-1);
                        if(caractereAnterior != 't'){
                            listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                            staccato.defineSequenciaDeNotas(staccato, "");
                            staccato.dobraVolume(staccato);
                        }
                    }
                    else{
                        staccato.dobraVolume(staccato);
                    }
                    break;
                }
                case '-' -> {
                    if(i>0){
                        char caractereAnterior = interpretador.textoInput.toLowerCase().charAt(i-1);
                        if(caractereAnterior != 't'){
                            listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                            staccato.defineSequenciaDeNotas(staccato, "");
                            staccato.resetaVolume(staccato);
                        }
                    }
                    else{
                        staccato.dobraVolume(staccato);
                    }
                    break;
                }
                case 't' -> {
                    if((i+1) < interpretador.textoInput.length()){
                        char proximoCaractere = interpretador.textoInput.charAt(i+1);
                        if (proximoCaractere == '+'){
                            listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                            staccato.defineSequenciaDeNotas(staccato, "");
                            staccato.aumentaOitava(staccato);
                        }
                        if (proximoCaractere == '-'){
                            listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                            staccato.defineSequenciaDeNotas(staccato, "");
                            staccato.diminuiOitava(staccato);
                        }    
                    }
                    break;
                }
                default -> {
                    continue;
                }
            }           
        }
        listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
        return listaDeStaccatos;
    }
    
    public String geraTextoParametrizado(InterpretadorDeTexto interpretador){
        
        List<String> listaDeStaccatos = interpretador.decompoeTextoEmStaccatos(interpretador);
        String textoMusical = "";
        
        for(String staccato : listaDeStaccatos){
            //System.out.println(staccato);
            textoMusical = textoMusical + staccato;
        }
        
        return textoMusical;
    }
    
}
