(1)
// Check to see if the employee is eligible for full benefits
if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))

private static final int RETIREMENT_AGE = 65;

if (isHourlyWorker() && isOverRetirementAge())

private void isHourlyWorker() {
    return employee.flags & HOURLY_FLAG;
}

private void isOverRetirementAge() {
    return employee.age > RETIREMENT_AGE;
}

(2)
// Returns an instance of the Responder being tested.
protected abstract Responder responderInstance();

protected abstract Responder responderBeingTested();