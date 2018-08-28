/**
Problem Statement:
There were  submissions made in a programming contest containing infinite problems. Each submission earned the contestant  points as none of the submissions is a wrong or a partial submission. You are given the details of the submissions - the username of the contestant and the time taken to solve the problem. Your task is to print the rank list according to the following rules:

The contestant with a higher score gets a higher rank.
If the scores are tied, then the contestant with the least sum of the time taken to solve the problems gets a higher rank.
In case of a tie in both scores and sum of the time taken, they are ranked lexicographically according to their usernames. 
Note: The details of the submissions are not sorted in any order (neither by time nor by username)

9
Tom 6
Jim 7
Tom 19
Phil 8
Rick 12
Jim 22
Rick 18
Phil 22
Tom 36

1 Tom
2 Jim
3 Phil
4 Rick
 */

process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input; 
});

process.stdin.on("end", function () {
   main(stdin_input);
});

function main(input) {
    let inpAr = input.split('\n');
    let tmp = {};
    let cMap = {};
    inpAr.forEach((str, idx) => {
        if(idx !== 0) {
            tmp = str.split(' ');
            if(cMap.hasOwnProperty(tmp[0])) {
                cMap[tmp[0]].count++;
                cMap[tmp[0]].time += parseInt(tmp[1]);
            }
            else {
                cMap[tmp[0]] = {}
                cMap[tmp[0]].count = 1;
                cMap[tmp[0]].time = parseInt(tmp[1]);
            }
        }
    });
    
    let cArr = [];
    
    Object.keys(cMap).forEach(key => {
        let val = cMap[key];
        val.name = key;
        cArr.push(val);
    });
    
    cArr.sort((a, b) => {
        let retVal = 0;
        if(a.count > b.count) {
            retVal = -1;
        }
        else if(a.count < b.count) {
            retVal = 1;
        }
        else {
            if(a.time > b.time) {
                retVal = 1;
            }
            else if(a.time < b.time) {
                retVal = -1;
            }
            else {
                retVal = a.name.localeCompare(b.name);
            }
        }
        return retVal;
    });
    
    cArr.forEach((c, idx) => {
        process.stdout.write(`${idx+1} ${c.name}\n`);
    });
}
