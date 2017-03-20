package absyn;

/*
 * Created by brenokeller on 3/15/17
 */

import env.Env;
import javaslang.collection.Tree;
import parse.Loc;

public class TyName extends Ty {
    public final String name;

    public TyName(Loc loc, String name) {
        super(loc);
        this.name = name;
    }

    @Override
    public void semantic(Env env) {

    }

    @Override
    public Tree.Node<String> toTree() {
        return Tree.of("Tyname: " + name);
    }
}
