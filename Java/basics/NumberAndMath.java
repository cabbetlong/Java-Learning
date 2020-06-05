public class NumberAndMath {
    public static void main (String []args){
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("-1 的绝对值：" + Math.abs(-1));

        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        for (int x : numbers) {
            System.out.print(x + ", ");
        }
    }
}
