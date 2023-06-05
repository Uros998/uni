class Osoba():
    pass

class Student(Osoba):
    def __init__(self, ime, prezime, broj_indeksa, smer):
        self.ime = ime
        self.prezime = prezime
        self.broj_indeksa = broj_indeksa
        self.smer = smer
        self.polozeni_ispiti = {}
    
    def dodaj_polozen_ispit(self):
        sifra = input('Unesite sifru predmeta: ')
        ocena = int(input('Unesite ocenu: '))
        if ocena > 5 and ocena <= 10:
            True
        else:
            print('Pogresan unos!')
            return
        self.polozeni_ispiti[sifra] = ocena

    def izracunaj_prosek(self):
        suma = 0
        broj_polozenih_ispita = len(self.polozeni_ispiti)
        for ocena in self.polozeni_ispiti.values():
            suma += ocena
        prosek = suma / broj_polozenih_ispita
        print("Student:", self.ime, self.prezime)
        print("Polozenih ispita:", broj_polozenih_ispita)
        print("Prosek:", prosek)

def studenti_smer(student_1, student_2):
    if student_1.smer == student_2.smer:
        print("Studenti su na istom smeru.")
    else:
        print("Studenti nisu na istom smeru.")

ime = input("Unesite ime studenta: ")
prezime = input("Unesite prezime studenta: ")
broj_indeksa = input("Unesite broj indeksa studenta: ")
smer = input("Unesite smer na kojem student studira: ")

student1 = Student(ime, prezime, broj_indeksa, smer)
student2 = Student(ime, prezime, broj_indeksa, smer)
student3 = Student(ime, prezime, broj_indeksa, smer)

student1.dodaj_polozen_ispit()
student2.dodaj_polozen_ispit()
student3.dodaj_polozen_ispit()

studenti_smer(student1, student2)
studenti_smer(student1, student3)

student1.izracunaj_prosek()
student2.izracunaj_prosek()
student3.izracunaj_prosek()


        