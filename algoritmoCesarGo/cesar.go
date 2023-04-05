package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func encrypt(text string, shift int) string {
	var cipher strings.Builder

	for _, char := range text {
		if char >= 'a' && char <= 'z' {
			char = 'a' + ((char-'a'+rune(shift))%26+26)%26
		} else if char >= 'A' && char <= 'Z' {
			char = 'A' + ((char-'A'+rune(shift))%26+26)%26
		}
		cipher.WriteRune(char)
	}

	return cipher.String()
}

func decrypt(cipherText string, shift int) string {
	return encrypt(cipherText, -shift)
}

func leerCadena() string {
	var input string
	fmt.Println("Ingresa una cadena de texto:")
	fmt.Scanln(&input)
	return input
}

func leerNumero() int {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Introduce un número entre 1 y 25: ")
	for scanner.Scan() {
		input := scanner.Text()
		numero, err := strconv.Atoi(input)
		if err != nil || numero < 1 || numero > 25 {
			fmt.Print("Número inválido. Introduce un número entre 1 y 25: ")
		} else {
			return numero
		}
	}
	return 0
}

func leerDireccion() string {
	var direccion string
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Introduce una dirección izquierda o derecha: ")
	for scanner.Scan() {
		input := scanner.Text()
		direccion = strings.ToLower(strings.TrimSpace(input))
		if direccion != "izquierda" && direccion != "derecha" {
			fmt.Print("Dirección incorrecta. Introduce una dirección (izquierda o derecha): ")
		} else {
			break
		}
	}
	return direccion
}

func main() {

	str := leerCadena()

	shift := leerNumero()

	direccion := leerDireccion()

	if direccion == "izquierda" {
		shift = shift * -1 // Shift 3 positions to the left
	}

	cipherText := encrypt(str, shift)
	fmt.Println("Cipher text: ", cipherText)

	plainText := decrypt(cipherText, shift)
	fmt.Println("Plain text: ", plainText)
}
