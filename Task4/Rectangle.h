#ifndef RECTANGLE_H_INCLUDED
#define RECTANGLE_H_INCLUDED
#include <iostream>
#include <cmath>
using namespace std;
class Rectangle
{
private:
    int *height;
    int *width;
    int *left;
    int *top;
    int *area;
    int temp;

public:
    Rectangle()
    {
        height = 0;
        width = 0;
        left = 0;
        top = 0;
        area = 0;
        cout << *area;
    }

    Rectangle(int high, int wid)
    {
        height = &high;
        width = &wid;
        temp = 0;
        left = &temp;
        top = &temp;
    }

    Rectangle(int &high, int &wid, int &leftVal, int &topVal)
    {
        this->height = &high;
        this->width = &wid;
        this->left = &leftVal;
        this->top = &topVal;
    }

    Rectangle(float &high, float &wid, float &leftVal, float &topVal)
    {
        *height = (int)high;
        *width = (int)wid;
        *left = (int)leftVal;
        *top = (int)topVal;
        cout << "The height is " << *height;
        cout << "The width is " << *width;
    }

    Rectangle(Rectangle &obj)
    {
        height = obj.height;
        width = obj.width;
        left = obj.left;
        top = obj.top;
        temp = ((*height) * (*width));
        area = &temp;
    }

    int areaFind(int hei, int wid)
    {
        return hei * wid;
    }

    ~Rectangle()
    {
        /*
    delete height;
    delete width;
    delete left;
    delete top;
    delete area;*/
    }

    void print()
    {
        cout << *height << endl
             << *width << endl
             << *left << endl
             << *top;
    }
};

#endif // RECTANGLE_H_INCLUDED
