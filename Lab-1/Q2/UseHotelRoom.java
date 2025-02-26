/*
  Subject code : CSEB5133 / CSEB534 Java Programming
  Section      : 01A
  Student name : Muhammad Izzat Fikri Bin Zurilan
  Student ID no: SW01082295
  Question no  : 2(a), 2(b), 2(c)
 */

public class UseHotelRoom {
    public static void main(String[] args) {
        HotelRoom room1 = new HotelRoom(250);
        HotelRoom room2 = new HotelRoom(350);
        System.out.println(room1.display());
        System.out.println(room2.display());

        System.out.println();

        Suite room3 = new Suite(230);
        Suite room4 = new Suite(360);
        System.out.println(room3.display());
        System.out.println(room4.display());

    }
}

class HotelRoom {
    private int roomNumber;
    private double nightRentalRate;

    public HotelRoom(int roomNumber){
        this.roomNumber = roomNumber;

        if(roomNumber <= 299){
            nightRentalRate = 190.00;
        } else {
            nightRentalRate = 250.00;
        }
    }

    public void setNightRentalRate(double nightRentalRate) {
        this.nightRentalRate = nightRentalRate;
    }

    public double getNightRentalRate() {
        return nightRentalRate;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String display() {
        return "Regular hotel room – room number " + getRoomNumber() + ", rental rate is RM" + getNightRentalRate() + " per night";
    }


}

class Suite extends HotelRoom{

    public Suite(int roomNumber) {
        super(roomNumber);
        double surcharge = 150.00;
        double newRate = getNightRentalRate() + surcharge;
        // Set the new nightly rental rate
        setNightRentalRate(newRate);
    }

    public String display() {
        return "Suite hotel room – room number " + getRoomNumber() + ", rental rate is RM" + getNightRentalRate() + " per night";
    }

}

