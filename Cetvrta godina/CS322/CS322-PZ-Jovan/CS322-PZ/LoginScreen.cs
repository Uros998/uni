using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class LoginScreen : Form
    {

        private static String connectionString = "datasource=localhost;database=cs322-pz;port=3306;username=root;password=;";
        private static MySqlConnection con;
        private static MySqlDataAdapter adapter;

        public LoginScreen()
        {
            InitializeComponent();
            con = new MySqlConnection(connectionString);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MainScreen form1 = new MainScreen();
            this.Hide();
            form1.ShowDialog();
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || textBox2.Text == "")
            {
                MessageBox.Show("Please fill all the fields");
            }
            else
            {
                try
                {
                    con.Open();
                    adapter = new MySqlDataAdapter();
                    string query = "SELECT * FROM user WHERE username LIKE '" + textBox1.Text + "' AND password LIKE '" + textBox2.Text + "'"; ;
                    adapter.SelectCommand = new MySqlCommand(query, con);

                    DataTable dt = new DataTable();
                    adapter.Fill(dt);

                    if (dt.Rows.Count == 1)
                    {
                        if (dt.Rows[0]["role"].ToString() == "user")
                        {
                            EventListScreen form5 = new EventListScreen();
                            form5.userId = Int32.Parse(dt.Rows[0]["id_user"].ToString());
                            this.Hide();
                            form5.ShowDialog();
                            this.Close();
                        }
                        else
                        {
                            AdminScreen form6 = new AdminScreen();
                            this.Hide();
                            form6.ShowDialog();
                            this.Close();
                        }
                        
                    }
                    else
                    {
                        MessageBox.Show("Incorrect username or password!", "", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    con.Close();
                }
                catch (Exception ex)
                {
                    con.Close();
                    MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }
    }
}
