public void printOwing() {
    double outstanding = 0.0;

    printBanner();
    outstanding = calculateOutstanding();
    printCustomerOwes(outstanding);
}

private void printBanner() {
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
}


private void calculateOutstanding() {
    double outstanding = 0.0;

    while (orders.hasMoreElements()) {
        Order each = (Order)orders.nextElement();
        outstanding += each.getAmount();
    }
    return outstanding;
}

private void printCustomerDetails(double outstanding) {
    System.out.println("name:" + name);
    System.out.println("amount" + outstanding);
}