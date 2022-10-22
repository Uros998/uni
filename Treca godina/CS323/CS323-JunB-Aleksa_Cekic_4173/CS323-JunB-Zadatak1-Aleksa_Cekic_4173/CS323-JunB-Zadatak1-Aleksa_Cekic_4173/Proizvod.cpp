#include "Proizvod.h"

Proizvod::Proizvod() {

}

Proizvod::Proizvod(string ime, string sifra, string cena) {
	this->ime = ime;
	this->sifra = sifra;
	this->cena = cena;
}

void Proizvod::setIme(string ime) {
	this->ime = ime;
}
void Proizvod::setSifra(string sifra) {
	this->sifra = sifra;
}
void Proizvod::setCena(string cena) {
	this->cena = cena;
}

string Proizvod::getIme() const {
	return ime;
}

string Proizvod::getSifra() const {
	return sifra;
}

string Proizvod::getCena() const {
	return cena;
}
