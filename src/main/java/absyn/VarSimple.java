package absyn;

import env.Env;
import javaslang.collection.Tree;
import parse.Loc;

import static semantic.SemanticHelper.*;

import types.Type;

public class VarSimple extends Var {

    public final String name;

    public VarSimple(Loc loc, String name) {
        super(loc);
        this.name = name;
    }

    @Override
    public Tree.Node<String> toTree() {
        return Tree.of(annotateType("VarSimple: " + name));
    }

    @Override
    protected Type semantic_(Env env) {
        Type t = env.venv.get(name);

        if (t == null) {
            throw undefined(loc, "variable", name);
        }

        return t;
    }

}
