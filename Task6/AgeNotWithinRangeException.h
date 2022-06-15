#ifndef AGENOTWITHINRANGEEXCEPTION_H_INCLUDED
#define AGENOTWITHINRANGEEXCEPTION_H_INCLUDED
#include <iostream>
#include <exception>
using namespace std;
class AgeNotWithinRangeException: public exception
{
 public:
        const char * what() const throw()
        {
            return "age not in range";
        }
};

#endif // AGENOTWITHINRANGEEXCEPTION_H_INCLUDED
