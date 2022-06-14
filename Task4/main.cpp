#include <iostream>
#include "Rectangle.h"
using namespace std;

int main()
{
    Rectangle r();
    int a = 5, b = 10, c = 15, d = 20;
    Rectangle r1(a, b, c, d);
    // Rectangle r2(5.5f,10.2f,15.3f,20.4f);
    Rectangle r3(r1);
    return 0;
}
