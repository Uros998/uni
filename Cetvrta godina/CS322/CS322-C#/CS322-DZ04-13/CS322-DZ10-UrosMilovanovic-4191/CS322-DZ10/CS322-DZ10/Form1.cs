using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_DZ10
{
	public partial class Form1 : Form
	{
		Random random = new Random();
		ArrayList list = new ArrayList();
		Stack stack = new Stack();
		Queue queue = new Queue();

		public Form1()
		{
			InitializeComponent();
			for(int i = 0; i < 100; i++)
			{
				int rand = random.Next(1, 500);
				list.Add(rand);
				stack.Push(rand);
				queue.Enqueue(rand);
			}

			foreach(int i in list)
			{
				listBox1.Items.Add(i);
			}
		}

		private void button1_Click(object sender, EventArgs e)
		{
			int rand = random.Next(1, 500);
			listBox1.Items.Add(rand);
			list.Add(rand);
		}

		private void button2_Click(object sender, EventArgs e)
		{
			if(listBox1.SelectedIndex != -1)
			{
				list.RemoveAt(listBox1.SelectedIndex - 1);
				listBox1.Items.RemoveAt(listBox1.SelectedIndex);
			} else
			{
				MessageBox.Show("Izaberite elemenat pre nego sto kliknete remove");
			}
		}

		private void button3_Click(object sender, EventArgs e)
		{
			if(listBox1.Items.Count > 0)
			{
				list.RemoveAt(0);
				stack.Pop();
				listBox1.Items.RemoveAt(0);
			} else
			{
				MessageBox.Show("Lista je prazna");
			}
			
		}

		private void button4_Click(object sender, EventArgs e)
		{
			if (listBox1.Items.Count > 0)
			{
				list.RemoveAt(list.Count - 1);
				queue.Dequeue();
				listBox1.Items.RemoveAt(listBox1.Items.Count - 1);
			}
				else
			{
				MessageBox.Show("Lista je prazna");
			}
		}

		private void button5_Click(object sender, EventArgs e)
		{
			int rand = random.Next(1, 500);
			listBox1.Items.Insert(0, rand);
			stack.Push(rand);
			list.Insert(0, rand);
		}
	}

	public class StackImpl
	{
		private ArrayList listaElemenata = new ArrayList();

		public void Push(object element)
		{
			listaElemenata.Insert(0, element);
		}

		public void Pop()
		{
			if (listaElemenata.Count > 0)
			{
				listaElemenata.RemoveAt(0);
			} 
		}

		public object Peek()
		{
			if (listaElemenata.Count > 0) {
				return listaElemenata[0]; 
			} else {
				return null;
			}
		}
	}

	public class QueueImpl
	{
		private ArrayList listaElemenata = new ArrayList();

		public void Enqueue(object element)
		{
			listaElemenata.Insert(0, element);
		}

		public void Dequeue()
		{
			if (listaElemenata.Count > 0)
			{
				listaElemenata.RemoveAt(listaElemenata.Count - 1);
			}
		}

		public object Peek()
		{
			if (listaElemenata.Count > 0)
			{
				return listaElemenata[listaElemenata.Count - 1];
			}
			else
			{
				return null;
			}
		}
	}
}
