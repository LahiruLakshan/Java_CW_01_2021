import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int vaccination = 150;
    public static String customerName;
    public static int M;
    public static String[] serviceCenter = new String[6];

    public static void main(String[] args) throws IOException {
        for (int x = 0; x < 6; x++) serviceCenter[x] = "empty";
        while (true) {
            System.out.println("---------------- Welcome to Vaccination ---------------");
            System.out.println("100 or VVB: View all Vaccination Booths");
            System.out.println("101 or VEB:View all Empty EmptyBooths");
            System.out.println("102 or APB:Add Patientto a Booth");
            System.out.println("103 or RPB:Remove Patientfrom a Booth");
            System.out.println("104 or VPS:View PatientsSorted in alphabetical order ");
            System.out.println("105 or SPD:Store Program Data into file");
            System.out.println("106 or LPD:Load ProgramDatafrom file");
            System.out.println("107 or VRV:View Remaining Vaccinations");
            System.out.println("108 or AVS:Add Vaccinationsto the Stock");
            System.out.println("999 or EXT:Exit the Program");

            System.out.print("Enter a number:");
            Scanner in = new Scanner(System.in);
            String input = in.next();

            switch (input) {
                case "VVB":
                case "100":
                    System.out.println("View all Vaccination Booths");
                    vaccinationBooths();
                    break;
                case "101":
                case "VEB":
                    emptyBooths();
                    break;
                case "102":
                case "APB":
                    addPatientBooth();
                    break;
                case "103":
                case "RPB":
                    removePatientBooth();
                    break;
                case "104":
                case "VPS":
                    alphabeticalOrder();
                    break;
                case "105":
                case "SPD":
                    storeData();
                    break;
                case "106":
                case "LPD":
                    loadData();
                    break;
                case "107":
                case "VRV":
                    viewRemainingVaccine();
                    break;
                case "108":
                case "AVS":
                    addVaccine();
                    break;
                case "109":
                case "EXT":
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
            System.out.println("");
            System.out.println(Arrays.toString(serviceCenter));
        }
    }


    public static void alphabeticalOrder() {


    }

    private static void loadData() {

    }

    public static void storeData() throws IOException {

    }

    public static void addVaccine() {
        boolean addVaccinesValidation;

        do{
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("How many vaccines are added to the stock ? : ");
                int addVaccines = in.nextInt();
                if (addVaccines > 0){
                    vaccination =  (vaccination + addVaccines);
                }else {
                    System.out.println("Please enter plus Integer input!");
                }

                addVaccinesValidation = false;
            } catch (Exception e) {
                System.out.println("Please enter Integer input!");
                addVaccinesValidation = true;
            }
        }while (addVaccinesValidation);
    }

    public static void viewRemainingVaccine() {
        System.out.println("Now stock have "+vaccination + " vaccines");
    }

    public static void removePatientBooth() {
        int boothNum;
        while (true){
            System.out.println("Enter booth number for remove patient (0-5) or 6 to stop:");
            Scanner in = new Scanner(System.in);
            try {
                boothNum = in.nextInt();
                if (boothNum >= 0 && boothNum <= 5) {
                    if (!serviceCenter[boothNum].equals("empty")) {
                        System.out.println(serviceCenter[boothNum] + " is left in booth");
                        serviceCenter[boothNum] = "empty";
                        for (int x = 0; x < 6; x++) {
                            System.out.println("\tbooth " + x + " occupied by " + serviceCenter[x]);
                        }
                    } else {
                        System.out.println("This booth Already Empty!");
                    }
                } else if (boothNum == 6) {
                    break;
                } else {
                    System.out.println("Invalid Booth Number!");
                }
            }catch (Exception e){
                System.out.println("Please Enter Integer Input!");
            }
        }
    }

    public static void addPatientBooth() {
        int boothNum;
        while (true){
            System.out.println("Enter booth number (0-5) or 6 to stop:");
            Scanner in = new Scanner(System.in);
            try {
                boothNum = in.nextInt();
                if (boothNum >= 0 && boothNum <= 5) {
                    if (serviceCenter[boothNum].equals("empty")) {
                        System.out.println("Enter customer name for booth " + boothNum + " :");
                        customerName = in.next();
                        serviceCenter[boothNum] = customerName;
                        vaccination = vaccination - 1;
                        for (int x = 0; x < 6; x++) {
                            System.out.println("\tbooth " + x + " occupied by " + serviceCenter[x]);
                        }
                    } else {
                        System.out.println("This booth has a patient!");
                    }
                } else if (boothNum == 6) {
                    break;
                } else {
                    System.out.println("Invalid Booth Number!");
                }
            }catch (Exception e){
                System.out.println("Please Enter Integer Input!");
            }
        }
//        int boothNum = 0;

//        while (boothNum < 6) {
//            System.out.println("Enter booth number (0-5) or 6 to stop:");
//            Scanner in = new Scanner(System.in);
//            M = in.nextInt();
//            if (M < 6) {
//                System.out.println("Enter customer name for booth " + M + " :");
//                customerName = in.next();
//                serviceCenter[M] = customerName;
//            } else {
//                break;
//            }
//            for (int x = 0; x < 6; x++) {
//                System.out.println("booth " + x + " occupied by " + serviceCenter[x]);
//            }
//            vaccination = vaccination - 1;
//            boothNum++;
//        }
    }

    public static void emptyBooths() {
        for (int x = 0; x < 6; x++)
            if (serviceCenter[x].equals("empty")) System.out.println("Booth " + x + " is empty");
    }

    private static void vaccinationBooths() {
        int i;
        for (i = 0; i < 6; i++) {
            System.out.println("Booth number " + i + " is " + serviceCenter[i]);
        }
    }
}