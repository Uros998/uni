using System;

namespace CS322_DZ06
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Kvadrat");
			Kvadrat k = new Kvadrat();
			k.izracunajPovrsinu(2);
			k.izracunajObim(10);

			Console.WriteLine("Pravougaonik");
			Pravougaonik p = new Pravougaonik(2);
			p.izracunajObim(3);
			p.izracunajPovrsinu(32);
			Console.WriteLine(p.StampajObjekat());
		}
	}
}
