"""
This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all
strings in the set that have s as a prefix.

For example, given the query string `de` and the set of strings [`dog`, `deer`, `deal`], return [`deer`, `deal`].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
"""


class Trie:

    def __init__(self):
        self.child = [None] * 26
        self.word = None

    def append(self, word):
        def add(curr_idx, trie):
            if curr_idx == len(word):
                trie.word = word
            else:
                char = ord(word[curr_idx]) - 97
                if not trie.child[char]:
                    trie.child[char] = Trie()
                add(curr_idx + 1, trie.child[char])

        add(0, self)

    def find_by_prefix(self, word):
        prefix_node = self.find_prefix_node(word, self)
        if prefix_node:
            return self.collect_words_at(prefix_node)

    def find_prefix_node(self, word, current_trie):
        if not word:
            return current_trie
        else:
            char = ord(word[0]) - 97
            return None if not current_trie or not current_trie.child[char] else \
                self.find_prefix_node(word[1:], current_trie.child[char])

    def collect_words_at(self, trie):
        def collect(current_trie, acc):
            if current_trie and current_trie.word:
                acc.append(current_trie.word)
            else:
                if current_trie and current_trie.child:
                    for i, trie_enum in enumerate(current_trie.child):
                        if current_trie.child[i]:
                            collect(current_trie.child[i], acc)
                return acc

        return collect(trie, [])


t = Trie()
words = ['dog', 'deer', 'deal']
[t.append(word) for word in words]

assert t.find_by_prefix('de') == ['deal', 'deer']
