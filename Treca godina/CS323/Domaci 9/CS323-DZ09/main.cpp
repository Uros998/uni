#include <iostream>
#include "CVector.h"

using namespace std;

int main() {
    CVector c1(1, 2, 3), c2(4, 5, 6);
    CVector c3 = c1 + c2;
    cout << c3.getX() << " " << c3.getY() << " " << c3.getZ() << " " << endl;

    CVector c4 = c1 - c2;

    cout << c4.getX() << " " << c4.getY() << " " << c4.getZ() << " " << endl;

    return 0;
}
