import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ohjelmanKäynnistys();
//
    }

    public static void ohjelmanKäynnistys(){         // Valikko. Käyttäjä valitsee toiminnon. Väärän numeron syöttäminen johtaa paluuseen.
        hakuToiminnot metodi = new hakuToiminnot();
        AsemienValinta valinta = new AsemienValinta();
        System.out.println(
                "                 _-====-__-======-__-========-_____-============-__\n" +
                "               _(                                                 _)\n" +
                "            OO(      •._.••´¯``•.¸¸.•`TERVETULOA`•.¸¸.•´´¯`••._.•     )_\n" +
                "           0  (_                                                   _)\n" +
                "         o0     (_                                                _)\n" +
                "        o         '=-___-===-_____-========-___________-===-----='\n" +
                "      .o                                _________\n" +
                "     . ______          ______________  |         |      _____\n" +
                "   _()_||__|| ________ |            |  |_________|   __||___||__\n" +
                "  (   VR    | |      | |            | __Y______00_| |_         _|\n" +
                " /-OO----OO\"\"=\"OO--OO\"=\"OO--------OO\"=\"OO-------OO\"=\"OO-------OO\"=P\n" +
                "#####################################################################");

        System.out.println("   ______________________________\n" +
                " / \\                             \\.\n" +
                "|   |                            |.\n" +
                " \\_ |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |      Valitse luku 1-3      |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    | 1. Hae asemien perusteella |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    | 2. Hae junan perusteella   |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    | 3. Lopeta                  |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |                            |.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |   _________________________|___");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    |  /                            /.");
        try{
            Thread.sleep(100);}
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("    \\_/____________________________/.");

        Scanner skanneri = new Scanner(System.in);
        String luku = skanneri.nextLine();
        if (luku.equals(null)) {
            ohjelmanKäynnistys();
        }
        if (luku.equals("1")) {
            valinta.asemienValinta();
        }
         else if (luku.equals("2")){
            metodi.junanValinta();
        }
         else if (luku.equals("3")){
            System.out.println("Kiitos käynnistä!");
        }else{
            System.out.println("Virheellinen syöte, valitse numero 1-3");
            System.out.println("Paluu etusivulle kolmessa sekunnissa");
            try{
                Thread.sleep(3000);}
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            ohjelmanKäynnistys();

        }

        }
    }
