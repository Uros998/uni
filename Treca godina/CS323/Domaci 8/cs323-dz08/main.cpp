#include <iostream>
#include "zadatak1/Kvadar.h"
#include "zadatak1/Krug.h"
#include "zadatak2/Student.h"
using namespace std;

int main() {

    // ZADATAK 1
    Krug k1(4);

    cout << k1.getRadius() << endl;
    cout << "Povrsina kruga:" << endl;
    cout<<  k1.racunajPovrsinu()<< endl;
    cout << "Obim kruga:" << endl;
    cout<< k1.racunajObim()<< endl;
    cout << "------------------------" << endl;


    Kvadar k2(2,3);

    cout << "Sirina:" << endl;
    cout << k2.getSirina() << endl;
    cout << "Duzina:" << endl;
    cout << k2.getDuzina() << endl;
    cout << "Povrsina kvadrata:" << endl;
    cout<< k2.racunajPovrsinu()<< endl;
    cout << "Obim kvadrata:" << endl;
    cout<< k2.racunajObim()<< endl;
    cout << "------------------------" << endl;


    // Zadatak 2
    Student s1("Uros","Milovanovic","SI",8.1);

    cout << s1.getIme() << endl;
    cout << s1.getPrezime() << endl;
    cout << s1.getProsek() << endl;
    cout << s1.getSmer() << endl;

    return 0;
}
