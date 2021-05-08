/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorDeMusica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConversorDeTexto {

    private String textoInput;
    private final StaccatoString staccato;
    private final List<String> listaDeStaccatos;

    private static final int CODIGO_A = 65;
    private static final int CODIGO_G = 71;
    
    public static final int CODIGO_PIANO = 0;
    public static final int CODIGO_HARPSICHORD = 7;
    public static final int CODIGO_TUBULAR_BELLS = 15;
    public static final int CODIGO_CHURCH_ORGAN = 20;
    public static final int CODIGO_VIOLAO = 24;
    public static final int CODIGO_GUITARRA = 26;
    public static final int CODIGO_VIOLIN = 40;
    public static final int CODIGO_ORQUESTRA = 55;
    public static final int CODIGO_PAN_FLUTE = 76;
    public static final int CODIGO_AGOGO = 114;


    public ConversorDeTexto(StaccatoString staccato) {
        this.textoInput = "";
        this.staccato = staccato;
        this.listaDeStaccatos = new ArrayList<>();
    }

    public void defineTextoInput(String input) {
        this.textoInput = input;
    }
    
    private boolean notaMusical(int codigoCaractere) {
        return (codigoCaractere >= CODIGO_A) && (codigoCaractere <= CODIGO_G);
    }

    private void adicionaStaccatoNaLista(StaccatoString staccato) {
        this.listaDeStaccatos.add(staccato.geraStringParametrizada());
        staccato.apagaSequenciaDeNotas();
    }

    private void apagaLista() {
        this.listaDeStaccatos.clear();
    }

    private char randomizaNota() {

        Random geradorDeNumeros = new Random();
        int numeroAleatorio = geradorDeNumeros.nextInt(6);

        return switch (numeroAleatorio) {
            case 0 -> 'A';
            case 1 -> 'B';
            case 2 -> 'C';
            case 3 -> 'D';
            case 4 -> 'E';
            case 5 -> 'F';
            default ->'G';
        };
    }

    private void decompoeTextoEmStaccatos() {

        char caractereAtual, caractereAnterior;

        for (int i = 0; i < this.textoInput.length(); i++) {

            caractereAtual = this.textoInput.charAt(i);
            switch (caractereAtual) {

                case 'A', 'B', 'C', 'D', 'E', 'F', 'G' -> staccato.adicionaNota(caractereAtual);
                case '@' -> staccato.adicionaNota(randomizaNota());
                case ' ' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.dobraVolume();
                }
                case '!' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_AGOGO);
                }
                case 'I', 'i', 'O', 'o', 'U', 'u' -> {
                    this.adicionaStaccatoNaLista(staccato);
                    staccato.defineInstrumento(CODIGO_HARPSICHORD);
                }
                case '\n' -> {
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
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
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
                    if (i != 0) {
                        caractereAnterior = this.textoInput.charAt(i - 1);
                        if (notaMusical((int) caractereAnterior)) {
                            staccato.adicionaNota(caractereAnterior);
                            continue;
                        }
                    }
                    staccato.adicionaPausa();
                }
            }
        }
        this.adicionaStaccatoNaLista(staccato);
    }

    public String geraTextoParametrizado() {

        this.decompoeTextoEmStaccatos();
        String textoParametrizado = "";

        for (String staccatoAtual : this.listaDeStaccatos) {
            textoParametrizado = textoParametrizado + staccatoAtual;
        }

        this.apagaLista();

        return textoParametrizado;
    }
}
