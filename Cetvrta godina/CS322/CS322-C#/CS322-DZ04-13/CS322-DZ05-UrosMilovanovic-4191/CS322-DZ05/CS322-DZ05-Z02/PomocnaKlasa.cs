using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ05_Z02
{
	class PomocnaKlasa
	{
		static public string vratiRandomRec()
		{
			string randomRec = "";
			//65-90 -> ascii vrednost velikih slova
			//97-122 -> ascii vrednost malih slova 
			Random random = new Random();

			randomRec += (char)random.Next(65, 90);

			for (int i = 0; i < 7; i++)
			{
				randomRec += (char)random.Next(97, 122);
			}
			return randomRec;
		}
		static public int vratiRandomBroj()
		{
			Random random = new Random();
			return random.Next(1, 200);
		}
	}
}
