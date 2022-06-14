#ifndef ICICI_H_INCLUDED
#define ICICI_H_INCLUDED
#include "Bank.h"
#include "Loan.h"

using namespace std;

class ICICI : public Bank, public Loan
{
private:
    string bankName;
    string branchName;
    string establishedDate;
    string bankType;
    string availableLoans;
    string landLoanDocs = "Aadhar,Pancard";
    string goldLoanDocs = "Aadhar,Pancard";
    string personalLoanDocs = "Aadhar,Pancard";
    double interestRate;

public:
    ICICI(string name, string branch, string date, string type, string availLoan, double rate) : Bank(name, branch, date, type), Loan(name, rate)
    {
        bankName = name;
        branchName = branch;
        establishedDate = date;
        bankType = type;
        availableLoans = availLoan;
        interestRate=rate;
    }

    string getName()
    {
        return bankName;
    }
    string getBranchName()
    {
        return branchName;
    }
    string getBankType()
    {
        return bankType;
    }
    string getEstablisedDate()
    {
        return establishedDate;
    }
    string getAvailableLoans()
    {
        return availableLoans;
    }
    string goldLoanDocumentRequired()
    {
        return goldLoanDocs;
    }
    string personalLoanDocumentRequired()
    {
        return personalLoanDocs;
    }
    string landLoanDocumentRequired()
    {
        return landLoanDocs;
    }
    double getInterestRate()
    {
        return interestRate;
    }
    string getInfo()
    {
        return bankName + "-" + branchName + "-" + establishedDate + "-" + bankType;
    }
};




#endif // ICICI_H_INCLUDED
