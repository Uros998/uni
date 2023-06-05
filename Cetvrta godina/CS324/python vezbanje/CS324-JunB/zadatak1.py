sum = 0
while True:
    num = input("Unesite broj: ")
    if num == '':
        break
    else:
        try:
            sum += float(num)
            if sum % 2 == 0:
                print('Trenutna suma je: ', int(sum))
            else:
                print('Trenutna suma je: ', sum)
        except ValueError:
            print('Nevalidan unos!')
