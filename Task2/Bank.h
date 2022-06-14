#ifndef BANK_H_INCLUDED
#define BANK_H_INCLUDED

using namespace std;
class Bank
{
private:
    string bankName;
    string branchName;
    string establishedDate;
    string bankType;

public:
    Bank(string name, string branch, string date, string type)
    {
        bankName = name;
        branchName = branch;
        establishedDate = date;
        bankType = type;
    }
    virtual string getName(){
    return "";
    }
    virtual string getEstablisedDate(){
    return "";
    }
    virtual string getBankType(){
    return "";
    }
    virtual string getInfo()
    {
      return bankName + " " + branchName + " " + establishedDate + " " + bankType;
    }
    virtual string getBranchName(){
    return "";
    }
};
#endif // BANK_H_INCLUDED
