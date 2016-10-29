package types;

/**
 * Created by brenokeller/debnasser on 10/24/16.
 */
public class INT extends Type  {

    public static final INT T = new INT();

    private INT() {
    }

    @Override
    public String toString() {
        return "int";
    }

}
