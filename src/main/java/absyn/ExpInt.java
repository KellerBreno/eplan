package absyn;

import javaslang.collection.Tree;
import org.bytedeco.javacpp.LLVM;
import parse.Loc;
import types.INT;
import types.Type;

import static org.bytedeco.javacpp.LLVM.*;

/**
 * Created by brenokeller/debnasser on 10/24/16.
 */
public class ExpInt extends Exp {

    public final Long value;

    public ExpInt(Loc loc, Long value) {
        super(loc);
        this.value = value;
    }

    @Override
    public Tree.Node<String> toTree() {
        return Tree.of(annotateType("ExpInt: " + value));
    }

    @Override
    protected Type semantic_() {
        return INT.T;
    }

    @Override
    public LLVM.LLVMValueRef codegen(LLVM.LLVMModuleRef module, LLVM.LLVMBuilderRef builder) {
        return LLVMConstInt(LLVMInt32Type(), value, 0);
    }
}
