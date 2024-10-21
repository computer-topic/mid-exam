public static final int STAUS_VALUE = 0;
public static final int ITEM = 4;

public class Cell{
    private int[] cell;

    public static boolean isFlagged() {
        if (cell[STAUS_VALUE] == ITEM) {
            return true;
        }
        return false;
    }
}

public List<Cell> getItemPosition() {
    List<Cell> itemPosition = new ArrayList<Cell>();

    for (Cell cell : map) {
        if (cell.isFlagged()) {
            itemPosition.add(cell);
        }
    }
    return itemPosition;
}