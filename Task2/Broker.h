#ifndef BROKER_H_INCLUDED
#define BROKER_H_INCLUDED
#include "Sbi.h";
#include "Loan.h"
#include "Bank.h"
#include <iostream>
using namespace std;
class Broker
{
public :

double compareInterestRates(double rate1,double rate2)
{
if(rate1<rate2)
{
return rate1;
}
return rate2;
}

double compareInterestRates(double rate1,double rate2,double rate3)
{
if(rate1<rate2 && rate1<rate3)
{
return rate1;
}
else if(rate2<rate1 && rate2<rate3)
{
return rate2;
}
return rate3;
}

int length(Sbi rate[])
{
 int n = sizeof(rate) / sizeof(rate[0]);
 return n;
}
//double compareInterestRates(int rate[])
//{
// int n = sizeof(rate) / sizeof(rate[0]);
// std::sort(rate, rate + n);
// return rate[0];
//}

void display(Bank &b)
{
std::cout<<b.getInfo()<<endl;
}

void display(Sbi b[])
{
int len=length(b);
cout<<len;
for(int i=0;i<len;i++)
{
std::cout<<b[i].getInfo()<<endl;
}
}

};

#endif // BROKER_H_INCLUDED
