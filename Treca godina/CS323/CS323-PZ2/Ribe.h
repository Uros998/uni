#pragma once
#include "Zivotinje.h"
class Ribe :
	public Zivotinja
{
private:
	string kozaPrekrivena;

public:
	Ribe() {};
	Ribe(string ime, string naucnoIme, string tip, string porodica, int id, string kozaPrekrivena)
		: Zivotinja(ime, naucnoIme, porodica, tip, id), kozaPrekrivena(kozaPrekrivena) {};
	~Ribe() {};

	void setKozaPrekrivena(string kozaPrekrivena) { this->kozaPrekrivena = kozaPrekrivena; };
	string getKozaPrekrivena() const { return kozaPrekrivena; };


	void  insert_animal();
	void display_all();
	void update_animal();
	


};


