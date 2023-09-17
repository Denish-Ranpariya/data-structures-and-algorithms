package basics;

//set kth bit
//GFG

//n = 10
//k = 2

//10 -> 1010
//for 10 result should be 1110 which is 14
//to transform 1010 into 1110
//have to do or operation with 0100 which is 4
// which is 2^k or (1<<k)
public class Program28 {
    static int setKthBit(int N,int K){
        // code here
        return N | (1 << K);
    }
}
