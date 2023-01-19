using System;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ11
{
	class Kvadrat : Oblik
	{
		private double StranicaA { set; get; }

		public Kvadrat(double stranicaA)
		{
			StranicaA = stranicaA;
		}

		public override double Obim()
		{
			return 4 * this.StranicaA;
		}

		public override double Povrsina()
		{
			return this.StranicaA * this.StranicaA;
		}
	}
}
