public void printOwing() {
    double outstanding = 0.0;

    printBanner();
    calculateOutstanding();
    printCustomerOwes();
}

private void printBanner() {
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
}


private void calculateOutstanding() {
    while (_orders.hasMoreElements()) {
        Order each = (Order)_orders.nextElement();
        outstanding += each.getAmount();
    }
}

private void printCustomerOwes() {
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
}