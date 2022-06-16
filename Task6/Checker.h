#ifndef CHECKER_H_INCLUDED
#define CHECKER_H_INCLUDED
class Checker
{
public:
    string course = "c,c++,java";
    void ageChecker(int age)
    {
        if (age < 15 || age > 21)
        {
            AgeNotWithinRangeException a;
            throw a;
        }
    }

    void nameChecker(string str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if ((str[i] >= 65 && str[i] <= 90) || (str[i] >= 97 && str[i] <= 122))
            {
                continue;
            }
            else
            {
                NameNotValidException n;
                throw n;
            }
        }
    }

    void courseChecker(string chosenCourse)
    {
        bool found = course.find(chosenCourse) != std::string::npos;
        if (!found)
        {
            InvalidCouseException e;
            throw e;
        }
    }
};

#endif // CHECKER_H_INCLUDED
