package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Caesar cipher function
func caesarCipher(str string, shift int) string {
	// Transform shift into a value between 0 and 25
	shift = shift % 26

	// Create an array to store the result
	result := make([]byte, len(str))

	// Loop through the input string
	for i := 0; i < len(str); i++ {
		char := str[i]

		// Shift uppercase characters
		if char >= 'A' && char <= 'Z' {
			char = char + byte(shift)
			if char > 'Z' {
				char = char - 26
			}
		}

		// Shift lowercase characters
		if char >= 'a' && char <= 'z' {
			char = char + byte(shift)
			if char > 'z' {
				char = char - 26
			}
		}

		result[i] = char
	}

	// Return the result as a string
	return string(result)
}

func leerCadena() string {
	var input string
	fmt.Println("Ingresa una cadena de texto:")
	fmt.Scanln(&input)
	return input
}

func leerNumero() int {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Introduce un número entre 2 y 26: ")
	for scanner.Scan() {
		input := scanner.Text()
		numero, err := strconv.Atoi(input)
		if err != nil || numero < 2 || numero > 26 {
			fmt.Print("Número inválido. Introduce un número entre 2 y 26: ")
		} else {
			return numero
		}
	}
	return 0
}

func leerIzquierdaODerecha() string {
	var letra string
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Introduce una letra (l o r): ")
	for scanner.Scan() {
		input := scanner.Text()
		letra = strings.ToLower(strings.TrimSpace(input))
		if letra != "l" && letra != "r" {
			fmt.Print("Letra inválida. Introduce una letra (l o r): ")
		} else {
			break
		}
	}
	return letra
}

// Función que pida una letra entre l o r por consola

func main() {
	str := leerCadena()

	shift := leerNumero()

	lr := leerIzquierdaODerecha()
	//Comparar si lr es l o r en un if
	if lr == "l" {
		shift = -shift
	}

	// Encrypt the input string
	encryptedStr := caesarCipher(str, shift)

	// Print the String
	fmt.Println("str: " + str)

	// Print the encrypted string
	fmt.Println("encryptedStr: " + encryptedStr)

	decryptStr := caesarCipher(encryptedStr, -shift)
	fmt.Println("decryptStr " + decryptStr)
}
