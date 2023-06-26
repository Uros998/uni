#include "Proizvod.h"
#pragma once
class Mobilni : public Proizvod
{
private:
	string marka;
public:
	Mobilni();

	void setMarka(string marka);
	string getMarka() const;

	void info() override {
		cout << "Ime proizvoda: " + Proizvod::getIme()
			<< " Sifra proizvoda: " + Proizvod::getSifra()
			<< " Cena proizvoda: " + Proizvod::getCena()
			<< " Marka: " + Mobilni::getMarka()
			<< endl;
	}

	friend ostream& operator<<(ostream& out, const Mobilni& m);
};

