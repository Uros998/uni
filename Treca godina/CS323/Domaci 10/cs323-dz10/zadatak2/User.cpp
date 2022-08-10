#include "User.h"
#include <iostream>
using namespace std;

User::User() {}
User::User(int id, double racun) : id(id), racun(racun) {}

int User::getId() const {
    return id;
}

void User::setId(int id) {
    User::id = id;
}

double User::getRacun() const {
    return racun;
}

void User::setRacun(double racun) {
    User::racun = racun;
}

void User::podigniSaBankomata(ATM &atm, double iznos) {
    if(!atm.isValidUser(this->id)) return;

    if (atm.getStanje() > iznos){
        atm.setStanje(atm.getStanje() - iznos);
        this->racun += iznos - (iznos * (atm.getFee()) / 100);
    } else {
        cout << "Trenutno nemamo sredstava za isplatu" << endl;
    }
}

User::~User() {}
