using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ11
{
	class Kurs : IComparable
	{
		private string ImeKursa { get; set; }
		public int FondCasova { get; set; }
		private string MaksimalnoPrijava { get; set; }

		public Kurs()
		{
		}

		public Kurs(string imeKursa, int fondCasova, string maksimalnoPrijava)
		{
			ImeKursa = imeKursa;
			FondCasova = fondCasova;
			MaksimalnoPrijava = maksimalnoPrijava;
		}

		public int CompareTo(Kurs kurs)
		{
			if (this.FondCasova > kurs.FondCasova)
			{
				return 1;
			} else if (this.FondCasova == kurs.FondCasova)
			{
				return 0;
			}

			return -1;
		}
	}
}
