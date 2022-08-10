#include "ATM.h"

ATM::ATM() {}
ATM::ATM(double stanje) : stanje(stanje) {}

double ATM::getStanje() const {
    return stanje;
}

void ATM::setStanje(double stanje) {
    ATM::stanje = stanje;
}

bool ATM::isValidUser(int id) {
    return id > 0;
}

ATM::~ATM() {}

int ATM::getFee() const {
    return fee;
}

void ATM::setFee(int fee) {
    ATM::fee = fee;
}



