const realDaysPerIdealDay = 4;
const WORK_DAYS_PER_WEEK = 5;
const NUMBER_OF_TASKS = 34;
int sum = 0;

for (int j = 0; j < NUMBER_OF_TASKS; j++) {
  const realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
  int realTaskWeeks= realTaskDays / WORK_DAYS_PER_WEEK;
  sum += realTaskWeeks;
}