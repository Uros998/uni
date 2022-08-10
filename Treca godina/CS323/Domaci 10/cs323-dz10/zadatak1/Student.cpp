#include "Student.h"
#include <iostream>
using namespace std;

void Student::info() {
    cout << "Ja sam student" << endl;
}

Student::Student() {}

Student::Student(const string &ime, const string &prezime, int index) : ime(ime), prezime(prezime), index(index) {}

const string &Student::getIme() const {
    return ime;
}

void Student::setIme(const string &ime) {
    Student::ime = ime;
}

const string &Student::getPrezime() const {
    return prezime;
}

void Student::setPrezime(const string &prezime) {
    Student::prezime = prezime;
}

int Student::getIndex() const {
    return index;
}

void Student::setIndex(int index) {
    Student::index = index;
}

Student::~Student() {
}
