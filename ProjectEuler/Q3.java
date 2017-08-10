public class Q3
{
  public static void main(String args [])
  {
    int i;
    for(i = 2; i <= Math.sqrt(13195); i++)
    {
      if((13195 % i) == 0)
        System.out.println(i);
    }
  }
}
