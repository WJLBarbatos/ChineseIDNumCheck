
/**
 * Created by WuJinlong on 2018/7/8.
 * 依照《中国公民身份证号码国家标准（GB 11643-1999）》规则进行身份证号码检验。
 * 第1-6位为地区码， 7-14位为生日码， 15-17位为顺序码，18位为校验码。
 */


public class ChineseIDNumCheck {
    private final static int[] multiNum = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
    private final static String[] checkNum = {"1","0","X","9","8","7","6","5","4","3","2"};

    private static String[] inputNumbers = new String[18];

    public static boolean checkNumber(String inputNumber){
        if(inputNumber.length() != 18){
            System.out.println("输入的身份证号码长度错误");
            return false;
        }

        if(!isNumeric(inputNumber)){
            System.out.println("输入内容错误");
            return false;
        }

        for(int i=0;i<inputNumber.length();i++){
            inputNumbers[i] = inputNumber.substring(i,i);
        }

        int tempSum = 0;
        for(int i=0;i<17;i++){
            tempSum += Integer.parseInt(inputNumbers[i]) * multiNum[i];
        }

        int finalCheckNum =tempSum%11;
        String finalCheckNumString = checkNum[finalCheckNum];

        return finalCheckNumString.compareTo(inputNumbers[17])==0;

    }

    /**
     * 检测18位数是否是数字
     * @param str 输入的18位身份证号
     * @return true = 合法
     */
    private static boolean isNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                if(i!= 17){
                    return false;
                }else {
                    if (str.charAt(i) != 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
