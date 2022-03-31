package org.example.JavaEnterpriseIntensive.firstLesson.main;

/**
 * this little class can say count of numbers in one Line/String
 */
public class IsDigit {



    public int getCountNumbers(String string){
        int digitCounts = 0;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                digitCounts++;
            }
        }

        return digitCounts;
    }

}
