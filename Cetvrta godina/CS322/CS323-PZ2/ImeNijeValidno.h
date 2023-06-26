#pragma once
#include<string>
#include<vector>
#include<algorithm>
#include<exception>

using namespace std;

class ImeNIjeValidno : public exception {
public:

	const char * what() const throw ()
	{
		return "Ime ili naucno ime treba da sadrze samo slova!!!";
	}


};
