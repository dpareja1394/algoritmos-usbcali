import random

n = int(input("Ingrese la cantidad de números aleatorios que desea generar: "))
for i in range(n):
    num = random.randint(0, 1000)
    print(num, end=', ')