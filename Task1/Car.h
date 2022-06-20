#ifndef CAR_H
#define CAR_H
#include <iostream>
#include "Vehicle.h"
using namespace std;

class Car : public Vehicle
{
    private:
        string carType;
        int noOfPerson;

    public :

        int getNoOfWheels()
        {
            return 4;
        }

        Car(string carType,int noOfPerson,string col,string brnd,string mdl,int mil,int pri):Vehicle(carType,col,brnd,mdl,mil,pri)
        {
            carType=carType;
            noOfPerson=noOfPerson;
        }


};


#endif // CAR_H
