using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ13
{
	class Grad : IEnumerable<Osoba>
	{

		public IList<Osoba> SpisakOsoba;
		public string Ime { get; set; }
		public Grad(string Ime)
		{
			SpisakOsoba = new List<Osoba>();
			this.Ime = Ime;
		}
		public void AddOsobu(Osoba osoba)
		{
			SpisakOsoba.Add(osoba);
		}
		public IEnumerator<Osoba> GetEnumerator()
		{
			foreach (Osoba osoba in SpisakOsoba)
			{
				yield return osoba;
			}
		}
		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}
	}
}
