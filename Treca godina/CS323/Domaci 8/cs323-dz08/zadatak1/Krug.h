#ifndef CS323_DZ08_KRUG_H
#define CS323_DZ08_KRUG_H

class Krug {

private:
    double radius;
public:
    Krug();
    Krug(double radius);
    Krug(Krug& k);

    void setRadius(double radius);
    double getRadius();

    double racunajPovrsinu();
    double racunajObim();

    ~Krug();
};


#endif
