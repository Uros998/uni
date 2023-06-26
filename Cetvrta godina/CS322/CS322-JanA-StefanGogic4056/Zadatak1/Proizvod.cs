using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak1
{
	internal class Proizvod
	{
		public int sifra { get; set; }
		public String naziv { get; set; }
		public String proizvodjac { get; set; }
		public int cena { get; set; }
		public String kategorija { get; set; }

		public Proizvod() { }

		~Proizvod() { }

		public Proizvod(int sifra, string naziv, string proizvodjac, int cena, string kategorija)
		{
			this.sifra = sifra;
			this.naziv = naziv;
			this.proizvodjac = proizvodjac;
			this.cena = cena;
			this.kategorija = kategorija;
		}

		//primer polimorfizma
		public void toString()
		{
			Console.WriteLine("Sifra: " + sifra + " naziv:" + naziv + " proizvodjac:" + 
				proizvodjac + " cena:" + cena + " kategorija:" + kategorija);
		}
	}
}
