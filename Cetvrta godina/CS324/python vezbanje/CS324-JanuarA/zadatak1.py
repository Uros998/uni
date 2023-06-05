def list_prime_nums(a):
    prime_list = []
    prime_count = 0

    for i in range(1, a + 1):
        if not prime_nums(i):
            prime_list.append(i)
            prime_count += 1
    return prime_list, prime_count



def prime_nums(a):
    flag = False

    if a == 1:
       return False
    elif a > 1:
        for i in range(2, a):
            if (a % i) == 0:
                flag = True
                break

    return flag


def var_nums(lst, count):
    mean = sum(lst) / count
    variance = sum((x - mean)**2 for x in lst) / count
    print(variance)

lst_100, count_100 = list_prime_nums(10)
var_nums(lst_100, count_100)
