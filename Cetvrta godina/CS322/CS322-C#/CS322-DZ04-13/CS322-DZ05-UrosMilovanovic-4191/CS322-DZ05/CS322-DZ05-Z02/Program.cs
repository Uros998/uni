using System;

namespace CS322_DZ05_Z02
{
	class Program
	{
		static void Main(string[] args)
		{
			Posetioc p1 = new Posetioc(PomocnaKlasa.vratiRandomRec(), PomocnaKlasa.vratiRandomRec(), PomocnaKlasa.vratiRandomBroj());
			Posetioc p2 = new Posetioc(PomocnaKlasa.vratiRandomRec(), PomocnaKlasa.vratiRandomRec(), PomocnaKlasa.vratiRandomBroj());
			p1.stampajPosetioca();
			p2.stampajPosetioca();
		}
	}
}
