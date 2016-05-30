public class Board {
    private Slot[][] board;
    private Corner uL;
    private Corner uR;
    private Corner dL;
    private Corner dR;

    public Board(){

        uL = new Corner();
        uR = new Corner();
        dL = new Corner();
        dR = new Corner();

        board = new Slot[6][6];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = new Slot(i, j);
            }
        }
        turn();
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

        //check rows
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length - 1; j++){
                if (board[i][j].getSlot() == board[i][j+1].getSlot()){
                    count++;
                }
                else {
                    count = 0;
                }
            }
        }

        //check verticals


        //check diagonals
        for (int j = -1; j < 2; j++){
            for (int i = 0; i < board.length-1; i++){
                if ((board[i+1][i+j+1] != null) && (board[i][i+j] != null)){
                    if (board[i][i+j] == board[i][i+j+1]){
                        count++;
                    }
                    else {
                        count = 0;
                    }
                }
            }
        }

        return false;
    }

}
