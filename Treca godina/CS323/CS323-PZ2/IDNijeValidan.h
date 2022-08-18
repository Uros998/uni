#pragma once
#include<string>
#include<vector>
#include<algorithm>
#include<exception>

using namespace std;

class IDNijeValidan : public exception {
public:

	const char * what() const throw ()
	{
		return "ID treba da bude od 1 do 10";
	}


};