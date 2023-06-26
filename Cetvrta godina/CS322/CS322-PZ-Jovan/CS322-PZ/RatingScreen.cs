using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class RatingScreen : Form
    {
        public int userId = 0;
        private static String connectionString = "datasource=localhost;database=cs322-pz;port=3306;username=root;password=;";
        private static MySqlConnection con;
        private static MySqlCommand command;
        private static MySqlDataAdapter adapter;

        public RatingScreen()
        {
            InitializeComponent();
            con = new MySqlConnection(connectionString);
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                adapter = new MySqlDataAdapter();
                string query = "SELECT * FROM event;";
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

        private void button1_Click(object sender, EventArgs e)
        {
            LoginScreen form2 = new LoginScreen();
            this.Hide();
            form2.ShowDialog();
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.inputRating(1);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.inputRating(2);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.inputRating(3);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.inputRating(4);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            this.inputRating(5);
        }

        private void inputRating(int ratingGrade)
        {
            int eventId = Int32.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            try
            {
                con.Open();
                adapter = new MySqlDataAdapter();
                string query = "SELECT * FROM rating WHERE id_user = " + userId + " AND id_event = " + eventId + ";";
                adapter.SelectCommand = new MySqlCommand(query, con);

                DataTable dt = new DataTable();
                adapter.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    query = "Update rating SET "
                        + "grade = " + ratingGrade + " "
                        + "WHERE id_rating = " + Int32.Parse(dt.Rows[0]["id_rating"].ToString());
                }
                else
                {
                    query = "insert into rating(id_user, id_event, grade) values("
                        + this.userId + ", "
                        + eventId + ", '"
                        + ratingGrade + "');";
                }

                command = new MySqlCommand(query, con);
                command.ExecuteNonQuery();
                con.Close();
                MessageBox.Show("Thank you for the feedback", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception ex)
            {
                con.Close();
                MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void button7_Click(object sender, EventArgs e)
        {
            EventListScreen form5 = new EventListScreen();
            form5.userId = userId;
            this.Hide();
            form5.ShowDialog();
            this.Close();
        }
    }
}
