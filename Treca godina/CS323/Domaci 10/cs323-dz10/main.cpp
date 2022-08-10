#include <iostream>
#include "zadatak1/BachelorStudent.h"
#include "zadatak1/Student.h"
#include "zadatak2/atms/IntesaATM.h"
#include "zadatak2/User.h"
#include "zadatak2/atms/ErsteATM.h"
#include <string>


using namespace std;

int main() {

//    Zadatak 1;
    BachelorStudent s1("Uros", "Milovanovic", 4191, "softversko inzinjerstvo");
    s1.info();


//    Zadatak2;
    IntesaATM atm1(1000);
    ErsteATM atm2(2000);

    User user(4191, 0);

    user.podigniSaBankomata(atm1, 500);

    user.podigniSaBankomata(atm2, 2200);


    cout << user.getRacun() << endl;
    cout << atm1.getStanje() << endl;
    cout << atm2.getStanje() << endl;


    return 0;
}
