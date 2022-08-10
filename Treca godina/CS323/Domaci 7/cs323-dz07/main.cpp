#include <iostream>
using namespace std;

int main() {
    char c;
    cout << "Unesite karakter: ";
    cin.get(c);
    cout << "Uneti karakter: " << c << "  " << "Njegov ASCI kod: " << int(c) << endl;

    int i = 0;
    while (i < 3) {
        cout << "Sledeci karakter: " << char(int(c) + i + 1) << "  " << "Njegov ASCI kod: " << (int(c) + i + 1)<< endl;
        i++;
    }
    return 0;
}
