using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace CS322_DZ13
{
	class Program
	{
		static void Main(string[] args)
		{

			Osoba osoba1 = new Osoba("Ime", "Prezime", "11231232");
			Osoba osoba2 = new Osoba("Ime2", "Prezime3", "11231234");
			Osoba osoba3 = new Osoba("Ime3", "Prezime3", "11231235");

			Grad grad = new Grad("Grad");
			grad.AddOsobu(osoba1);
			grad.AddOsobu(osoba2);
			grad.AddOsobu(osoba3);

			Osoba[] osobe = new Osoba[] { osoba1, osoba2, osoba3 };

			IEnumerable<Osoba> lista = grad.Where(podatak => String.Equals(podatak.Ime, "Ime2"));

			Console.WriteLine(lista.Count() + "");

			foreach(Osoba o in lista)
			{
				Console.WriteLine(o.Ime);
			}

			Drzava drzava = new Drzava();
			drzava.AddGrad(grad);

			IEnumerable<Grad> os = drzava.Where(podatak => String.Equals(grad.Ime, "Grad"));

			Console.WriteLine(os.Count() + "");

			foreach (Grad o in os)
			{
				Console.WriteLine(o.Ime);
			}


			Predmet predmet = new Predmet("Likovno", 3);
			Predmet predmet2 = new Predmet("Fizicko", 4);

			Skola skola = new Skola("Ime skole");

			skola.AddPredmet(predmet);
			skola.AddPredmet(predmet2);

			IEnumerable<Predmet> Predmeti = skola.Where(podatak => String.Equals(grad.Ime, "Grad"));

			Console.WriteLine(os.Count() + "");

			foreach (Predmet predmett in Predmeti)
			{
				Console.WriteLine(predmett.ImePredmeta);
			}


			string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;";

			MySqlConnection conn = new MySqlConnection(mySqlConnectionString);
			MySqlCommand command = new MySqlCommand("INSERT INTO `cs322-dz12`.korisnik(username, password, ime) VALUES (@Username, @Password, @Name)", conn);
			command.Parameters.AddWithValue("@Username", "UsernameKorisnika");
			command.Parameters.AddWithValue("@Password", "1234sifra");
			command.Parameters.AddWithValue("@Name", "ImeKorisnika");
			conn.Open();
			object ob = command.ExecuteScalar();
			conn.Close();

		}
	}
}
