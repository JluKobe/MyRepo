package com.myproject.service.impl;

import com.myproject.jpa.bean.Sam;
import com.myproject.jpa.repository.SamRepository;
import com.myproject.service.ISam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SamImpl implements ISam {

    @Autowired
    private SamRepository samRepository;

    @Override
    public double[] countSam(String localUrl, String writeUrl) throws Exception{
        FileReader fileReader = new FileReader(localUrl);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(writeUrl);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        List<String> dataList = getDataList(bufferedReader);

        String[][] dataStr = getStrData(dataList);
        double[][] dataDouble = getDoubleData(dataStr);
        double[] dataX = getX(dataDouble);
        double[] dataY = getY(dataDouble);
        double[] samScore = getSamScore(dataX, dataY);
        saveData(bufferedWriter, samScore);

        bufferedWriter.close();
        bufferedReader.close();
        fileWriter.close();
        fileReader.close();

        for(double score : samScore) {
            Sam sam = Sam.builder()
                    .data(localUrl)
                    .samScore(String.valueOf(score))
                    .build();
            samRepository.save(sam);
        }


        return samScore;
    }

    /**
     * 获取数据
     * @param bufferedReader
     * @return
     * @throws IOException
     */
    public static List<String> getDataList(BufferedReader bufferedReader) throws IOException {
        List<String> dataList = new ArrayList<>();
        String dataLine;
        while((dataLine = bufferedReader.readLine())!= null) {
            dataList.add(dataLine);
        }
        return dataList;
    }

    /**
     * 处理数据，获取String类型二维数组数据
     * @param dataList
     * @return
     */
    public static String[][] getStrData(List<String> dataList) {
        String[][] dataStr2 = new String[dataList.size()][];
        int i = 0;
        for(String data : dataList) {
            dataStr2[i] = data.split("\\t");
            i ++;
        }
        return dataStr2;
    }

    /**
     * 处理数据，获取Double类型二维数组数据
     * @param dataStr
     * @return
     */
    public static double[][] getDoubleData(String[][] dataStr) {
        double[][] doubleData = new double[dataStr.length][];
        for(int i = 0; i < dataStr.length; i ++) {
            doubleData[i] = new double[dataStr[i].length];
            for(int j = 0; j < dataStr[i].length; j ++) {
                doubleData[i][j] = Double.valueOf(dataStr[i][j]);
            }
        }
        return doubleData;
    }

    /**
     * 计算分子
     * @param doubleData
     * @return
     */
    public static double[] getX(double[][] doubleData) {
        double[] doubleX = new double[doubleData.length];
        int count;
        double x1Sum;
        double x2Sum;
        String result = "";
        for(int i = 0; i < doubleData.length; i ++) {
            x1Sum = 0.0;
            x2Sum = 0.0;
            count = doubleData[i].length / 2;
            for(int j = 0; j < count; j ++) {
                x1Sum += doubleData[i][j];
            }
            for(int j = count; j < doubleData[i].length; j ++) {
                x2Sum += doubleData[i][j];
            }
            doubleX[i] = x1Sum / count - x2Sum / count;
            result = String.format("%.8f", doubleX[i]);
            doubleX[i] = Double.valueOf(result);
        }
        return doubleX;
    }

    /**
     * 计算分母
     * @param doubleData
     * @return
     */
    public static double[] getY(double[][] doubleData) {
        double[] doubleY = new double[doubleData.length];
        double sumLine;
        double aveLine;
        double sumLine2;
        double doubleYScore;
        String result = "";
        for(int i = 0; i < doubleData.length; i ++) {
            sumLine = 0.0;
            sumLine2 = 0.0;
            for(int j = 0; j < doubleData[i].length; j ++) {
                sumLine += doubleData[i][j];
            }
            aveLine = sumLine / doubleData[i].length;

            for(int j = 0; j < doubleData[i].length; j ++) {
                sumLine2 += (doubleData[i][j] - aveLine) * (doubleData[i][j] - aveLine);
            }
            doubleYScore = Math.sqrt(sumLine2 / doubleData[i].length);
            result = String.format("%.8f", doubleYScore);
            doubleY[i] = Double.valueOf(result);
        }
        return doubleY;
    }

    /**
     * 计算SAM值
     * @param doubleX
     * @param doubleY
     * @return
     */
    public static double[] getSamScore(double[] doubleX, double[] doubleY) {
        double[] samScore = new double[doubleX.length];
        String result = "";
        for(int i = 0; i < doubleX.length; i ++) {
            samScore[i] = doubleX[i] / doubleY[i];
            result = String.format("%.8f", samScore[i]);
            samScore[i] = Double.valueOf(result);
        }
        return samScore;
    }

    /**
     * 保存数据到本地
     * @param bufferedWriter
     * @param samScore
     */
    public static void saveData(BufferedWriter bufferedWriter, double[] samScore) throws IOException {
        for(double sam : samScore) {
            bufferedWriter.write(String.valueOf(sam));
            bufferedWriter.newLine();
        }
    }
}
