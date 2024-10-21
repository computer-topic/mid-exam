public static final int MOVABLE_SPACE = 0;
public static final int ITEM = 4;

public List<Cell> getItemPosition () {
    List<Cell> itemPosition = new ArrayList<Cell>();

    for (Cell cell : map) {
        if (cell[MOVABLE_SPACE] == ITEM) {
            itemPosition.add(cell);
        }
    }
    return itemPosition;
}