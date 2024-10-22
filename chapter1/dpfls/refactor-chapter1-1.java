public static boolean isSummer() {
    return !date.isBefore(plan.summerStart) && !date.isAfter(plan.summerEnd);
}

public static int getSummerCharge() {
    return quantity * plan.summerRate;
}

public static int getRegularCharge() {
    return quantity * plan.regularRate + plan.regularServiceCharge;
}

if (isSummer())
    charge = getSummerCharge();
else
    charge = getRegularCharge();