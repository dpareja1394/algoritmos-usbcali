package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
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

func main() {
	fmt.Println("Ingrese un texto: ")
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	str := scanner.Text()

	fmt.Println("Ingrese un la cantidad de posiciones: ")
	scanner.Scan()
	inputStr := scanner.Text()

	shift, err := strconv.Atoi(inputStr)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	fmt.Println("¿Izquierda o derecha?: ")
	scanner.Scan()
	lr := scanner.Text()

	//Comparar si lr es l o r en un if
	if lr == "i" {
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
