def Collatz(a: Integer): Integer = {
    if (a % 2 == 0) {
    return (a / 2)
    } else {
    return ((a * 3) + 1)
    }
}