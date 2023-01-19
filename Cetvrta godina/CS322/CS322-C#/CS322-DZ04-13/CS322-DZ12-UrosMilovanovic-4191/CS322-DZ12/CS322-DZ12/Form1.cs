using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_DZ12
{
	public partial class Form1 : Form
	{
		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";

		private MySqlConnection mySqlConnection;
		private MySqlDataAdapter mySqlDataAdapter;

		public Form1()
		{
			InitializeComponent();
			
			mySqlConnection = new MySqlConnection(mySqlConnectionString);
		}

		private void button1_Click(object sender, EventArgs e)
		{
			string Query = "INSERT INTO `cs322-dz12`.`korisnik` (`username`, `password`) VALUES ('Novi podatak', 'Nova sifra');";
			MySqlCommand mySqlCommand = new MySqlCommand(Query, mySqlConnection);

			try
			{
				mySqlConnection.Open();
				mySqlCommand.ExecuteNonQuery();
				mySqlConnection.Close();
				MessageBox.Show("Novi podatak je uspesno dodat u bazu !");
			}
			catch (Exception ex)
			{
				mySqlConnection.Close();
				MessageBox.Show("Desila se greska !");
			}

			mySqlConnection.Open();
			mySqlDataAdapter = new MySqlDataAdapter();
			string query = "SELECT * FROM `cs322-dz12`.korisnik";
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

		private void button2_Click(object sender, EventArgs e)
		{
			openFileDialog1.ShowDialog();
			openFileDialog1.Title = "Browse Text Files";
			openFileDialog1.DefaultExt = "txt";
			openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

			MessageBox.Show(openFileDialog1.FileName);

			FileStream f = new FileStream("podaci.txt", FileMode.Create);
			StreamWriter s = new StreamWriter(f);

			using (FileStream fs = File.OpenRead(openFileDialog1.FileName))
			{
				byte[] b = new byte[1024];
				UTF8Encoding temp = new UTF8Encoding(true);
				while (fs.Read(b, 0, b.Length) > 0)
				{
					s.WriteLine(temp.GetString(b));
				}
			}

			s.Close();
			f.Close();
		}
	}
}
