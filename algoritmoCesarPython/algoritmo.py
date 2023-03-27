def cifrar(texto, desplazamiento):
    resultado = ""

    for letra in texto:
        if letra.isupper():
            resultado += chr((ord(letra) + desplazamiento - 65) % 26 + 65)
        elif letra.islower():
            resultado += chr((ord(letra) + desplazamiento - 97) % 26 + 97)
        else:
            resultado += letra

    return resultado


def descifrar(texto, desplazamiento):
    return cifrar(texto, -desplazamiento)

texto = "Hola mundo"
desplazamiento = 3

texto_cifrado = cifrar(texto, desplazamiento)
texto_descifrado = descifrar(texto_cifrado, desplazamiento)

print(texto_cifrado)    # "Krod pxqgr"
print(texto_descifrado) # "Hola mundo"
