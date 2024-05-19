const numberArr = [1, 2, 3, 4, 5];
const numberMapArr = numberArr.map((item) => {
    return (item % 2 === 0) ? 'even' : 'odd'; // 연산한 결과값을 넣어 배열 반환
});
 
console.log(numberMapArr); // ['odd', 'even', 'odd', 'even', 'odd']