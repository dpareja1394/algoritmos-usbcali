package main

import (
	"crypto"
	"crypto/rand"
	"crypto/rsa"
	"fmt"
)

func main() {
	// Generar el par de claves RSA
	privateKey, err := rsa.GenerateKey(rand.Reader, 2048)
	if err != nil {
		fmt.Println(err)
		return
	}

	// Mensaje a encriptar
	message := []byte("Hola mundo")

	// Encriptar mensaje
	ciphertext, err := rsa.EncryptPKCS1v15(rand.Reader, &privateKey.PublicKey, message)
	if err != nil {
		fmt.Println(err)
		return
	}

	// Descifrar mensaje
	plaintext, err := privateKey.Decrypt(
		nil,
		ciphertext,
		&rsa.OAEPOptions{Hash: crypto.SHA256},
	)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(string(plaintext))

	//fmt.Println(ciphertext)

}
