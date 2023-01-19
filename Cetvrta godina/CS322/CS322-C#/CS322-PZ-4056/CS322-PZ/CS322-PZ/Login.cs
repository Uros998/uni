using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_PZ
{
	public partial class Login : Form
	{

		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";
		private MySqlConnection mySqlConnection;

		public Login()
		{
			InitializeComponent();

			mySqlConnection = new MySqlConnection(mySqlConnectionString);
		}

		private void button1_Click(object sender, EventArgs e)
		{
			string AuthParam = textBox1.Text;
			string Password = textBox2.Text;

			MySqlCommand cmd = null;
			MySqlDataReader reader = null;

			if (Password != "")
			{
				string Query = "SELECT * FROM cs322.posetioci WHERE broj_telefona = '"
					+ AuthParam + "' AND jmbg LIKE '" + Password + "';";
				cmd = new MySqlCommand(Query, mySqlConnection);

				mySqlConnection.Open();

				reader = cmd.ExecuteReader();

				if (reader.HasRows)
				{
					string ImePosetioca = "";
					string JMBGPosetioca = "";

					while (reader.Read())
					{
						ImePosetioca = reader.GetString("ime");
						JMBGPosetioca = reader.GetString("jmbg");
					}

					mySqlConnection.Close();
					Posetioc posetiocForm = new Posetioc();

					posetiocForm.PosetiocPodaci(JMBGPosetioca, ImePosetioca);

					posetiocForm.Show();
					this.Hide();
				}
				else
				{
					MessageBox.Show("Podaci koje ste uneli su nepostojeći");
				}
				mySqlConnection.Close();

			}
			else
			{
				string Query = "SELECT * FROM cs322.doktori WHERE email LIKE '" + AuthParam + "';";
				cmd = new MySqlCommand(Query, mySqlConnection);
				int IdDoktora = 0;


				mySqlConnection.Open();

				reader = cmd.ExecuteReader();

				if (reader.HasRows)
				{
					while (reader.Read())
					{
						IdDoktora = reader.GetInt32("id");
					}

					mySqlConnection.Close();
					Doktor doktor = new Doktor();

					doktor.ListaPacijenata(IdDoktora);
					Doktor.IdDoktora = IdDoktora;

					doktor.Show();
					this.Hide();
				}
				else
				{
					MessageBox.Show("Podaci koje ste uneli su nepostojeći");
				}
				mySqlConnection.Close();
			}
		}

		private void label2_Click(object sender, EventArgs e)
		{

		}

		private void textBox1_TextChanged(object sender, EventArgs e)
		{

		}

		private void label1_Click(object sender, EventArgs e)
		{

		}

		private void textBox2_TextChanged(object sender, EventArgs e)
		{

		}
	}
}
