/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorDeMusica;

public class StaccatoString {
    
    private int oitava;
    private int instrumento;
    private int volume;
    private int BPM;
    private String sequenciaNotas;
    
    private static final int OITAVA_MAXIMA = 10;
    private static final int OITAVA_MINIMA = 0;
    private static final int OITAVA_DEFAULT = 5;
    
    private static final int INSTRUMENTO_MAXIMO = 127;
    private static final int INSTRUMENTO_MINIMO = 0;
    
    private static final int VOLUME_MAXIMO = 127;
    private static final int VOLUME_MINIMO = 31;
    private static final int VOLUME_DEFAULT = 63;
    
    private static final int BPM_MINIMO = 60;
    private static final int BPM_MAXIMO = 210;
    
    
    public StaccatoString(){
        oitava = OITAVA_DEFAULT;
        instrumento = INSTRUMENTO_MINIMO;
        volume = VOLUME_DEFAULT;
        BPM = BPM_MINIMO;
        sequenciaNotas = "";
    }
    
    private void resetaVolume(){
        volume = VOLUME_DEFAULT;
    }
    
    public void defineVolume(int volume){
       if((volume >= VOLUME_MINIMO) && (volume <= VOLUME_MAXIMO)){
           this.volume = volume;
       }
    }
    
    public void dobraVolume(){
        if((volume * 2) > VOLUME_MAXIMO){
            this.resetaVolume();
        }
        else{
            volume *= 2;
        }
    }
    
    public void defineBPM(int BPM){
       if((BPM >= BPM_MINIMO) && (BPM <= BPM_MAXIMO)){
           this.BPM = BPM;
       }
    }
    
    public void aumentaBPM(){
        BPM += 50;
    }
    
    public void diminuiBPM(){
        if((BPM - 50) <= BPM_MINIMO){
            BPM = BPM_MINIMO;
        }
        else{
            BPM -= 50;
        }
    }
    
    private void resetaOitava(){
        oitava = OITAVA_DEFAULT;
    }
    
    public void defineOitava(int oitava){
       if((oitava >= OITAVA_MINIMA) && (oitava <= OITAVA_MAXIMA)){
           this.oitava = oitava;
       }
    }
    
    public void aumentaOitava(){
        if((oitava + 1) > OITAVA_MAXIMA){
            this.resetaOitava();
        }
        else{
            oitava ++;
        }
    }
    
    public void diminuiOitava(){
        if((oitava - 1) <= OITAVA_MINIMA){
            oitava = OITAVA_MINIMA;
        }
        else{
            oitava --;
        }
    }
    
    public void defineInstrumento(int instrumento){
        if((instrumento >= INSTRUMENTO_MINIMO) && (instrumento <= INSTRUMENTO_MAXIMO)){
           this.instrumento = instrumento;
        }
    }
    
    public int retornaInstrumento(){
        return instrumento;
    }
    
    public void adicionaNota(char nota){
        sequenciaNotas = sequenciaNotas + nota + " ";
    }
    
    public void adicionaPausa(){
        sequenciaNotas = sequenciaNotas + "R ";
    }
    
    public void apagaSequenciaDeNotas(){
        sequenciaNotas = "";
    }
    
    private String adicionaOitavasNaSequencia(){
        return sequenciaNotas.replace(" ", this.oitava + " ");
    }
    
    public String geraStringParametrizada(){
        
        String sequenciaNotasComOitavas = adicionaOitavasNaSequencia();
        return ("T" + BPM + " V0 I" + instrumento + " :CON(7," + volume + ") " + sequenciaNotasComOitavas);
    }
    
}
