function solution(str1, str2) {
    if(str1.length < str2.length) {
        return 2
    }
    
    for(i = 0; i <= str1.length - str2.length; i++) {
        if(str2 === str1.slice(0+i,str2.length+i)) {
            return 1
        }
    }
    return 2;
}