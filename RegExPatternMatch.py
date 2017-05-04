def isMatch(text, pattern):
    if len(text) == 0:
        if len(pattern) == 0:
            return True
        else:
            return False
    p_text = 0
    p_pat = 0
    while p_text < len(text) and p_pat < len(pattern):
        letter = text[p_text]
        p_letter = pattern[p_pat]
        if p_pat + 1 < len(pattern) and pattern[p_pat + 1] is not "*":
            if p_letter is "." or letter is p_letter:
                p_text += 1
                p_pat += 1
            else:
                return False
        else:
            while p_text < len(text) and p_letter is letter:
                p_text += 1
                if p_text < len(text):
                    letter = text[p_text]
            p_pat += 2
    if p_text is not len(text):
        return False
    return True


text = "aa"
pattern = "aa"
print(isMatch(text, pattern))
