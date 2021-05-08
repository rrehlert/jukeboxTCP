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
    private int ibpm;
    private int iinstrumento;
    private int ivolume;
    private int ioitava;

    private static final int CODIGO_A = 65;
    private static final int CODIGO_G = 71;
    private static final int CODIGO_HARPSICHORD = 7;
    private static final int CODIGO_TUBULAR_BELLS = 15;
    private static final int CODIGO_CHURCH_ORGAN = 20;
    private static final int CODIGO_GUITARRA = 26;
    private static final int CODIGO_ORQUESTRA = 55;
    private static final int CODIGO_PAN_FLUTE = 76;
    private static final int CODIGO_AGOGO = 114;

    private final int CODIGO_PIANO = 0;
    private final int CODIGO_VIOLAO = 24;
    private final int CODIGO_VIOLIN = 40;


    public InterpretadorDeTexto() {
        this.textoInput = "";
        this.listaDeStaccatos = new ArrayList<>();
    }

    public void defineTextoInput(String input) {
        this.textoInput = input;
    }

    private void adicionaStaccatoNaLista(StaccatoString staccato) {
        this.listaDeStaccatos.add(staccato.geraStringParametrizada());
        staccato.apagaSequenciaDeNotas();
    }

    private void apagaLista() {
        this.listaDeStaccatos.clear();
    }

    private boolean notaMusical(int codigoCaractere) {
        return (codigoCaractere >= CODIGO_A) && (codigoCaractere <= CODIGO_G);
    }

    private char randomizaNota() {

        Random geradorDeNumeros = new Random();
        int numeroAleatorio = geradorDeNumeros.nextInt(6);

        switch (numeroAleatorio) {
            case 0 -> {
                return 'A';
            }
            case 1 -> {
                return 'B';
            }
            case 2 -> {
                return 'C';
            }
            case 3 -> {
                return 'D';
            }
            case 4 -> {
                return 'E';
            }
            case 5 -> {
                return 'F';
            }
            default -> {
                return 'G';
            }
        }
    }

    private int getInstrumentoInicial(String instrumento) {
        switch (instrumento) {
            case "Piano":
                return CODIGO_PIANO;
            case "Violão":
                return CODIGO_VIOLAO;
            case "Guitarra":
                return CODIGO_GUITARRA;
            case "Violino":
                return CODIGO_VIOLIN;
            case "Agogo":
                return CODIGO_AGOGO;
            case "Orquestra":
                return CODIGO_ORQUESTRA;
            case "Flauta de Pã":
                return CODIGO_PAN_FLUTE;
            case "Órgão":
                return CODIGO_CHURCH_ORGAN;
            case "Sinos tubulares":
                return CODIGO_TUBULAR_BELLS;
            case "Cravo":
                return CODIGO_HARPSICHORD;
            default:
                return CODIGO_PIANO;
        }
    }

    private int getVolumeInicial(String volume) {
        switch (volume) {
            case "1":
                return 31;
            case "2":
                return 55;
            case "3":
                return 79;
            case "4":
                return 103;
            case "5":
                return 127;
            default:
                return 79;
        }
    }

    private void decompoeTextoEmStaccatos() {

        StaccatoString staccato = new StaccatoString();
        staccato.defineBPM(ibpm);
        staccato.defineInstrumento(iinstrumento);
        staccato.defineVolume(ivolume);
        staccato.defineOitava(ioitava);


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


        for (String staccato : this.listaDeStaccatos) {
            //System.out.println(staccato);
            textoParametrizado = textoParametrizado + staccato;
        }

        this.apagaLista();

        return textoParametrizado;
    }

    public void defineConfiguracoesIniciais(String bpm, String instrumento, String volume, String oitava) {

        this.ibpm = Integer.parseInt(bpm);
        this.iinstrumento = getInstrumentoInicial(instrumento);
        this.ivolume = getVolumeInicial(volume);
        this.ioitava = Integer.parseInt(oitava);

    }
}
