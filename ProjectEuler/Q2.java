public class Q2
{
  public static void main(String args [])
  {
    int a = 1, b = 2, i = 0;
    int temp = 0;
    int count = 0, sum = 0;
    // System.out.println(a);
    // System.out.println(b);
    while(i < 1000)
    {
      temp = a + b;
      a = b;
      b = temp;
      i++;
      if(temp % 2 == 0)
      {
        if(temp <= 4000000)
          sum += temp;
        else
          break;
      }
    }
    System.out.println(sum+2);
  }
}
