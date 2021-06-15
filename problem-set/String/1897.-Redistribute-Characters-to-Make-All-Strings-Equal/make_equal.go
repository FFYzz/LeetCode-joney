package main

func main() {

}

func makeEqual(words []string) bool {
	var numberOfWord = len(words)
	if numberOfWord <= 1 {
		return true
	}
	var letter [26]int
	for i := 0; i < numberOfWord; i++ {
		word := words[i]
		for j := 0; j < len(word); j++ {
			letter[word[j]-'a']++
		}
	}
	for i := 0; i < 26; i++ {
		if letter[i]%numberOfWord != 0 {
			return false
		}
	}
	return true
}
