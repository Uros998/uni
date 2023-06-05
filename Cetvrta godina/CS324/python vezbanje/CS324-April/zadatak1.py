
# Napisati funkciju prime_nums(a)koja će računati sve proste brojeve 
# u intervalu [2, a], i kao povratne vrednost 
# vraća listu prostih brojeva prime_lst.
# Zatim, napisati funkciju var_nums(lst) 
# koja ručno računa i štampa varijansu za elemente liste lst.
#  Varijansa se računa po sledećoj formuli:
  
# U glavnom programu pozvati funkciju prime_nums(100), 
# dodeliti povratnu vrednost promenljivoj lst_100, štampati ih, 
# i iskoristiti povratne vrednosti ovog poziva za pozivanje 
# funkcije var_nums(lst_100)

def prime_nums(a):
    prime_lst = []
    for num in range (2, a+1):
        is_prime = True
        for i in range (2, num):
            if num % i == 0:
                is_prime = False
                break
        if is_prime:
            prime_lst.append(num)
    return prime_lst

def var_nums(lst):
    x1= sum(lst) / lst(len)
    varijansa = sum([(x - x1)**2 for x in lst]) /len(lst)
    print("Varijansa: ", varijansa)

prime_lst_100 = prime_nums(100)
print("Prosti brojevi: ", prime_lst_100)
var_nums(prime_lst_100)