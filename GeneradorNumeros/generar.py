import random

n = int(input("Ingrese la cantidad de números aleatorios que desea generar: "))
count = 0  # inicializar contador
for i in range(n):
    num = random.randint(0, 1000)
    print(num, end=', ')
    count += 1
    if count % 30 == 0:  # añadir salto de línea cada 30 números
        print()
