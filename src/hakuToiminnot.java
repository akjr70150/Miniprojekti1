import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.net.URI;
import java.net.URL;
import java.util.*;


public class hakuToiminnot {
    Scanner skanneri = new Scanner(System.in);
    List<Juna> junaLista;
    List<Asema> asemaLista;
    List<TimeTableRow> timeTableRows;


    public List<Juna> lueJunanJSONData() {  // hakee sivustolta junien tiedot
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/live-trains", baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            junaLista = mapper.readValue(url, tarkempiListanTyyppi);
            return junaLista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Juna> haeReitinJunat(String lahto, String maara) { // hakee sivustolta reitin junat
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/live-trains/station/%s/%s", baseurl, lahto, maara)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            List<Juna> junaLista = mapper.readValue(url, tarkempiListanTyyppi);
            return junaLista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public List<Asema> lueAsemanJSONData() { // hakee sivustolta asemien tiedot
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/metadata/stations", baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Asema.class);
            asemaLista = mapper.readValue(url, tarkempiListanTyyppi);
            return asemaLista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




    public void junanValinta() {
        AsemienValinta asemienValinta=new AsemienValinta();
        Main main = new Main();
        System.out.println("Anna junan tunnus: "); // Käyttäjä antaa junan tunnuksen, metodi hakee kyseisen junan tiedot.
        String junanTunnus = skanneri.nextLine();
        if (junanTunnus.equals(null)) {
            junanValinta();
        }
        String käyttäjänHakemaJuna = junanHaku(junanTunnus);
        System.out.println(käyttäjänHakemaJuna);

        System.out.println("\n1. Tee haku uudestaan");
        System.out.println("2. Hae aseman perusteella");
        System.out.println("3. Lopeta");
        String jatkonValinta = skanneri.nextLine();
        if (jatkonValinta.equals(null)) {
            junanValinta();
        }

        if (jatkonValinta.equals("1")){
            junanValinta();
        }
        else if (jatkonValinta.equals("2")){
            asemienValinta.asemienValinta();
        }
        else if (jatkonValinta.equals("3")){
            System.out.println("Kiitos käynnistä");
        }else{
            System.out.println("Lue ohjeet uudestaan kiitos :)");
            System.out.println("Paluu etusivulle kolmessa sekunnissa");
            try{
                Thread.sleep(3000);}
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            main.ohjelmanKäynnistys();
        }

    }

    public String junanHaku(String junanTyyppi) { // hakee käyttäjän syöttämällä id:llä ko. junan
        if (junaLista == null) {
            lueJunanJSONData();
        }
        for (int i = 0; i < junaLista.size(); i++) {
            String junanId = junaLista.get(i).getTrainType() + junaLista.get(i).getTrainNumber();
            if (junanId.equals(junanTyyppi)) {
                return "" + junaLista.get(i);
            }
        }
                return "Valitsemasi juna ei kulje seuraavan vuorokauden aikana.";

    }

    public String asemienYhdistäminen(final String stationShortCode) { // yhdistää asemien lyhytkoodit
        if (asemaLista == null) {
            lueAsemanJSONData();
        }

        Optional<String> nimi = asemaLista
                .parallelStream()
                .filter(a->a.getStationShortCode().equals(stationShortCode))
                .map(Asema::getStationName)
                .findFirst();
        return nimi.orElse("Tuntematon");

    }
}






