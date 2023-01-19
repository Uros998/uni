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
	public partial class Posetioc : Form
	{

		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";
		private MySqlConnection mySqlConnection;
		private MySqlDataAdapter mySqlDataAdapter;

		public Posetioc()
		{
			InitializeComponent();

			label3.Hide();
			mySqlConnection = new MySqlConnection(mySqlConnectionString);
		}

		internal void PosetiocPodaci(string JMBGPosetioca, string ImePosetioca)
		{
			label2.Text = "Ulogovani ste kao : " + ImePosetioca;

			label3.Text = JMBGPosetioca;
			label3.Hide();

			mySqlConnection.Open();

			mySqlDataAdapter = new MySqlDataAdapter();
			string query = "SELECT * FROM cs322.zakazane_posete WHERE jmbg_posetioca LIKE '" 
				+ JMBGPosetioca + "' ;";
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
			ZakaziPosetu zakaziPosetu = new ZakaziPosetu();


			ZakaziPosetu.JMBGPosetioca = label3.Text;

			zakaziPosetu.Show();
		}

		private void label1_Click(object sender, EventArgs e)
		{

		}

		private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
		{

		}

		private void label2_Click(object sender, EventArgs e)
		{

		}
	}
}
