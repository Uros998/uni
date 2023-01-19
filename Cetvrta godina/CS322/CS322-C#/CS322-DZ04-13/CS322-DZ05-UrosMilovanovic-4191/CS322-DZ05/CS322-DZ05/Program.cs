using System;

namespace CS322_DZ05
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Unesite prvi broj : ");
			int prviBroj = int.Parse(Console.ReadLine());

			Console.WriteLine("Unesite drugi broj : ");
			int drugiBroj = int.Parse(Console.ReadLine());

			Console.WriteLine(vratiStepen(prviBroj, drugiBroj));
		}

		static public double vratiStepen(double prviBroj, double drugiBroj)
		{
			if(prviBroj == 0)
			{
				Console.WriteLine("Prvi broj mora biti razlicit od 0");
				return -1;
			}
			else if (drugiBroj < 0)
			{
				Console.WriteLine("Drugi broj mora biti veci od 0 ili jednak 0");
				return -1;
			}
			return Math.Pow(prviBroj, drugiBroj);
		}
	}
}
