#ifndef NAMENOTVALIDEXCEPTION_H_INCLUDED
#define NAMENOTVALIDEXCEPTION_H_INCLUDED

#include <iostream>
#include <exception>
using namespace std;
class NameNotValidException: public exception
{
 public:
        const char * what() const throw()
        {
            return "name is not valid ";
        }
};

#endif // NAMENOTVALIDEXCEPTION_H_INCLUDED
