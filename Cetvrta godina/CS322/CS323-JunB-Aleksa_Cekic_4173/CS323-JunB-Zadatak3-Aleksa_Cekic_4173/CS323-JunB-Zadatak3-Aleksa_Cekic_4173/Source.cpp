#include <iostream>
#include "StringNema323Tekst.h"
using namespace std;

void zameni(const string& s, string ns) {
	
		if (s.find("omg") != string::npos) {
			ns = ns.replace(s.find("omg"), 3, "****");
		}
		if (s.find("lol") != string::npos) {
			ns = ns.replace(s.find("lol"), 3, "****");
		}
		if (s.find("rofl") != string::npos) {
			ns = ns.replace(s.find("rofl"), 4, "****");
		}
		if (s.find("llah") != string::npos) {
			ns = ns.replace(s.find("llah"), 4, "****");
		}
		if (s.find("stfw") != string::npos) {
			ns = ns.replace(s.find("stfw"), 4, "****");
		}
		cout << ns;
}


void ponavljaj(const string& s) {
	int count = 0;

	for (int i = 0; i < s.size(); i++)
		if (s[i] == 'C' && s[i+1] == 'S' && s[i+2] == '3' && s[i+3] == '2' && s[i+4] == '3') count++;

	cout << "String se pojavljuje " << count << " broj puta" << endl;
}

int main() {
	string str;
	int n;
	int i = 0;
	cout << "Unesite koliko teksta zelite da unesete: " << endl;
	cin >> n;
	cout << "Unesite n = " << n << " teksta : " << endl;
	
	for (int i = 0; i < n; i++)
	{
		cout << "Tekst " << i + 1 << ": ";
		cin >> str;
		cout << "\n";
		str;
		zameni(str, str);

		if (str.find("CS323") == string::npos) {
			StringNema323TekstException stringNema323TekstException;
			throw stringNema323TekstException;
		}

		ponavljaj(str);
	}
	


	return 0;
}