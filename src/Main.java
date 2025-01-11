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



        while(riproduzionePlayer) {
            System.out.print("Che contenuto multimediale vuoi riprodurre? Scegli un numero da 1 a 5 oppure 0 per uscire: ");
            switch (sc.nextLine()) {
                case "0": {
                    System.out.println("Chiusura del player multimediale...");
                    riproduzionePlayer = false;
                    break;
                }

                case "1": {
                    if(contenutiMultimediali[0] instanceof Registrazione){
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Registrazione) contenutiMultimediali[0]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Registrazione) contenutiMultimediali[0]).abbassaVolume();
                        }
                        ((Registrazione) contenutiMultimediali[0]).play();
                    } else if (contenutiMultimediali[0] instanceof Video) {
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[0]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[0]).abbassaVolume();
                        }
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        input = sc.nextLine();
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[0]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[0]).abbassaLuminosità();
                        }
                        ((Video) contenutiMultimediali[0]).play();
                    }
                    else {
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[0]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[0]).abbassaLuminosità();
                        }
                        ((Immagine) contenutiMultimediali[0]).show();
                    }
                    break;
                }
                case "2": {
                    if(contenutiMultimediali[1] instanceof Registrazione){
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Registrazione) contenutiMultimediali[1]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Registrazione) contenutiMultimediali[1]).abbassaVolume();
                        }
                        ((Registrazione) contenutiMultimediali[1]).play();
                    } else if (contenutiMultimediali[1] instanceof Video) {
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[1]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[1]).abbassaVolume();
                        }
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        input = sc.nextLine();
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[1]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[1]).abbassaLuminosità();
                        }
                        ((Video) contenutiMultimediali[1]).play();
                    }
                    else {
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[1]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[1]).abbassaLuminosità();
                        }
                        ((Immagine) contenutiMultimediali[1]).show();
                    }
                    break;
                }
                case "3": {
                    if(contenutiMultimediali[2] instanceof Registrazione){
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Registrazione) contenutiMultimediali[2]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Registrazione) contenutiMultimediali[2]).abbassaVolume();
                        }
                        ((Registrazione) contenutiMultimediali[2]).play();
                    } else if (contenutiMultimediali[2] instanceof Video) {
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[2]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[2]).abbassaVolume();
                        }
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        input = sc.nextLine();
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[2]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[2]).abbassaLuminosità();
                        }
                        ((Video) contenutiMultimediali[2]).play();
                    }
                    else {
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[2]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[2]).abbassaLuminosità();
                        }
                        ((Immagine) contenutiMultimediali[2]).show();
                    }
                    break;
                }
                case "4": {
                    if(contenutiMultimediali[3] instanceof Registrazione){
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Registrazione) contenutiMultimediali[3]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Registrazione) contenutiMultimediali[3]).abbassaVolume();
                        }
                        ((Registrazione) contenutiMultimediali[3]).play();
                    } else if (contenutiMultimediali[3] instanceof Video) {
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[3]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[3]).abbassaVolume();
                        }
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        input = sc.nextLine();
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[3]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[3]).abbassaLuminosità();
                        }
                        ((Video) contenutiMultimediali[3]).play();
                    }
                    else {
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[3]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[3]).abbassaLuminosità();
                        }
                        ((Immagine) contenutiMultimediali[3]).show();
                    }
                    break;
                }
                case "5": {
                    if(contenutiMultimediali[4] instanceof Registrazione){
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Registrazione) contenutiMultimediali[4]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Registrazione) contenutiMultimediali[4]).abbassaVolume();
                        }
                        ((Registrazione) contenutiMultimediali[4]).play();
                    } else if (contenutiMultimediali[4] instanceof Video) {
                        System.out.print("Vuoi alzare il volume? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[4]).alzaVolume();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[4]).abbassaVolume();
                        }
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        input = sc.nextLine();
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[4]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[4]).abbassaLuminosità();
                        }
                        ((Video) contenutiMultimediali[4]).play();
                    }
                    else {
                        System.out.print("Vuoi alzare la luminosità? '+' per alzare, '-' per abbassare, 'invio' per non fare nulla e visualizzare il contenuto: ");
                        String input = sc.nextLine(); //qui salvo le azioni che l'utente vuole compiere
                        if (input.equals("+")){
                            ((Video) contenutiMultimediali[4]).alzaLuminosità();
                        } else if (input.equals("-")) {
                            ((Video) contenutiMultimediali[4]).abbassaLuminosità();
                        }
                        ((Immagine) contenutiMultimediali[4]).show();
                    }
                    break;
                }

                default: {
                    System.out.println("Inserire un valore corretto");
                }
            }
        }
    }

    public static void aggiungiRegistrazione(ContenutoMultimediale r){
        for (int i = 0; i < contenutiMultimediali.length; i++) {
            if (contenutiMultimediali[i] == null) {
                contenutiMultimediali[i] = r;
                return;
            }

        }
    }

    public static void aggiungiVideo(ContenutoMultimediale v){
        for (int i = 0; i < contenutiMultimediali.length; i++) {
            if (contenutiMultimediali[i] == null) {
                contenutiMultimediali[i] = v;
                return;
            }

        }
    }

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