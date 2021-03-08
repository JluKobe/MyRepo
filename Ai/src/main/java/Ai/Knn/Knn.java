package Ai.Knn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knn {
    private static double[][] group = {{1.0, 1.1}, {1.0, 1.0}, {0.0, 0.0}, {0.0, 0.1}};

    private static String[] labels = {"A", "A", "B", "B"};

    public static void main(String[] args) {
        Knn knn = new Knn();
        double[] num = {0.0, 0.0};
        String result = knn.getKnn(3, group, labels, num);
        System.out.println(result);
    }

    public String getKnn(int k, double[][] group, String[] labels, double[] num) {
        double[] distance = new double[group.length];
        for(int i = 0; i < group.length; i ++) {
            //计算已知类别数据集中的点与当前点之间的距离
            distance[i] = getDistance(group[i], num);
        }

        //distance 1.49 1.41 0.0 0.1
        //按照距离递增次序排序
        Arrays.sort(distance);

        List<Integer> list = new ArrayList<>();

        //选取与当前点距离最小的k个点
        //确定前k个点所在类别的出现频率
        //返回前k个点出现频率最高的类别作为当前点的预测分类

        return "";
    }

    //计算已知类别数据集中的点与当前点之间的距离
    public double getDistance(double[] d1, double[] d2) {
        double x2 = (d1[0] - d2[0]) * (d1[0] - d2[0]);
        double y2 = (d1[1] - d2[1]) * (d1[1] - d2[1]);
        double num = Math.sqrt(x2 + y2);

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(num));
    }
}