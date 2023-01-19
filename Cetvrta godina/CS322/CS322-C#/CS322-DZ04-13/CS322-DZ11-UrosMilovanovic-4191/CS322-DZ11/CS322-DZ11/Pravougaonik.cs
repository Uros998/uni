using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ11
{
	class Pravougaonik : Oblik
	{
		private double StranicaA { set; get; }
		private double StranicaB { set; get; }

		public Pravougaonik(double stranicaA, double stranicaB)
		{
			StranicaA = stranicaA;
			StranicaB = stranicaB;
		}

		public override double Obim()
		{
			return 2 * this.StranicaA + 2 * this.StranicaB;
		}

		public override double Povrsina()
		{
			return this.StranicaA * this.StranicaB;
		}
	}
}
