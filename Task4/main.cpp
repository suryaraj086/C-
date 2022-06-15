#include <iostream>
#include "Rectangle.h"
using namespace std;

int main()
{
    Rectangle r();
    int a = 5, b = 10, c = 15, d = 20;
    cout << "Enter the length" << endl;
    cin >> a;
    cout << "Enter the width" << endl;
    cin >> b;
    cout << "Enter the left" << endl;
    cin >> c;
    cout << "Enter the top" << endl;
    cin >> d;
    Rectangle r1(a, b, c, d);
    r1.print();
    float a1 = 5.5f, b1 = 10.2f, c1 = 15.3f, d1 = 20.4f;
    Rectangle r2(a1, b1, c1, d1);
    // r2.print();
    Rectangle r3(r1);
    //  r3.print();
    Rectangle r4(a, b);
    r4.print();
    return 0;
}
