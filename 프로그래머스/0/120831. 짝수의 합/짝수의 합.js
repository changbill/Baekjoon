function solution(n) {
    n % 2 === 1 ? n-- : null
    var sum = 0;
    for(i = n; i > 0; i -= 2) {
        sum += i;
    }
    
    return sum;
}