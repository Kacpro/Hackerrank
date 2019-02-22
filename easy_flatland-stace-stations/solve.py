#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the flatlandSpaceStations function below.
def flatlandSpaceStations(n, c):
    maxDist = 0
    c.sort()
    for i in range(len(c) - 1):
        buf = c[i+1] - c[i]
        if buf > maxDist:
            maxDist = buf
    result = math.ceil((maxDist - 1) / 2)
    if c[0] > result: result = c[0]
    if n - c[len(c) - 1] - 1 > result: result = n - c[len(c) - 1] - 1

    return result 

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    c = list(map(int, input().rstrip().split()))

    result = flatlandSpaceStations(n, c)

    fptr.write(str(result) + '\n')

    fptr.close()

