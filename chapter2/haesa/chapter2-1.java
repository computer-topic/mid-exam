for (i = 1; i <=n; i++)
  flag[i] = true;

for （i = 2; i <= n / 2; i++）
{
  j = i + i;
  while (j <= n) {
    flag[j] = false;
    j = j + i;
  }
}

for （i = 1; i <= n; i++）
  if (flag[i])
    System.out.printin(i + "is prime.");