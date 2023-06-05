class Osoba():
    pass

class Student(Osoba):
    def __init__(self, ime, prezime, broj_indeksa, smer):
        self.ime=ime
        self.prezime=prezime
        self.broj_indeksa=broj_indeksa
        self.smer=smer
        self.polozeni_ispiti={}
    
    def dodaj_polozen_ispit(self):
        sifra = input("Unesite sifru predmeta: ")
        ocena = input("Unesite ocenu: ")
        if ocena > 5 and ocena <= 10:
            self.polozeni_ispiti[sifra] = ocena
        else:
            print("Pogresan unos")
    
def studenti_smer(student_1, student_2):
    if student_1.smer == student_2.smer:
        print("Studenti su na istom smeru.")
    else:
        print("Studenti nisu na istom smeru.")

student1 = Student('Pera', 'Peric', 4586, 'FIT')
student2 = Student("Mile", "Micic", 3645, "IT")

student1.dodaj_polozen_ispit()
print(student1.polozeni_ispiti)

student2.dodaj_polozen_ispit()
print(student2.polozeni_ispiti)


studenti_smer(student1, student2)



        
