def deletionDistance(str1, str2):
    return helper(0,0,str1, str2)

def helper(s1, s2, str1, str2):
    if s1 >= len(str1):
        return len(str2) - s2
    if s2 >= len(str2):
        return len(str1) - s1
    if str1[s1] == str2[s2]:
        return helper(s1 + 1, s2 + 1, str1, str2)
    else:
        d1 = helper(s1 + 1, s2, str1, str2)
        d2 = helper(s1, s2 + 1, str1, str2)
        return min(d1, d2) + 1
print(deletionDistance("aaa","aaaab"))

# ANTIHUMAN
# ANSHUMAN
#   - A N T I H U M A N
# - 0 1 2 3 4 5 6 7 8 9
# A 1 0 1 2 3 4 5 6 7 8
# N 2 1 0 1 2 3 4 5 6 7
# S 3 2 1 2 3 4 5 6 7 8
# H 4
# U 5
# M 6
# A 7
# N 8                .

# https://www.dropbox.com/s/5xijf58c9ywic8y/File%2003-05-2017%2C%2009%2033%2059.jpeg?dl=0

# base casaes
# if any of the string is empty return the length of the other one
# counter
#2 pointers that are the indices would the start of both strings
# 2 cases
# 1. if characters at the pointers are same increment the pointers
# 2. if characters at the pointers are not same
#			increment the counter and increment one of the pointer
#     increment one of the pointer :
#			rule increment str1 first if str1 is reached the end:
# iteration will go till one of the pointers goes out of bound
# wrraping up the counter
# Time O(m+n)
