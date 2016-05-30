import java.util.Scanner;

public class Player {
    private final Slot.SlotType color;

    public Player(String color){
        this.color = Slot.SlotType.fromString(color);
    }
    public Player(Slot.SlotType slot) {this.color = slot; }

    public Slot play(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Which quadrant do want to play in? Type  \"ul\" for upper left, " +
                                                                    "\"ur\" for upper right, " +
                                                                    "\"dl\" for down left, or " +
                                                                    "\"dr\" for down right.");
        String input1 = scanner1.next();

        if (input1.equalsIgnoreCase("ul")){

        }
        else if (input1.equalsIgnoreCase("ur")){

        }
        else if (input1.equalsIgnoreCase("dl")){

        }
        else if (input1.equalsIgnoreCase("dr")){

        }
        else {
            System.out.println("That is not a valid input.");
            return play();
        }
        return play();
    }

    public Slot chooseCoord(){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Which slot do want to play in? Type a pair of x and y coordinates between 0 and 2 inclusive, separated by a space.");

        int x_input = 0;
        int y_input = 0;

        if((scanner2.hasNextInt()) && ((scanner2.nextInt() >= 0 || scanner2.nextInt() <= 2))){
            x_input = scanner2.nextInt();
        }
        else {
            System.out.println("That is not a valid x coordinate.");
            return play();
        }

        if((scanner2.hasNextInt()) && ((scanner2.nextInt() >= 0 || scanner2.nextInt() <= 2))){
            y_input = scanner2.nextInt();
        }
        else {
            System.out.println("That is not a valid y coordinate.");
            return play();

        }
        return play();
    }

    public Slot.SlotType getColor(){
        return color;
    }
}
