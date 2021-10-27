package Fibonacci;

import java.math.BigInteger;


public class Fibonacci {


    /**
     * @param n On va chercher Fibonacci.Fibonacci à l'index n
     * @return calcul Fibonacci.Fibonacci de n en recursif
     */

    public BigInteger recursive(BigInteger n) {

        if (n.compareTo(BigInteger.ONE) <= 0)
            return n;

        return recursive(n.subtract(new BigInteger("2"))).add(recursive(n.subtract(new BigInteger("1"))));

    }


    /**
     * @param n On va chercher Fibonacci.Fibonacci à l'index n
     * @return calcul Fibonacci.Fibonacci de n en iteratif
     */

    public BigInteger iterative(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0)
            return n;

        BigInteger pred = new BigInteger("0");
        BigInteger next = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        BigInteger sum = new BigInteger("0");

        while (i.compareTo(n) != 0) {
            sum = pred.add(next);
            pred = next;
            next = sum;
            i = i.add(BigInteger.ONE);
        }

        return sum;

    }


    /**
     * @param n On va chercher Fibonacci à cet index
     * @return Calcule Fibonacci de n par exponentiation matricielle
     */

    public BigInteger matrixExponentiation(BigInteger n) {

        if (n.compareTo(BigInteger.ONE) <= 0)
            return n;

        BigInteger[][] fibonacci_matrix = {

                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };

        fibonacci_matrix = matrixToPower(fibonacci_matrix, n);

        return fibonacci_matrix[0][1];

    }


    public BigInteger[][] matrixToPower(BigInteger[][] matrix, BigInteger p) {

        if (p.compareTo(BigInteger.ONE) <= 0)
            return matrix;

        if (p.remainder(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
            return matrixToPower(
                    matrixSquare(matrix), p.shiftRight(1)
            );

        else
            return multiplyMatrixBy(
                    matrix, matrixToPower(matrixSquare(matrix), p.shiftRight(1))
            );

    }


    public BigInteger[][] matrixSquare(BigInteger[][] matrix) {
        return multiplyMatrixBy(matrix, matrix);
    }


    public BigInteger[][] multiplyMatrixBy(BigInteger[][] first, BigInteger[][] second) {

        BigInteger[][] product = new BigInteger[2][2];

        product[0][0] = first[0][0].multiply(second[0][0]).add(first[0][1].multiply(second[1][0]));
        product[0][1] = first[0][0].multiply(second[0][1]).add(first[0][1].multiply(second[1][1]));
        product[1][0] = first[1][0].multiply(second[0][0]).add(first[1][1].multiply(second[1][0]));
        product[1][1] = first[1][0].multiply(second[0][1]).add(first[1][1].multiply(second[1][1]));

        return product;

    }


}