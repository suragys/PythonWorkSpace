from heapq import heappush, heappop

'''
Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
Analyze the time and space complexities of your solution.
Example:
input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
'''


def sortKMessedArray(arr, k):
    n = len(arr)
    window = k + 1
    if n < k:
        return
    h = []
    for j in range(window):
        heappush(h, arr[j])
    for i in range(len(arr) - window):
        arr[i] = heappop(h)
        heappush(h, arr[i + window])
    while len(h) > 0:
        i += 1
        arr[i] = heappop(h)

    return arr


arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
k = 2
print(sortKMessedArray(arr, k))
