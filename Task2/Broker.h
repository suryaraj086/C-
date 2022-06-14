#ifndef BROKER_H_INCLUDED
#define BROKER_H_INCLUDED
#include "Sbi.h";
#include "Loan.h"
#include "Bank.h"
#include <bits/stdc++.h>

using namespace std;
class Broker
{
public:
    Loan compareInterestRates(Loan &rate1, Loan &rate2)
    {
        if (rate1.getInterestRate() < rate2.getInterestRate())
        {
            return rate1;
        }
        return rate2;
    }

    Loan compareInterestRates(Loan &rate1, Loan &rate2, Loan &rate3)
    {
        if (rate1.getInterestRate() < rate2.getInterestRate() && rate1.getInterestRate() < rate3.getInterestRate())
        {
            return rate1;
        }
        else if (rate2.getInterestRate() < rate1.getInterestRate() && rate2.getInterestRate() < rate3.getInterestRate())
        {
            return rate2;
        }
        return rate3;
    }

    template <class T>
    int length(T rate[])
    {
        int n = sizeof(rate) / sizeof(rate[0]);
        return n;
    }

    template <class T>
    void display(T b)
    {
        std::cout << b.getInfo() << endl;
    }

    template <class T>
    Loan lowestInterest(T ptr[], int length, Loan temp)
    {
        int minVal = INT_MAX;
        for (int i = 0; i < length; i++)
        {
            T obj=ptr[i];
            cout<<obj.getInterestRate()<<endl;
            if (ptr[i].getInterestRate() < minVal)
            {
                minVal = ptr[i].getInterestRate();
                cout<<minVal;
                temp = ptr[i];
            }
        }
        return temp;
    }

    template <class T>
    void display(T b[], int length)
    {
        for (int i = 0; i < length; i++)
        {
            std::cout << b[i].getInfo() << endl;
        }
    }
};

#endif // BROKER_H_INCLUDED
