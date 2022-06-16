#ifndef TASK7_H_INCLUDED
#define TASK7_H_INCLUDED
#include <bits/stdc++.h>
#include <iostream>
using namespace std;
class Task7
{
private:
    unordered_map<string,bool> sensorMap;
    unordered_map<string,float> temperatureMap;

public:
    Task7()
    {
        temperatureMap.insert({"Temp",22.0f});
        sensorMap.insert({"Door",false});
        sensorMap.insert({"Fan",true});
        sensorMap.insert({"Gas",false});
        sensorMap.insert({"Light",true});
        temperatureMap.insert({"Waterlevel",20.0f});
        temperatureMap.insert({});
    }

    string sensorStatus()
    {
        double temperature= temperatureMap["Temp"];
        string temp="the temperature is ";
        temp.append(to_string(temperature));
       // cout<<temp;
        return temp;
    }

    void openDoor()
    {
//    iterator it = wordMap.find("First");
//    bool stat=false;
//    if (it != wordMap.end())
//    {
//    stat=it->second;
//    }
//    if(stat)
//    {
//    return;
//    }
        sensorMap.insert({"Door",true});
    }

    void closeDoor()
    {
        sensorMap.insert({"Door",false});
    }

    void turnOnFan()
    {
        sensorMap.insert({"Fan",true});
    }

    void turnOnLight()
    {
        sensorMap.insert({"Light",true});
    }

    void turnOfLight()
    {
        sensorMap.insert({"Light",false});
    }

    void changeTemperature(float val)
    {
        temperatureMap.insert({"Temp",val});
    }

};

#endif // TASK7_H_INCLUDED
