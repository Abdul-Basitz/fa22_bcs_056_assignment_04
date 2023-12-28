package Assignment_4.src;

import java.util.Arrays;

public class CodeReuse
{
    public static void sortDescending(int[] arr /*It passes the array in pointer so no need to make it return an array*/)
    {
        boolean sorted;
        do
        {
            sorted = false;
            for (int i = 0; i < arr.length - 1; i++)
            {
                if (arr[i+1] > arr[i])
                {
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    sorted = true;
                }
            }
        } while (sorted);
    }

    public static double[] calculateStatistics(int[] arr)
    {
        double[] result = new double[4];

        Arrays.sort(arr);
        result[0] = calculateMedian(arr);
        result[1] = calculateVariance(arr);
        result[2] = Math.sqrt(result[1]);
        result[3] = sumOfSquares(arr);

        return result;
    }

    private static double calculateMedian(int[] arr)
    {
        int length = arr.length;
        if (length % 2 == 0)
        {
            int mid1 = arr[length / 2 - 1];
            int mid2 = arr[length / 2];
            return (double) (mid1 + mid2) / 2;
        } else
        {
            return arr[length / 2];
        }
    }

    private static double calculateVariance(int[] arr)
    {
        double mean = mean(arr);
        double sumOfSquaredDifferences = 0;

        for (int value : arr)
        {
            sumOfSquaredDifferences += Math.pow(value - mean, 2);
        }

        return sumOfSquaredDifferences / arr.length;
    }

    private static double mean(int[] arr)
    {
        int sum = 0;
        for (int value : arr)
        {
            sum += value;
        }
        return (double) sum / arr.length;
    }

    private static double sumOfSquares(int[] arr)
    {
        double sumSquare = 0;
        for (int value : arr)
        {
            sumSquare += Math.pow(value, 2);
        }
        return sumSquare;
    }

    public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB, int rowsA, int columnsA, int columnsB)
    {
        if (columnsA != matrixB.length)
        {
            throw new IllegalArgumentException("Matrix(s) can't be multiplied");
        }

        int[][] resultMatrix = new int[rowsA][columnsB];


        for (int i = 0; i < rowsA; i++)
        {
            for (int j = 0; j < columnsB; j++)
            {
                for (int k = 0; k < columnsA; k++)
                {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }


}


