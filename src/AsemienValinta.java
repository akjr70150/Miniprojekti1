import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class AsemienValinta extends hakuToiminnot {
    Scanner skanneri = new Scanner(System.in);
    hakuToiminnot metodi = new hakuToiminnot();
    Main main = new Main();


    public void asemienValinta() { // Käyttäjä antaa junan lähtö- ja päämääräasemat. Metodi etsii kyseisellä välillä kulkevat junat.
        System.out.println("Syötä lähtöasema (esim. Helsinki): ");
        String lähtöAsema = skanneri.nextLine().toLowerCase();
        if (lähtöAsema.isEmpty()) {
            asemienValinta();
        }
        else {
            String lahtoasemanFiksaus = lähtöAsema.substring(0,1).toUpperCase();
            lähtöAsema = lahtoasemanFiksaus+lähtöAsema.substring(1);
        }

        System.out.println("Syötä pääteasema (esim. Lahti): ");
        String pääteAsema = skanneri.nextLine().toLowerCase();
        if (pääteAsema.isEmpty()) {
            System.out.println("Otappa uudestaan :)");
            System.out.println("Paluu etusivulle kolmessa sekunnissa");
            try{
                Thread.sleep(3000);}
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            main.ohjelmanKäynnistys();

        } else {
            String paateasemanFiksaus = pääteAsema.substring(0,1).toUpperCase();
            pääteAsema = paateasemanFiksaus+pääteAsema.substring(1);
        }

        String lahtoasemanMuunto = syötetynLahtoasemanMuunto(lähtöAsema);
        String paateasemanMuunto = syötetynPaateasemanMuunto(pääteAsema);
        String lähtö = lähtöAsemanMuunto(lahtoasemanMuunto);
        String pääte = pääteAsemanMuunto(paateasemanMuunto);
        reitinHaku(lähtö, pääte);
        System.out.println(reitinHaku(lähtö, pääte));


        System.out.println("\n1. Tee haku uudestaan");
        System.out.println("2. Syötä halutun junan tunnus");
        System.out.println("3. Lopeta");
        String jatkonValinta = skanneri.nextLine();
        if (jatkonValinta.equals(null)) {
            main.ohjelmanKäynnistys();
        }

        if (jatkonValinta.equals("1")) {
            asemienValinta();
        }
        else if (jatkonValinta.equals("2")) {
            metodi.junanValinta();
        }
        else if (jatkonValinta.equals("3")) {
            System.out.println("Kiitos käynnistä!");

        }
        else {
            System.out.println("Lue ohjeet uudestaan kiitos :)");
            System.out.println("Paluu etusivulle kolmessa sekunnissa");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            main.ohjelmanKäynnistys();

        }
    }

    public String syötetynPaateasemanMuunto(String pääteAsema) { // yhdistää properties-tiedoston pääteasemalle
        ResourceBundle rb = ResourceBundle.getBundle("asemat");
        if (rb.containsKey(pääteAsema)) {
            return "" + rb.getString(pääteAsema);
        }
        return "" + pääteAsema;
    }

    public String syötetynLahtoasemanMuunto(String lähtöAsema) { // yhdistää properties-tiedoston lähtöasemalle
        ResourceBundle rb = ResourceBundle.getBundle("asemat");
        if (rb.containsKey(lähtöAsema)) {
            return "" + rb.getString(lähtöAsema);
        }
        return "" + lähtöAsema;
    }

    public String lähtöAsemanMuunto(String lähtöAsema) { // yhdistää aseman lyhytkoodin ja aseman nimen
        if (asemaLista == null) {
            lueAsemanJSONData();
        }
        for (int i = 0; i < asemaLista.size(); i++) {
            if (lähtöAsema.equals(asemaLista.get(i).stationName)) {
                return asemaLista.get(i).stationShortCode;
            }

        }
        return null;
    }

    public String reitinHaku(String lähtö, String pääte) { // katsoo onko lyhytkoodit samat molemmilla sivustoilla
        List<Juna> junat = haeReitinJunat(lähtö, pääte);
        return junat.stream()
                .map(Juna::vainJunanTiedot)
                .collect(Collectors.joining("\n"));
    }

    public String pääteAsemanMuunto(String pääteAsema) { // katsoo onko pääteasema sama kuin sivustolla oleva aseman nimi
        if (asemaLista == null) {
            lueAsemanJSONData();
        }
        boolean ehto = false;
        for (int i = 0; i < asemaLista.size(); i++) {
            if (pääteAsema.equals(asemaLista.get(i).stationName)) {
                return asemaLista.get(i).stationShortCode;
            } else {
                ehto = true;
            }
        }
        if (ehto) {
            System.out.println("Asemaa ei löytynyt.");
                System.out.println("Paluu etusivulle kolmessa sekunnissa");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                main.ohjelmanKäynnistys();
        }

        return null;
    }
}





