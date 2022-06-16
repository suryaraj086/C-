#ifndef MYEXCEPTION_H_INCLUDED
#define MYEXCEPTION_H_INCLUDED
#include <iostream>
using namespace std;
class MyException : public std::exception
{
public:
    MyException(string str)
    {
        throw(str);
    }
};

#endif // MYEXCEPTION_H_INCLUDED
