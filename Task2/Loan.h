#ifndef LOAN_H_INCLUDED
#define LOAN_H_INCLUDED
using namespace std;
class Loan
{
private:
    string bankName;
    double interestRate;

public:
    Loan(string name, double rate)
    {
        bankName = name;
        interestRate = rate;
    }
    virtual string getAvailableLoans() {}
    virtual double getInterestRate()
    {
        return interestRate;
    }
    virtual string goldLoanDocumentRequired() {}
    virtual string personalLoanDocumentRequired() {}
    virtual string landLoanDocumentRequired() {}
    virtual string getBankName() {
    return bankName;
    }
};

#endif // LOAN_H_INCLUDED
