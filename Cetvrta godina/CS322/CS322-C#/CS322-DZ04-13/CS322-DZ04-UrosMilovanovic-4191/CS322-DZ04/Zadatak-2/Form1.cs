using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Zadatak_2
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

		private void button1_Click(object sender, EventArgs e)
		{
			int suma = 0;

			for (int i = 8; i < 17; i++)
			{
				suma += i;
			}
			char[] stringSume = (suma.ToString()).ToCharArray();
			Array.Reverse(stringSume);
			MessageBox.Show(new string(stringSume));
		}
	}
}
