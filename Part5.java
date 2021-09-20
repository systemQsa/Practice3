public class Part5 {

    public static String[] units ={"","I","II","III","IV","V","VI","VII","VIII","IX"};
    public static String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    public static String[] hundreds = {"","C"};

    public static void main(String[] args) {
        String decimalRoman = decimal2Roman(21);
        //System.out.println(decimalRoman);
        int romanDecimal = roman2Decimal("C");
        System.out.println(romanDecimal);
    }
    public static String decimal2Roman(int x) {
        int digit = x % 10;
        int decimal = (x / 10) % 10;
        int hundred = (x / 100) % 10;

        String res = units[digit];
        String res2 = tens[decimal];
        String res3 = hundreds[hundred];
        return res3 + res2 + res;
    }

    public static int roman2Decimal(String s) {
        int result = 0;
        for (int i = 0; i < hundreds.length; i++) {
            for (int j = 0; j < tens.length; j++) {
                for (int k = 0; k < units.length; k++) {
                    if ((hundreds[i] + tens[j] + units[k]).equals(s)){
                        result = (i * 100) + (j * 10) + k;
                    }
                }
            }
        }
        return result;
    }
}
