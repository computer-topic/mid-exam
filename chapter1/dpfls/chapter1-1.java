if (!date.isBefore(plan.summerStart) && !date.isAfter(plan.summerEnd))
  charge = quantity * plan.summerRate;
else
  charge = quantity * plan.summerRate + plan.regularServiceCharge;