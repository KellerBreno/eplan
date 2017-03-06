package absyn;

/*
 * Created by brenokeller on 2/22/17
 */

import env.Env;
import javaslang.collection.Tree;
import parse.Loc;
import semantic.SemanticHelper;
import types.Type;

import static semantic.SemanticHelper.*;

public class DecVar extends Dec {
    public final String name;
    public final String typeName;
    public final Exp init;

    public DecVar(Loc loc, String name, String typeName, Exp init) {
        super(loc);
        this.name = name;
        this.typeName = typeName;
        this.init = init;
    }

    @Override
    public Tree.Node<String> toTree() {
        return Tree.of("DecVar", Tree.of(name), Tree.of(typeName), init.toTree());
    }

    @Override
    public void semantic(Env env) {
        Type t_init = init.semantic(env);
        Type t_var = t_init;

        if (typeName != null) {
            Type t_typeName = env.tenv.get(typeName);
            if (t_typeName == null) {
                throw undefined(loc, "type", typeName);
            }
            if (!t_init.is(t_typeName)) {
                throw typeMismatch(init.loc, t_init, t_typeName);
            }
            t_var = t_typeName;
        }
        env.venv.put("name", t_var);
    }
}
