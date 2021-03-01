package Ai.Knn;

public class Knn {
    private static double[][] group = {{1.0, 1.1}, {1.0, 1.0}, {0.0, 0.0}, {0.0, 0.1}};

    private static String[] labels = {"A", "A", "B", "B"};


}


/*
#计算已知类别数据集中的点与当前点之间的距离
#按照距离递增次序排序
#选取与当前点距离最小的k个点
#确定前k个点所在类别的出现频率
#返回前k个点出现频率最高的类别作为当前点的预测分类

def createDataSet() :
    group = array([[1.0, 1.1], [1.0, 1.0], [0, 0], [0, 0.1]])
    labels = ['A', 'A', 'B', 'B']
    return group, labels
 */