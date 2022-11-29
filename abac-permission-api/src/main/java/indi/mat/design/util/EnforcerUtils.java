package indi.mat.design.util;


import indi.mat.design.domain.model.permission.CasbinRule;
import org.casbin.jcasbin.model.Assertion;
import org.casbin.jcasbin.model.Model;
import org.casbin.jcasbin.persist.Helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Mat
 * @version : EnforcerUtils, v 0.1 2022-11-29 23:33 Yang
 */
public class EnforcerUtils {

    public static void policyLinesToModel(List<CasbinRule> lines, Model model) {
        if (lines == null || lines.isEmpty()) return;
        for (CasbinRule line : lines) {
            String lineText = line.getPtype();
            if (line.getV0() != null) {
                lineText += ", " + line.getV0();
            }
            if (line.getV1() != null) {
                lineText += ", " + line.getV1();
            }
            if (line.getV2() != null) {
                lineText += ", " + line.getV2();
            }
            if (line.getV3() != null) {
                lineText += ", " + line.getV3();
            }
            if (line.getV4() != null) {
                lineText += ", " + line.getV4();
            }
            if (line.getV5() != null) {
                lineText += ", " + line.getV5();
            }
            Helper.loadPolicyLine(lineText, model);
        }
    }


    public static List<CasbinRule> modelToPolicyLines(Model model){
        List<CasbinRule> policyLines = new ArrayList<>();

        for (Map.Entry<String, Assertion> entry : model.model.get("p").entrySet()) {
            String ptype = entry.getKey();
            Assertion ast = entry.getValue();

            for (List<String> rule : ast.policy) {
                CasbinRule line = createPolicyLine(ptype, rule);
                policyLines.add(line);
            }
        }

        for (Map.Entry<String, Assertion> entry : model.model.get("g").entrySet()) {
            String ptype = entry.getKey();
            Assertion ast = entry.getValue();

            for (List<String> rule : ast.policy) {
                CasbinRule line = createPolicyLine(ptype, rule);
                policyLines.add(line);
            }
        }

        return policyLines;
    }


    public static CasbinRule createPolicyLine(String ptype, List<String> rule){
        CasbinRule line = new CasbinRule();

        line.setPtype(ptype);
        if (rule.size() > 0) {
            line.setV0(rule.get(0));
        }
        if (rule.size() > 1) {
            line.setV1(rule.get(1));
        }
        if (rule.size() > 2) {
            line.setV2(rule.get(2));
        }
        if (rule.size() > 3) {
            line.setV3(rule.get(3));
        }
        if (rule.size() > 4) {
            line.setV4(rule.get(4));
        }
        if (rule.size() > 5) {
            line.setV5(rule.get(5));
        }

        line.setInUser("Casbin");
        line.setInDate(new Date().getTime());

        return line;
    }
}
