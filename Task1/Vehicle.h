#ifndef VEHICLE_H
#define VEHICLE_H
#include "iostream"
using namespace std;

class Vehicle
{
private:
string VehicleType;
string color;
string brand;
string model;
int mileage;
int price;

public:
virtual int getNoOfWheels()=0;

Vehicle(string type,string col,string brnd,string mdl,int mil,int pri)
{
VehicleType=type;
color=col;
brand=brnd;
model=mdl;
mileage=mil;
price=pri;
}
 void display()
{
cout<<VehicleType<<" "<<brand<<" "<<model<<" "<<color<<" "<<mileage<<" "<<price<<endl;
}


 bool operator <(Vehicle& d) {
         if(price < d.price) {
            return true;
         }
         return false;
      }

};

#endif
