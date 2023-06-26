using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Zadatak4
{
	public partial class _Default : Page
	{
		protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void Button1_Click(object sender, EventArgs e)
        {
			if (TextBox1.Text.Length == 0)
			{
				Label2.Text = "Polje je prazno";
			}
			else
			{
				Label2.Text = "";

				String[] samoglasnici = { "a", "e", "i", "o", "u" };

				String rec = TextBox1.Text.ToLower();

				int a = 0;
				int ee = 0;
				int i = 0;
				int o = 0;
				int u = 0;

				foreach (char c in rec)
				{
					if (samoglasnici.Contains(c + ""))
					{
						if( c == 'a')
						{
							a++;
						}
						else if (c == 'e')
						{
							ee++;
						}
						else if (c == 'i')
						{
							i++;
						}
						else if (c == 'o')
						{
							o++;
						}
						else if (c == 'u')
						{
							u++;
						}
					}
				}

				Label2.Text = "a:" + a + " e:" + ee + " i:" + i + " o:" + o + " u:" + u;
			}
        }
    }
}