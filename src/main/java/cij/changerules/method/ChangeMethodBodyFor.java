package cij.changerules.method;

import java.util.ArrayList;

import cij.changerules.ChangeCategory;
import cij.changerules.ChangeRule;
import cij.changerules.MethodInformationDataCollector;
import cij.grammar.java.CodeComponentNode;
import cij.grammar.java.JavaParseTree;

public class ChangeMethodBodyFor extends ChangeRule {

    private JavaParseTree treeBeforeChange;
    private JavaParseTree treeAfterChange;
    private boolean add = false; 

    public ChangeMethodBodyFor(JavaParseTree treeBeforeChange, JavaParseTree treeAfterChange) {
        this.treeBeforeChange = treeBeforeChange;
        this.treeAfterChange = treeAfterChange;
    }

    @Override
    public ChangeCategory getCategory() {
        if (isChangeCategory(treeBeforeChange, treeAfterChange)) {
            if (add){
                return ChangeCategory.DFR_FOR_CONDITION_DELETED;
            }
            return ChangeCategory.AFR_FOR_CONDITION_ADDED;
        }
        return null;
    }

    @Override
    public boolean isChangeCategory(JavaParseTree beforeChangeCode, JavaParseTree afterChangeCode) {
        MethodInformationDataCollector beforeChange = new MethodInformationDataCollector();
        beforeChange.collectMethods(beforeChangeCode.getRootNode());
        MethodInformationDataCollector afterChange = new MethodInformationDataCollector();
        afterChange.collectMethods(afterChangeCode.getRootNode());

        for (MethodBodyInformation beforeChangeMethod : beforeChange.getMethodList()) {
            for (MethodBodyInformation afterChangeMethod : afterChange.getMethodList()) {

                if (beforeChangeMethod.getMethodByNameReturnParamType()
                        .equals(afterChangeMethod.getMethodByNameReturnParamType())) {

                    ArrayList<String> beforeForList = beforeChangeMethod.getForList();
                    ArrayList<String> afterForList = afterChangeMethod.getForList();

                    if (beforeForList.equals(afterForList)) {
                        add = true;
                        // return true;
                    }
                    else{
                        add = beforeForList.size() > afterForList.size();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Compare two methods if they have the same body.
     * If the bodies are not same return false
     * If the bodies are same return true
     */
    public boolean compareMethodBodies(CodeComponentNode beforeChangeNode, CodeComponentNode afterChangeNode) {
        String beforeChangeMethodBody = stringifyMethodBody(beforeChangeNode);
        String afterChangeMethodBody = stringifyMethodBody(afterChangeNode);
        return beforeChangeMethodBody.equals(afterChangeMethodBody);
    }

    /*
     * Stringify the method body tree into one string for easy compare
     */
    private String stringifyMethodBody(CodeComponentNode beforeChangeNode) {
        String str = "";
        str = str + beforeChangeNode.getType() + " " + beforeChangeNode.getCodeList() + " ";
        for (CodeComponentNode child : beforeChangeNode.getChildren()) {
            str = str + stringifyMethodBody(child);
        }
        return str;
    }
}