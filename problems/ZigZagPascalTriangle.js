/**
 * Prints the given string in a pascal triange in a zig-zag order.
 * @param {int} h - Height of the triangle
 * @param {string} d - The direction of triangle : u - up , d - down
 * 
 * Example Output:
 * 
h=5, d='u':

    a
   ihb
  sheka
 kehsihb
abhisheka

h=5, d='d':

abhisheka
 kehsihb
  abhis
   keh
    a
 */

function printTriangle(h, d) {
    const str = 'abhishek';
    let maxWidth = (h-1)*2 + 1,q = Math.ceil(((maxWidth+1)*h/2)/str.length),finalstr = str.repeat(q), startidx = 0;
    Array(h).fill('').map((v,idx) => {
        let i = d=='u'?idx+1:h-idx;
        let chars = (i-1)*2+1;
        let towrite = finalstr.slice(startidx,startidx+=chars);
        towrite = i%2 === 0 ? towrite.split('').reverse().join('') : towrite;
        process.stdout.write(`${towrite.padStart((chars+maxWidth)/2,' ')}\n`);
    });
}

printTriangle(5, 'u');
process.stdout.write('\n');
printTriangle(5, 'd');