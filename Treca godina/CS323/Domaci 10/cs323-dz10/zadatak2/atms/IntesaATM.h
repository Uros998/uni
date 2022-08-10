#ifndef CS323_DZ10_INTESAATM_H
#define CS323_DZ10_INTESAATM_H
#include "../ATM.h"

class IntesaATM : public ATM{

public:
    IntesaATM();

    IntesaATM(double stanje);


    virtual ~IntesaATM();

    bool isValidUser(int id) override;
};


#endif //CS323_DZ10_INTESAATM_H
