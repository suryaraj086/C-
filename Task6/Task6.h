#ifndef TASK6_H_INCLUDED
#define TASK6_H_INCLUDED
#include <iostream>
#include "MyException.h"

using namespace std;
class Task6{

public:
int division(int a,int b)
{
string str="Invalid division";
if(a==0)
{
str="Format mismatch";
throw(str);
}
if(b==0)
{
str="Invalid division";
throw(str);
}
int c=a/b;
return c;
}

char checkIndex(string str,int index)
{
if(index<0 || index>=str.length())
{
string exe="Index is invalid";
throw(exe);
}
return str.at(index);
}

int checkArrayIndex(int arr[],int index,int length)
{
if(index<0 || index>=length)
{
string str="Array index is invalid";
throw MyException(str);
}
return arr[index];
}

};


#endif // TASK6_H_INCLUDED
