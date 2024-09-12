//Lab 1
//Saurav Chaudhary
//301425864


import java.time.LocalDate;

public class SauravChaudhary_COMP228Lab2 {
    public static void main(String[] args) {
Singers singer1 = new Singers();
System.out.println("Singer ID: " + singer1.getID() + "\n" +
                    "Singer Name: " + singer1.getName() +  "\n" +
                    "Singer Address: " + singer1.getAddress()+  "\n" +
                    "Singer Date of Birth: " + singer1.getDob()+  "\n" +
                    "Singer's Number of Albums: " + singer1.getNumAlbums()  + "\n" );

                singer1.setID(43646);
                singer1.setName("Justin");
                singer1.setAddress("Bieber");
                singer1.setDob(LocalDate.of(1990,06,13));
                singer1.setNumAlbums(4);

        System.out.println("Singer ID: " + singer1.getID() + "\n" +
                "Singer Name: " + singer1.getName() + "\n" +
                "Singer Address: " + singer1.getAddress()+  "\n" +
                "Singer Date of Birth: " + singer1.getDob()+  "\n" +
                "Singer's Number of Albums: " + singer1.getNumAlbums());
    }
}
class Singers{
    private int ID;
    private String name;
    private String address;
    private LocalDate dob;
    private int numAlbums;




    //Getters and Setters
    public int getNumAlbums() {
        return numAlbums;
    }

    public void setNumAlbums(int numAlbums) {
        this.numAlbums = numAlbums;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAllValues(int id, String name, String address, LocalDate date, int albums ){

        this.ID = id;
        this.name = name;
        this.address = address;
        this.dob = date;
        this.numAlbums = albums;
    }



    public Singers()
    {
        this.ID = 0000;
        this.name = "None";
        this.address = "None";
        this.dob = LocalDate.of(1111,11,11);
        this.numAlbums = 0;
    }

    public Singers(int id)
    {
        this.ID = id;
        this.name = "None";
        this.address = "None";
        this.dob = LocalDate.of(0000,00,00);
        this.numAlbums = 0;
    }

    public Singers(int id, String name)
    {
        this.ID = id;
        this.name = name;
        this.address = "None";
        this.dob = LocalDate.of(0000,00,00);
        this.numAlbums = 0;
    }

    public Singers(int id, String name, String address)
    {
        this.ID = id;
        this.name = name;
        this.address = address;
        this.dob = LocalDate.of(0000,00,00);
        this.numAlbums = 0;
    }

    public Singers(int id, String name, String address, LocalDate date)
    {
        this.ID = id;
        this.name = name;
        this.address = address;
        this.dob = date;
        this.numAlbums = 0;
    }

    public Singers(int id, String name, String address, LocalDate date, int albums)
    {
        this.ID = id;
        this.name = name;
        this.address = address;
        this.dob = date;
        this.numAlbums = albums;
    }

}
