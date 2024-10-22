public class Owing {
  private String name = '홍길동';
  private double outstanding = 0.0;
  private Order[] orders;

  public void print() {
    printBanner();
    calculateOutcome();

    System.out.println("name:" + this.name);
    System.out.println("amount" + this.outstanding);
  }

  void printBanner() {
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
  }

  void calculateOutcome() {
    while (this.orders.hasMoreElements()) {
      Order each = (Order)this.orders.nextElement();
      this.outstanding += each.getAmount();
    }
  }
}





