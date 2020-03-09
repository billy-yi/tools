import java.math.BigDecimal;

/**
 * 基金计算
 */
public class FundCaculate {
    public static void main(String[] args) {
        //初始资金
        BigDecimal initialFunding = new BigDecimal(500000);
        //目标金额
        BigDecimal targetFunding = new BigDecimal(100 * 10000);
        //年化利息
        BigDecimal interest = new BigDecimal(0.032);

        //当前资金
        BigDecimal nowFunds = new BigDecimal(0);

        nowFunds = nowFunds.add(initialFunding);

        int i = 0;

        while (true) {
            i ++;
            //单次利息
            BigDecimal singleInterest = nowFunds.multiply(interest);
            nowFunds = nowFunds.add(singleInterest);

            if (nowFunds.compareTo(targetFunding) == 1) {
                break;
            }
        }

        System.out.println("初始资金：" + initialFunding.doubleValue());
        System.out.println("目标金额：" + targetFunding.doubleValue());
        System.out.println("年化利息" + interest.doubleValue());
        System.out.println("-------------------------------");
        System.out.println("最终结果：" + nowFunds.doubleValue());
        System.out.println("需要年数：" + i);
    }
}
