#include "BachelorStudent.h"
#include <string>
#include <iostream>
using namespace std;

BachelorStudent::BachelorStudent() {}

BachelorStudent::BachelorStudent(const string &ime, const string &prezime, int index, const string &smer) :
Student(ime,prezime,index),smer(smer) {}


const string &BachelorStudent::getSmer() const {
    return smer;
}

void BachelorStudent::setSmer(const string &smer) {
    BachelorStudent::smer = smer;
}

BachelorStudent::~BachelorStudent() {}

void BachelorStudent::info() {
    cout << "Moji smer je " << smer << endl;
}
