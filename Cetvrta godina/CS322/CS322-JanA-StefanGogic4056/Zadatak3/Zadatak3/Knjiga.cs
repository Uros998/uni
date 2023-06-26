using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak3
{
	internal class Knjiga
	{
		//atributi sa get set metodama
		static public int idKnjige { get; set; }
		public String nazivKnjige { get; set; }
		public String opisKnjige { get; set; }
		public String kategorijaKnjige { get; set; }
		public int cenaKnjige { get; set; }

		//defaultni konstruktor
		public Knjiga()
		{
			idKnjige += 1;
		}


		// konstruktor sa svim parametrima

		public Knjiga(string nazivKnjige, string opisKnjige, string kategorijaKnjige, int cenaKnjige)
		{
			idKnjige += 1;
			this.nazivKnjige = nazivKnjige;
			this.opisKnjige = opisKnjige;
			this.kategorijaKnjige = kategorijaKnjige;
			this.cenaKnjige = cenaKnjige;
		}

		public Knjiga(string nazivKnjige, string opisKnjige, int cenaKnjige)
		{
			idKnjige += 1;
			this.nazivKnjige = nazivKnjige;
			this.opisKnjige = opisKnjige;
			this.cenaKnjige = cenaKnjige;
		}

		//destruktor
		~Knjiga() { idKnjige -= 1; }

		//toString metoda
		public void toString()
		{
			Console.WriteLine("Id" + idKnjige + "naziv knjige: " 
				+ nazivKnjige + "opis knjige: " + opisKnjige 
				+ "kategorija knjige" + kategorijaKnjige + "cena knjige" + cenaKnjige);
		}
	}
}
