#include <iostream>
#include "Mobilni.h"
#include "Klima.h"
#include <stack>
#include <fstream>

using namespace std;

int main() {
	Mobilni m;
	Klima k;
	stack<Mobilni> sm;
	stack<Klima> sk;

	string ime, sifra, cena, marka;
	int jacinaKlime;
	cout << "Mobilni" << endl;
	for (int i = 0; i < 3; i++)
	{
		cout << "Unesite ime proizvoda: " << endl;
		cin >> ime;
		m.setIme(ime);
		cout << "Unesite sifru proizvoda: " << endl;
		cin >> sifra;
		m.setSifra(sifra);
		cout << "Unesite cenu proizvoda: " << endl;
		cin >> cena;
		m.setCena(cena);
		cout << "Unesite marku telefona: " << endl;
		cin >> marka;
		m.setMarka(marka);

		m.info();

		sm.push(m);
	}

	cout << "Klima uredjaj" << endl;
	for (int i = 0; i < 3; i++)
	{
		cout << "Unesite ime proizvoda: " << endl;
		cin >> ime;
		k.setIme(ime);
		cout << "Unesite sifru proizvoda: " << endl;
		cin >> sifra;
		k.setSifra(sifra);
		cout << "Unesite cenu proizvoda: " << endl;
		cin >> cena;
		k.setCena(cena);
		cout << "Unesite jacinu klime: " << endl;
		cin >> jacinaKlime;
		k.setJacinaKlime(jacinaKlime);

		k.info();

		sk.push(k);
	}

	ofstream out;
	out.open("Proizvodi.txt");
	out << "0 - Mobilni Uredjaj" << endl;
	while (!sm.empty()) {
		
		if (sm.top().getMarka() == "Samsung") {
			out << "Mobilni telefon: " << sm.top() << endl;
		}
		sm.pop();
	}

	out << "1 - Klima Uredjaji" << endl;
	while (!sk.empty()) {
		if (sk.top().getJacinaKlime() > 14000) {
			out << "Klima uredjaj: " << sk.top() << endl;
		}
		sk.pop();
	}

	out.close();

	return 0;
}