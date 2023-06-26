using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class RegistrationScreen : Form
    {
        private static String connectionString = "datasource=localhost;database=cs322-pz;port=3306;username=root;password=;";
        private static MySqlConnection con;
        private static MySqlCommand command;
        private static MySqlDataAdapter adapter;

        public RegistrationScreen()
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
            if (textBox1.Text == "" || textBox2.Text == "" || textBox3.Text == "")
            {
                MessageBox.Show("Please fill all the fields");
            }
            else
            {
                try
                {
                    con.Open();
                    adapter = new MySqlDataAdapter();
                    string query = "SELECT * FROM user WHERE username LIKE '" + textBox2.Text + "'"; ;
                    adapter.SelectCommand = new MySqlCommand(query, con);

                    DataTable dt = new DataTable();
                    adapter.Fill(dt);

                    if (dt.Rows.Count > 0)
                    {
                        MessageBox.Show("Username already exists in the database!", "", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    else
                    {
                        query = "insert into user(username, password, full_name, role) values('"
                            + textBox2.Text + "', '"
                            + textBox3.Text + "', '"
                            + textBox1.Text + "', '"
                            + "user'" + ");";
                        command = new MySqlCommand(query, con);
                        command.ExecuteNonQuery();
                        LoginScreen form2 = new LoginScreen();
                        this.Hide();
                        form2.ShowDialog();
                        this.Close();
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
