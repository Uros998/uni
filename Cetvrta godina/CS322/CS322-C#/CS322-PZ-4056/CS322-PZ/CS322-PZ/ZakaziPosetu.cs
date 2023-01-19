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
	public partial class ZakaziPosetu : Form
	{
		public static string JMBGPosetioca;

		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";
		private MySqlConnection mySqlConnection;


		public ZakaziPosetu()
		{
			InitializeComponent();

			mySqlConnection = new MySqlConnection(mySqlConnectionString);
			monthCalendar1.MaxSelectionCount = 1;
		}

		private void button1_Click(object sender, EventArgs e)
		{
			MySqlCommand cmd = null;
			MySqlDataReader reader = null;

			string jmbg = textBox1.Text;
			string datum = monthCalendar1.SelectionRange.Start.ToString("yyyy-MM-dd");

			string Query = "SELECT * FROM cs322.pacijenti WHERE jmbg LIKE '" + jmbg + "';";
			cmd = new MySqlCommand(Query, mySqlConnection);

			mySqlConnection.Open();

			reader = cmd.ExecuteReader();

			if (reader.HasRows)
			{
				Query = "INSERT INTO cs322.zakazane_posete (`jmbg_posetioca`, `jmbg_pacijenta`, `datum_posete`) " +
					"VALUES ('" + JMBGPosetioca + "', '" + jmbg + "', '" + datum + "')";

				reader.Close();
				mySqlConnection.Close();

				mySqlConnection.Open();

				cmd = new MySqlCommand(Query, mySqlConnection);

				try
				{
					cmd.ExecuteNonQuery();
					mySqlConnection.Close();
					MessageBox.Show("Poseta je zakazana");
				}
				catch (Exception ex)
				{
					mySqlConnection.Close();
					MessageBox.Show("Desila se greška ! " + ex);
				}
			}
			else
			{
				MessageBox.Show("Nepostojeći JMBG je unet");
				mySqlConnection.Close();
			}
		}	
	}
}
