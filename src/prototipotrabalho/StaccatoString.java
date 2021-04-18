/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

public class StaccatoString {
    
    //atributos da classe
    
    private int oitava;
    private int instrumento;
    private int volume;
    private int BPM;
    private String sequenciaNotas;
    
    //constantes da classe
    
    private final int OITAVA_MAXIMA = 10;
    private final int OITAVA_MINIMA = 0;
    private final int OITAVA_DEFAULT = 5;
    
    private final int INSTRUMENTO_MAXIMO = 127;
    private final int INSTRUMENTO_MINIMO = 0;
    
    private final int VOLUME_MAXIMO = 127;
    private final int VOLUME_MINIMO = 31;
    private final int VOLUME_DEFAULT = 63;
    
    private final int BPM_MINIMO = 30;
    private final int BPM_DEFAULT = 60;
    
    //métodos da classe
    
    public StaccatoString(){
        this.oitava = OITAVA_DEFAULT;
        this.instrumento = INSTRUMENTO_MINIMO;
        this.volume = VOLUME_DEFAULT;
        this.BPM = BPM_DEFAULT;
        this.sequenciaNotas = "";
    }
    
    private void resetaVolume(StaccatoString staccato){
        staccato.volume = VOLUME_DEFAULT;
    }
    
    public void defineVolume(StaccatoString staccato, int volume){
       if((volume >= VOLUME_MINIMO) && (volume <= VOLUME_MAXIMO)){
           staccato.volume = volume;
       }
    }
    
    public void dobraVolume(StaccatoString staccato){
        if((staccato.volume * 2) > VOLUME_MAXIMO){
            staccato.resetaVolume(staccato);
        }
        else{
            staccato.volume *= 2;
        }
    }
    
    public void defineBPM(StaccatoString staccato, int BPM){
       if(BPM >= BPM_MINIMO){
           staccato.BPM = BPM;
       }
    }
    
    public void aumentaBPM(StaccatoString staccato){
        staccato.BPM += 30;
    }
    
    public void diminuiBPM(StaccatoString staccato){
        if((staccato.BPM - 30) <= BPM_MINIMO){
            staccato.BPM = BPM_MINIMO;
        }
        else{
            staccato.BPM -= 30;
        }
    }
    
    private void resetaOitava(StaccatoString staccato){
        staccato.oitava = OITAVA_DEFAULT;
    }
    
    public void defineOitava(StaccatoString staccato, int oitava){
       if((oitava >= OITAVA_MINIMA) && (oitava <= OITAVA_MAXIMA)){
           staccato.oitava = oitava;
       }
    }
    
    public void aumentaOitava(StaccatoString staccato){
        if((staccato.oitava + 1) > OITAVA_MAXIMA){
            staccato.resetaOitava(staccato);
        }
        else{
            staccato.oitava ++;
        }
    }
    
    public void diminuiOitava(StaccatoString staccato){
        if((staccato.oitava - 1) <= OITAVA_MINIMA){
            staccato.oitava = OITAVA_MINIMA;
        }
        else{
            staccato.oitava --;
        }
    }
    
    public void defineInstrumento(StaccatoString staccato, int instrumento){
        if((instrumento >= INSTRUMENTO_MINIMO) && (instrumento <= INSTRUMENTO_MAXIMO)){
           staccato.instrumento = instrumento;
       }
    }
    
    public void defineSequenciaDeNotas(StaccatoString staccato, String notas){
        staccato.sequenciaNotas = notas;
    }
    
    public void adicionaNotas(StaccatoString staccato, String notas){
        staccato.sequenciaNotas = staccato.sequenciaNotas + notas;
    }
    
    public String montaStaccatoComAtributos(StaccatoString staccato){
        
        String sequenciaNotasComOitavas = staccato.sequenciaNotas.replace(" ", staccato.oitava + " ");
        return ("T" + staccato.BPM + " V0 I" + staccato.instrumento + " :CON(7," + staccato.volume + ")" + " " + sequenciaNotasComOitavas);
    }
    
}
