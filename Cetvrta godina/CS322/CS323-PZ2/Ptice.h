#pragma once
#include "Zivotinje.h"
class Ptice :
	public Zivotinja
{
private:
	string kozaPrekrivena;
	string letacice;


public:
	Ptice() {};
	Ptice(string ime, string naucnoIme, string tip, string porodica, int id, string kozaPrekrivena, string letacice)
		: Zivotinja(ime, naucnoIme, porodica, tip, id), kozaPrekrivena(kozaPrekrivena), letacice(letacice) {};
	~Ptice() {};

	void setKozaPrekrivena(string kozaPrekrivena) { this->kozaPrekrivena = kozaPrekrivena; };
	string getKozaPrekrivena() const { return kozaPrekrivena; };

	void setLetacice(string letacice) { this->letacice = letacice; };
	string getLetacice() const { return  letacice; };


	void  insert_animal();
	void display_all();
	void update_animal();
	


	



};
