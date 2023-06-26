using System.Data;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace Zadatak2
{
	public partial class Form1 : Form
	{
		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;";
		private MySqlConnection mySqlConnection;
		private MySqlDataAdapter mySqlDataAdapter;

		public Form1()
		{
			InitializeComponent();
			mySqlConnection = new MySqlConnection(mySqlConnectionString);
			ucitaj();
		}

		void ucitaj()
		{
			mySqlConnection.Open();


			mySqlDataAdapter = new MySqlDataAdapter();
			string query = "SELECT * FROM cs322.proizvod";

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
			Form2 f = new Form2();
			f.Show();
		}

		private void button2_Click(object sender, EventArgs e)
		{
		}

		private void button2_Click_1(object sender, EventArgs e)
		{
			if (dataGridView1.SelectedRows.Count == 1)
			{
				DataGridViewSelectedCellCollection DSCL = dataGridView1.SelectedCells;
				Form2 f = new Form2();
				f.Show();
			}
			else
			{
				MessageBox.Show("Morate da izaberete jedan proizvod !");
			}
		}
	}
}