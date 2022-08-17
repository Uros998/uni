#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<Windows.h>
#include"Sisari.h"
#include"Ptice.h"
#include"Gmizavci.h"
#include"Insekti.h"
#include"Ribe.h"



using namespace std;

int main() {



	try {
		Sisari s;
		Ptice p;
		Gmizavci g;
		Ribe r;
		Insekti i;

		Zivotinja *aa = &s;
		Zivotinja *ba1 = &p;
		Zivotinja *aa2 = &i;
		Zivotinja *aa4 = &g;
		Zivotinja *aa3 = &r;

		string us = "y";

		while (us == "y")
		{

            cout << "------ IZABERITE VRSTU ZIVOTINJA ----- \n\n";

			cout << " 1 za Sisare  \n 2 za Ptice \n 3 za Ribe  \n 4 za Insekte \n 5 za Gmizavce \n";

            cout << " \n _________________________________________ ";
            cout << " \n Izaberi jednu od ponudjenih opcija: ";
			int c;
			cin >> c;
			if (c == 1) {
				cout << "----- Izabrali ste sisare -----" << endl;
				cout << " 1: Unesi  \n 2: Pretrazi \n 3: Prikaz  \n 4: Editovanje \n 5: Brisanje \n 6: Prikazi ceo fajl  \n ";
				int k;
				cin >> k;
				switch (k)
				{

				case 1:
					aa->insert_animal();
					break;
				case 2:
					aa->search_animal();
					break;
				case 3:
					aa->display_all();
					break;
				case 4:
					aa->update_animal();

					break;
				case 5:
					aa->delete_animal();
					break;
				case 6:
					aa->display_all_list();
					break;
				

				default:
					cout << " \n Izaberi jednu od ponudjenih opcija: \n";
				}
				system("pause");
				system("cls");
			}
			else if (c == 2) {
				cout << "----- Izabrali ste vrstu Ptice -----" << endl;
				cout << " 1: Unesi  \n 2: Pretrazi \n 3: Prikaz  \n 4: Editovanje \n 5: Brisanje \n 6: Prikazi ceo fajl \n ";
				int z;
				cin >> z;
				switch (z)
				{
				case 1:
					ba1->insert_animal();
					break;
				case 2:
					ba1->search_animal();
					break;
				case 3:
					ba1->display_all();
					break;
				case 4:
					ba1->update_animal();

					break;
				case 5:
					ba1->delete_animal();
					break;
				case 6:
					ba1->display_all_list();
					break;

				default:
                    cout << " \n Izaberi jednu od ponudjenih opcija: \n";
				}
				system("pause");
				system("cls");
			}
			else if (c == 3) {
				cout << "!!!Ribe!!!" << endl;
                cout << " 1: Unesi  \n 2: Pretrazi \n 3: Prikaz  \n 4: Editovanje \n 5: Brisanje \n 6: Prikazi ceo fajl \n ";
				int b;
				cin >> b;
				switch (b)
				{

				case 1:
					aa3->insert_animal();
					break;
				case 2:
					aa3->search_animal();
					break;
				case 3:
					aa3->display_all();
					break;
				case 4:
					aa3->update_animal();

					break;
				case 5:
					aa3->delete_animal();
					break;
				case 6:
					aa3->display_all_list();
					break;

				default:
                    cout << " \n Izaberi jednu od ponudjenih opcija: \n";
				}
				system("pause");
				system("cls");
			}
			else if (c == 4) {
				cout << "!!!Insekti!!!" << endl;
                cout << " 1: Unesi  \n 2: Pretrazi \n 3: Prikaz  \n 4: Editovanje \n 5: Brisanje \n 6: Prikazi ceo fajl \n ";
				int a;
				cin >> a;
				switch (a)
				{

				case 1:
					aa2->insert_animal();
					break;
				case 2:
					aa2->search_animal();
					break;
				case 3:
					aa2->display_all();
					break;
				case 4:
					aa2->update_animal();

					break;
				case 5:
					aa2->delete_animal();
					break;
				case 6:
					aa2->display_all_list();
					break;

				default:
                    cout << " \n Izaberi jednu od ponudjenih opcija: \n";
				}
				system("pause");
				system("cls");
			}
			else if (c == 5) {
				cout << "!!!Gmizavci!!!" << endl;
                cout << " 1: Unesi  \n 2: Pretrazi \n 3: Prikaz  \n 4: Editovanje \n 5: Brisanje \n 6: Prikazi ceo fajl \n ";
				int r;
				cin >> r;
				switch (r)
				{
				case 1:
					aa4->insert_animal();
					break;
				case 2:
					aa4->search_animal();
					break;
				case 3:
					aa4->display_all();
					break;
				case 4:
					aa4->update_animal();

					break;
				case 5:
					aa4->delete_animal();
					break;
				case 6:
					aa4->display_all_list();
					break;

				default:
                    cout << " \n Izaberi jednu od ponudjenih opcija: \n";
				}
				system("pause");
				system("cls");
			}
			else {

				cout << "Izaberi odgovarajuci broj" << endl;
			}

			cout << "Upisi y za nastavak" << endl;
			cin >> us;
			
		}
		
	}
	catch (IDNijeValidan& e) {
		cout << e.what() << endl;
	}
	catch (ImeNIjeValidno& e) {
		cout << e.what() << endl;
	}
	
	
	return 0;
}

