#include "Klima.h"

Klima::Klima() {

}

void Klima::setJacinaKlime(int jacinaKlime) {
    this->jacinaKlime = jacinaKlime;
}

int Klima::getJacinaKlime() const {
    return jacinaKlime;
}

ostream &operator<<(ostream &out, const Klima &k) {
    out << k.ime << " " << k.sifra << " " << k.cena << " " << k.jacinaKlime << endl;
    return out;
}