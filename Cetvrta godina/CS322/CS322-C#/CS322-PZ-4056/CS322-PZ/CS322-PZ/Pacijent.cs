using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace CS322_PZ
{
	public partial class Pacijent : Form
	{
		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";
		private MySqlConnection mySqlConnection;

		internal void PodaciOPacijentu(string IdPacijenta, string JMBG, string Ime,
			string Prezime,  string StepenBolesti)
		{
			label5.Text = IdPacijenta + "";
			label5.Hide();

			textBox1.Text = Ime;
			textBox2.Text = Prezime;
			textBox3.Text = JMBG;
			textBox3.ReadOnly = true;
			textBox4.Text = StepenBolesti + "";
		}

		internal void NoviPacijent(string IdDoktora)
		{
			label6.Text = IdDoktora + "";
			label6.Hide();
		}

		public Pacijent()
		{
			InitializeComponent();

			mySqlConnection = new MySqlConnection(mySqlConnectionString);
		}

		private void button1_Click(object sender, EventArgs e)
		{
			//ukoliko pacijent ima ID onda se radi o update-u, dok ukoliko nema onda se upisuje novi pacijent

			//ID pacijenta se cuva u label5 ali je taj label sakriven dok njegova vrednost je i dalje tu 
			//i može se koristiti
			if ( label5.Text == "")
			{
				int StepenBolesti = 0;
				string Ime = textBox1.Text;
				string Prezime = textBox2.Text;
				string JMBG = textBox3.Text;
				bool JMBGSadrziSamoBrojeve = true;
				int IdDoktora = 0;

				int.TryParse(textBox4.Text, out StepenBolesti);
				int.TryParse(label6.Text, out IdDoktora);

				foreach (char s in JMBG)
				{
					int broj = 0;

					if (!int.TryParse(s + "", out broj))
					{
						JMBGSadrziSamoBrojeve = false;
					}
				}

				if (Ime == "" || Prezime == "")
				{
					MessageBox.Show("Ime i prezime su obavezna polja !");
				}
				else if (JMBG.Length != 13 || JMBGSadrziSamoBrojeve == false)
				{
					MessageBox.Show("JMBG mora da ima tačno 13 cifara i ne sme da sadrži slova");
				}
				else if (StepenBolesti < 1 || StepenBolesti > 5)
				{
					MessageBox.Show("Stepen bolesti mora da bude broj od 1 do 5");
				}
				else
				{
					string query = "SELECT * FROM cs322.pacijenti WHERE jmbg LIKE '"
										+ JMBG + "' ;";
					MySqlCommand mySqlCommand = new MySqlCommand(query, mySqlConnection);

					MySqlCommand cmd = null;
					MySqlDataReader reader = null;

					cmd = new MySqlCommand(query, mySqlConnection);

					mySqlConnection.Open();

					reader = cmd.ExecuteReader();

					if (!reader.HasRows)
					{
						reader.Close();
						mySqlConnection.Close();

						string Query = "INSERT INTO cs322.pacijenti (jmbg, ime, prezime, stepen_bolesti, id_doktora) " +
						"VALUES ('" + JMBG + "', '" + Ime + "', '" + Prezime + "'," +
						"'" + StepenBolesti + "', " + IdDoktora + ")";

						mySqlCommand = new MySqlCommand(Query, mySqlConnection);

						try
						{
							mySqlConnection.Open();
							mySqlCommand.ExecuteNonQuery();
							mySqlConnection.Close();
							MessageBox.Show("Pacijent je napravljen");
						}
						catch (Exception ex)
						{
							mySqlConnection.Close();
							MessageBox.Show("Desila se greška !");
						}
					}
					else
					{
						MessageBox.Show("JMBG postoji");
						reader.Close();
						mySqlConnection.Close();
					}
				}
			}
			else
			{
				int StepenBolesti = 0;
				int IdPacijenta = Int32.Parse(label5.Text);
				string Ime = textBox1.Text;
				string Prezime = textBox2.Text;
				
				int.TryParse(textBox4.Text, out StepenBolesti);

				if (Ime == "" || Prezime == "")
				{
					MessageBox.Show("Ime i prezime su obavezna polja !");
				}
				else if(StepenBolesti < 1 || StepenBolesti > 5)
				{
					MessageBox.Show("Stepen bolesti mora da bude broj od 1 do 5");
				}
				else
				{
					string Query = "UPDATE cs322.pacijenti SET ime = '" + Ime + "', prezime = '" + Prezime +
						"', stepen_bolesti = '" + StepenBolesti +"' WHERE id = '"+ IdPacijenta +"'";

					MySqlCommand mySqlCommand = new MySqlCommand(Query, mySqlConnection);

					try
					{
						mySqlConnection.Open();
						mySqlCommand.ExecuteNonQuery();
						mySqlConnection.Close();
						MessageBox.Show("Pacijent je ažuriran");
					}
					catch (Exception ex)
					{
						mySqlConnection.Close();
						MessageBox.Show("Desila se greška !");
					}
				}
			}
		}
	}
}
