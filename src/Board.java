import java.util.Scanner;

public class Board {
    private Slot[][] board;
    private Corner uL;
    private Corner uR;
    private Corner dL;
    private Corner dR;

    public Board(){

        uL = new Corner(Slot.Corner.UL);
        uR = new Corner(Slot.Corner.UR);
        dL = new Corner(Slot.Corner.DL);
        dR = new Corner(Slot.Corner.DR);

        board = new Slot[6][6];

        for (int i = 0; i < uL.getSize(); i++){
            for (int j = 0; j < uL.getSize(); j++){
                uL.setSlot(new Slot(i, j, Slot.Corner.UL));
            }
        }
        turn();
    }

    public void setCornerSlot(Slot slot){
        if (slot.getCorner() == uL.getCorner()){
            uL.setSlot(slot);
        }
        else if (slot.getCorner() == uR.getCorner()){
            uR.setSlot(slot);
        }
        else if (slot.getCorner() == dL.getCorner()){
            dL.setSlot(slot);
        }
        else if (slot.getCorner() == dR.getCorner()){
            dR.setSlot(slot);
        }
    }

    public Slot getCornerSlot(Slot slot){
        if (slot.getCorner() == uL.getCorner()){
            return uL.getSlot(slot);
        }
        else if (slot.getCorner() == uR.getCorner()){
            return uR.getSlot(slot);
        }
        else if (slot.getCorner() == dL.getCorner()){
            return dL.getSlot(slot);
        }
        else if (slot.getCorner() == dR.getCorner()){
            return dR.getSlot(slot);
        }
        return null;
    }

    public void rotate(Slot.Corner corner){

        if (corner == uL.getCorner()){
            rotateHelper(uL);
        }
        else if (corner == uR.getCorner()){
            rotateHelper(uR);
        }
        else if (corner == dL.getCorner()){
            rotateHelper(dL);
        }
        else if (corner == dR.getCorner()){
            rotateHelper(dR);
        }
        else {
            return;
        }
    }

    public void rotateHelper(Corner corner){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to rotate this quadrant? Type \"l\" to rotate counter-clockwise, \"r\" to rotate clockwise, and \"n\" to not rotate.");
        String input1 = scanner.next();


        if (input1.equalsIgnoreCase("l")){
            corner.turnCounterClockwise();
        }
        else if (input1.equalsIgnoreCase("r")){
            corner.turnClockwise();
        }
        else if (input1.equalsIgnoreCase("n")){

        }
        else {
            System.out.println("That is not a valid input.");
            rotateHelper(corner);
            return;
        }

    }


    public void turn(){

        for (int i = 0; i < uL.getSize(); i++){
            for (int j = 0; j < uL.getSize(); j++){
                board[i][j] = uL.getSlot(i, j);
            }
        }

        for (int i = 0; i < uR.getSize(); i++){
            for (int j = 0; j < uR.getSize(); j++){
                board[i][j+3] = uR.getSlot(i, j);
            }
        }

        for (int i = 0; i < dL.getSize(); i++){
            for (int j = 0; j < dL.getSize(); j++){
                board[i+3][j] = dL.getSlot(i, j);
            }
        }

        for (int i = 0; i < dR.getSize(); i++){
            for (int j = 0; j < dR.getSize(); j++){
                board[i+3][j+3] = dR.getSlot(i, j);
            }
        }

        System.out.println(toString());
    }

    public String toString(){
        String description = "";
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j].getSlot() == Slot.SlotType.BLACK){
                    description += "B ";
                }
                else if (board[i][j].getSlot() == Slot.SlotType.WHITE){
                    description += "W ";
                }
                else if (board[i][j].getSlot() == Slot.SlotType.EMPTY){
                    description += "O ";
                }
            }
            description += '\n';
        }
        return description;
    }

    public boolean isWon(Player player){
        int count = 0;
        Slot.SlotType color = player.getColor();

        //check rows
        for (int i = 0; i < board.length; i++){
            count = 0;
            for (int j = 0; j < board.length; j++){
                if (board[i][j].getSlot() == color){
                    count++;
                }
                else {
                    count = 0;
                }
                if (count == 5){
                    return true;
                }
            }
        }

        //check verticals
        for (int i = 0; i < board.length; i++){
            count = 0;
            for (int j = 0; j < board.length; j++){
                if (board[j][i].getSlot() == color){
                    count++;
                }
                else {
                    count = 0;
                }
                if (count == 5){
                    return true;
                }
            }
        }

        //check top left to bottom right diagonals
        for (int k = 0; k < 2; k++){
            for (int j = 0; j < 2; j++){
                count = 0;
                for (int i = 0; i < board.length-1-k; i++){
                    if (!(board[i+k][i+j+k].isEmpty())){
                        if (board[i+k][i+j+k].getSlot() == color){
                            count++;
                        }
                    }
                }
                if (count == 5){
                    return true;
                }
            }
        }

        //check bottom left to to right diagonals
        for (int k = 0; k < 2; k++){
            for (int j = 0; j < 2; j++){
                count = 0;
                for (int i = 0; i < board.length-1; i++){
                    if (!(board[(4-i)+k][i+j].isEmpty())){
                        if (board[(4-i)+k][i+j].getSlot() == color){
                            count++;
                        }
                    }
                }
                if (count == 5){
                    return true;
                }
            }
        }



        return false;
    }
}
