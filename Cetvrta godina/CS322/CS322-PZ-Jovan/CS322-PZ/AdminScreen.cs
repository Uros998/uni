using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class AdminScreen : Form
    {
        private static String connectionString = "datasource=localhost;database=cs322-pz;port=3306;username=root;password=;";
        private static MySqlConnection con;
        private static MySqlCommand command;
        private static MySqlDataAdapter adapter;

        public AdminScreen()
        {
            InitializeComponent();
            con = new MySqlConnection(connectionString);
        }

        private void Form6_Load(object sender, EventArgs e)
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

        private void button7_Click(object sender, EventArgs e)
        {
            LoginScreen form2 = new LoginScreen();
            this.Hide();
            form2.ShowDialog();
            this.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            textBox1.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
            comboBox1.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
            comboBox2.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();
            monthCalendar1.SetDate(Convert.ToDateTime(dataGridView1.SelectedRows[0].Cells[3].Value.ToString().Split(' ')[0]));
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || comboBox1.Text == "" || comboBox2.Text == "")
            {
                MessageBox.Show("Please fill all the fields");
            }
            else
            {
                try
                {
                    con.Open();
                    String[] dateStrings = monthCalendar1.SelectionStart.ToString().Split(' ')[0].Split('/');
                    String date = dateStrings[2] + "-" + dateStrings[0] + "-" + dateStrings[1];
                    String query = "insert into event(name, type, event_date, event_status) values('"
                        + textBox1.Text + "', '"
                        + comboBox1.Text + "', '"
                        + date + "', '"
                        + comboBox2.Text + "');";
                    command = new MySqlCommand(query, con);
                    command.ExecuteNonQuery();
                    con.Close();
                    this.Form6_Load(sender, e);
                }
                catch (Exception ex)
                {
                    con.Close();
                    MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int eventId = Int32.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            try
            {
                con.Open();
                String query = "DELETE FROM event WHERE id_event = " + eventId;
                command = new MySqlCommand(query, con);
                command.ExecuteNonQuery();
                con.Close();
                this.Form6_Load(sender, e);
            }
            catch (Exception ex)
            {
                con.Close();
                MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || comboBox1.Text == "" || comboBox2.Text == "")
            {
                MessageBox.Show("Please fill all the fields");
            }
            else
            {
                try
                {
                    con.Open();
                    String[] dateStrings = monthCalendar1.SelectionStart.ToString().Split(' ')[0].Split('/');
                    String date = dateStrings[2] + "-" + dateStrings[0] + "-" + dateStrings[1];
                    String query = "Update event SET "
                        + "name = '" + textBox1.Text + "', "
                        + "type = '" + comboBox1.Text + "', "
                        + "event_date = '" + date + "', "
                        + "event_status = '" + comboBox2.Text + "' "
                        + "WHERE id_event = " + Int32.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                    command = new MySqlCommand(query, con);
                    command.ExecuteNonQuery();
                    con.Close();
                    this.Form6_Load(sender, e);
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
