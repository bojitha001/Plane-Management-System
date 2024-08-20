import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Ticket {

    private char row;   //create the variables
    private int seat;
    private double price;
    private Person person;

    public Ticket(char row, int seat, double price, Person person) {   //create the constructor
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    // add getters and setters
    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {

        return seat;
    }

    public void setSeat(int seat) {

        this.seat = seat;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }
    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    //method for ticketInformation
    public void ticketInformation() {
        System.out.println("Row :- " + getRow());
        System.out.println("Seat :- " + getSeat());
        System.out.println("Price :- " + getPrice());
        person.personalDetails();
    }

    //method for saveFIle
    public void saveFile(char row, int seat) {
        String fileName = Character.toString(row) + String.valueOf(seat) + ".txt";


        try {
            FileWriter writeFile = new FileWriter(fileName,true);
            writeFile.write("Person Information\n");
            System.out.println();
            writeFile.write("Name :- " + getPerson().getName() + "\n");
            writeFile.write("Surname :- " + getPerson().getSurname() + "\n");
            writeFile.write("Mail :- " + getPerson().getEmail() + "\n");
            writeFile.write("Row :- " + getRow() + "\n");
            writeFile.write("Seat :- " + getSeat() + "\n");
            writeFile.write("Price :- " + getPrice() + "\n");
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method for deleteFile
    public void deleteFile(char row, int seat) {
        String fileName = Character.toString(row) + String.valueOf(seat) + ".txt";


        File deleteFile = new File(fileName);
        if (deleteFile.exists()) {
            if (deleteFile.delete()) {
                System.out.println(fileName + " is successfully deleted.");
            } else {
                System.out.println(fileName + " failed to delete.");
            }
        } else {
            System.out.println(fileName + " does not exist.");
        }
    }


}

