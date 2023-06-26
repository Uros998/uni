using Zadatak1;

string datumNarucivanja = DateTime.Now + "";
int kolicina = 0;
int cenaKolicine1 = 0;
int cenaKolicine2 = 0;

Proizvod p = new Proizvod();
p.sifra = 2;
p.cena = 20000;
p.naziv = "P1";
p.proizvodjac = "Stark";
p.kategorija = "Slatkisi";

Proizvod p2 = new Proizvod();
p2.sifra = 2;
p2.cena = 21000;
p2.naziv = "P2";
p2.proizvodjac = "Bambi";
p2.kategorija = "Slanisi";

Kupac kupac = new Kupac();
kupac.adresa = "Adresa Ulica broj";
kupac.email = "email";
kupac.lozinka = "****";
kupac.ime = "Ime";
kupac.prezime = "Prezime";
kupac.korisnickoIme = "KOrisnikcoImeKupac";

int kol1 = 0;
int kol2 = 0;
while (true)
{
	Console.WriteLine("Unesite koji proizvod zelite da kupite (P1 ili P2 unesite) ili unesite nesto drugo za kraj programa");

	string imeProizvoda = Console.ReadLine();
	
	if( imeProizvoda == "P1")
	{
		p.toString();
		Console.WriteLine("Unesite kolicinu");
		kol1 += Int16.Parse(Console.ReadLine());
		cenaKolicine1 += kol1 * p.cena;
		kupac.proizvodi.Add(p);

	}
	else if (imeProizvoda == "P2")
	{
		p2.toString();
		Console.WriteLine("Unesite kolicinu");
		kol2 += Int16.Parse(Console.ReadLine());
		cenaKolicine2 += kol2 * p2.cena;
		kupac.proizvodi.Add(p2);
	}
	else
	{
		break;
	}
}

Console.WriteLine("Datum je " + datumNarucivanja);
Console.WriteLine("Kolicina kupljenih proizvoda P1 :" + kol1 + " a cena je :" + cenaKolicine1);
Console.WriteLine("Kolicina kupljenih proizvoda P2 :" + kol2 + " a cena je :" + cenaKolicine2);
Console.WriteLine("Podaci o kupcu : ");
kupac.toString();