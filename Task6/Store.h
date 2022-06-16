#ifndef STORE_H_INCLUDED
#define STORE_H_INCLUDED
#include "Student.h"
#include <bits/stdc++.h>
using namespace std;
class Store
{
private:
    unordered_map<int, Student> userMap;

public:
    void setIn(int inp, Student obj)
    {
        userMap.insert({inp, obj});
    }
    bool contains(int key)
    {
        if (userMap.find(key) != userMap.end())
        {
            return true;
        }
        return false;
    }
};

#endif // STORE_H_INCLUDED
