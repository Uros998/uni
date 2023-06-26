using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak3
{
	internal class KnjigaUtility
	{
		//liste svih slova, lista kategorija
		String[] slova = { "Q", "W", "E", "R", "T", "Y", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", 
		"V", "B", "N", "M"};

		String[] kategorije = { "beletristika", "strucna literatura", "stripovi", "casopisi", "knjige za decu", "antikvarne knjige" };

		//vracanje reci od random N slova
		public String vratiRec(int N)
		{
			String rec = "";
			Random random = new Random();

			for (int i = 0; i < N ; i++) {
				if( i != 0)
				{
					rec += slova[random.NextInt64(0, 25)].ToLower();
				}
				else
				{
					rec += slova[random.NextInt64(0, 25)];
				}

			}

			return rec;
		}

		//vracanje reci od random N slova i recenice od M reci
		public String vratiRecenicu(int M, int N)
		{
			String recenica = "";
			for (int i = 0; i < M; i++)
			{
				if (i != 0)
				{
					recenica += vratiRec(N).ToLower() + " ";
				}
				else
				{
					recenica += vratiRec(N) + " ";
				}
			}
			recenica += ".";
			return recenica;
		}

		//vracanje 1 random kategorije iz liste
		public String vratiKategoriju()
		{
			Random random = new Random();

			return kategorije[random.Next(0, kategorije.Length)];
		}

		//vracanje random cene iz opsega od 200 do 10000
		public int vratiCenu()
		{
			Random random = new Random();
			return random.Next(200, 10000);
		}

	}
}
