#ifndef CS323_DZ08_STUDENT_H
#define CS323_DZ08_STUDENT_H
#include <string>
using namespace std;


class Student {
private:
    string ime, prezime, smer;
    double prosek;
public:
    Student();
    Student(string ime, string prezime, string smer, double prosek);
    Student(Student &s);

    void setIme(string ime);
    void setPrezime(string prezime);
    void setSmer(string smer);
    void setProsek(double prosek);

    string getIme();
    string getPrezime();
    string getSmer();
    double getProsek();

    ~Student();




};


#endif //CS323_DZ08_STUDENT_H
