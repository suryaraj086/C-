#ifndef INVALIDCOUSEEXCEPTION_H_INCLUDED
#define INVALIDCOUSEEXCEPTION_H_INCLUDED
#include <iostream>
#include <exception>
using namespace std;
class InvalidCouseException: public exception
{
 public:
        const char * what() const throw()
        {
            return "Invalid course ";
        }
};


#endif // INVALIDCOUSEEXCEPTION_H_INCLUDED
