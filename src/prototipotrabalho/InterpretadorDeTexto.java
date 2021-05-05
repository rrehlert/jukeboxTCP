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
    private final List<String> listaDeStaccatos;
    
    
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
        this.listaDeStaccatos = new ArrayList<>();
    }
    
    public void defineTextoInput(String input){
        this.textoInput = input;
    }
    
    private void adicionaStaccatoNaLista(StaccatoString staccato){
        this.listaDeStaccatos.add(staccato.geraStringParametrizada());
        staccato.apagaSequenciaDeNotas();
    }
    
    private void apagaLista(){
        this.listaDeStaccatos.clear();
    }
    
    private boolean notaMusical(int codigoCaractere){
        return (codigoCaractere >= CODIGO_A) && (codigoCaractere <= CODIGO_G);
    }
    
    private char randomizaNota(){
        
        Random geradorDeNumeros = new Random();
        int numeroAleatorio = geradorDeNumeros.nextInt(6);
       
        switch (numeroAleatorio){
            case 0 -> {return 'A';}
            case 1 -> {return 'B';}
            case 2 -> {return 'C';}
            case 3 -> {return 'D';}
            case 4 -> {return 'E';}
            case 5 -> {return 'F';}
            default -> {return 'G';}
        }
    }
    
    private void decompoeTextoEmStaccatos(){
        
        StaccatoString staccato = new StaccatoString();
        char caractereAtual; int caractereAnterior;
        
        for(int i = 0; i < this.textoInput.length(); i++){
            
            caractereAtual = this.textoInput.charAt(i);
            switch (caractereAtual){
                
                case 'A','B','C','D','E','F','G' -> staccato.adicionaNota(caractereAtual);
                case '@' -> staccato.adicionaNota(randomizaNota());
                case ' ' -> {
                    this.adicionaStaccatoNaLista(staccato); 
                    staccato.dobraVolume();
                }
                case '!' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_AGOGO);
                }
                case 'I','i','O','o','U','u' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_HARPSICHORD);
                }
                case '\n' ->{
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_TUBULAR_BELLS);
                }
                case ';' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_PAN_FLUTE);
                }
                case ',' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_CHURCH_ORGAN);
                }
                case '#' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_GUITARRA);
                }
                case '$' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_ORQUESTRA);
                }
                case '0','1','2','3','4','5','6','7','8','9' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(staccato.retornaInstrumento() + Character.getNumericValue(caractereAtual));
                }
                case '?' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.aumentaOitava();
                }
                case '%' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.diminuiOitava();
                }
                case '+' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.aumentaBPM();
                }
                case '-' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.diminuiBPM();
                }
                default -> {
                    if(i != 0){
                        caractereAnterior = (int)this.textoInput.charAt(i-1);
                        if(notaMusical(caractereAnterior)){
                            staccato.adicionaNota((char)caractereAnterior);
                            continue;
                        }
                    }
                    staccato.adicionaPausa();
                }
            }
        }
        this.adicionaStaccatoNaLista(staccato);
    }
    
    public String geraTextoParametrizado(){
        
        this.decompoeTextoEmStaccatos();
        String textoParametrizado = "";
        
        for(String staccato : this.listaDeStaccatos){
            //System.out.println(staccato);
            textoParametrizado = textoParametrizado + staccato;
        }
        
        this.apagaLista();
        
        return textoParametrizado;
    }
    
}
