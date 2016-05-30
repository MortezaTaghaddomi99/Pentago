public class Slot {
    private SlotType color;
    private int x_coord;
    private int y_coord;

    public Slot(int x, int y){
        this.color = SlotType.EMPTY;
        this.x_coord = x;
        this.y_coord = y;
    }

    public enum SlotType {
        EMPTY,
        BLACK,
        WHITE;

        public static SlotType fromString(String str) {
            if ( str.equalsIgnoreCase("BLACK") ) return BLACK;
            else if ( str.equalsIgnoreCase("WHITE") ) return WHITE;
            else return EMPTY;
        }

        public static SlotType flip(SlotType slot){
            if (slot == BLACK){
                return WHITE;
            }
            if (slot == WHITE){
                return BLACK;
            }
            return EMPTY;
        }

    }

    public void color(SlotType color){
        this.color = color;
    }

    public SlotType getSlot(){
        return this.color;
    }

    public int getX_coord(){
        return this.x_coord;
    }

    public int getY_coord(){
        return this.y_coord;
    }
}
