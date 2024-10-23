public static final int STATUS_VALUE = 0;
public static final int ITEM = 4;

public class Cell {
    private int[] cell;

    public boolean isFlagged() {
        if (cell[STAUS_VALUE] == ITEM) {
            return true;
        }
        return false;
    }
}

public List<Cell> getItemPosition() {
    List<Cell> flaggedCells = new ArrayList<Cell>();

    for (Cell cell : map) {
        if (cell.isFlagged()) {
            flaggedCells.add(cell);
        }
    }
    return flaggedCells;
}