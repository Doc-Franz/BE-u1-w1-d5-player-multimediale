package player;

public class Registrazione extends ContenutoMultimediale implements ContenutoRiproducibile{
    private int durata;
    private int volume;

    public Registrazione(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void play(){
        System.out.println("Registrazioneee");
    };

    public void alzaVolume(){
        volume ++;
    };

    public void abbassaVolume(){
        volume --;
    };


    public void info(){
        System.out.println("Il titolo della Registrazione è " + this.getTitolo() + ", la durata è di " + this.durata + " min," + "il volume è " + this.volume);
    }
}
