using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ06
{
	abstract class Objekat : Interfejs
	{
		private double stranica;

		public Objekat()
		{
		}

		public virtual void izracunajObim(double stranica)
		{
		}

		public virtual void izracunajPovrsinu(double stranica)
		{
		}

		public virtual string StampajObjekat()
		{
			return "Stranica je " + stranica;
		}
	}
}