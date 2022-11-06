namespace CS322_DZ03_IlijaMilosevic4282
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

        private void button1_Click(object sender, EventArgs e)
        {
            BackColor = Color.Yellow;
            button1.BackColor = Color.Yellow;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            BackColor = Color.Blue;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            BackColor = Color.Red;

        }

        private void button4_Click(object sender, EventArgs e)
        {
            label1.Text = textBox1.Text;
        }

		private void button3_Click_1(object sender, EventArgs e)
		{
            BackColor = Color.Red;
        }
	}
}