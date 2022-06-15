#include <iostream>
#include "Task6.h"
#include "Student.h"
using namespace std;

int main()
{
cout<<"1.Division"<<endl<<"2.Add student details";
int val;
cin>>val;
switch(val)
{
case 1:
{
    cout<<"Enter the value"<<endl;
    int a;
    cin>>a;
    cout<<"Enter the value"<<endl;
    int b;
    cin>>b;
    string str;
//    cin>>str;
//    int temp=(int)str;
//    cout<<"The temp value is "<<temp;
    Task6 obj;
    try{
    int c=obj.division(a,b);
    cout<<"The output is "<<c;
    }
    catch(string s){
    cout << s << endl;
    }
break;
}
case 2:
{
    cout<<"Enter the name"<<endl;
    string name;
    cin>>name;
    cout<<"Enter the roll number"<<endl;
    int roll;
    cin>>roll;
    cout<<"Enter the age"<<endl;
    int age;
    cin>>age;
    cout<<"Enter the course"<<endl;
    string course;
    cin>>course;
    Student sObj(roll,age,name,course);
break;
}
}

    return 0;
}
