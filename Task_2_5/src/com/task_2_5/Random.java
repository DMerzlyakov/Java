package com.task_2_5;

class Random {
    int[] values;
    int[] weights;
    int sum = 0;

    public Random(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;

        for (int i = 0; i < weights.length; i++)
            sum += weights[i];
    }

    public int getNumber() {
        int rand = (int) (Math.random() * (sum - 1));
        int index = 0;
        int k = 0;
        for (int i = 0; i < values.length; i++) {
            if (k >= rand)
                break;
            index = i;
            k += weights[i];
        }

        return values[index];
    }
}