import datetime


class Osoba:
    pass


class Student(Osoba):
    def __init__(self, ime, prezime, broj_indeksa, godina_upisa):
        self.ime = ime
        self.prezime = prezime
        self.broj_indeksa = broj_indeksa
        self.godina_upisa = godina_upisa
        self.polozeni_ispiti = []

    def dodaj_polozen_ispit(self):
        sifra = input("Unesi sifru: ")
        predmet = input("Unesi naziv predmeta: ")
        ocena = int(input("Unesi ocenu: "))
        if not (5 < ocena <= 10):
            print("Pogresan unos: ")
            return
        datum = input("Unesite datum polaganja ispita u formatu MM-YYYY: ")

        try:
            datum = datetime.datetime.strptime(datum, "%m-%Y")
        except ValueError:
            print("Pogresan unos.")
        if datum > datetime.datetime.now():
            print("Pogresan unos.")
            return
        if datum.year < self.godina_upisa:
            print("Pogresan unos.")
            return            
        self.polozeni_ispiti.append([sifra, predmet, ocena, datum])

def prvi_ispit(self):
    if not self.polozeni_ispiti:
        return None
    self.polozeni_ispiti_sort(key= lambda x: x[3])
    ispit = self.polozeni_ispiti[0]
    return f"Student: {self.ime} {self.prezime}\nIspit: {ispit[1]}\nOcena: {ispit[2]}\nDatum: {ispit[3]}"

def najbolji_ispit(self):
    if not self.polozeni_ispiti:
        return None
    self.polozeni_ispiti.sort(key=lambda x: x[2], reverse=True)
    ispit = self.polozeni_ispiti[0]
    return f"Student: {self.ime} {self.prezime}\nIspit: {ispit[1]}\nOcena: {ispit[2]}\nDatum: {ispit[3]}"

