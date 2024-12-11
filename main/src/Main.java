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

        while(!FirstStep){
            System.out.println("Co chcesz zrobić?\n1-Poproś o menu  2-Szturchnij kasjerkę   3-Odejdź");
            if(scanner.hasNextInt()){
                FirstDecision = scanner.nextInt();

                if(FirstDecision == 1){
                    System.out.println("***MENU***\nNAPOJE   WARZYWA    OWOCE\nWoda     Sałata     Banan\nSok      Ogórek     Truskawki\nKawa     Ziemniaki  Maliny\n\n");
                    while(!SecondStep){
                        System.out.println("Chcesz coś kupić? (TAK/NIE/KOSZYK)");
                        SecondDecision = scanner.next();
                        if (SecondDecision.equalsIgnoreCase("tak")){
                            ThirdStep=false;
                            System.out.println("Jaki produkt chcesz kupić? (Nazwa_produktu/Powrót)");
                            while (!ThirdStep){
                                System.out.print("Wybierz produkt:");
                                ProductChoose = scanner.next();
                                if (ProductChoose.equalsIgnoreCase("woda")){
                                    drinks.add("woda");
                                }
                                else if (ProductChoose.equalsIgnoreCase("sok")){
                                    drinks.add("sok");
                                }
                                else if (ProductChoose.equalsIgnoreCase("kawa")){
                                    drinks.add("kawa");
                                }
                                else if (ProductChoose.equalsIgnoreCase("sałata")){
                                    vegetables.add("sałata");
                                }
                                else if (ProductChoose.equalsIgnoreCase("ogórek")){
                                    vegetables.add("ogórek");
                                }
                                else if (ProductChoose.equalsIgnoreCase("ziemniaki")){
                                    vegetables.add("ziemniaki");
                                }

                                else if (ProductChoose.equalsIgnoreCase("banan")){
                                    fruits.add("banan");

                                }
                                else if (ProductChoose.equalsIgnoreCase("truskawki")){
                                    fruits.add("truskawki");
                                }
                                else if (ProductChoose.equalsIgnoreCase("maliny")){
                                    fruits.add("maliny");
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

                            }
                            else {
                                System.out.println("Masz pusty koszyk!");
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