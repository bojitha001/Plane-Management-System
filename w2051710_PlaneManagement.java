import  java.util.*;
public class w2051710_PlaneManagement {

    // Jagged array for seating plan
    public static int[][] seats = new int[4][] ;

    static {

        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

    }

//    An array for store Ticket of objects
    public static Ticket[] myTicket = new Ticket[53];
    //Variables to store rowLetter, seatNUm, count, price and ticket
    public static char rowLetter;
    public static int seatNum,count = 1;
    public static double price;
    public static Ticket ticket;

    //Main method
    public static void main(String[] args) {

        boolean stopTheLoop = true;
        while (stopTheLoop) { // create a loop until the user enter a correct input.

            Scanner sc = new Scanner(System.in);

            System.out.println();
            System.out.println("Welcome to the Plane Management application");
            System.out.println();
            System.out.println("*".repeat(50));
            System.out.println("*               MENU OPTIONS               *");
            System.out.println("*".repeat(50));
            System.out.println();
            System.out.println("\t1) Buy a seat");
            System.out.println("\t2) Cancel a seat");
            System.out.println("\t3) Find first available seat");
            System.out.println("\t4) Show seating plan");
            System.out.println("\t5) Print tickets information and total sales");
            System.out.println("\t6) Search tickets");
            System.out.println("\t0) Quit");
            System.out.println("*".repeat(50));
            System.out.print("Please enter your option :- ");

            try{
                int num = sc.nextInt(); //Get the input from the user to ask for a option.
                switch (num) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        stopTheLoop = false; //exit the loop
                        break;
                    default:
                        System.out.println("Invalid Number");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Enter the correct value");
            }
        }
    }
    //method to buy_set
    public static void buy_seat() {
        String name = "";       //initialize variables.
        String surname = "";
        String email = "";

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Row Letter :- "); //ask user to enter a row number.
            rowLetter = sc.next().toUpperCase().charAt(0);


        try {
            if (rowLetter <= 'D' && rowLetter >= 'A') { //check the row number is at correct range.
                System.out.print("Enter the Column Number :- ");
                seatNum = sc.nextInt();

                int charToRow = rowLetter - 65;  //covert char to int

                if (seats[charToRow][seatNum - 1] == 1) {  //check the seat is book or not.
                    System.out.println("This seat is already booked.Please try again.");
                    return; //exit from the method
                }
                else {
                    boolean checkName = true;
                    while (checkName) {  //loop until the user enter a correct input.
                        System.out.print("Enter the Name :- ");
                        name = sc.next();  // ask user to enter the name
                        if (name.matches("[a-zA-Z]+")) {  // check the name is valid or not.
                            checkName = false;
                        } else {
                            System.out.println("Invalid name.Please enter the name again.");
                            System.out.println();
                        }
                    }
                    boolean checkSurname = true;
                    while (checkSurname) { //loop until the user enter a correct input.
                        System.out.print("Enter the Surname :- ");
                        surname = sc.next();  //ask user to enter the surname.
                        if (surname.matches("[a-zA-Z]+")){  //check the username is valid not.
                            checkSurname = false;
                        }
                        else {
                            System.out.println("Invalid surname.Please enter the surname again.");
                        }
                    }
                    boolean checkEmail = true;
                    while (checkEmail) {  //loop until the user enter a correct input
                        System.out.print("Enter the Email :- ");
                        email = sc.next();  //ask user to enter the email.
                        if (email.contains("@") && (email.contains("."))) {  //check the email is valid not
                            checkEmail = false;
                        }
                        else {
                            System.out.println("Invalid Email. Please enter the email again.");
                        }
                    }
                        Person personName = new Person(name, surname, email);  // create the object as person and passing the data to the constructor.
                        ticketPrice(); // calling the ticket method.
                        ticket = new Ticket(rowLetter, seatNum, price, personName); // create the object as ticket and passing the data to the constructor.
                        ticket.saveFile(rowLetter,seatNum); //pass the values to the Ticket class
                        myTicket[count] = ticket; //input information to the myTicket array
                        count++;

                        if (rowLetter == 'A') {
                            seats[0][seatNum - 1] = 1;
                        } else if (rowLetter == 'B') {
                            seats[1][seatNum - 1] = 1;
                        } else if (rowLetter == 'C') {
                            seats[2][seatNum - 1] = 1;
                        } else if (rowLetter == 'D') {
                            seats[3][seatNum - 1] = 1;
                        }
                }
                if (seatNum > 14 && seatNum < 1) {
                    System.out.println("Invalid Input please enter the correct value at correct range.");
                }
                else {
                    System.out.println("Successfully booked the seat.Thank you!");
                }
            }
            else {
                System.out.println("Invalid letter please enter again.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter the correct value at correct range");
        }
    }
    // method to ticketPrice
    public static void ticketPrice() {
        if ( seatNum >= 1 && seatNum <= 5 ) {  //check the prices
            price = 200;
        }
        else if ( seatNum >= 6 && seatNum <= 9  ) {
            price = 150;
        }
        else {
            price = 180;
        }
    }
    //method to cancel_seat
    public static void cancel_seat() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Row Letter :- ");  //ask user to enter the row letter
        char rowLetter = sc.next().toUpperCase().charAt(0);

        try {
            if (rowLetter <= 'D' && rowLetter >= 'A') {  //check the row letter in correct range
                System.out.print("Enter the Seat Number :- ");
                int seatNum = sc.nextInt();

                int charToRow = rowLetter - 65; //convert char to int

                if (seats[charToRow][seatNum - 1] == 0) { //check the seat is booked or not
                    System.out.println("This seat is already available. Please try again.");
                    return;
                }
                else {
                    for (int a = 0; a < count; a++){
                        if ( myTicket[a] != null) {  //check the array is null or not
                            if ( myTicket[a].getRow() == rowLetter && myTicket[a].getSeat() == seatNum) { //check the index pf the array null or not
                                myTicket[a] = null;  //make that index null
                            }
                        }
                    }
                    if (rowLetter == 'A') {
                        seats[0][seatNum - 1] = 0;
                    } else if (rowLetter == 'B') {
                        seats[1][seatNum - 1] = 0;
                    } else if (rowLetter == 'C') {
                        seats[2][seatNum - 1] = 0;
                    } else if (rowLetter == 'D') {
                        seats[3][seatNum - 1] = 0;
                    }
                }
                if (seatNum > 14 && seatNum < 1) {
                    System.out.println("Invalid Input please enter the correct value at correct range.");
                } else {
                    System.out.println("Successfully cancel the seat.Thank you!");
                    ticket.deleteFile(rowLetter,seatNum);
                }
            }
            else {
                System.out.println("Invalid letter please enter again.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter the value at correct range.");
        }
    }
//    method to find_first_available
    public static void find_first_available() {

        for (int seatRow = 0; seatRow < seats.length; seatRow++ ){ //run through the rows of array.
            for (int seatCol = 0; seatCol < seats[seatRow].length; seatCol++){ //run through the columns of array.
                if ( seats[seatRow][seatCol] == 0 ) {
                    if (seatRow == 0) {
                        System.out.println("The first seat available is at " + "A" + (seatCol + 1));
                    } else if (seatRow == 1) {
                        System.out.println("B" + (seatCol + 1));
                    } else if (seatRow == 2) {
                        System.out.println("C" + (seatCol + 1));
                    } else if (seatRow == 3) {
                        System.out.println("D" + (seatCol + 1));
                    }
                    return; //exit from the method
                }
            }
        }
    }
    //method for show_seating_plan
    public static void show_seating_plan() {
        for (int i = 0; i < seats.length; i++) {  //run through the rows of array.
            for (int j = 0; j < seats[i].length; j++){  //run through the columns of array
                if ( seats[i][j] == 1 ) {
                    System.out.print("X "); //print the array
                }
                else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
//    method for print_ticket_info
    public static void print_tickets_info() {
            double total = 0;
            for (int a = 1; a <= count; a++) {
                if (myTicket[a] != null) { // Check the index of array is null or not
                    myTicket[a].ticketInformation();
                    total += myTicket[a].getPrice();
                    System.out.println();

                }
            }
            System.out.println("Total price is :- £"+ total);
    }
//    method fot search_tickets
    public static void search_ticket() {
        Scanner sc2 = new Scanner(System.in);


        System.out.print("Enter the Row Letter :- ");
        try{
        char RowLetter = sc2.next().toUpperCase().charAt(0);

            if (RowLetter <= 'D' && RowLetter >= 'A') {
                System.out.print("Enter the Seat Number :-");
                int SeatNumber = sc2.nextInt();
                if (SeatNumber >= 1 && SeatNumber <= 14) {
                    for (int a = 1; a <= count; a++) {
                        if (myTicket[a] != null) {
                            if (myTicket[a].getRow() == RowLetter && myTicket[a].getSeat() == SeatNumber) {
                                myTicket[a].ticketInformation();
                            }
                        }
                        else {
                            System.out.println("The seat is available.");
                            return;
                        }
                    }
                }
                else {
                    System.out.println("Invalid number please enter again.");
                }
            }
            else {
                System.out.println("Invalid letter please enter again.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid number please enter again.");
        }
    }
}
