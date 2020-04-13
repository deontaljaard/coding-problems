"""
Kata: Format a string of names like 'Bart, Lisa & Maggie'.

Details: 
Given: an array containing hashes of names

Return: a string formatted as a list of names separated by commas except for the last two names, which should be separated by an ampersand.
"""

def mk_name_str(names):
    last = names.pop() if names else {'name': ''}
    name_str = ', '.join([obj.get('name') for obj in names])
    return f"{name_str} & {last['name']}" if name_str else last['name']
    

assert mk_name_str([{'name': 'Bart'},{'name': 'Lisa'},{'name': 'Maggie'},{'name': 'Homer'},{'name': 'Marge'}]) == 'Bart, Lisa, Maggie, Homer & Marge'
assert mk_name_str([{'name': 'Bart'},{'name': 'Lisa'}]) == 'Bart & Lisa'
assert mk_name_str([{'name': 'Bart'}]) == 'Bart'