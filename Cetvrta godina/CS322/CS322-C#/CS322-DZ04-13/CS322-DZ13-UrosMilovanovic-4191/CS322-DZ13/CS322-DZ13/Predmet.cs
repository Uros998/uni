using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ13
{
	class Predmet
	{
		public string ImePredmeta { get; set; }
		public int BrojCasova { get; set; }

		public Predmet(string imePredmeta, int brojCasova)
		{
			ImePredmeta = imePredmeta;
			BrojCasova = brojCasova;
		}
	}
}
