package types;

/*
 * Created by brenokeller on 2/20/17
 */

public class BOOL extends Type {
    public static final BOOL T = new BOOL();

    private BOOL() {
    }

    @Override
    public String toString() {
        return "bool";
    }
}
