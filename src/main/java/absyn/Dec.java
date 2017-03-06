package absyn;

/*
 * Created by brenokeller on 2/22/17
 */

import env.Env;
import parse.Loc;

public abstract class Dec extends AST {
    public Dec(Loc loc) {
        super(loc);
    }

    public abstract void semantic(Env env);
}
