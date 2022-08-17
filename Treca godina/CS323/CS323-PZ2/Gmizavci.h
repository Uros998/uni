#pragma once
#include "Zivotinje.h"
class Gmizavci :
	public Zivotinja
{
private:
	string kozaPrekrivena;
	string otrovne;

public:
	Gmizavci() {};
	Gmizavci(string ime, string naucnoIme, string tip, string porodica, int id, string kozaPrekrivena, string otrovne)
		: Zivotinja(ime, naucnoIme, porodica, tip, id), kozaPrekrivena(kozaPrekrivena), otrovne(otrovne) {};
	~Gmizavci() {};

	void setKozaPrekrivena(string kozaPrekrivena) { this->kozaPrekrivena = kozaPrekrivena; };
	string getKozaPrekrivena() const { return kozaPrekrivena; };


	void setOtrovne(string otrovne) { this->otrovne = otrovne; };
	string getOtrovne() const { return otrovne; };


	void insert_animal();
	void display_all();
	void update_animal();
	
	


};

