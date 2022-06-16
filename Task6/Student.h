#ifndef STUDENT_H_INCLUDED
#define STUDENT_H_INCLUDED
#include "AgeNotWithinRangeException.h"
#include "NameNotValidException.h"
#include "InvalidCouseException.h"
#include <iostream>
using namespace std;
class Student
{

private:
    int rollNo;
    int age;
    string name;
    string course;

public:
    Student(int roll, int age, string name, string course)
    {
        this->rollNo = roll;
        this->age = age;
        this->name = name;
        this->course = course;
    }
};

#endif // STUDENT_H_INCLUDED
