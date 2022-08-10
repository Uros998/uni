#include "Student.h"
#include "Zaposleni.h"

int main() {
	Student s;
	Zaposleni z;

	s.setIme("Uros");
	s.setPrezime("Milovanovic");
	s.setAdresa("Nis");
	s.setIndex(4191);
	s.setTelefon("0658489077");

	z.setIme("Milos");
	z.setPrezime("Radivojevic");
	z.setAdresa("Nis");
	z.setTelefon("064987361");
	z.setId(12341);

	cout << s.toString() << endl;
	cout << z.toString() << endl;

	return 0;
}