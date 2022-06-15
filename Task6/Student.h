#ifndef STUDENT_H_INCLUDED
#define STUDENT_H_INCLUDED
#include "AgeNotWithinRangeException.h"
#include "NameNotValidException.h"
#include "InvalidCouseException.h"
#include <iostream>
using namespace std;
class Student{

private:
int rollNo;
int age;
string name;
string course="c,c++,java";
string chosenCourse;
public:
Student(int roll,int age,string name,string course)
{
 for (char &c: course) {
        c = to_lowercase(c);
    }
ageChecker(age);
nameChecker(name);
courseChecker(course);
this->rollNo=roll;
this->age=age;
this->name=name;
}
char to_lowercase(char c)
{
    if (c >= 'A' && c <= 'Z') {
        return c + 32;
    }
    return c;
}
void ageChecker(int age)
{
if(age<15||age>21)
{
AgeNotWithinRangeException a;
throw a;
}
}

void nameChecker(string str)
{
for(int i=0;i<str.length();i++)
{
if ((str[i]>=65 && str[i]<=90)|| (str[i]>=97 && str[i]<=122))
{
continue;
}
else{
NameNotValidException n;
throw n;
}
}
}

void courseChecker(string chosenCourse)
{
bool found = course.find(chosenCourse) != std::string::npos;
if(!found)
{
InvalidCouseException e;
throw e;
}
}

};


#endif // STUDENT_H_INCLUDED
