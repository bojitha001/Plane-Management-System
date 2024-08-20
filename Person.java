public class Person {

    private String name; //create the variables
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {  //create the constructor
        this.name = name;
        this.surname = surname;
        this.email = email;

    }
    // add getters and setters
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public  String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail() {

        this.email = email;
    }

    public void personalDetails() {
        System.out.println("Name :- " + getName() );
        System.out.println("Surname :- " + getSurname() );
        System.out.println("Email :- " + getEmail() );
    }

}
