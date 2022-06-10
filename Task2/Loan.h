#ifndef LOAN_H_INCLUDED
#define LOAN_H_INCLUDED
using namespace std;
class Loan
{
public:
virtual string getAvailableLoans()=0;
virtual double getInterestRate()=0;
virtual string goldLoanDocumentRequired()=0;
virtual string personalLoanDocumentRequired()=0;
virtual string landLoanDocumentRequired()=0;
};

#endif // LOAN_H_INCLUDED
