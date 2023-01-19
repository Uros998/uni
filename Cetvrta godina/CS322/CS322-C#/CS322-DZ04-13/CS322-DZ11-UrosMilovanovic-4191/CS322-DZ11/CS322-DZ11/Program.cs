using System;
using System.Collections;
using System.Collections.Generic;

namespace CS322_DZ11
{
	class Program
	{
		static void Main(string[] args)
		{
			// Zadatak 1
			Kurs kurs = new Kurs("ime", 12, "22");
			Kurs kurs2 = new Kurs("ime2", 125, "22");
			Kurs kurs3 = new Kurs("ime3", 123, "22");

			List<Kurs> lista = new List<Kurs>();
			lista.Add(kurs);
			lista.Add(kurs2);
			lista.Add(kurs3);

			lista.Sort( (k1, k2) => k1.CompareTo(k2) );

			foreach(Kurs k in lista){
				Console.WriteLine(k.FondCasova);
			}

			// Zadatak 2
		}
	}
}
