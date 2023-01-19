using System;
using System.Text;

namespace CS322_DZ13
{
	class Osoba
	{
		public string Ime { get; set; }
		public string Prezime { get; set; }
		public string JMBG { get; set; }

		public Osoba(string Ime, string Prezime, string JMBG)
		{
			this.Ime = Ime;
			this.Prezime = Prezime;
			this.JMBG = JMBG;
		}

	}
}
