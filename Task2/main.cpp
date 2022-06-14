#include <iostream>
#include "Sbi.h"
#include "Broker.h"
#include "Loan.h"
using namespace std;

int main()
{
    Sbi s("Stat bank of india", "Guduvancheri", "10-6-2020", "public", "Gold loan,personal loan,land loan", 9.7);
    Broker b;
    b.display(s);
    Sbi s1("Sta bank of chennai", "Guduvancheri", "10-6-2020", "public", "Gold loan,personal loan,land loan", 8.5);
    //std::cout<<"The interest rate is "<<b.compareInterestRates(s,s1).getInterestRate()<<endl;
    Sbi arr[] = {s, s1};
    int length = sizeof(arr) / sizeof(arr[0]);
    // b.display(arr,length);

    Loan temp("sbi", 8.3);
    Loan sb = b.lowestInterest(arr, length, temp);
    std::cout << "The interest rate is " << sb.getBankName() << endl;
    return 0;
}
