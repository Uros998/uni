#ifndef CS323_DZ10_ERSTEATM_H
#define CS323_DZ10_ERSTEATM_H

#include "../ATM.h"

class ErsteATM : public ATM{

public:
    ErsteATM();

    ErsteATM(double stanje);

    bool isValidUser(int id) override;

    virtual ~ErsteATM();
};


#endif //CS323_DZ10_ERSTEATM_H
