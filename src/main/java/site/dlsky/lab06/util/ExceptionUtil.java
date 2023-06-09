package site.dlsky.lab06.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static site.dlsky.lab06.extensions.ListExtensions.concat;

public class ExceptionUtil {
    public static Throwable merge(Throwable ex, StackTraceElement[] stackTrace) {
        changeOnBasic(stackTrace);
        for (Throwable throwable : splitByHierarchy(ex))
            appendStackTrace(throwable, stackTrace);
        return ex;
    }

    /**
     * Split exception by Hierarchy
     * for Example if Exception1 was thrown earlier, then Exception2.
     * Exception2 will be upper then Exception1
     *
     * @param ex caught Exception
     * @return list of Exception by hierarchy order
     */
    private static List<Throwable> splitByHierarchy(Throwable ex) {
        List<Throwable> exs = new ArrayList<>();
        if (ex != null) {
            Collections.addAll(exs, ex.getSuppressed());
            while (ex != null) {
                exs.add(ex);
                ex = ex.getCause();
            }
        }

        return exs;
    }
    private static void changeOnBasic(StackTraceElement[] elements){
        for (int i = 0; i< elements.length; i++){
            if(elements[i].getMethodName().equals("getStackTrace")){
                String[] classNames = elements[i].getClassName().split("\\.");
                String className = classNames[classNames.length-1];
                StackTraceElement element = new StackTraceElement('<'+className,"start>","",-1);
                elements[i] = element;
            }
        }
    }
    private static void appendStackTrace(Throwable t, StackTraceElement[] elements) {
        List<StackTraceElement> traceElements = new ArrayList<>();
        if (t != null) {
            concat(traceElements, t.getStackTrace());
            concat(traceElements, elements);
            t.setStackTrace(traceElements.toArray(new StackTraceElement[0]));
        }
    }

}
