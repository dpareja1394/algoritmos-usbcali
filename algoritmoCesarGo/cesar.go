go
package main

import (
	"fmt"
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
	// Input string and shift
	str := "Hello, World!"
	shift := 3

	// Encrypt the input string
	encryptedStr := caesarCipher(str, shift)

	// Print the encrypted string
	fmt.Println(encryptedStr)
}