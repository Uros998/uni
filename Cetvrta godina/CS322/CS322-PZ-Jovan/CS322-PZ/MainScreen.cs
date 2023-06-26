using System;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class MainScreen : Form
    {
        public MainScreen()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            LoginScreen form2 = new LoginScreen();
            this.Hide();
            form2.ShowDialog();
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            RegistrationScreen form3 = new RegistrationScreen();
            this.Hide();
            form3.ShowDialog();
            this.Close();
        }
    }
}
