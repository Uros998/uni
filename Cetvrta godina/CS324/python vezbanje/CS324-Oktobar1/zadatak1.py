suma=0

while True:
    broj = input("Unesite broj sa tastature: ")
    if broj == '':
        break
    else:
        try:
            suma += float(broj)
            print('Trenutna suma je ', suma)
        except ValueError:
            print('Nevalidan unos!')