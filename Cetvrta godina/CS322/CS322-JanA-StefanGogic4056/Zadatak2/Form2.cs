using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Zadatak2
{
	public partial class Form2 : Form
	{
		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;";
		private MySqlConnection mySqlConnection;

		public Form2()
		{
			InitializeComponent();
			mySqlConnection = new MySqlConnection(mySqlConnectionString);
		}

		private void button1_Click(object sender, EventArgs e)
		{

		}
	}
}