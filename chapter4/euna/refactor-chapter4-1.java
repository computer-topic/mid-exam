(1)
// Check to see if the employee is eligible for full benefits
if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))

boolean isEligibleForFullBenefits = (employee.flags & HOURLY_FLAG) && (employee.age > 65)
if(isEligibleForFullBenefits) {
  ...
}


(2)
// Returns an instance of the Responder being tested.
protected abstract Responder responderInstance();

protected abstract Responder getResponsederBeingTested();