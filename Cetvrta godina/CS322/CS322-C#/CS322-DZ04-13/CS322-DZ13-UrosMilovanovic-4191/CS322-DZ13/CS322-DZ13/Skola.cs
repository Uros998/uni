using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ13
{
	class Skola : IEnumerable<Predmet>
	{
		public string ImeSkole { get; set; }
		private IList<Predmet> Predmeti;

		public Skola(string imeSkole)
		{
			this.ImeSkole = imeSkole;
			Predmeti = new List<Predmet>();
		}

		public void AddPredmet(Predmet predmet)
		{
			Predmeti.Add(predmet);
		}
		public IEnumerator<Predmet> GetEnumerator()
		{
			foreach (Predmet predmet in Predmeti)
			{
				yield return predmet;
			}
		}

		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}
	}
}
