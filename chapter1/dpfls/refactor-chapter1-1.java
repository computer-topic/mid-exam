public static boolean isDateBetweenSummerTime() {
    if (!date.isBefore(summerStart) && !date.isAfter(summerEnd)) {
        return true;
    }
    return false;
}

String summerStart = plan.summerStart;
String summerEnd = plan.summerEnd;
String regularServiceCharge = plan.regularServiceCharge;

if (isDateBetweenSummerTime(summerStart, summerEnd))
  charge = quantity * summerRate;
else
  charge = quantity * summerRate + regularServiceCharge;