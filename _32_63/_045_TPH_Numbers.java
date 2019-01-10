package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.HashSet;

/**
 *
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 * Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
 * Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 * It can be verified that T285 = P165 = H143 = 40755.
 *
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
public class _045_TPH_Numbers {
    private HashSet<Long> tNumbers;
    private long largestTNumber;
    private HashSet<Long> pNumbers;
    private long largestPNumber;
    private HashSet<Long> hNumbers;
    private long largestHNumber;
    public _045_TPH_Numbers(){
        largestTNumber = 0;
        largestHNumber = 0;
        largestPNumber = 0;
        tNumbers = new HashSet<>();
        hNumbers = new HashSet<>();
        pNumbers = new HashSet<>();
    }
    enum XNumber {
        tNumber,
        pNumber,
        hNumber;
    }
    public static void main(String[] args) {
        util.Util.print(new _045_TPH_Numbers().run());
    }
    public long run () {
//        Not necessary as all hex numbers are also triangular
//        Util.WrapLong wrapT = new Util.WrapLong(largestTNumber);
        Util.WrapLong wrapH = new Util.WrapLong(largestHNumber);
        Util.WrapLong wrapP = new Util.WrapLong(largestPNumber);
        for(long n = 40756L; true; n++){
            if(wrapH.num > largestHNumber){
                largestHNumber = wrapH.num;
            }
            wrapH.num = largestHNumber;

            if(isXNumber(n,wrapH, XNumber.hNumber, hNumbers)) {
                if (isXNumber(n, wrapP, XNumber.pNumber, pNumbers)) {
                    return wrapP.num;
//                    Not necessary
//                    if (isXNumber(n, wrapT, XNumber.tNumber, tNumbers)) {
//                        return wrapT.num;
//                    }
                }
            }
        }
    }
    public boolean isXNumber(long n, Util.WrapLong largestXNumber, XNumber xn, HashSet<Long> xNumbers){
        if( n < largestXNumber.num){
            return xNumbers.contains(n);
        } else {
            for(long nextN = xNumbers.size()+1; n > largestXNumber.num; nextN ++){
                largestXNumber.num = calculateXNumber(nextN, xn);
                xNumbers.add(largestXNumber.num);
            }
            return (n == largestXNumber.num);
        }
    }
    public long calculateXNumber(long n, XNumber xn){
        switch (xn){
            case tNumber:
                return calculateTriangularNumber(n);
            case pNumber:
                return  calculatePentagonalNumber(n);
            case hNumber:
                return calculateHexagonalNumber(n);
            default:
                return 0;
        }
    }
    //not necessary
    public long calculateTriangularNumber( long n){
        return (n * (n+1) / 2);
    }
    public long calculatePentagonalNumber( long n){
        return (n * (3 * n - 1) /2);
    }
    public long calculateHexagonalNumber( long n){
        return (n * (2 * n - 1));
    }
}
