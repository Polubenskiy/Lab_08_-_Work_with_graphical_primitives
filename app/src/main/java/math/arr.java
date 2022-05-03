package math;

public class arr
{
    // find min value inside array a[], n - number of elements in a[]
    public static float min(float[] a, int n)
    {
        float x = a[0];
        for (int i = 0; i < n; i++)
        {
            if (a[i] < x) x = a[i];
        }
        return x;
    }

    // find max value inside array a[]
    public static float max(float[] a, int n)
    {
        float x = a[0];
        for (int i = 0; i < n; i++)
            if (a[i] > x) x = a[i];
        return  x;
    }

}
