#ifndef CS323_DZ10_ATM_H
#define CS323_DZ10_ATM_H

class ATM {
protected:
    double stanje;
    int fee;

public:
    ATM();

    ATM(double stanje);

    double getStanje() const;

    void setStanje(double stanje);

    int getFee() const;

    void setFee(int fee);

    virtual bool isValidUser(int id);

    virtual ~ATM();
};


#endif //CS323_DZ10_ATM_H
