namespace Zadatak3
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

		private void button1_Click(object sender, EventArgs e)
		{
			Knjiga knjiga = new Knjiga();
			KnjigaUtility knjigaUtility = new KnjigaUtility();

			knjiga.nazivKnjige = knjigaUtility.vratiRec(20);
			knjiga.cenaKnjige = knjigaUtility.vratiCenu();
			knjiga.opisKnjige = knjigaUtility.vratiRecenicu(20, 5);
			knjiga.kategorijaKnjige = knjigaUtility.vratiKategoriju();

			textBox1.Text = Knjiga.idKnjige + "";
			textBox2.Text = knjiga.opisKnjige;
			textBox3.Text = knjiga.nazivKnjige;
			textBox4.Text = knjiga.kategorijaKnjige;
			textBox5.Text = knjiga.cenaKnjige + "";
		}
	}
}


