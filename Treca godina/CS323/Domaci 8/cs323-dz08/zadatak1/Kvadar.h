#ifndef CS323_DZ08_KVADAR_H
#define CS323_DZ08_KVADAR_H

class Kvadar {

private:
    double duzina, sirina;
public:
    Kvadar();
    Kvadar(double duzina, double sirina);
    Kvadar(Kvadar& k);


    void setDuzina(double  duzina);
    void setSirina(double sirina);

    double getDuzina();
    double getSirina();

    double racunajPovrsinu();
    double racunajObim();

    ~Kvadar();
};


#endif
