#ifndef BIKES_H_INCLUDED
#define BIKES_H_INCLUDED
#include <iostream>
#include "Vehicle.h"
using namespace std;

class Bikes: public Vehicle
{
        int weight;
        string bikeType;

    public:

        int getNoOfWheels()
        {
            return 2;
        }

        Bikes(int weigh,string type,string col,string brnd,string mdl,int mil,int pri):Vehicle(type,col,brnd,mdl,mil,pri)
        {
            weight=weigh;
            bikeType=type;
        }
        ~Bikes()
        {}


};

#endif // BIKES_H_INCLUDED
