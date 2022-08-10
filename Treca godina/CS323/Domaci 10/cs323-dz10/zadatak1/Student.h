#ifndef CS323_DZ10_STUDENT_H
#define CS323_DZ10_STUDENT_H
#include <string>
using namespace std;

class Student {
protected:
    string ime, prezime;
    int index;

public:

    Student();

    Student(const string &ime, const string &prezime, int index);

    const string &getIme() const;

    void setIme(const string &ime);

    const string &getPrezime() const;

    void setPrezime(const string &prezime);

    int getIndex() const;

    void setIndex(int index);

    virtual void info();

    virtual ~Student();
};


#endif //CS323_DZ10_STUDENT_H
