"""
Kata: Simple Pig Latin

Details:
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
"""

def pig_it(text):
    return " ".join([convert(word) for word in text.split()])

def convert(word):
    punctuations = '''!()-[]{};:'"\,<>./?@#$%^&*_~'''
    if len(word) > 1:
        return word[1:] + word[0] + "ay"
    elif word in punctuations:
        return word
    else:
        return word + "ay"
             
assert pig_it("How are you doing?") == "owHay reaay ouyay oing?day"
assert pig_it("This is not funny") == "hisTay siay otnay unnyfay"