package cij.changerules;

import cij.changerules.method.MethodInformation;
import cij.grammar.java.CodeComponentNode;

public class MethodBodyInformationDataCollector extends MethodInformationDataCollector{
    

    // @Override
    // private CodeComponentNode collectMethodBody(CodeComponentNode root) {
    //     for (CodeComponentNode child : root.getChildren()) {
    //         if (child.getType().equals("(methodBody")) {

    //             // collect if, for and while statements

    //             return child;
    //         } else if (child.getType().equals("(constructorBody")) {
    //             return child;
    //         }
    //     }
    //     return null;
    // }

    // private CodeComponentNode collectIfStatements(CodeComponentNode root) {
    //     for (CodeComponentNode child : root.getChildren()) {
    //         if (child.getType().equals("(ifStatement")) {
    //             return child;
    //         }
    //     }
    //     return root;
    // }

}
