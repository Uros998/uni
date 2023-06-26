using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class EventListScreen : Form
    {
        public int userId = 0;
        private static String connectionString = "datasource=localhost;database=cs322-pz;port=3306;username=root;password=;";
        private static MySqlConnection con;
        private static MySqlDataAdapter adapter;

        public EventListScreen()
        {
            InitializeComponent();
            con = new MySqlConnection(connectionString);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            LoginScreen form2 = new LoginScreen();
            this.Hide();
            form2.ShowDialog();
            this.Close();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                adapter = new MySqlDataAdapter();
                string query = "SELECT event.name, ROUND(AVG(grade), 1) AS \"average grade\" FROM rating JOIN event ON rating.id_event = event.id_event GROUP BY event.name;";
                adapter.SelectCommand = new MySqlCommand(query, con);

                DataTable table = new DataTable();
                adapter.Fill(table);

                BindingSource bSource = new BindingSource();
                bSource.DataSource = table;

                dataGridView1.DataSource = bSource;
                dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
                dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                con.Close();
            }
            catch (Exception ex)
            {
                con.Close();
                MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            RatingScreen form4 = new RatingScreen();
            form4.userId = this.userId;
            this.Hide();
            form4.ShowDialog();
            this.Close();
        }
    }
}
