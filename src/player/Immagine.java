package player;

public class Immagine extends ContenutoMultimediale implements ContenutoNonRiproducibile {
    private int luminosità;
    public Immagine(String titolo, int luminosità) {
        super(titolo);
        this.luminosità = luminosità;
    }

    public void show(){
        System.out.println(getTitolo() + " " + "*".repeat(luminosità));
    };

    public void alzaLuminosità(){
      luminosità ++;
    }

    public void abbassaLuminosità() {
        luminosità --;
    }

    public void info(){
        System.out.println("Il titolo del Video è " + this.getTitolo() + ", la luminosità è " + this.luminosità);
    }
}
