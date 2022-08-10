#ifndef CS323_DZ10_USER_H
#define CS323_DZ10_USER_H
#include "ATM.h"

class User {
private:
    int id;
    double racun;

public:
    User();

    User(int id, double racun);

    int getId() const;

    void setId(int id);

    double getRacun() const;

    void setRacun(double racun);

    virtual ~User();

    void podigniSaBankomata(ATM &atm, double iznos);
};


#endif //CS323_DZ10_USER_H
