def collatz(a: Int): Int = {
    if (a % 2 == 0) {
    return (a / 2)
    } else {
    return ((a * 3) + 1)
    }
}

def collatzCount(a: Int): Int = {
    if (a == 1) {
        return 0
    }
    return 1 + collatzCount(collatz(a))
}