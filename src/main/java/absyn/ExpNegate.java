package absyn;

import javaslang.collection.Tree;
import parse.Loc;
import types.INT;
import types.REAL;
import types.Type;

import static org.bytedeco.javacpp.LLVM.*;

public class ExpNegate extends Exp {

    public final Exp arg;

    public ExpNegate(Loc loc, Exp arg) {
        super(loc);
        this.arg = arg;
    }

    @Override
    public Tree.Node<String> toTree() {
        return Tree.of(annotateType("ExpNegate"), arg.toTree());
    }

    @Override
    public LLVMValueRef codegen(LLVMModuleRef module, LLVMBuilderRef builder) {
        final LLVMValueRef v_arg = arg.codegen(module, builder);
        if (arg.type.canBe(INT.T)) {
            return LLVMBuildNeg(builder, v_arg, "negtmp");
        } else {
            return LLVMBuildFNeg(builder, v_arg, "negtmp");
        }
    }

    @Override
    protected Type semantic_() {
        final Type t_arg = arg.semantic();
        if (!t_arg.canBe(REAL.T)) {
            if (t_arg.canBe(INT.T))
                return INT.T;
            typeMismatch(arg.loc, t_arg, REAL.T);
        }
        return REAL.T;
    }
}
