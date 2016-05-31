public class Corner {
    private Slot[][] slots;
    private Slot.Quadrant quadrant;

    public Corner(Slot.Quadrant q){
        this.slots = new Slot[3][3];
        this.quadrant = q;

        for (int i = 0; i < slots.length; i++){
            for (int j = 0; j < slots[0].length; j++){
                slots[i][j] = new Slot(i, j, quadrant);
            }
        }
    }

    //rotates 3x3 grid counterclockwise
    public void turnCounterClockwise(){
        Slot[][] temp = new Slot[3][3];
        for (int i = 0; i < slots.length; i++){
            for (int j = 0; i < slots[0].length; i++){
                temp[j][2-i] = slots[i][j];
            }
        }
        slots = temp;
    }

    //rotates 3x3 grid clockwise
    public void turnClockwise(){
        Slot[][] temp = new Slot[3][3];
        for (int i = 0; i < slots.length; i++){
            for (int j = 0; i < slots[0].length; i++){
                temp[2-j][i] = slots[i][j];
            }
        }
        slots = temp;
    }

    public int getSize(){
        return slots.length;
    }

    public Slot getSlot(int x, int y){
        return slots[x][y];
    }

    public void setSlot(Slot slot){slots[slot.getX_coord()][slot.getY_coord()] = slot;}

}