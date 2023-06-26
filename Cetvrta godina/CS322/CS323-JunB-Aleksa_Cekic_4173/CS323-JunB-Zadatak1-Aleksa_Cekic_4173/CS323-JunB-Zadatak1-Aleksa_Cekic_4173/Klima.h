#include "Proizvod.h"
#include<iostream>
#include<string>
using namespace std;
#pragma once
class Klima : public  Proizvod
{
private:
	int jacinaKlime;
public:
	Klima();

	void setJacinaKlime(int jacinaKlime);
	int getJacinaKlime() const;

	void info() override {
		cout << "Ime proizvoda: " + Proizvod::getIme()
			<< " Sifra proizvoda: " + Proizvod::getSifra()
			<< " Cena proizvoda: " + Proizvod::getCena()
			<< " Jacina klime: " + Klima::getJacinaKlime()
			<< endl;
	}

	friend ostream& operator<<(ostream& out, const Klima& k);
};

