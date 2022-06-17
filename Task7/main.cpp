#include <iostream>
#include "Task7.h"
#include <stdlib.h>

using namespace std;

int main()
{

    Task7 obj;
    bool loop=true;
    while(loop)
    {
        cout<<"1.Get sensor status"<<endl<<"2.Simulating input"<<endl;
        int val;
        cin>>val;
        switch(val)
        {
            case 1:
                {
                    cout<<obj.sensorStatus()<<endl;
                    break;
                }
            case 2:
                {
                    cout<<"1.Change state"<<endl<<"2.Connect Device"<<endl<<"3.Disconnect device"<<endl;
                    int num;
                    cin>>num;
                    switch(num)
                    {
                        case 1:
                            {
                                cout<<"1.Door"<<endl<<"2.motion sensor"<<endl<<"3.Temperature sensor"<<endl<<"4.Water level sensor"<<endl<<"4.Gas detection sensor"<<endl<<"5.Light"<<endl<<"6.Fan"<<endl;
                                int choice;
                                cin>>choice;
                                switch(choice)
                                {
                                    case 1:
                                        {
                                            cout<<"1.Open door"<<endl<<"2.Close door"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.openDoor();
                                                        break;
                                                    }
                                                case 2:
                                                    {
                                                        obj.closeDoor();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }

                                    case 2:
                                        {
                                            cout<<"1.Turn on"<<endl<<"2.Turn of"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.turnOnMotionSensor();
                                                        break;
                                                    }
                                                case 2:
                                                    {
                                                        obj.turnOffMotionSensor();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }

                                    case 3:
                                        {
                                            cout<<"1.Increase Temperature"<<endl<<"2.Decrease Temperature"<<endl;
                                            int temp;
                                            cin>>temp;
                                            switch(temp)
                                            {
                                                case 1:
                                                    {
                                                        float data=obj.getTemperature();
                                                        data+=1.00;
                                                        obj.changeTemperature(data);
                                                        break;
                                                    }
                                                case 2:
                                                    {
                                                        float data=obj.getTemperature();
                                                        data-=1.00;
                                                        obj.changeTemperature(data-1);
                                                        break;
                                                    }
                                            }
                                            break;
                                        }
                                    case 4:
                                        {
                                            cout<<"1.Get Water Level"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        cout<<"The water level is "<< obj.getWaterLevel();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }
                                    case 5:
                                        {
                                            cout<<"1.Turn On Gas Detection"<<endl<<"2.Turn Off Gas Detection"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.turnOnGasSensor();
                                                        break;
                                                    }
                                                case 2:
                                                    {
                                                        obj.turnOffGasSensor();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }

                                    case 6:
                                        {
                                            cout<<"1.Turn On Light"<<endl<<"2.Turn Off Light"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.turnOnLight();
                                                        break;
                                                    }
                                                case 2:
                                                    {
                                                        obj.turnOffLight();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }

                                    case 7:
                                        {
                                            cout<<"1.Turn On Fan"<<endl<<"2.Turn Off Fan"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.turnOnFan();
                                                        break;
                                                    }
                                                case 2:
                                                    {
                                                        obj.turnOffFan();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }

                                }
                                system("clear");
                                break;
                            }

                        case 2:
                            {
                                cout<<"1.Door"<<endl<<"2.motion sensor"<<endl<<"3.Gas detection sensor"<<endl<<"4.Light"<<endl<<"5.Fan";
                                int connect;
                                cin>>connect;
                                switch(connect)
                                {
                                    case 1:
                                        {
                                            cout<<"1.Connect"<<endl<<"2.Disconnect";
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.connectDoor();
                                                        break;
                                                    }

                                                case 2:
                                                    {
                                                        obj.disConnectDoor();
                                                        break;
                                                    }

                                            }
                                            break;
                                        }
                                    case 2:
                                        {
                                            cout<<"1.Connect"<<endl<<"2.Disconnect";
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.connectMotionSensor();
                                                        break;
                                                    }

                                                case 2:
                                                    {
                                                        obj.disConnectMotionSensor();
                                                        break;
                                                    }

                                            }
                                            break;
                                        }

                                    case 3:
                                        {
                                            cout<<"1.Connect"<<endl<<"2.Disconnect";
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.connectGasSensor();
                                                        break;
                                                    }

                                                case 2:
                                                    {
                                                        obj.disConnectGasSensor();
                                                        break;
                                                    }

                                            }
                                            break;
                                        }


                                    case 4:
                                        {
                                            cout<<"1.Connect"<<endl<<"2.Disconnect";
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.connectLight();
                                                        break;
                                                    }

                                                case 2:
                                                    {
                                                        obj.disConnectLight();
                                                        break;
                                                    }

                                            }
                                            break;
                                        }

                                    case 5:
                                        {
                                            cout<<"1.Connect"<<endl<<"2.Disconnect"<<endl;
                                            int door;
                                            cin>>door;
                                            switch(door)
                                            {
                                                case 1:
                                                    {
                                                        obj.connectFan();
                                                        break;
                                                    }

                                                case 2:
                                                    {
                                                        obj.disConnectFan();
                                                        break;
                                                    }
                                            }
                                            break;
                                        }
//                                     system("clear");
                                }
                                system("clear");
                                break;
                            }
                    }
                    break;
                }
        }
    }
    return 0;
}
