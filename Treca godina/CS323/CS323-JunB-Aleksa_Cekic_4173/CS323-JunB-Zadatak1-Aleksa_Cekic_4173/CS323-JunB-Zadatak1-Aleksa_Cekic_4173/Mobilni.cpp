#include "Mobilni.h"

Mobilni::Mobilni() {

}

void Mobilni::setMarka(string marka) {
	this->marka = marka;
}

string Mobilni::getMarka() const {
	return marka;
}

ostream& operator<<(ostream& out, const Mobilni& m) {
	out << m.ime << " " << m.sifra << " " << m.cena << " " << m.marka << endl;
	return out;
}