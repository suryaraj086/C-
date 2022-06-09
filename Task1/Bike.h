#ifndef BIKE_H_INCLUDED
#define BIKE_H_INCLUDED
using namespace std;
class Bike:Vehicle
{

int weight;
string bikeType;

Bike(int weigh,string type,string col,string brnd,string mdl,int mil,int pri):Vehicle(type,col,brnd,mdl,mil,pri)
{
weight=weigh;
bikeType=type;
}

};

#endif // BIKE_H_INCLUDED
