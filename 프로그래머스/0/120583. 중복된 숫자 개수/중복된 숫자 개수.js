function solution(array, n) {
    var answer = 0;
    for(i = 0; i < array.length; i++) {
        n === array[i] ? answer++ : null
    }
    return answer;
}