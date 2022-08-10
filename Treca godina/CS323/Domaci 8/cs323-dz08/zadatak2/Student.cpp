#include "Student.h"
#include <string>
#include <iostream>
using namespace std;

Student::Student() {}

Student::Student(string ime, string prezime, string smer, double prosek) {
    this->ime = ime;
    this->prezime = prezime;
    this->smer = smer;
    this->prosek = prosek;
}

Student::Student(Student &s) {
    this->ime = s.ime;
    this->prezime = s.prezime;
    this->smer = s.smer;
    this->prosek = s.prosek;
}

void Student:: setIme(string ime){
    this-> ime = ime;
}
void Student::setPrezime(string prezime){
    this-> prezime = prezime;
}
void Student:: setSmer(string smer){
    this-> smer = smer;
}
void Student:: setProsek(double prosek){
    this-> prosek = prosek;
}

string Student::getIme() {
    return this-> ime;
}
string Student::getPrezime() {
    return this-> prezime;
}
string Student::getSmer() {
    return this-> smer;
}

double Student::getProsek() {
    return this->prosek;
}

Student:: ~Student() {
    cout << "Student je unisten!" << endl;
}



