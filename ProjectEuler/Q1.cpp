#include <bits/stdc++.h>

template<typename T> void print(T n)
{
    bool neg = 0;
 
    if (n < 0)
        n *= -1, neg = 1;
 
    char snum[65];
    int i = 0;
    do
    {
        snum[i++] = n % 10 + '0';
        n /= 10;
    }
 
    while (n);
    --i;
 
    if (neg)
        putchar('-');
 
    while (i >= 0)
        putchar(snum[i--]);
 
    putchar('\n');
}

int main()
{
    auto sum = 0;

     for(auto i = 0; i < 1000; i++)
    {
        if((i % 3 == 0) || (i % 5 == 0))
            sum += i;
    }
    print(sum);
}