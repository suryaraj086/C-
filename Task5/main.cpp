#include <iostream>
#include "Math.h"
#include "Temp.h"
using namespace std;

namespace first_space
{
    int square(int val)
    {
        return val * val;
    }
    namespace second_space
    {
        int cube(int val)
        {
            return val * val * val;
        }
    }
    int findMax(int val1, int val2)
    {
        if (val1 > val2)
        {
            return val1;
        }
        return val2;
    }
    int findMin(int val1, int val2)
    {
        if (val1 < val2)
        {
            return val1;
        }
        return val2;
    }
}

using namespace first_space;
int main()
{
    Temp t;
    cout << "1.The value of pi" << endl
         << "2.square a value" << endl
         << "3.cube a value" << endl
         << "4.find max value" << endl
         << "5.find min value" << endl;
    int val;
    cin >> val;
    switch (val)
    {
    case 1:
    {
        cout << t.calculatePi();
        cout << maths::Math::pi();
        break;
    }
    case 2:
    {
        cout << "Enter the value";
        int num;
        cin >> num;
        square(num);
        break;
    }
    case 3:
    {
        cout << "Enter the value";
        int num;
        cin >> num;
        cout << "Enter the second value";
        int num1;
        cin >> num1;
        int out = findMin(num, num1);
        cout << "the minimum value is " << out;
        break;
    }
    case 4:
    {
        cout << "Enter the value";
        int num;
        cin >> num;
        cout << "Enter the second value";
        int num1;
        cin >> num1;
        int out = findMax(num, num1);
        cout << "the maximum value is " << out;
        break;
    }
    case 5:
    {
        cout << "Enter the value";
        int num;
        cin >> num;
        second_space::cube(num);
        break;
    }
    }
    return 0;
}
