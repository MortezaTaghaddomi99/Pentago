import java.util.Scanner;

public class Player {
    private final Slot.SlotType color;

    public Player(Slot.SlotType slot) {this.color = slot; }

    public Slot play(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Which quadrant do want to play in? Type  \"ul\" for upper left, " +
                                                                    "\"ur\" for upper right, " +
                                                                    "\"dl\" for down left, or " +
                                                                    "\"dr\" for down right.");
        String input1 = scanner1.next();

        if (Slot.Corner.fromString(input1) != Slot.Corner.ERROR){
            return chooseCoord(Slot.Corner.fromString(input1));
        }
        else {
            System.out.println("That is not a valid input.");
            return play();
        }
    }

    public Slot chooseCoord(Slot.Corner corner){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Which slot do want to play in? Type a pair of x and y coordinates between 0 and 2 inclusive, separated by a space.");

        int x_input = -1;

        if (scanner2.hasNextInt()){
            x_input = scanner2.nextInt();
        }
        if(!((x_input >= 0 && x_input <= 2))){
            System.out.println("That is not a valid x coordinate.");
            return play();
        }

        int y_input = -1;

        if (scanner2.hasNextInt()){
            y_input = scanner2.nextInt();
        }
        if(!((y_input >= 0 && y_input <= 2))){
            System.out.println("That is not a valid y coordinate.");
            return play();
        }

        if (x_input >= 0 && y_input >= 0){
            Slot newSlot = new Slot(x_input, y_input, corner);
            newSlot.color(color);
            return newSlot;
        }

        return play();
    }

    public Slot.SlotType getColor(){
        return color;
    }
}