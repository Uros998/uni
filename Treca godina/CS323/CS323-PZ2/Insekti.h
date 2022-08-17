#pragma once
#include "Zivotinje.h"
class Insekti :
	public Zivotinja
{
private:
	string kozaPrekrivena;
	string otrovne;

public:
	Insekti() {};
	Insekti(string ime, string naucnoIme, string tip, string porodica, int id, string kozaPrekrivena, string otrovne)
		: Zivotinja(ime, naucnoIme, porodica, tip, id), kozaPrekrivena(kozaPrekrivena), otrovne(otrovne) {};
	~Insekti() {};

	void setKozaPrekrivena(string kozaPrekrivena) { this->kozaPrekrivena = kozaPrekrivena; };
	string getKozaPrekrivena() const { return kozaPrekrivena; };


	void setOtrovne(string otrovne) { this->otrovne = otrovne; };
	string getOtrovne() const { return otrovne; };


	void  insert_animal();
	void display_all();
	void update_animal();
	
	
	

};

