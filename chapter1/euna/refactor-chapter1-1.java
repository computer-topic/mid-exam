boolean isSummer = !date.isBefore(plan.summerStart) && !data.isAfter(plna.summerEnd)

if (isSummer)
  charge = quantity * plan.summerRate;
else
  charge = quantity * plan.summerRate + plan.regularServiceCharge;