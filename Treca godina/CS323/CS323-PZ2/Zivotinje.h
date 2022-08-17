#pragma once
#include<iostream>
#include<fstream>
#include<string>
#include<vector>
#include<algorithm>
#include<exception>
#include <cctype>
#include"IDNijeValidan.h"
#include"ImeNijeValidno.h"
#include<map>
#include<sstream>


using namespace std;

class Zivotinja {
private:
	string ime;
	string naucnoIme;
	string tip;
	string porodica;
	int id;
protected:
	Zivotinja() {};
	Zivotinja(string ime, string naucnoIme, string tip, string porodica, int id) :
		ime(ime), naucnoIme(naucnoIme), tip(tip), id(id) {};
	virtual ~Zivotinja() {};
public:

	void setIme(string ime);
	void setNaucnoIme(string naucnoIme);
	void setTip(string tip) { this->tip = tip; };
	void setPorodica(string porodica) { this->porodica = porodica; };
	void setId(int id);

	string getIme() const { return ime; };
	string getNaucnoIme() const { return naucnoIme; };
	string getTip() const { return tip; };
	string getPorodica() const { return porodica; };
	int getId() const { return id; };


	virtual void insert_animal() = 0;
	virtual void search_animal();
	virtual void display_all() = 0;
	virtual void update_animal() = 0;
	virtual void delete_animal();
	virtual void display_all_list();
	






};