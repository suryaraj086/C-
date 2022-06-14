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
    virtual string getAvailableLoans() {
        return "";
    }
    double getInterestRate()
    {
        return interestRate;
    }
    virtual string goldLoanDocumentRequired() {
    return "";
    }
    virtual string personalLoanDocumentRequired() {
    return "";
    }
    virtual string landLoanDocumentRequired() {
    return "";
    }
    virtual string getBankName() {
    return bankName;
    }
};

#endif // LOAN_H_INCLUDED
