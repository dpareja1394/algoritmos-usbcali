from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

def generar_claves(tamano_clave=2048):
    clave_privada = RSA.generate(tamano_clave)
    clave_publica = clave_privada.publickey()
    return clave_privada, clave_publica

def cifrar(texto, clave_publica):
    cifrador = PKCS1_OAEP.new(clave_publica)
    texto_cifrado = cifrador.encrypt(texto.encode())
    return texto_cifrado

def descifrar(texto_cifrado, clave_privada):
    descifrador = PKCS1_OAEP.new(clave_privada)
    texto_descifrado = descifrador.decrypt(texto_cifrado).decode()
    return texto_descifrado

texto = "Hola mundo"
clave_privada, clave_publica = generar_claves()

texto_cifrado = cifrar(texto, clave_publica)
texto_descifrado = descifrar(texto_cifrado, clave_privada)

print(texto_cifrado)    # b'\xab\xd2...\xcf'
print(texto_descifrado) # "Hola mundo"
