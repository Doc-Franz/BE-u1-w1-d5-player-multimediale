import player.ContenutoMultimediale;
import player.Immagine;
import player.Registrazione;
import player.Video;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static ContenutoMultimediale[] contenutiMultimediali = new ContenutoMultimediale[5];
    public static boolean contenutiDaInserire = true; //verifica quando l'array viene riempito totalmente
    public static boolean riproduzionePlayer = true; //verifica quando uscire dal player multimediale

    public static String titoloRegistrazione;
    public static int durataRegistrazione;
    public static int volumeRegistrazione;
    public static String titoloVideo;
    public static int durataVideo;
    public static int volumeVideo;
    public static int luminositàVideo;
    public static String titoloImmagine;
    public static int luminositàImmagine;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        selezionaContenuto();
    }

    public static void selezionaContenuto(){


        while (contenutiDaInserire) {

            System.out.print("Che tipo di contenuto vuoi inserire? \nDigita 1 per una Registrazione, 2 per un Video e 3 per un'Immagine: ");
            switch (sc.nextLine()) {
                case "1": {
                    System.out.println("Inserisci i dati della registrazione: ");
                    System.out.print("Titolo: ");
                    titoloRegistrazione = sc.nextLine();
                    System.out.print("Durata: ");
                    durataRegistrazione = Integer.parseInt(sc.nextLine());
                    System.out.print("Volume: ");
                    volumeRegistrazione = Integer.parseInt(sc.nextLine());
                    aggiungiRegistrazione(new Registrazione(titoloRegistrazione, durataRegistrazione, volumeRegistrazione));
                    break;
                }
                case "2": {
                    System.out.println("Inserisci i dati del del video");
                    System.out.print("Titolo: ");
                    titoloVideo = sc.nextLine();
                    System.out.print("Durata: ");
                    durataVideo = Integer.parseInt(sc.nextLine());
                    System.out.print("Volume: ");
                    volumeVideo = Integer.parseInt(sc.nextLine());
                    System.out.print("Luminosità: ");
                    luminositàVideo = Integer.parseInt(sc.nextLine());
                    aggiungiVideo(new Video(titoloVideo, durataVideo, volumeVideo, luminositàVideo));
                    break;
                }
                case "3": {
                    System.out.println("Inserisci i dati dell'immagine");
                    System.out.print("Titolo: ");
                    titoloImmagine = sc.nextLine();
                    System.out.print("Luminosità: ");
                    luminositàImmagine = Integer.parseInt(sc.nextLine());
                    aggiungiImmagine(new Immagine(titoloImmagine, luminositàImmagine));
                    break;
                }
                default:
                    System.out.println("Digitare un valore corretto");
            }
            contenutiDaInserire = controllaArray();
        }

        /*for (int i = 0; i < contenutiMultimediali.length; i++){
            contenutiMultimediali[i].info();
        }*/

        leggiContenuto();

    }

    public static void leggiContenuto(){

        int contenutoSelezionato; // variabile che salva l'elemento selezinato nell'array

        while(riproduzionePlayer) {

            System.out.print("Che contenuto multimediale vuoi riprodurre? Scegli un numero da 1 a 5 oppure 0 per uscire: ");
            contenutoSelezionato = Integer.parseInt(sc.nextLine());
            switch (contenutoSelezionato) {
                case 0: {
                    System.out.println("Chiusura del player multimediale...");
                    riproduzionePlayer = false;
                    break;
                }

                case 1: {
                    if(contenutiMultimediali[0] instanceof Registrazione){
                        gestisciRegistrazione(contenutoSelezionato);
                    } else if (contenutiMultimediali[0] instanceof Video) {
                        gestisciVideo(contenutoSelezionato);
                    }
                    else {
                        gestisciImmagine(contenutoSelezionato);
                    }
                    break;
                }
                case 2: {
                    if(contenutiMultimediali[1] instanceof Registrazione){
                        gestisciRegistrazione(contenutoSelezionato);
                    } else if (contenutiMultimediali[1] instanceof Video) {
                        gestisciVideo(contenutoSelezionato);
                    }
                    else {
                        gestisciImmagine(contenutoSelezionato);
                    }
                    break;
                }
                case 3: {
                    if(contenutiMultimediali[2] instanceof Registrazione){
                        gestisciRegistrazione(contenutoSelezionato);
                    } else if (contenutiMultimediali[2] instanceof Video) {
                        gestisciVideo(contenutoSelezionato);
                    }
                    else {
                        gestisciImmagine(contenutoSelezionato);
                    }
                    break;
                }
                case 4: {
                    if(contenutiMultimediali[3] instanceof Registrazione){
                        gestisciRegistrazione(contenutoSelezionato);
                    } else if (contenutiMultimediali[3] instanceof Video) {
                        gestisciVideo(contenutoSelezionato);
                    }
                    else {
                        gestisciImmagine(contenutoSelezionato);
                    }
                    break;
                }
                case 5: {
                    if(contenutiMultimediali[4] instanceof Registrazione){
                        gestisciRegistrazione(contenutoSelezionato);
                    } else if (contenutiMultimediali[4] instanceof Video) {
                        gestisciVideo(contenutoSelezionato);
                    }
                    else {
                        gestisciImmagine(contenutoSelezionato);
                    }
                    break;
                }

                default: {
                    System.out.println("Inserire un valore corretto");
                }
            }
        }
    }

    //funzione che gestisce la regolazione dei valori di registrazione e la sua stampa a video
    public static void gestisciRegistrazione(int contenutoSelezionato){
        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
        if (input.equals("+")){
            ((Registrazione) contenutiMultimediali[contenutoSelezionato - 1]).alzaVolume();
        } else if (input.equals("-")) {
            ((Registrazione) contenutiMultimediali[contenutoSelezionato - 1]).abbassaVolume();
        }
        ((Registrazione) contenutiMultimediali[contenutoSelezionato - 1]).play();

    }

    //funzione che gestisce la regolazione dei valori di video e la sua stampa a video
    public static void gestisciVideo(int contenutoSelezionato){
        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla: ");
        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
        if (input.equals("+")){
            ((Video) contenutiMultimediali[contenutoSelezionato - 1]).alzaVolume();
        } else if (input.equals("-")) {
            ((Video) contenutiMultimediali[contenutoSelezionato - 1]).abbassaVolume();
        }
        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
        input = sc.nextLine();
        if (input.equals("+")){
            ((Video) contenutiMultimediali[contenutoSelezionato - 1]).alzaLuminosità();
        } else if (input.equals("-")) {
            ((Video) contenutiMultimediali[contenutoSelezionato - 1]).abbassaLuminosità();
        }
        ((Video) contenutiMultimediali[contenutoSelezionato - 1]).play();
    }

    //funzione che gestisce la regolazione dei valori di immagine e la sua stampa a video
    public static void gestisciImmagine(int contenutoSelezionato){
        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
        if (input.equals("+")){
            ((Video) contenutiMultimediali[contenutoSelezionato - 1]).alzaLuminosità();
        } else if (input.equals("-")) {
            ((Video) contenutiMultimediali[contenutoSelezionato - 1]).abbassaLuminosità();
        }
        ((Immagine) contenutiMultimediali[contenutoSelezionato - 1]).show();
    }

    //funzione che gestisce l'aggiunta delle registrazioni nell'array iniziale
    public static void aggiungiRegistrazione(ContenutoMultimediale r){
        for (int i = 0; i < contenutiMultimediali.length; i++) {
            if (contenutiMultimediali[i] == null) {
                contenutiMultimediali[i] = r;
                return;
            }

        }
    }

    //funzione che gestisce l'aggiunta dei video nell'array iniziale
    public static void aggiungiVideo(ContenutoMultimediale v){
        for (int i = 0; i < contenutiMultimediali.length; i++) {
            if (contenutiMultimediali[i] == null) {
                contenutiMultimediali[i] = v;
                return;
            }

        }
    }

    //funzione che gestisce l'aggiunta delle immagini nell'array iniziale
    public static void aggiungiImmagine(ContenutoMultimediale p){
        for (int i = 0; i < contenutiMultimediali.length; i++) {
            if (contenutiMultimediali[i] == null) {
                contenutiMultimediali[i] = p;
                return;
            }

        }
    }

    //Controllo quando l'array è arrivato a riempimento
    public static boolean controllaArray(){
        for (int i = 0; i < contenutiMultimediali.length; i++){
            if (contenutiMultimediali[i] == null){
                return true;
            }
        }
        return false;
    }
}