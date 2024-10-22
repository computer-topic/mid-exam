void printOwing() {
  double outstanding = 0.0;

  // print banner
  System.out.println("**************************");
  System.out.println("***** Customer Owes ******");
  System.out.println("**************************");

  // calculate outstanding
  while (_orders.hasMoreElements()) {
    Order each = (Order)_orders.nextElement();
    outstanding += each.getAmount();
  }

  // print details
  System.out.println("name:" + _name);
  System.out.println("amount" + outstanding);
}