using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ06
{
	class Pravougaonik : Objekat
	{
		double stranicaB;
		public Pravougaonik(double stranicaB)
		{
			this.stranicaB = stranicaB;
		}
		//primer override-a
		public override void izracunajObim(double stranica)
		{
			Console.WriteLine("Obim : " + (2 * stranica + 2 * stranicaB));
		}
		//primer override-a
		public override void izracunajPovrsinu(double stranica)
		{
			Console.WriteLine("Povrsina: " + stranica * stranicaB);
		}
		//primer override-a
		public override string StampajObjekat()
		{
			return base.StampajObjekat();
		}

		//primer overload-a
		public void izracunajPovrsinu(double stranica, double stranicaB)
		{
			Console.WriteLine("Povrsina: " + stranica * stranicaB);
		}
	}
}
