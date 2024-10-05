public interface HotelInterface {

    public void showRoom( String status );
    public void orderRoom(String roomName, String customerName);
    public void checkAvailability(String roomName);
    public void orderDetails(String roomName);
    public void checkOut (String roomName, String customerName);
}