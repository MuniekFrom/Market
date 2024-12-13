import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //2D ArrayList

        ArrayList<ArrayList<String>> Shop= new ArrayList<>();

        ArrayList <String> drinks = new ArrayList<>();
        ArrayList <String> vegetables = new ArrayList<>();
        ArrayList <String> fruits = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        Shop.add(drinks);
        Shop.add(vegetables);
        Shop.add(fruits);

        System.out.println("-----WELCOME TO THE MARKET-----");

        boolean FirstStep = false;
        int FirstDecision=0;
        boolean SecondStep = false;
        String SecondDecision="";
        String ProductChoose="";
        boolean ThirdStep=false;
        double cena=0;
        double kosztwody = 0.99;
        double kosztsoku = 2.99;
        double kosztkawy = 3.99;
        double kosztsalaty = 1.99;
        double kosztogorka = 1.49;
        double kosztziemniakow = 3.49;
        double kosztbanana = 1.25;
        double koszttruskawek = 8.99;
        double kosztmalin = 12.49;

        DecimalFormat df = new DecimalFormat("#.##");

        while(!FirstStep){
            System.out.println("Co chcesz zrobić?\n1-Poproś o menu  2-Szturchnij kasjerkę   3-Odejdź");
            if(scanner.hasNextInt()){
                FirstDecision = scanner.nextInt();

                if(FirstDecision == 1){
                    System.out.println("***MENU***\nNAPOJE   WARZYWA    OWOCE\nWoda     Sałata     Banan\nSok      Ogórek     Truskawki\nKawa     Ziemniaki  Maliny\n\n");
                    while(!SecondStep){
                        System.out.println("Chcesz coś kupić? (TAK/NIE/KOSZYK/KUP)");
                        SecondDecision = scanner.next();
                        if (SecondDecision.equalsIgnoreCase("tak")){
                            ThirdStep=false;
                            System.out.println("Jaki produkt chcesz kupić? (Nazwa_produktu/Powrót)");
                            while (!ThirdStep){
                                System.out.print("Wybierz produkt:");
                                ProductChoose = scanner.next();
                                if (ProductChoose.equalsIgnoreCase("woda")){
                                    drinks.add("woda");
                                    cena += kosztwody;
                                }
                                else if (ProductChoose.equalsIgnoreCase("sok")){
                                    drinks.add("sok");
                                    cena += kosztsoku;
                                }
                                else if (ProductChoose.equalsIgnoreCase("kawa")){
                                    drinks.add("kawa");
                                    cena += kosztkawy;
                                }
                                else if (ProductChoose.equalsIgnoreCase("sałata")){
                                    vegetables.add("sałata");
                                    cena += kosztsalaty;
                                }
                                else if (ProductChoose.equalsIgnoreCase("ogórek")){
                                    vegetables.add("ogórek");
                                    cena += kosztogorka;
                                }
                                else if (ProductChoose.equalsIgnoreCase("ziemniaki")){
                                    vegetables.add("ziemniaki");
                                    cena += kosztziemniakow;
                                }

                                else if (ProductChoose.equalsIgnoreCase("banan")){
                                    fruits.add("banan");
                                    cena += kosztbanana;

                                }
                                else if (ProductChoose.equalsIgnoreCase("truskawki")){
                                    fruits.add("truskawki");
                                    cena += koszttruskawek;
                                }
                                else if (ProductChoose.equalsIgnoreCase("maliny")){
                                    fruits.add("maliny");
                                    cena += kosztmalin;
                                }
                                else if(ProductChoose.equalsIgnoreCase("powrót") || ProductChoose.equalsIgnoreCase("powrot")){
                                    System.out.println("Powrót do poprzedniego menu");
                                    ThirdStep=true;
                                }
                                else {
                                    System.out.println("Nie ma takiego produktu");
                                }
                            }
                        }
                        else if (SecondDecision.equalsIgnoreCase("nie")) {
                            System.out.println("Do widzenia!");
                            SecondStep=true;
                            FirstStep=true;
                        }
                        else if(SecondDecision.equalsIgnoreCase("koszyk")){
                            if (!((drinks.isEmpty()) && (vegetables.isEmpty()) && (fruits.isEmpty()))){
                                System.out.println("Twój koszyk: \n");
                                if(!(drinks.isEmpty())){
                                    System.out.println("Napoje: ");
                                    for (int i=0;i<drinks.size();i++){
                                        System.out.println("-" + drinks.get(i));
                                    }
                                }
                                if(!(vegetables.isEmpty())){
                                    System.out.println("Warzywa: ");
                                    for (int i=0;i<vegetables.size();i++){
                                        System.out.println("-" + vegetables.get(i));
                                    }
                                }
                                if(!(fruits.isEmpty())){
                                    System.out.println("Owoce: ");
                                    for (int i=0;i<fruits.size();i++){
                                        System.out.println("-" + fruits.get(i));
                                    }
                                }
                                String dfcenakoszyk = df.format(cena);
                                System.out.println("Cena za twoje produkty: " + dfcenakoszyk + "zł.");
                            }
                            else {
                                System.out.println("Masz pusty koszyk!");
                            }
                        }
                        else if(SecondDecision.equalsIgnoreCase("kup")){
                            if ((drinks.isEmpty()) && (vegetables.isEmpty()) && (fruits.isEmpty())){
                                System.out.println("Masz pusty koszyk!");
                            } else {
                                System.out.println("Kupiłeś produkty! Trzymaj paragon");
                                if(!(drinks.isEmpty())){
                                    for (int i=0;i<drinks.size();i++){
                                        System.out.println("-" + drinks.get(i));
                                    }
                                }
                                if(!(vegetables.isEmpty())){
                                    for (int i=0;i<vegetables.size();i++){
                                        System.out.println("-" + vegetables.get(i));
                                    }
                                }
                                if(!(fruits.isEmpty())){
                                    for (int i=0;i<fruits.size();i++){
                                        System.out.println("-" + fruits.get(i));
                                    }
                                }
                                String dfcenaparagon = df.format(cena);
                                System.out.println("Cena: " + dfcenaparagon + "zł.");
                                SecondStep = true;
                                FirstStep = true;
                            }
                        }
                        else {
                            System.out.println("To nie jest dobra odpowiedź!");
                        }
                    }
                }
                else if(FirstDecision == 2){
                    System.out.println("Kasjerka wkurzyła się na ciebie i nic tobie już nie sprzeda!");
                    FirstStep=true;
                }
                else if(FirstDecision == 3){
                    System.out.println("Odszedleś ze sklepu. Do widzenia!");
                    FirstStep=true;
                }


            } else {
                System.out.println("Wybierz mądrze!");
                scanner.next();
            }
        }




    }
}