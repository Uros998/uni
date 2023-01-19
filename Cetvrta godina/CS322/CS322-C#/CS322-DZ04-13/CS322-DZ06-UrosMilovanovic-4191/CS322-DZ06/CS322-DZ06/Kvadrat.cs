using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ06
{
	class Kvadrat : Objekat
	{
		public Kvadrat()
		{
		}
		//primer override-a
		public override void izracunajObim(double stranica)
		{
			Console.WriteLine("Obim : " + 2 * stranica);
		}
		//primer override-a
		public override void izracunajPovrsinu(double stranica)
		{
			Console.WriteLine("Povrsina: " + stranica * stranica);
		}
		//primer override-a
		public override string StampajObjekat()
		{
			return base.StampajObjekat();
		}
	}
}
