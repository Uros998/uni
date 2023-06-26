#pragma once
#include "Zivotinje.h"
class Sisari :
	public Zivotinja
{
private:
	string kozaPrekrivena;

public:
	Sisari() {};
	Sisari(string ime, string naucnoIme, string tip, string porodica, int id, string kozaPrekrivena)
		: Zivotinja(ime, naucnoIme, porodica, tip, id), kozaPrekrivena(kozaPrekrivena) {};
	~Sisari() {};

	void setKozaPrekrivena(string kozaPrekrivena) { this->kozaPrekrivena = kozaPrekrivena; };
	string getKozaPrekrivena() const { return kozaPrekrivena; };


	void  insert_animal();
	void display_all();
	void update_animal();
    

};


