package absyn;

/*
 * Created by brenokeller on 3/15/17
 */

import env.Env;
import parse.Loc;

public abstract class Ty extends AST {
    public Ty(Loc loc) {
        super(loc);
    }
    // Do semantic analysis of the type
    public abstract void semantic(Env env);
}
