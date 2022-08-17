#include "Insekti.h"



void Insekti::insert_animal()
{

	Insekti s;
	int id;
	string ime;
	string naucno;
	string tip;
	string porodica;
	string koza;
	string otrovne;
	string line;
	string c = "y";

	ofstream write;
	ifstream read;

	write.open("zivotinje.txt", ios::app);

	while (c == "y")
	{
        cout << "___________________________________\n";
        cout << "----- Unesite novog insekta -----\n";
        cout << "ID                 :"; cin >> id;
        cout << "Ime                :"; cin >> ime;
        cout << "Naucno ime         :"; cin >> naucno;
        cout << "Tip                :"; cin >> tip;
        cout << "Porodica           :"; cin >> porodica;
        cout << "Koza je prekriveno :"; cin >> koza;
        cout << "Otrovne da ili ne  :"; cin >> otrovne;
        cout << "___________________________________\n";


		s.setId(id);
		s.setIme(ime);
		s.setNaucnoIme(naucno);
		s.setTip(tip);
		s.setPorodica(porodica);
		s.setKozaPrekrivena(koza);
		s.setOtrovne(otrovne);

		write << s.getId() << " " << s.getIme() << " " << s.getNaucnoIme() << " " << s.getTip() << " " << s.getPorodica() << " " << s.getKozaPrekrivena() << " " << s.getOtrovne() << endl;

		cout << "Unesi y za nastavak!!!" << endl;
		cin >> c;
	}

	cout << "Uspesno ste dodali insekta!!!" << endl;


	write.close();
}

void Insekti::display_all()
{
	vector<string>v;

	ifstream read;
	read.open("zivotinje.txt", ios::in);
	string line;

	while (getline(read, line))
	{
		if (line.find("4") != string::npos) {
			v.push_back(line);
		}
	}

	sort(v.begin(), v.end());
	for (auto s : v) {

		cout << s << endl;
	}

	read.close();
}

void Insekti::update_animal()
{
	Insekti s;
	fstream stud;
	fstream temp;

	stud.open("zivotinje.txt", ios::in);
	temp.open("temp.txt", ios::out);

	string line;
	string search;

	cin.ignore();
	cout << "Unesi latinski naziv zivotinje koju editujes: ";
	getline(cin, search);
	while (getline(stud, line))
	{

		if (line.find(search) != string::npos)
		{

			continue;
		}
		else
		{
			temp << line << endl;

		}


	}
	temp.close();
	stud.close();

	stud.open("zivotinje.txt", ios::out);
	temp.open("temp.txt", ios::in);
	while (getline(temp, line))
	{

		stud << line << endl;

	}
	temp.close();
	stud.close();
	remove("temp.txt");


	int id;
	string ime;
	string naucno;
	string tip;
	string porodica;
	string koza;
	string c = "y";


	stud.open("zivotinje.txt", ios::app);
	temp.open("zivotinje.txt", ios::in);


    cout << "___________________________________\n";
    cout << "----- Unesite nove podatke -----\n";
	cout << "ID                 :"; cin >> id;
	cout << "Ime                :"; cin >> ime;
	cout << "Naucno ime         :"; cin >> naucno;
	cout << "Tip                :"; cin >> tip;
	cout << "Porodica           :"; cin >> porodica;
	cout << "Koza je prekriveno :"; cin >> koza;
	cout << "Otrovne da ili ne  :"; cin >> otrovne;
    cout << "___________________________________\n";

	s.setId(id);
	s.setIme(ime);
	s.setNaucnoIme(naucno);
	s.setTip(tip);
	s.setPorodica(porodica);
	s.setKozaPrekrivena(koza);
	s.setOtrovne(otrovne);


	stud << s.getId() << " " << s.getIme() << " " << s.getNaucnoIme() << " " << s.getTip() << " " << s.getPorodica() << " " << s.getKozaPrekrivena() << " " << s.getOtrovne() << endl;

	while (getline(temp, line))
	{
		if (line.find("4") != string::npos) {
			cout << line << endl;
		}
	}

	stud.close();
	temp.close();

	cout << "\n Uspesno ste izmenili insekta!!! \n";
}


