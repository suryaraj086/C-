#ifndef SENSOR_H_INCLUDED
#define SENSOR_H_INCLUDED
#include <iostream>
using namespace std;
class Sensor
{
    private:

        bool state;
        bool connectionStatus;
        string sensorName;

    public:

        Sensor()
        {}

        Sensor(bool stateOfSensor,bool connect,string name)
        {
            state=stateOfSensor;
            connectionStatus=connect;
            sensorName=name;
        }

        bool getState()
        {
            return state;
        }
        string getName()
        {
            return sensorName;
        }

        void turnOn()
        {
            checkConnection();
            state=true;
        }

        void turnOff()
        {
            checkConnection();
            state=false;
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

        void checkConnection()
        {
            if(!connectionStatus)
            {
                throw("Device Disconnected");
            }
        }


        void checkState()
        {
            if(!state)
            {
                throw("Device is in off condition");
            }

        }

};

#endif // SENSOR_H_INCLUDED
