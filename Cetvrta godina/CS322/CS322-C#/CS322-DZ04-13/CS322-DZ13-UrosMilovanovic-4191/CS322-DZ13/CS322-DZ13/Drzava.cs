using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace CS322_DZ13
{
	class Drzava : IEnumerable<Grad>
	{
		private IList<Grad> SpisakGradova;

		public Drzava()
		{
			SpisakGradova = new List<Grad>();
		}
		public void AddGrad(Grad grad)
		{
			SpisakGradova.Add(grad);
		}
		public IEnumerator<Grad> GetEnumerator()
		{
			foreach (Grad grad in SpisakGradova)
			{
				yield return grad;
			}
		}
		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}
	}
}
