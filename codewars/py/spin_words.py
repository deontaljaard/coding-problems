"""
Kata: Stop gninnipS My sdroW!

Details:
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
"""

def spin_words(sentence):
    return ' '.join([word if len(word) < 5 else word[::-1] for word in sentence.split(' ')])

assert spin_words("Stop spinning this around!") == "Stop gninnips this !dnuora"