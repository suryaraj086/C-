#include <iostream>
#include "Car.h"
#include "Vehicle.h"
#include "Bike.h"

using namespace std;

int main() {
    Car c("sedan",4,"red","audi","R8",8,5000000);
    Car c1("sedan",4,"red","audi","A4",10,3000000);
    cout<<"The number of wheels: "<< c.getNoOfWheels()<<endl;
    c.display();
    cout<<"The number of wheels: "<< c1.getNoOfWheels()<<endl;
    c1.display();
    if(c<c1)
    {
    cout<<"car1 price is lesser than car2";
    }
    else
    {
    cout<<"car1 price is not lesser than car2 ";
    }
    return 0;
}


