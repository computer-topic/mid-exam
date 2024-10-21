double charge;
boolean isSummer = !date.isBefore(plan.summerStart) && !date.isAfter(plan.summerEnd);

if (isSummer) {
  charge = quantity * plan.summerRate;
} else {
  charge = quantity * plan.summerRate + plan.regularServiceCharge;
}