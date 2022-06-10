#include <iostream>
#include "Sbi.h"
#include "Broker.h"
#include "Loan.h"
using namespace std;

int main()
{
    Sbi s("State bank of india","Guduvancheri","10-6-2020","public","Gold loan,personal loan,land loan");
    Broker b;
    b.display(s);
    Sbi s1("State bank of india","Guduvancheri","10-6-2020","public","Gold loan,personal loan,land loan");
    Sbi[] arr;
    arr[0]=s;
    arr[1]=s1;
    b.display(arr);
    return 0;
}
