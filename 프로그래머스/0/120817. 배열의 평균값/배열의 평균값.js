function solution(numbers) {
    var sum = 0;
    for(i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    
    return sum / numbers.length;
}