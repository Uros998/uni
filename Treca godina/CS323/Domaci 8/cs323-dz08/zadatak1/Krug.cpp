#include "Krug.h"
#include <math.h>
#include <iostream>
using namespace std;

Krug:: Krug(){};

Krug::Krug(double r) {
    this->radius = r;
}

Krug:: Krug(Krug& k){
    this->radius = k.radius;
}

void Krug::setRadius(double radius) {
    this->radius = radius;
}

double Krug::getRadius() {
    return this->radius;
}
double Krug::racunajObim() {
    return M_PI * (2 * this->radius);
}

double  Krug::racunajPovrsinu() {
    return M_PI * (this->radius * this->radius);
}

Krug::~Krug() {
    cout << "Objekat je unisten" << endl;
}
