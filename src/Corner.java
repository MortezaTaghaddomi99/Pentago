public class Corner {
    private Slot[][] slots;
    private Slot.Corner corner;

    public Corner(Slot.Corner c){
        this.slots = new Slot[3][3];
        this.corner = c;

        for (int i = 0; i < slots.length; i++){
            for (int j = 0; j < slots[0].length; j++){
                slots[i][j] = new Slot(i, j, corner);
            }
        }
    }

    //rotates 3x3 grid counterclockwise
    public void turnClockwise(){
        Slot[][] temp = new Slot[3][3];
        for (int i = 0; i < slots.length; i++){
            for (int j = 0; j < slots[0].length; j++){
                temp[j][2-i] = slots[i][j];
            }
        }
        slots = temp;
    }

    //rotates 3x3 grid clockwise
    public void turnCounterClockwise(){
        Slot[][] temp = new Slot[3][3];
        for (int i = 0; i < slots.length; i++){
            for (int j = 0; j < slots[0].length; j++){
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
    public Slot getSlot(Slot slot) { return slots[slot.getX_coord()][slot.getY_coord()]; }

    public void setSlot(Slot slot){
        slots[slot.getX_coord()][slot.getY_coord()] = slot;
        return;
    }

    public Slot.Corner getCorner(){return corner; }

}