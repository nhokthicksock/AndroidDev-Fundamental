package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
     public void process(int size) {
         horFrame(size);
         mOut.println();
         topHalf(size);
         centerLine(size);
         mOut.println();
         botHalf(size);
         horFrame(size);
    }

    // draw horizontal frame
    public void horFrame(int size){
        mOut.print("+");
        for (int i = 0; i < size * 2; i++){
            mOut.print("-");
        }
        mOut.print("+");
    }

    // draw top haft of the diamond
    public void topHalf(int size){
        for (int i = 0; i < size - 1; i++){
            // draw left frame
            mOut.print("|");

            // draw spaces
            for (int j = 0; j < size - i - 1; j++){
                mOut.print(" ");
            }

            if (i % 2 == 0){
                mOut.print("/");
                for (int j = 0; j < i * 2; j++){
                    mOut.print("=");
                }
                // draw right edge
                mOut.print("\\");
                // draw spaces
                for (int j = 0; j < size - i - 1; j++){
                    mOut.print(" ");
                }
                // draw right frame
                mOut.print("|");
                mOut.println();
            }

            if (i % 2 != 0){
                // draw left edge
                mOut.print("/");
                for (int j = 0; j < i * 2; j++){
                    mOut.print("-");
                }
                // draw right edge
                mOut.print("\\");
                for (int j = 0; j < size - i - 1; j++){
                    mOut.print(" ");
                }
                // draw right frame
                mOut.print("|");
                mOut.println();
            }
        }
    }

    // draw bottom half of the diamond
    public void botHalf(int size){
        for (int i = size - 2; i >= 0; i--){
            mOut.print("|");
            // draw spaces\
            for (int j = 0; j < size - i - 1; j++){
                mOut.print(" ");
            }

            if (i % 2 == 0){
                // draw left edge
                mOut.print("\\");
                for (int j = 0; j < i * 2; j++){
                    mOut.print("=");
                }
                // draw right edge
                mOut.print("/");
                for (int j = 0; j < size - i - 1; j++){
                    mOut.print(" ");
                }
                // draw right frame
                mOut.print("|");
                mOut.println();
            }

            if (i % 2 != 0){
                // draw left edge
                mOut.print("\\");
                for (int j = 0; j < i * 2; j++){
                    mOut.print("-");
                }
                // draw right edge
                mOut.print("/");
                for (int j = 0; j < size - i - 1; j++){
                    mOut.print(" ");
                }
                // draw right frame
                mOut.print("|");
                mOut.println();
            }
        }
    }

    /// draw center line of the diamond
    public void centerLine(int size){
        mOut.print("|");
        mOut.print("<");
        if (size % 2 == 0){
            for (int i = 0; i < 2 * (size - 1); i++){
                mOut.print("-");
            }
        }
        else if (size % 2 != 0){
            for (int i = 0; i < 2 * (size - 1); i++){
                mOut.print("=");
            }
        }
        mOut.print(">");
        mOut.print("|");
    }
}
