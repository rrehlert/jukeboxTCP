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
    
    //constantes da classe
    
    private final int CODIGO_HARPSICHORD = 7;
    private final int CODIGO_TUBULAR_BELLS = 15;
    private final int CODIGO_CHURCH_ORGAN = 20;
    private final int CODIGO_PAN_FLUTE = 76;
    private final int CODIGO_AGOGO = 114;
    
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
            
            switch (interpretador.textoInput.charAt(i)){
                
                case 'A' -> {
                    staccato.adicionaNotas(staccato, "A ");
                    break;
                }
                case 'B' -> {
                    staccato.adicionaNotas(staccato, "B ");
                    break;
                }
                case 'C' -> {
                    staccato.adicionaNotas(staccato, "C ");
                    break;
                }
                case 'D' -> {
                    staccato.adicionaNotas(staccato, "D ");
                    break;
                }
                case 'E' -> {
                    staccato.adicionaNotas(staccato, "E ");
                    break;
                }
                case 'F' -> {
                    staccato.adicionaNotas(staccato, "F ");
                    break;
                }
                case 'G' -> {
                    staccato.adicionaNotas(staccato, "G ");
                    break;
                }
                case ' ' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                    staccato.defineSequenciaDeNotas(staccato, "");
                    staccato.dobraVolume(staccato);
                    break;
                }
                case '!' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                    staccato.defineSequenciaDeNotas(staccato, "");
                    staccato.defineInstrumento(staccato, CODIGO_AGOGO);
                    break;
                }
                case '?' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                    staccato.defineSequenciaDeNotas(staccato, "");
                    staccato.aumentaOitava(staccato);
                    break;
                }
                case ';' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                    staccato.defineSequenciaDeNotas(staccato, "");
                    staccato.defineInstrumento(staccato, CODIGO_PAN_FLUTE);
                    break;
                }
                case ',' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos(staccato));
                    staccato.defineSequenciaDeNotas(staccato, "");
                    staccato.defineInstrumento(staccato, CODIGO_CHURCH_ORGAN);
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
