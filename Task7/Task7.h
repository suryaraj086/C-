#ifndef TASK7_H_INCLUDED
#define TASK7_H_INCLUDED
#include <bits/stdc++.h>
#include <iostream>
#include "TempAndWaterSensor.h"
#include "Sensor.h"

using namespace std;
class Task7
{
    private:
        unordered_map<string,Sensor> sensorMap;
        unordered_map<string,TempAndWaterSensor> temperatureMap;

    public:

        Task7()
        {
            temperatureMap.insert({"Temp",objectCreate("Temperature Sensor",22.0f,true)});
            sensorMap.insert({"Door",objectCreator(true,true,"Door")});
            sensorMap.insert({"Fan",objectCreator(true,true,"Fan")});
            sensorMap.insert({"Gas",objectCreator(true,true,"Gas Detection Sensor")});
            sensorMap.insert({"Motion",objectCreator(true,true,"Motion Sensor")});
            sensorMap.insert({"Light",objectCreator(true,true,"Light")});
            temperatureMap.insert({"Waterlevel",objectCreate("Water level Sensor",22.0f,true)});
        }

        TempAndWaterSensor objectCreate(string name,float val,bool connect)
        {
            TempAndWaterSensor temp(val,name,connect);
            return temp;
        }

        Sensor objectCreator(bool state,bool connect,string name)
        {
            Sensor s(state,connect,name);
            return s;
        }


        string sensorStatus()
        {
            TempAndWaterSensor temperature= temperatureMap["Temp"];
            string temp="Sensor          status\n";
            temp.append("---------------------\n");
            temp.append("the temperature = ");
            temp.append(to_string(temperature.getVal()));
            Sensor state = sensorMap["Door"];
            temp.append("\n");
            temp.append("the Door = ");
            temp.append(to_string(state.getState()));
            return temp;
        }

        //        void openDoor()
        //        {
        //    iterator it = wordMap.find("First");
        //    bool state=false;
        //    if (it != wordMap.end())
        //    {
        //    state=it->second;
        //    }
        //    if(state)
        //    {
        //    return;
        //    }
        //            sensorMap["Door"]=true;
        //        }

        function<void()> openDoor = [=]()mutable{Sensor obj=this->sensorMap["Door"]; obj.turnOn(); this->sensorMap["Door"]=obj;};

        function<void()> connectDoor = [=]()mutable{Sensor obj=this->sensorMap["Door"]; obj.connect(); this->sensorMap["Door"]=obj;};

        function<void()> disConnectDoor = [=]()mutable{Sensor obj=this->sensorMap["Door"]; obj.disconnect(); this->sensorMap["Door"]=obj;};

        function<void()> closeDoor = [=]()mutable{Sensor obj=this->sensorMap["Door"]; obj.turnOff(); this->sensorMap["Door"]=obj;};

        function<void()> turnOnFan = [=]()mutable{Sensor obj=this->sensorMap["Fan"]; obj.turnOn() ; this->sensorMap["Fan"]=obj;};

        function<void()> connectFan = [=]()mutable{Sensor obj=this->sensorMap["Fan"]; obj.connect(); this->sensorMap["Fan"]=obj;};

        function<void()> disConnectFan = [=]()mutable{Sensor obj=this->sensorMap["Fan"]; obj.disconnect(); this->sensorMap["Fan"]=obj;};

        function<void()> turnOffFan = [=]()mutable{Sensor obj=this->sensorMap["Fan"]; obj.turnOff() ; this->sensorMap["Fan"]=obj;};

        function<void()> turnOnLight = [=]()mutable{Sensor obj=this->sensorMap["Light"]; obj.turnOn() ; this->sensorMap["Light"]=obj;};

        function<void()> connectLight = [=]()mutable{Sensor obj=this->sensorMap["Light"]; obj.connect(); this->sensorMap["Light"]=obj;};

        function<void()> disConnectLight = [=]()mutable{Sensor obj=this->sensorMap["Light"]; obj.disconnect(); this->sensorMap["Light"]=obj;};

        function<void()> turnOffLight = [=]()mutable{Sensor obj=this->sensorMap["Light"]; obj.turnOff() ; this->sensorMap["Light"]=obj;};

        function<void()> turnOnGasSensor = [=]()mutable{Sensor obj=this->sensorMap["Gas"]; obj.turnOn() ; this->sensorMap["Gas"]=obj;};

        function<void()> connectGasSensor = [=]()mutable{Sensor obj=this->sensorMap["Gas"]; obj.connect(); this->sensorMap["Gas"]=obj;};

        function<void()> disConnectGasSensor = [=]()mutable{Sensor obj=this->sensorMap["Gas"]; obj.disconnect(); this->sensorMap["Gas"]=obj;};

        function<void()> turnOffGasSensor = [=]()mutable{Sensor obj=this->sensorMap["Gas"]; obj.turnOff() ; this->sensorMap["Gas"]=obj;};

        function<void()> turnOnMotionSensor = [=]()mutable{Sensor obj=this->sensorMap["Motion"]; obj.turnOn() ; this->sensorMap["Motion"]=obj;};

        function<void()> connectMotionSensor = [=]()mutable{Sensor obj=this->sensorMap["Motion"]; obj.connect(); this->sensorMap["Motion"]=obj;};

        function<void()> disConnectMotionSensor = [=]()mutable{Sensor obj=this->sensorMap["Motion"]; obj.disconnect(); this->sensorMap["Motion"]=obj;};

        function<void()> turnOffMotionSensor = [=]()mutable{Sensor obj=this->sensorMap["Motion"]; obj.turnOff() ; this->sensorMap["Motion"]=obj;};

        function<void(int val)>  changeTemperature = [=](int val)mutable{TempAndWaterSensor obj=this->temperatureMap["Temp"]; obj.changeTemperature(val); this->temperatureMap["Temp"]=obj;};

        function<float()>  getTemperature = [=]()mutable{TempAndWaterSensor obj=this->temperatureMap["Temp"]; return obj.getVal(); };

        function<void(int val)>  changeWaterLevel = [=](int val)mutable{TempAndWaterSensor obj=this->temperatureMap["Waterlevel"]; obj.changeTemperature(val); this->temperatureMap["Waterlevel"]=obj;};

        function<float()>  getWaterLevel = [=]()mutable{TempAndWaterSensor obj=this->temperatureMap["Waterlevel"]; return obj.getVal();};

};

#endif // TASK7_H_INCLUDED
