class Osoba:
    pass

class Student(Osoba):
    def __init__(self, ime, prezime, broj_indeksa, smer):
        self.ime = ime
        self.prezime = prezime
        self.broj_indeksa = broj_indeksa
        self.smer = smer
        self.polozeni_ispiti = {}

    def dodaj_polozen_ispit(self):
        sifra = input("Unesite sifru predmeta: ")
        ocena = int(input("Unesite ocenu (6-10): "))
        if ocena < 6 or ocena > 10:
            print("Pogresan unos")
            return
        self.polozeni_ispiti[sifra] = ocena
        
    def izracunaj_prosek(self):
        broj_ispita = len(self.polozeni_ispiti)
        suma_ocena = sum(self.polozeni_ispiti.values())
        prosek = suma_ocena / broj_ispita
        print("Student:", self.ime, self.prezime)
        print("Polozenih ispita:", broj_ispita)
        print("Prosek:", prosek)

def studenti_ispiti(student1, student2):
    broj_ispita1 = len(student1.polozeni_ispiti)
    broj_ispita2 = len(student2.polozeni_ispiti)
    if broj_ispita1 > broj_ispita2:
        print(student1.ime, student1.prezime, "ima vise polozenih ispita.")
    else:
        print(student2.ime, student2.prezime, "ima vise polozenih ispita.")

# primer kreiranja objekata
student1 = Student("Pera", "Peric", "123", "Informacioni sistemi")
student2 = Student("Mika", "Mikic", "456", "Menadzment")

studenti_ispiti(student1, student2)
