package com.geekhub.hw3.string;

public class StringPerformance {

    private static final int CONCAT_CYCLES = 1000000;
    private static char [] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        testStringPerformance();
        testStringBuilderPerformance();
        testStringBufferPerformance();
        try {
            System.out.println(parseInt("12345"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    private static void testStringPerformance() {
        long beginTime = System.currentTimeMillis();
        String s = new String("hello");

        for (int i=0; i < CONCAT_CYCLES; i++) {
            s += "something";
        }

        long timePastMs = System.currentTimeMillis() - beginTime;
        System.out.println("String concatenation took " + timePastMs + "ms");
    }

    private static void testStringBuilderPerformance() {
        long beginTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("hello");

        for (int i=0; i < CONCAT_CYCLES; i++) {
            sb.append("something");
        }

        long timePastMs = System.currentTimeMillis() - beginTime;
        System.out.println("StringBuilder concatenation took " + timePastMs + "ms");
    }

    private static void testStringBufferPerformance() {
        long beginTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("hello");

        for (int i=0; i < CONCAT_CYCLES; i++)
            sb.append("something");

        long timePastMs = System.currentTimeMillis() - beginTime;
        System.out.println("StringBuffer concatenation took " + timePastMs + "ms");
    }

    public static Integer parseInt(String str) throws NumberFormatException {

        if (str!=null && str.startsWith("0") && str.length()>1){
            throw new NumberFormatException();
        }

        boolean charIsNumber;

        for (int i=0; i<str.length(); i++){
            charIsNumber = false;
            for (int j=0; j < numbers.length; j++) {
                if (str.charAt(i) == numbers[j]){
                    charIsNumber = true;
                    continue;
                }
            }

            if (!charIsNumber) {
                throw new NumberFormatException();
            }
        }

        return new Integer(str);
    }
}
