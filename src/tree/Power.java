package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:45 2018/3/6
 * @ ModifiedBy:
 */
public class Power {
    public double Power(double base, int exponent) {
        if (exponent == 0 && base == 0) throw new IllegalArgumentException();
        if (exponent == 0) return 1;
        double result = 1.0;
        if (exponent > 0) {
            while (exponent != 0) {
                result *= base;
                exponent--;
            }
            return result;
        }
        else {
            if (base == 0) throw new IllegalArgumentException();
            exponent = Math.abs(exponent);
            while (exponent != 0) {
                result *= base;
                exponent--;
            }
            result = 1.0/result;
        }
        return result;
    }

    public double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) result *= base;
        return result;
    }
    public static void main(String[] args) {
        Power p = new Power();

    }
}
