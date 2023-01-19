using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Zadatak_3
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

		private void button1_Click(object sender, EventArgs e)
		{
			int broj = (int)Int64.Parse(textBox1.Text);

			if ( broj < 0)
			{
				broj *= -1;
			}

			if( broj > 1000000000)
			{
				MessageBox.Show("Broj je preveliki !");
			}
			else
			{
				string provera = broj.ToString();
				double trenutnaVrednost = -1;
				int brojNepodudaranja = 0;

				foreach (char slovo in provera)
				{
					if(trenutnaVrednost == -1)
					{
						trenutnaVrednost = Char.GetNumericValue(slovo);
					}
					else if (trenutnaVrednost >= Char.GetNumericValue(slovo))
					{
						brojNepodudaranja++;
						break;
					}
					else
					{
						trenutnaVrednost = Char.GetNumericValue(slovo);
					}
				}

				if (brojNepodudaranja == 0)
				{
					MessageBox.Show("Cifre obrazuju strogo rastući niz !");
				}
				else
				{
					MessageBox.Show("Cifre ne obrazuju strogo rastući niz !");
				}
			}
		}
	}
}
