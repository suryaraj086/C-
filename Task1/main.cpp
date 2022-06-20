#include <iostream>
#include "Car.h"
#include "Vehicle.h"
#include "Bikes.h"

using namespace std;

int main()
{
    Car c("sedan",4,"red","audi","R8",8,5000000);
    Car c1("sedan",4,"red","audi","A4",10,3000000);
    Bikes b1(300,"scooter","Black","TVS","Scooty",35,80000);
    cout<<"The number of wheels: "<< c.getNoOfWheels()<<endl;
    c.display();
    cout<<"The number of wheels: "<< c1.getNoOfWheels()<<endl;
    c1.display();
    cout<<"The number of wheels: "<< b1.getNoOfWheels()<<endl;
    b1.display();
    if(c<c1)
    {
        cout<<"car1 price is lesser than car2"<<endl;
    }
    else
    {
        cout<<"car1 price is not lesser than car2 "<<endl;
    }
    if(b1<c)
    {
        cout<<"bike price is lesser than car"<<endl;
    }
    else
    {
        cout<<"car price is lesser than bike"<<endl;
    }
    return 0;
}


