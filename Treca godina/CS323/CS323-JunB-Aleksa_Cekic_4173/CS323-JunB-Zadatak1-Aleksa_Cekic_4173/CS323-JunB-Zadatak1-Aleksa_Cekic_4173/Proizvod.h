#include<iostream>
#include<string>
using namespace std;

#pragma once
class Proizvod
{
protected:
	string ime;
	string sifra;
	string cena;

public:
	Proizvod();
	Proizvod(string ime, string sifra, string cena);

	void setIme(string ime);
	void setSifra(string sifra);
	void setCena(string cena);

	string getIme() const;
	string getSifra() const;
	string getCena() const;

	virtual void info() = 0;
};

