#ifndef SBI_H_INCLUDED
#define SBI_H_INCLUDED
#include "Bank.h";
#include "Loan.h";
using namespace std;

class Sbi:public Bank,public Loan {
private:
 string bankName;
 string branchName;
 string establishedDate;
 string bankType;
 string availableLoans;
 string landLoanDocs="Aadhar,Pancard";
 string goldLoanDocs="Aadhar,Pancard";
 string personalLoanDocs="Aadhar,Pancard";

public:
Sbi(string name,string branch,string date,string type,string availLoan)
{
bankName=name;
branchName=branch;
establishedDate=date;
bankType=type;
availableLoans=availLoan;
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
return 9.7;
}
string getInfo()
{

return bankName+" "+branchName+" "+establishedDate+" "+bankType;
}

};

#endif // SBI_H_INCLUDED
