#ifndef BANK_H_INCLUDED
#define BANK_H_INCLUDED
using namespace std;
class Bank
{
public:
virtual string getName()=0;
virtual string getEstablisedDate()=0;
virtual string getBankType()=0;
virtual string getInfo()=0;
virtual string getBranchName()=0;
};

#endif // BANK_H_INCLUDED
