const int NUMBER_OF_TASKS = 34;
const int REAL_DAYS_PER_IDEAL_DAY = 4;
const int WORK_DAYS_PER_WEEK = 5;
int sum = 0;

for (int j = 0; j < 34; j++) {
    int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
    int realTaskWeeks = realTaskDays / WORK_DAYS_PER_WEEK;
    sum += realTaskWeeks;
}