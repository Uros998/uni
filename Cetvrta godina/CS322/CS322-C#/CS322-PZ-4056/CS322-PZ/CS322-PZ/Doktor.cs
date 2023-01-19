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
	public partial class Doktor : Form
	{
		public static int IdDoktora;
		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";
		private MySqlConnection mySqlConnection;
		private MySqlDataAdapter mySqlDataAdapter;

		public Doktor()
		{
			InitializeComponent();
			mySqlConnection = new MySqlConnection(mySqlConnectionString);
		}

		internal void ListaPacijenata(int IdDoktora)
		{
			mySqlConnection.Open();

			label1.Text = IdDoktora + "";
			label1.Hide();

			mySqlDataAdapter = new MySqlDataAdapter();
			string query = "SELECT * FROM cs322.pacijenti WHERE id_doktora = '"
				+ IdDoktora + "' ;";

			mySqlDataAdapter.SelectCommand = new MySqlCommand(query, mySqlConnection);

			DataTable table = new DataTable();
			mySqlDataAdapter.Fill(table);

			BindingSource bs = new BindingSource();
			bs.DataSource = table;

			dataGridView1.DataSource = bs;
			dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
			dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
			
			mySqlConnection.Close();
		}

		private void button1_Click(object sender, EventArgs e)
		{
			Pacijent pacijent = new Pacijent();

			pacijent.NoviPacijent(label1.Text);

			pacijent.Show();
		}

		private void button2_Click(object sender, EventArgs e)
		{
			if( dataGridView1.SelectedRows.Count == 1 )
			{
				DataGridViewSelectedCellCollection DSCL = dataGridView1.SelectedCells;

				Pacijent pacijent = new Pacijent();

				pacijent.PodaciOPacijentu(DSCL[0].Value.ToString(), 
					DSCL[1].Value.ToString(), DSCL[2].Value.ToString(), DSCL[3].Value.ToString(),
					DSCL[4].Value.ToString());

				pacijent.Show();
			} 
			else
			{
				MessageBox.Show("Morate da izaberete jednog pacijenta !");
			}
		}
	}
}
