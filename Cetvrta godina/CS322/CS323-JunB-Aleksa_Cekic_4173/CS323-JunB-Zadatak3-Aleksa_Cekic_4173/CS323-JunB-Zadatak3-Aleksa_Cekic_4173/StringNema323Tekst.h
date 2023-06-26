#pragma once
#include <exception>
using namespace std;

class StringNema323TekstException : public exception {
public:
    const char* what() {
        return "Uneti string ne sadrzi CS323 tekst u sebi!";
    }
};