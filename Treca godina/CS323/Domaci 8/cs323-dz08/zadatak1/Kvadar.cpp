#include "Kvadar.h"
#include <iostream>
using namespace std;

Kvadar:: Kvadar() {}

Kvadar::Kvadar(double duzina, double sirina) {
    this->duzina=duzina;
    this->sirina = sirina;
}
Kvadar::Kvadar(Kvadar &k) {
    this->sirina = k.sirina;
    this->duzina = k.sirina;
}

void Kvadar::setDuzina(const double duzina) {
    this->duzina = duzina;
}
void Kvadar::setSirina( const double sirina) {
    this->sirina = sirina;
}

double Kvadar::getDuzina() {
    return this->duzina;
}

double Kvadar::getSirina() {
    return this->sirina;
}

double Kvadar::racunajObim() {
    return 2 * (this->duzina + this->sirina);
}

double Kvadar::racunajPovrsinu() {
    return this->sirina * this->duzina;
}

Kvadar:: ~Kvadar() {
    cout << "Objekat je unisten" << endl;
}

