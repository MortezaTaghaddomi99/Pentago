public class Slot {
    private SlotType color;
    private Corner corner;
    private int x_coord;
    private int y_coord;

    public Slot(int x, int y, Corner q){
        this.color = SlotType.EMPTY;
        this.corner = q;
        this.x_coord = x;
        this.y_coord = y;
    }

    public enum Corner {
        ERROR,
        UL,
        UR,
        DL,
        DR;

        public static Corner fromString(String str){
            if (str.equalsIgnoreCase("ul")){
                return UL;
            }
            else if (str.equalsIgnoreCase("ur")){
                return UR;
            }
            else if (str.equalsIgnoreCase("dl")){
                return DL;
            }
            else if (str.equalsIgnoreCase("dr")){
                return DR;
            }
            return ERROR;
        }
    }


    public enum SlotType {
        ERROR,
        EMPTY,
        BLACK,
        WHITE;

        public static SlotType fromString(String str) {
            if ( str.equalsIgnoreCase("BLACK") ) return BLACK;
            else if ( str.equalsIgnoreCase("WHITE") ) return WHITE;
            else if ( str.equalsIgnoreCase("EMPTY") ) return EMPTY;
            return ERROR;
        }

        public static SlotType flip(SlotType slot){
            if (slot == BLACK){
                return WHITE;
            }
            else if (slot == WHITE){
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

    public boolean isEmpty(){ return (this.color == SlotType.EMPTY); }

    public Corner getCorner() { return this.corner; }

    public int getX_coord(){
        return this.x_coord;
    }

    public int getY_coord(){
        return this.y_coord;
    }
}
