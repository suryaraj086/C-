#ifndef TEMPANDWATERSENSOR_H_INCLUDED
#define TEMPANDWATERSENSOR_H_INCLUDED
#include <iostream>
using namespace std;
class TempAndWaterSensor
{
    private:
        float val;
        string sensorName;
        bool connectionStatus;
        bool sensorState;

    public:

        TempAndWaterSensor()
        {}

        TempAndWaterSensor(float num,string name,bool conStatus)
        {
            val=num;
            sensorName=name;
            connectionStatus=conStatus;
            sensorState=true;
        }

        float getVal()
        {
            return val;
        }
        string getName()
        {
            return sensorName;
        }

        bool getConnection()
        {
            return connectionStatus;
        }

        void connect()
        {
            connectionStatus=true;
        }

        void disconnect()
        {
            connectionStatus=false;
        }

        void changeTemperature(float val)
        {
            checkConnection();
            this->val=val;
        }

        void checkConnection()
        {
            if(!connectionStatus)
            {
                throw("Device Disconnected");
            }
        }

        void checkState()
        {

            if(!sensorState)
            {
                throw("Device is in off condition");
            }
        }


};

#endif // TEMPANDWATERSENSOR_H_INCLUDED
