import sun.invoke.empty.Empty;

public class Board {
    private Slot[][] board;
    private Corner uL;
    private Corner uR;
    private Corner dL;
    private Corner dR;

    public Board(){

        uL = new Corner(Slot.Quadrant.UL);
        uR = new Corner(Slot.Quadrant.UR);
        dL = new Corner(Slot.Quadrant.DL);
        dR = new Corner(Slot.Quadrant.DR);

        board = new Slot[6][6];

        for (int i = 0; i < uL.getSize(); i++){
            for (int j = 0; j < uL.getSize(); j++){
                uL.setSlot(new Slot(i, j, Slot.Quadrant.UL));
            }
        }
        turn();
    }

    public void setCornerSlot(Slot slot){

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
            for (int j = 0; j < board.length - 1; j++){
                if (board[i][j].getSlot() == color){
                    count++;
                }
                else {
                    count = 0;
                }
            }
        }

        if (count == 5){
            return true;
        }

        //check verticals


        //check diagonals
        for (int k = 0; k < 2; k++){
            for (int j = 0; j < 2; j++){
                count = 0;
                for (int i = 0; i < board.length-1; i++){
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

        return false;
    }

}
