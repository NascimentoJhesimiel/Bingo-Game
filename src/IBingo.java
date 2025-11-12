public interface IBingo {
  public Cartela createGame(int quantity);
  public int sortNumber();
  public void showSortedNumbers();
  public int countSortedNumbers();
  public boolean checkIfNumberIsSorted(int number);
}
