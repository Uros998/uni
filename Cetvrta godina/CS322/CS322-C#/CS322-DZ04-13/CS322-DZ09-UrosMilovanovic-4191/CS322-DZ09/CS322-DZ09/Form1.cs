using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_DZ09
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

		private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
		{

		}

		private void button1_Click(object sender, EventArgs e)
		{
			int suma = 0;

			for(int i = 1; i < 3001; i++)
			{
				suma += i;
			};

			MessageBox.Show(suma + "");
		}

		private void button2_Click(object sender, EventArgs e)
		{
			int suma = 0;
			int count = 0;
			int i = 0;

			while(count < 101)
			{
				i += 1;
				int a = (i % 2 == 0) ? suma += i : 0;
				_ = (a == 0) ? count += 1 : 0;
			};

			MessageBox.Show(suma + "");
		}

		private void button3_Click(object sender, EventArgs e)
		{
			int suma = 0;

			for (int i = 21; i < 100; i++)
			{
				_ = (i % 2 == 0) ? suma += i : 0;
			};

			MessageBox.Show(suma + "");
		}

		private void button4_Click(object sender, EventArgs e)
		{
			int n = 5;
			int[] niz = new int[n];
			int suma = 0;

			for(int i = 0; i < n; i++)
			{
				niz[i] = i;
				listBox1.Items.Add(i);
			}
			
			foreach (int element in niz)
			{
				suma += element;
			}

			MessageBox.Show((suma / n) + "");
		}

		private void button5_Click(object sender, EventArgs e)
		{
			int n = 5;
			int[] niz = new int[n];

			for (int i = 0; i < n; i++)
			{
				niz[i] = i * i + 1;
				listBox2.Items.Add(i * i + 1);
			}
			
			MessageBox.Show("Min element is : " + niz.Min());
			MessageBox.Show("Max element is : " + niz.Max());
		}
	}
}
