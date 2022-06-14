#include <iostream>
#include "Sbi.h"
#include "Broker.h"
#include "Loan.h"
#include "ICICI.h"
using namespace std;

int main()
{
    Sbi s("Stat bank of india", "Guduvancheri", "10-6-2020", "public", "Gold loan,personal loan,land loan", 9.7);
    Broker b;
    //b.display(s);
    Sbi s1("Sta bank of india", "Guduvancheri", "10-6-2020", "public", "Gold loan,personal loan,land loan", 8.5);
    //Sbi s2("state bank of india", "karaikudi", "10-6-2018", "public", "Gold loan,personal loan,land loan", 7.4);
    ICICI s2("ICICI", "Guduvancheri", "10-6-2020", "private", "Gold loan,personal loan,land loan", 7.5);
    std::cout<<b.compareInterestRates(s,s1).getBankName()<<" has the lowest interest rate"<<endl;
    std::cout<<b.compareInterestRates(s,s1,s2).getBankName()<<" has the lowest interest rate"<<endl;
    Loan arr[] = {s, s1,s2};
    int length = sizeof(arr) / sizeof(arr[0]);
    Loan sb = b.lowestInterest(arr, length);
    std::cout<< sb.getBankName() <<" has the lowest interest rate"<< endl;
    return 0;
}
