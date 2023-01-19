using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ05_Z02
{
	class Posetioc
	{
		public string ime
		{ get; set; }

		public string prezime
		{ get; set; }

		private int brojUlaznice
		{ get; set; }

		Posetioc() { }
		public Posetioc(string ime, string prezime, int brojUlaznice)
		{
			this.ime = ime;
			this.prezime = prezime;
			this.brojUlaznice = brojUlaznice;
		}

		public void stampajPosetioca()
		{
			Console.WriteLine("Ime : " + ime + ", Prezime :" + prezime + ", Broj ulaznice : " + brojUlaznice);
		}
	}
}
