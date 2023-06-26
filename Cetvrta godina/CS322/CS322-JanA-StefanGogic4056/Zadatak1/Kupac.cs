using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak1
{
	internal class Kupac
	{
		public String korisnickoIme { get; set; }
		public String lozinka { get; set; }
		public String ime { get; set; }
		public String prezime { get; set; }
		public String adresa { get; set; }
		public String email { get; set; }
		public String mobilniTelefon { get; set; }

		public List<Proizvod> proizvodi = new List<Proizvod>();

		public Kupac() { }

		~Kupac() { }

		public Kupac(string korisnickoIme, string lozinka, string ime, string prezime, string adresa, string email, string mobilniTelefon)
		{
			this.korisnickoIme = korisnickoIme;
			this.lozinka = lozinka;
			this.ime = ime;
			this.prezime = prezime;
			this.adresa = adresa;
			this.email = email;
			this.mobilniTelefon = mobilniTelefon;
		}

		//primer polimorfizma jer je svaka klasa na svoj nacin uradila tostring metodu
		public void toString()
		{
			Console.WriteLine("Korisnicko ime:" + korisnickoIme + " lozinka:" + lozinka + " ime:" + ime 
				+ " prezime:" + prezime + " adresa:" + adresa + " email:" + email + " broj telefona:" + mobilniTelefon);

			foreach(Proizvod proizvod in proizvodi)
			{
				Console.WriteLine(proizvod.ToString);
			}
		}

	}
}
