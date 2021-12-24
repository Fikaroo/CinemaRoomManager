import java.util.Scanner;

public class Cinema {
    static int row,seat,tprice,rows,seats,key,total_seats,hrows,tc = 0,ec = 0,count = 0;
    static final int price = 10;
    static final int lowprice = 8;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();

        String[][] cinema = new String[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = "S";
            }
        }

        total_seats = rows * seats;
        hrows = rows/2;
        menu(cinema);
        }
    public static void menu(String[][] cinema) {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        int a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.println();
                printCinema(cinema);
                System.out.println();
                menu(cinema);
                break;
            case 2:
                System.out.println();
                ticketPrice(cinema);
                System.out.println();
                count++;
                menu(cinema);
            case 3:
                System.out.println();
                cStatistics();
                System.out.println();
                menu(cinema);
                break;
            case 0:
                break;
            default:
                System.out.println("Try Again :)");
                menu(cinema);
        }
    }

    public static void printCinema(String[][] cinema) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i < seats + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void ticketPrice (String[][] cinema){
         do {
            System.out.println("Enter a row number:");
            row = sc.nextInt();

            System.out.println("Enter a seat number in that row:");
            seat = sc.nextInt();

            if (row>rows || seat>seats){
                System.out.println();
                System.out.println("Wrong input!");
                System.out.println();
            }
            else if (cinema[row - 1][seat - 1] == "S"){
                cinema[row - 1][seat - 1] = "B";
                break;
            }
            else {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            }
        }while (true);
            System.out.println();
            System.out.println("Ticket price:");
            if (total_seats <= 60) {
                tprice = price;
            } else {
                if (row <= hrows){
                    tprice = price;
                    tc++;
                }
                else {
                    tprice = lowprice;
                    ec++;
                }
            }

            System.out.println("$" + tprice);

    }

    public static void cStatistics (){
        int income;
        float perc=0;
        if (total_seats<=60){
            income = price * total_seats;
            tprice = count * price;
        }
        else {
            int fincome = hrows * seats * price;
            int hfrows = rows - hrows;
            int hincome = hfrows * seats * lowprice;
            income = hincome + fincome;
            tprice = tc * price + ec * lowprice;
            }

        perc += ((float) count / (float) total_seats) * (float) 100;
        System.out.println("Number of purchased tickets: " + count);
        System.out.printf("Percentage: %.2f%%%n", perc);
        System.out.println("Current income: $" + tprice);
        System.out.println("Total income: $" + income);
        }

}