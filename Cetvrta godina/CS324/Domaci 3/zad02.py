import random

def main():
	n = 4191
	numbers = [random.randint(1, 10000) for _ in range(n)]
	numbers.sort(reverse=True)
	print(numbers)


if __name__ == '__main__':
	main()
