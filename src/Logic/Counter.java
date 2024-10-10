//319049540 Alik Teplitsky
package Logic;

/**
 * Counter of remaining block.
 */
public class Counter {

    private int number;

    /**
     * Default constructor.
     */
    public Counter() {
        this.number = 0;
    }

    /**
     * Constructor that  a gets a number.
     *
     * @param number - a number.
     */
    public Counter(int number) {
        this.number = number;
    }

    /**
     * Increase.
     *
     * @param number the number
     */
// add number to current count.
    void increase(int number) {
        this.number += number;
    }

    /**
     * Decrease.
     *
     * @param number the number
     */
// subtract number from current count.
    void decrease(int number) {
        this.number -= number;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
// get current count.
    int getValue() {
        return this.number;
    }
}
