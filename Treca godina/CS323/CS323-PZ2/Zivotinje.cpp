#include "Zivotinje.h"

void Zivotinja::setIme(string ime) {
    int i = 0;
    while (ime[i]) {
        if (!isalpha(ime[i])) {

            throw ImeNIjeValidno();
        } else {
            this->ime = ime;
        }
        i++;
    }
}

void Zivotinja::setNaucnoIme(string naucnoIme) {
    int i = 0;
    while (naucnoIme[i]) {
        if (!isalpha(naucnoIme[i])) {

            throw ImeNIjeValidno();
        } else {
            this->naucnoIme = naucnoIme;
        }
        i++;
    }


}

void Zivotinja::setId(int id) {
    if (id < 1 || id > 10) {
        throw IDNijeValidan();
    }
    this->id = id;
}

void Zivotinja::search_animal() {


    ifstream read;
    read.open("zivotinje.txt", ios::in);
    string line;
    string search;

    cout << "Unesi Latinski naziv zivotinje:  ";
    cin >> search;

    while (getline(read, line)) {
        if (line.find(search) != string::npos) {
            cout << line << endl;
        }
    }


    read.close();

}

void Zivotinja::delete_animal() {

    fstream stud;
    fstream temp;

    stud.open("zivotinje.txt", ios::in);
    temp.open("temp.txt", ios::out);

    string line;
    string search;

    cin.ignore();
    cout << "Unesi latinski naziv zivotinje koji brises: ";
    getline(cin, search);
    while (getline(stud, line)) {


        if (line.find(search) != string::npos) {

            continue;
        } else {
            temp << line << endl;

        }


    }
    temp.close();
    stud.close();

    stud.open("zivotinje.txt", ios::out);
    temp.open("temp.txt", ios::in);
    while (getline(temp, line)) {

        cout << line << endl;
        stud << line << endl;

    }
    temp.close();
    stud.close();
    remove("temp.txt");
    cout << "\n Uspesno ste izbrisali!!! \n";

}

void Zivotinja::display_all_list() {

    vector<string> v;

    ifstream read;
    read.open("zivotinje.txt", ios::in);
    string line;


    if (read.is_open()) {
        while (getline(read, line)) {
            v.push_back(line);
        }
        sort(v.begin(), v.end());

        for (auto s: v) {
            cout << "----------------------------" << endl;
            cout << s << endl;
        }
        cout << "----------------------------" << endl;


    }
    read.close();


}


