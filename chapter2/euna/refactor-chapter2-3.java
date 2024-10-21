public static final int FLAG = 0;
public static final int FLAGGED = 4;

public class Cell{
  int[] cell;
}

public List<Cell> addFlaggedFlag(List<Cell> checkedCells) {
  List<Cell> cells = new ArrayList<Cell>();
  for (Cell cell : checkedCells)
    if (cell[FLAG] == FLAGGED)
      cells.add(cell);
  return cells;
}