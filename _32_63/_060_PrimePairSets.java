package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * The primes 3, 7, 109, and 673, are quite remarkable.
 * By taking any two primes and concatenating them in any order the result will always be prime.
 * For example, taking 7 and 109, both 7109 and 1097 are prime.
 * The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
 *
 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 */
public class _060_PrimePairSets {
    HashSet<Long> primesCache = new HashSet<>();
    List<Long> primes = new ArrayList<>();
    long primeCeiling = 2;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Util.println("Result = " + new _060_PrimePairSets().run2());
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public long run() {
//        Lazy generation of primes
//        populatePrimesCache(primesCache, 10000);
//        populatePrimesWithCache();
//        return getSumOfSetOfNPrimePairSets(5,0, 674, primes);
        return run2();//takes 12.5s with pre-generated primes under 100,000,000
    }
    public long run2(){
        populatePrimesFromFile();
        return getSumOfSetOfNPrimePairSets(5,0, 674, primes);
    }
    private long getSumOfSetOfNPrimePairSets(int n, long nSum, int beginning, List <Long> primes){
        int count = 0;
//        int end;
        for(int i = beginning; i < primes.size(); i++){
            ArrayList <Long> thisPrimeResults = new ArrayList<>();
            long iValue = primes.get(i);
            for(int j = i-1; j >=0; j--){
                long jValue = primes.get(j);
                if(areConcatsPrime(String.valueOf(iValue),String.valueOf(jValue))) {
                    count++;
                    thisPrimeResults.add(jValue);
                }
                if(count>=n-1){
                    if(count == 1)
                        return nSum + iValue + jValue;
                    long result = getSumOfSetOfNPrimePairSets(n-1, nSum+ iValue, 0, thisPrimeResults);
                    if(result != -1){
                        return result;
                    }
                }
            }
        }
//        Lazy generation of primes
//        end = primes.size();
//        if( n == 5) {
//            populatePrimesCache(primesCache, primes.get(primes.size()-1)*10);
//            populatePrimesWithCache();
//            return getSumOfSetOfNPrimePairSets(n, 0, end, this.primes);
//        }
        return -1;
    }
    private boolean areConcatsPrime(String p1, String p2){
        long p1ConcatP2 = Long.valueOf(p1.concat(p2));
        long p2ConcatP1 = Long.valueOf(p2.concat(p1));
//        if(primeCeiling < p1ConcatP2){//        Lazy generation of primes. Takes 365s to complete
//            populatePrimesCache(primesCache, p1ConcatP2);
//            primeCeiling = p1ConcatP2;
//        }
//        if(primeCeiling < p2ConcatP1){
//            populatePrimesCache(primesCache, p2ConcatP1);
//            primeCeiling = p2ConcatP1;
//        }
        return primesCache.contains(p1ConcatP2) && primesCache.contains(p2ConcatP1);//365
    }
    
//        Lazy generation of primes
    private void populatePrimesCache(Collection <Long> col, long value){
        Util.populateCollWithPrimesAboveXBelowY(col, primeCeiling, value+1 );
    }
    private void populatePrimesWithCache(){
        Long[] array = primesCache.toArray(new Long[0]);
        Arrays.sort(array);
        primes = Arrays.asList(array);
        Collections.sort(primes);
        primeCeiling = primes.get(primes.size()-1);
    }
    private void populatePrimesFromFile(){
        String path = Util.PATH + "\\src\\";
        String fileName = "primes.txt";
        try {
            java.io.FileReader fileReader = new java.io.FileReader(path + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String delim = ",";
            while((line = bufferedReader.readLine()) != null) {
                List<String> list = Arrays.asList(line.split(delim));
                for(String s : list){
                    Long sValue = Long.parseLong(s);
                    primes.add(sValue);
                    primesCache.add(sValue);
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");
        }
    }
}
