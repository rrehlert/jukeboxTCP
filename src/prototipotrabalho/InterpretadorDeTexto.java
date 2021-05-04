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
    
    private String textoInput;
    
    
    private static final int CODIGO_A = 65;
    private static final int CODIGO_G = 71;
    private static final int CODIGO_HARPSICHORD = 7;
    private static final int CODIGO_TUBULAR_BELLS = 15;
    private static final int CODIGO_CHURCH_ORGAN = 20;
    private static final int CODIGO_GUITARRA = 24;
    private static final int CODIGO_ORQUESTRA = 55;
    private static final int CODIGO_PAN_FLUTE = 76;
    private static final int CODIGO_AGOGO = 114;
    
    
    public InterpretadorDeTexto(){
        this.textoInput = "";
    }
    
    public void defineTextoInput(String input){
        this.textoInput = input;
    }
    
    private boolean notaMusical(int codigoCaractere){
        return (codigoCaractere >= CODIGO_A) && (codigoCaractere <= CODIGO_G);
    }
    
    private char randomizaNota(){
        
        Random geradorDeNumeros = new Random();
        int numeroAleatorio = geradorDeNumeros.nextInt(6);
        char caractere;
        
        switch (numeroAleatorio){
            case 0 -> caractere = 'A';
            case 1 -> caractere = 'B';
            case 2 -> caractere = 'C';
            case 3 -> caractere = 'D';
            case 4 -> caractere = 'E';
            case 5 -> caractere = 'F';
            default -> caractere = 'G';
        }
        
        return caractere;
    }
    
    private List<String> decompoeTextoEmStaccatos(){
        
        List<String> listaDeStaccatos = new ArrayList<>();
        StaccatoString staccato = new StaccatoString();
        char caractereAtual; int caractereAnterior;
        
        for(int i = 0; i < this.textoInput.length(); i++){
            
            caractereAtual = this.textoInput.charAt(i);
            
            switch (caractereAtual){
                
                case 'A','B','C','D','E','F','G' -> staccato.adicionaNota(caractereAtual);
                case '@' -> staccato.adicionaNota(randomizaNota());
                case ' ' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas(); 
                    staccato.dobraVolume();
                }
                case '!' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(CODIGO_AGOGO);
                }
                case 'I','i','O','o','U','u' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas(); 
                    staccato.defineInstrumento(CODIGO_HARPSICHORD);
                }
                case '\n' ->{
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(CODIGO_TUBULAR_BELLS);
                }
                case ';' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(CODIGO_PAN_FLUTE);
                }
                case ',' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(CODIGO_CHURCH_ORGAN);
                }
                case '#' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(CODIGO_GUITARRA);
                }
                case '$' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(CODIGO_ORQUESTRA);
                }
                case '0','1','2','3','4','5','6','7','8','9' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.defineInstrumento(staccato.retornaInstrumento() + Character.getNumericValue(caractereAtual));
                }
                case '?' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.aumentaOitava();
                }
                case '%' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.diminuiOitava();
                }
                case '+' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.aumentaBPM();
                }
                case '-' -> {
                    listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
                    staccato.apagaSequenciaDeNotas();
                    staccato.diminuiBPM();
                }
                default -> {
                    if(i >= 1){
                        caractereAnterior = (int) this.textoInput.charAt(i-1);
                        if(notaMusical(caractereAnterior)){
                            staccato.adicionaNota(this.textoInput.charAt(i-1));
                        }
                        else{
                            staccato.adicionaPausa();
                        }
                    }
                    else{
                        staccato.adicionaPausa();
                    }
                }
            }           
        }
        listaDeStaccatos.add(staccato.montaStaccatoComAtributos());
        return listaDeStaccatos;
    }
    
    public String geraTextoParametrizado(InterpretadorDeTexto interpretador){
        
        List<String> listaDeStaccatos = interpretador.decompoeTextoEmStaccatos();
        String textoMusical = "";
        
        for(String staccato : listaDeStaccatos){
            System.out.println(staccato);
            textoMusical = textoMusical + staccato;
        }
        
        return textoMusical;
    }
    
}
