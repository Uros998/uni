using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_DZ04
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

		private void label1_Click(object sender, EventArgs e)
		{

		}

		private void button1_Click(object sender, EventArgs e)
		{
			int brojDo = (int)Int64.Parse(textBox1.Text);

			if( brojDo < 2)
			{
				MessageBox.Show("Uneti broj mora biti veći od 1 !");
			}
			else
			{
				MessageBox.Show("Suma je : " + sumaNeparnihBrojeva(brojDo));
			}

		}

		public static int sumaNeparnihBrojeva(int brojDo)
		{
			if (brojDo == 1)
			{
				return brojDo;
			}

			if (brojDo % 2 == 0)
			{
				return sumaNeparnihBrojeva(brojDo - 1);
			}
			else
			{
				return sumaNeparnihBrojeva(brojDo - 1) + brojDo;
			}
		}
	}
}
