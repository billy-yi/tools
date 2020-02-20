import java.math.BigDecimal;

public class PayBackCalculate {
    public static void main(String[] args) {
        //总共需要还
        BigDecimal totalPayBack = new BigDecimal(57597.98);
        //利息
        BigDecimal interest = new BigDecimal(0.005);
        //每次还
        BigDecimal eachTimePayBack = new BigDecimal(2000);

        BigDecimal payBackLeft = new BigDecimal(57597.98);

        BigDecimal totalAlreadyPayBack = new BigDecimal(0);

        BigDecimal totalInterest = new BigDecimal(0);

        Integer payBackTime = 0;

        while (true) {
            //计算出本次利息
            BigDecimal needInterest = payBackLeft.multiply(interest);
            //累加总利息
            totalInterest = totalInterest.add(needInterest);
            //利息加到剩余需要还的里
            payBackLeft = payBackLeft.add(needInterest);
            //已还的钱+每次还的
            totalAlreadyPayBack = totalAlreadyPayBack.add(eachTimePayBack);
            //剩余需要还的减去每次还的
            payBackLeft = payBackLeft.subtract(eachTimePayBack);
            //还钱次数++
            payBackTime ++;

            //剩余需要还的输出
            System.out.println("[" + payBackTime + "][当次利息: " + needInterest.setScale(2, BigDecimal.ROUND_UP).doubleValue() + "][剩余: " + payBackLeft.setScale(2, BigDecimal.ROUND_UP).doubleValue() + "]");

            if (payBackLeft.compareTo(eachTimePayBack) == -1) {
                //如果需要还的钱比每次还的少
                if (payBackLeft.compareTo(new BigDecimal(0)) == 1) {
                    //如果剩余需要换的 > 0则还钱次数++
                    payBackTime ++;
                    totalAlreadyPayBack = totalAlreadyPayBack.add(payBackLeft);
                }
                break;
            }
        }

        System.out.println();
        System.out.println("总共需要还: " + totalPayBack.doubleValue());
        System.out.println("利息比例: " + interest.doubleValue());
        System.out.println("每次还: " + eachTimePayBack.doubleValue());
        System.out.println();
        System.out.println("需要还款: " + payBackTime + " 次");
        System.out.println("总利息: " + totalInterest.setScale(2, BigDecimal.ROUND_UP).doubleValue());
    }
}
