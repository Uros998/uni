namespace CS322_DZ01
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string str1 = textBox1.Text;
            string str2 = textBox3.Text;

            MessageBox.Show("Ime: " + str1 + "  Adresa: " + str2);
            
        }
    }
}