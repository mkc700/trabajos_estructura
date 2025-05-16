import random

# Tamaño del arreglo
n = 8  # Puedes cambiar este número según lo necesites

# Generar el arreglo con números aleatorios entre 1 y 20
arreglo = [random.randint(1, 20) for _ in range(n)]

print("Arreglo aleatorio:", arreglo)
