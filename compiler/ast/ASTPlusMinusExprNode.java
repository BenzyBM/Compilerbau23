package compiler.ast;

import java.io.OutputStreamWriter;

public class ASTPlusMinusExprNode extends ASTExprNode {
    ASTExprNode m_lhs;
    ASTExprNode m_rhs;
    compiler.Token m_token;

    public ASTPlusMinusExprNode(ASTExprNode lhs, ASTExprNode rhs, compiler.Token token) {
        m_lhs = lhs;
        m_rhs = rhs;
        m_token = token;
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent + m_token.toString() + "\n");
        String newIndent = indent + "  ";
        m_lhs.print(outStream, newIndent);
        m_rhs.print(outStream, newIndent);
    }

    @Override
    public int eval() {
        int lhsVal = m_lhs.eval();
        int rhsVal = m_rhs.eval();
        int result = 0;
        if (m_token.m_type == compiler.TokenIntf.Type.PLUS) {
            result = lhsVal + rhsVal;
        } else {
            result = lhsVal - rhsVal;
        }
        return result;
    }
    
}
